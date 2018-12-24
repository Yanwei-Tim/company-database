package cy.its.vehTrack.rest.action.impl;

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
import com.wordnik.swagger.annotations.ApiOperation;

import cy.its.com.util.StringUtil;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.ISiteService;
import cy.its.vehTrack.domain.service.IVioSpaceTimeService;
import cy.its.vehTrack.rest.action.IVioSpaceTimeAnalysis;
import cy.its.vehTrack.rest.dto.VioSpaceTimeInputBean;
import cy.its.vehTrack.rest.dto.VioSpaceTimeOutBean;
import cy.its.vehTrack.rest.dto.VioSpaceTimeOutBean.DetailBean;

@RequestMapping(value = "/vehTrack/spaceTime")
@RestController
public class VioSpaceTimeAnalysis implements IVioSpaceTimeAnalysis {
	@Autowired
	IVioSpaceTimeService service;
	@Autowired
	ISiteService siteService;

	
	
	@Override
	@RequestMapping(value = "/getDistribution", method = RequestMethod.POST)
	@ApiOperation(value = "getDistribution", notes = "Υ���ֲ�����", httpMethod = "POST")
	public Map<String, Object> getVioDistribution(VioSpaceTimeInputBean inputBean) throws Exception {
		inputBean.setOrgAuthorityCode(inputBean.getCurrentOrgPrivilegeCode());
		String result = this.service.getVioDistribution(inputBean.toString());
		JSONObject obj = JSONObject.parseObject(result);
		Integer total = obj.getJSONObject("result").getIntValue("total");
		String rows = obj.getJSONObject("result").getString("rows");
		List<VioSpaceTimeOutBean> vioSpaceTimeList = new ArrayList<VioSpaceTimeOutBean>();
		//Υ������
		/*List<Integer> vioCountList  = new ArrayList<Integer>();
		//�ܶ�
		List<String>  vioDensityList = new ArrayList<String>();*/
		Map<String,List<Integer>> outMap = new HashMap<String, List<Integer>>();
		String[] vioTypes = inputBean.getViolationTypes().split(",");
		List<Integer> list;
		for (String vioType:vioTypes){
			list= new ArrayList<Integer>();
			outMap.put(vioType, list);
		}
		if (!StringUtil.isNullOrEmpty(rows)){
			vioSpaceTimeList = JSONObject.parseArray(rows, VioSpaceTimeOutBean.class);
		}
		dataConvert(outMap, vioSpaceTimeList, inputBean);
		Map<String, Object>  map = returnResult(vioSpaceTimeList,total);
		map.put("outMap", outMap);
		return map;

	}

	@Override
	@RequestMapping(value = "/getVioTrendStat", method = RequestMethod.POST)
	@ApiOperation(value = "getVioTrendStat", notes = "Υ�����Ʒ���", httpMethod = "POST")
	public  Map<String, Object> getVioTrendStat(VioSpaceTimeInputBean inputBean) throws Exception {
		// TODO Auto-generated method stub
		inputBean.setOrgAuthorityCode(inputBean.getCurrentOrgPrivilegeCode());
		String result = this.service.getVioTrendStat(inputBean.toString());
		JSONObject obj = JSONObject.parseObject(result);
		Integer total = obj.getJSONObject("result").getIntValue("total");
		String rows = obj.getJSONObject("result").getString("rows");
		List<VioSpaceTimeOutBean> vioSpaceTimeList = new ArrayList<VioSpaceTimeOutBean>();
		Map<String,List<Integer>> outMap = new HashMap<String, List<Integer>>();
		String[] vioTypes = inputBean.getViolationTypes().split(",");
		List<Integer> list;
		for (String vioType:vioTypes){
			list= new ArrayList<Integer>();
			outMap.put(vioType, list);
		}
		if (!StringUtil.isNullOrEmpty(rows)){
			vioSpaceTimeList = JSONObject.parseArray(rows, VioSpaceTimeOutBean.class);
		}
		dataConvert(outMap, vioSpaceTimeList, inputBean);
		Map<String, Object>  map = returnResult(vioSpaceTimeList,total);
		map.put("outMap", outMap);
		return map;

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
	
	
	
	/**
	 * ���ݵķ�װ
	 * @param rows
	 * @param outMap
	 * @param vioSpaceTimeList
	 * @param inputBean
	 */
	public void dataConvert(Map<String,List<Integer>> outMap,List<VioSpaceTimeOutBean> vioSpaceTimeList,
			VioSpaceTimeInputBean inputBean){
	
			if ("site".equals(inputBean.getStatBy())||"hourd".equals(inputBean.getStatBy())){
				if ("site".equals(inputBean.getStatBy())){
				//�����ݾ�ϲ����
					sortBySiteCode(vioSpaceTimeList,"site");
				}else {
					sortBySiteCode(vioSpaceTimeList,"hour");
				}
				for(VioSpaceTimeOutBean bean:vioSpaceTimeList){
				if ("site".equals(inputBean.getStatBy())){
					Site site = this.siteService.siteOfCode(bean.getVio_site_code());
					if(site!=null){
						bean.setSite_name(site.getSiteName());
				}
				}
				//��Ҫ����ϸ���ݵ�map
				Map<String,Integer> detailMap = new HashMap<String, Integer>();
				for (DetailBean detalBean:bean.getVioTypeCountList()){
					String key =detalBean.getKey();
					detailMap.put(key, detalBean.getValue());
				}
				//����һ�������Υ��������1,e ����������ֻ��1��û��e,����Ҫ��e���Ǹ�list�����0
				for (Entry<String, List<Integer>> entry:outMap.entrySet()){
					if (detailMap.containsKey(entry.getKey())){
						entry.getValue().add(detailMap.get(entry.getKey()));
					}else{
						entry.getValue().add(0);
					}
				}
				}
			}
		}
	
	
	/**
	 * ��list��������desc
	 * 
	 * @param resultList
	 */
	public  void sortBySiteCode(List<VioSpaceTimeOutBean> resultList,String sortType) {
		Collections.sort(resultList, new Comparator<VioSpaceTimeOutBean>() {
			public int compare(VioSpaceTimeOutBean arg0, VioSpaceTimeOutBean arg1) {
				// return arg0.getHour().compareTo(arg1.getHour());
				if ("site".equals(sortType)){
					return arg0.getVio_site_code().compareTo(arg1.getVio_site_code());
				}else {
					return arg0.getDateStr().compareTo(arg1.getDateStr());
				}
			}
		});
	}

}
