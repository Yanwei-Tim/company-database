package cy.its.vehTrack.rest.action.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import cy.its.com.util.StringUtil;
import cy.its.device.domain.criteria.SystemCriteria;
import cy.its.device.domain.model.Sys;
import cy.its.device.domain.model.TollgateSys;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.ISiteService;
import cy.its.device.domain.service.ISystemService;
import cy.its.vehTrack.domain.service.IDataLatencyAnalysisService;
import cy.its.vehTrack.rest.action.IDataLatencyAnalysisAction;
import cy.its.vehTrack.rest.dto.DataLatencyAnalysisInputBean;
import cy.its.vehTrack.rest.dto.DataLatencyConvertBean;
import cy.its.vehTrack.rest.dto.DataLatencyOutBean;

@RestController
@RequestMapping(value = "/vehTrack/dataLantency")
@Api(value = "DataLatencyAnalysisAction", description = "�����ӳٷ���")
public class DataLatencyAnalysisAction implements IDataLatencyAnalysisAction {

	@Autowired
	IDataLatencyAnalysisService service;
	@Autowired
	ISystemService systemService;
	@Autowired
	ISiteService siteService;

	@Override
	@RequestMapping(value = "findDataLatencyList", method = RequestMethod.POST)
	@ApiOperation(value = "findDataLatencyList", notes = "�����ӳٷ���", httpMethod = "POST")
	public Map<String, Object> findDataLatencyList(DataLatencyAnalysisInputBean inputBean) throws Exception {
		// ���ô�����ƽ̨��������
		String query = "sync=true&creator.id=%s&job.name=%s&job.alias=%s&job.params={\"fromDate\":\"%s\", \"endDate\":\"%s\", \"districtCode\":\"%s\" }";
		query = String.format(query, inputBean.getCurrentUserName(), "DataDelayAnalysis","���ݴ����ӳٷ���",
				inputBean.getFromDate().replaceAll("-", ""), inputBean.getEndDate().replaceAll("-", ""),
				inputBean.getDistritCode());
		String result = this.service.findDataLatencyList(query);
		List<DataLatencyOutBean> list = JSONObject.parseArray(result, DataLatencyOutBean.class);
		//�����ݰ�װ
		if (list==null){
			return null;
		}
		List<DataLatencyConvertBean> outList = convert(list);
		return returnResult(outList,outList.size());
	}
	
