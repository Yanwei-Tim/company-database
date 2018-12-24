package cy.its.vehTrack.rest.action.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import cy.its.com.util.StringUtil;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.ISiteService;
import cy.its.vehTrack.domain.service.IAccompanyCarService;
import cy.its.vehTrack.rest.action.IAccompanyCarAction;
import cy.its.vehTrack.rest.dto.AccompanyDetailBean;
import cy.its.vehTrack.rest.dto.AccompanySearchInputBean;
import cy.its.vehTrack.rest.dto.AccompanyStatBean;


@RestController
@RequestMapping(value= "/vehTrack/accompanyCar")
@Api(description="���泵����", value = "AccompanyCarAction")
public class AccompanyCarAction implements IAccompanyCarAction {

	@Autowired
	IAccompanyCarService service;
	@Autowired
	ISiteService siteService;
	
	@Override
	@RequestMapping(value="findAccompanyCarList",method=RequestMethod.POST)
	@ApiOperation(value="findCollAnalyResList",notes="���泵����",httpMethod="POST")
	public Map<String, Object> findAccompanyCarList(AccompanySearchInputBean bean) throws Exception {
		JSONObject obj = this.service.findAccompanyCarList(bean.toString());
		String rows = obj.getJSONObject("result").getString("rows");
		List<AccompanyStatBean> accompanyAreaBeanList = new ArrayList<AccompanyStatBean>();
		if (!StringUtil.isNullOrEmpty(rows)){
		accompanyAreaBeanList = JSONObject.parseArray(rows, AccompanyStatBean.class);
		for (AccompanyStatBean accompanyAreaBean : accompanyAreaBeanList) {
			for (AccompanyDetailBean detailBean : accompanyAreaBean.getDetailList()) {
				Site site = siteService.siteOfCode(detailBean.getSite_code());
				if (site != null) {
					detailBean.setSite_name(site.getSiteName());
				}
			}
		}
		}
		return returnResult(accompanyAreaBeanList, obj.getJSONObject("result").getIntValue("total"));
		/*List<AccompanyStatBean> dangerAreaBeanList = new ArrayList<AccompanyStatBean>();
		List<AccompanyDetailBean> dangerAreaDetaiList = new ArrayList<AccompanyDetailBean>();
		AccompanyStatBean dangerBean = new AccompanyStatBean();
		dangerBean.setPlate_nbr("��A124444");
		dangerBean.setPlate_type("a");
		dangerBean.setAcccount(5);
		dangerBean.setAccplatenbr("��B2222");
		
		AccompanyDetailBean detaiBean = new AccompanyDetailBean();
		detaiBean.setPlate_nbr("��A12345");
		detaiBean.setPlate_type("a");
		detaiBean.setSite_name("����·��1");
		detaiBean.setAcccount(2);
		detaiBean.setAccpasstime(new Date());
		detaiBean.setImgSource("aaa.jpg");
		detaiBean.setAccImgSource("bb.jpg");
		detaiBean.setAccplatenbr("��B2222");
		dangerAreaDetaiList.add(detaiBean);
		dangerAreaDetaiList.add(detaiBean);
		dangerBean.setDetailList(dangerAreaDetaiList);
		dangerAreaBeanList.add(dangerBean);
		
	return returnResult(dangerAreaBeanList,1);*/
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
