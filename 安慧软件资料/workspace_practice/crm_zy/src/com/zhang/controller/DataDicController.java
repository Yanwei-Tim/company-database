package com.zhang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhang.entity.DataDic;
import com.zhang.entity.PageBean;
import com.zhang.service.DataDicService;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * �����ֵ�Controller��
 *
 */
@Controller
@RequestMapping("/datadic")
public class DataDicController {

	@Autowired
	private DataDicService dataDicService;

	/**
	 * ��ҳ��������ѯ�����ֵ��б�
	 * 
	 * @param page
	 *            easyui��ҳ����Ĳ���(��ǰҳ)
	 * @param rows
	 *            easyui��ҳ����Ĳ���(�У�����)
	 * @param s_datadic
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, DataDic s_dataDic,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataDicName", s_dataDic.getDataDicName());
		map.put("dataDicValue", StringUtil.formatLike(s_dataDic.getDataDicValue()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<DataDic> dataDicList = dataDicService.find(map);
		Long total = dataDicService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(dataDicList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * ��ѯ�����ֵ����� Ϊ�˳�ʼ����ѯ������������
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findDataDicName")
	public String dataDicNameComboList(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = new JSONArray();
		List<DataDic> dataDicList = dataDicService.findAll();
		JSONArray rows = JSONArray.fromObject(dataDicList); // ����ѯ���������ֵ伯��ת����JSON����
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
		return null;
	}

	/**
	 * ��ӻ��޸������ֵ�ʱ�ı���
	 * 
	 * @param dataDic
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(DataDic dataDic, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // �����ļ�¼����
		if (dataDic.getId() == null) { // �����ȡ����id����˵�������
			resultTotal = dataDicService.add(dataDic); // ����
		} else {
			resultTotal = dataDicService.update(dataDic);// ����
		}
		JSONObject result = new JSONObject(); // ����json����
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * ɾ�������ֵ�
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(","); // ������һ��ɾ���������ݣ����id����
		for (int i = 0; i < idsStr.length; i++) {
			dataDicService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ���������ֵ����Ʋ��ң��û�������
	 * @param dataDicName
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataDicComboList")
	public String dataDicComboList(String dataDicName,HttpServletResponse response)throws Exception{
		JSONArray jsonArray=new JSONArray();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("dataDicName", dataDicName);
		List<DataDic> dataDicList=dataDicService.find(map);
		JSONArray rows=JSONArray.fromObject(dataDicList);
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
}