	@Override
	@RequestMapping(value = "findDataLatencyList2", method = RequestMethod.POST)
	@ApiOperation(value = "findDataLatencyList2", notes = "�����ӳٷ���", httpMethod = "POST")
	public Map<String, Object> findDataLatencyList2(DataLatencyAnalysisInputBean inputBean) throws Exception {
		StringBuffer deviceNbrs=new StringBuffer(); 
		if (!StringUtil.isNullOrEmpty(inputBean.getOrgId()) || !StringUtil.isNullOrEmpty(inputBean.getServerId())){
			//���ǰ̨ѡ������֯����
			SystemCriteria criteria = new SystemCriteria();
			criteria.orgId = inputBean.getOrgId();
			criteria.deviceType = inputBean.getDeviceType();
			//���ǰ̨ѡ���˽���ƽ̨���߼�����ģ�
			criteria.serverPlatId = inputBean.getServerId();
			List<Sys> list = systemService.findSystems(criteria);
			for(Sys sys:list){
				deviceNbrs.append(sys.getDeviceSysNbr()).append(",");
			}
			if (list !=null && list.size()>0){
				deviceNbrs.substring(0, deviceNbrs.length()-1);
			}
		}
		// ���ô�����ƽ̨��������
		String query = "sync=true&creator.id=%s&job.name=%s&job.alias=%s&job.params={\"fromDate\":\"%s\", \"endDate\":\"%s\", \"deviceSysNbrs\":\"%s\",\"startHourMinute\":\"%s\" ,\"endHourMinute\":\"%s\"}";
		query = String.format(query, inputBean.getCurrentUserName(), "DataDelayAnalysis2","���ݴ����ӳٷ���V2",
				inputBean.getFromDate().replaceAll("-", ""), inputBean.getEndDate().replaceAll("-", ""),
				deviceNbrs.toString(),inputBean.getStartTime().substring(0, 5),inputBean.getEndTime().substring(0, 5));
		String result = this.service.findDataLatencyList(query);
		List<DataLatencyOutBean> list = JSONObject.parseArray(result, DataLatencyOutBean.class);
		//�����ݰ�װ
		List<DataLatencyConvertBean> outList = convert(list);
		return returnResult(outList,outList.size());
	}
	/**
	 * ������ת��
	 * 
	 * @param list
	 */
	public List<DataLatencyConvertBean> convert(List<DataLatencyOutBean> list) {
		Map<String, List<DataLatencyOutBean>> map = new HashMap<String, List<DataLatencyOutBean>>();
		String deviceNbr;
		// ���豸���Ϊkey���з���
		for (DataLatencyOutBean bean : list) {
			deviceNbr = bean.getDeviceSysNbr();
			BigDecimal cost = new BigDecimal(bean.getCost()).divide(new BigDecimal(1000), 2,RoundingMode.HALF_UP);
			bean.setCost(new Float(cost.toString()));
			if (map.containsKey(deviceNbr)) {
				map.get(deviceNbr).add(bean);
			} else {
				List<DataLatencyOutBean> beanList = new ArrayList<DataLatencyOutBean>();
				beanList.add(bean);
				map.put(deviceNbr, beanList);
			}
		}
		List<DataLatencyConvertBean> outList = new ArrayList<DataLatencyConvertBean>();
		for (Entry<String, List<DataLatencyOutBean>> entry : map.entrySet()) {
			Map<Integer,Double> seqMap = new HashMap<Integer,Double>();
			// ���������
			sortBySeq(entry.getValue());
			List<Integer> xAxis = new ArrayList<Integer>();
			List<Double> yAxis = new ArrayList<Double>();
			Double tatolCost = (double) 0;
			// �ռ�x,y�������
			for (DataLatencyOutBean bean : entry.getValue()) {
				if (seqMap.containsKey(bean.getSeq())){
					Double seqTatol = seqMap.get(bean.getSeq()) ;
					seqTatol =  seqTatol+bean.getCost();
					seqMap.put(bean.getSeq(), seqTatol);
				}else{
					seqMap.put(bean.getSeq(), bean.getCost());
				}
				xAxis.add(bean.getSeq());
				yAxis.add(bean.getCost());
				tatolCost = tatolCost + bean.getCost();
			}
			DataLatencyConvertBean outBean = new DataLatencyConvertBean();
			outBean.setDeviceNbr(entry.getKey());
			Sys sysDevice = this.systemService.selectByNBR(outBean.getDeviceNbr());
			if (sysDevice!=null){
				outBean.setSite_id(sysDevice.getSiteId());
				TollgateSys tollgateSys = this.systemService.tollgateSysOfId(sysDevice.getDeviceId());
				if (tollgateSys!=null){
					outBean.setTollgateType(tollgateSys.getTollgateType());
				}
				try {
					Site site =this.siteService.siteOfId(outBean.getSite_id());
					if (site !=null){
						outBean.setSite_name(site.getSiteName());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			outBean.setTatolCost(tatolCost);
			outBean.setxAxis(new ArrayList<Integer>(seqMap.keySet()));
			outBean.setyAxis(new ArrayList<Double>(seqMap.values()));
			outList.add(outBean);
		}
		return outList;

	}

	/**
	 * ��list����seq����desc
	 * 
	 * @param resultList
	 */
	public static void sortBySeq(List<DataLatencyOutBean> resultList) {
		Collections.sort(resultList, new Comparator<DataLatencyOutBean>() {
			public int compare(DataLatencyOutBean arg0, DataLatencyOutBean arg1) {
				// return arg0.getHour().compareTo(arg1.getHour());
				return Integer.valueOf(arg0.getSeq()) - Integer.valueOf(arg1.getSeq());
			}
		});
	}
	
	/**
	 * 
	 * returnResult ��װ���ز��� @Title: returnResult @Description:
	 * ��װ���ز��� @param @param dataList ���� @param @param total ���� @param @return
	 * �趨�ļ� @return Map<String,Object> �������� @throws
	 */
	private Map<String, Object> returnResult(List dataList, int total) {
		// ��װ���ؼ�
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("error", "");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", dataList);
		returnMap.put("result", resultMap);
		return returnMap;
	}


}
