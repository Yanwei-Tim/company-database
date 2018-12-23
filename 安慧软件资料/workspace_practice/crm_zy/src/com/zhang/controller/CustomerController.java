package com.zhang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhang.entity.Customer;
import com.zhang.entity.CustomerFw;
import com.zhang.entity.CustomerGc;
import com.zhang.entity.CustomerGx;
import com.zhang.entity.PageBean;
import com.zhang.service.CustomerService;
import com.zhang.util.DateUtil;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * �ͻ�Controller��
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * ��ҳ��������ѯ�ͻ��б�
	 * @param page easyui��ҳ����Ĳ���(��ǰҳ)
	 * @param rows easyui��ҳ����Ĳ���(�У�����)
	 * @param s_customer
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, Customer s_customer, HttpServletResponse response)
			throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("khno", StringUtil.formatLike(s_customer.getKhno())); //Ϊ��mybatis��ģ����ѯ���ֶ�ǰ�����%...%
		map.put("name", StringUtil.formatLike(s_customer.getName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Customer> customerList = customerService.find(map);
		Long total = customerService.getTotal(map);
		JSONObject result = new JSONObject(); //����json����
		JSONArray jsonArray = JSONArray.fromObject(customerList);//��listת��json����
		result.put("rows", jsonArray);//���� ������easyui��ǰ̨����row���ա�
		result.put("total", total);//�ܼ�¼��
		ResponseUtil.write(response, result);//д��ǰ̨����
		return null;
	}
	
	/**
	 * ��ӻ��޸Ŀͻ�ʱ�ı���
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Customer customer,HttpServletResponse response) throws Exception{
		int resultTotal=0; // �����ļ�¼����
		if(customer.getId()==null){ //�����ȡ����id����˵�������
			customer.setKhno("KH"+DateUtil.getCurrentDateStr()); // ��̬���ɿͻ����
			resultTotal = customerService.add(customer); //����
		} else{
			resultTotal = customerService.update(customer); //�޸�
		}
		JSONObject result = new JSONObject(); //����json����
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ɾ���ͻ�
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		String[] idsStr=ids.split(","); //������һ��ɾ���������ݣ����id����
		for(int i=0;i<idsStr.length;i++){
			customerService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ͨ��ID����ʵ��
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		Customer customer=customerService.findById(Integer.parseInt(id));
		JSONObject jsonObject=JSONObject.fromObject(customer);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
	/**
	 * ��ҳ��������ѯ�ͻ��б�
	 * @param page easyui��ҳ����Ĳ���(��ǰҳ)
	 * @param rows easyui��ҳ����Ĳ���(�У�����)
	 * @param s_customer
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCustomerGx")
	public String findCustomerGx(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, CustomerGx s_customerGx, HttpServletResponse response)
			throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", StringUtil.formatLike(s_customerGx.getName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<CustomerGx> customerGxList = customerService.findCustomerGx(map);
		Long total = customerService.getTotalCustomerGx(map);
		JSONObject result = new JSONObject(); //����json����
		JSONArray jsonArray = JSONArray.fromObject(customerGxList);//��listת��json����
		result.put("rows", jsonArray);//���� ������easyui��ǰ̨����row���ա�
		result.put("total", total);//�ܼ�¼��
		ResponseUtil.write(response, result);//д��ǰ̨����
		return null;
	}
	
	/**
	 * ��ѯ�ͻ������б�
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCustomerGc")
	public String findCustomerGc(HttpServletResponse response)throws Exception {
		List<CustomerGc> customerGcList = customerService.findCustomerGc();
		JSONArray jsonArray = JSONArray.fromObject(customerGcList);//��listת��json����
		ResponseUtil.write(response, jsonArray);//д��ǰ̨����
		return null;
	}
	
	/**
	 * ��ѯ�ͻ������б�
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCustomerFw")
	public String findCustomerFw(HttpServletResponse response)throws Exception {
		List<CustomerFw> customerFwList = customerService.findCustomerFw();
		JSONArray jsonArray = JSONArray.fromObject(customerFwList);//��listת��json����
		ResponseUtil.write(response, jsonArray);//д��ǰ̨����
		return null;
	}
}
