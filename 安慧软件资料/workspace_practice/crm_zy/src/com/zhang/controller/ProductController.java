package com.zhang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhang.entity.PageBean;
import com.zhang.entity.Product;
import com.zhang.service.ProductService;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ��ƷController��
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * ��ҳ��������ѯ��Ʒ�б�
	 * @param page easyui��ҳ����Ĳ���(��ǰҳ)
	 * @param rows easyui��ҳ����Ĳ���(�У�����)
	 * @param s_product
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, Product s_product, HttpServletResponse response)
			throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productName", StringUtil.formatLike(s_product.getProductName())); //Ϊ��mybatis��ģ����ѯ���ֶ�ǰ�����%...%
//		map.put("productName", s_product.getproductName());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Product> productList = productService.find(map);
		Long total = productService.getTotal(map);
		JSONObject result = new JSONObject(); //����json����
		JSONArray jsonArray = JSONArray.fromObject(productList);//��listת��json����
		result.put("rows", jsonArray);//���� ������easyui��ǰ̨����row���ա�
		result.put("total", total);//�ܼ�¼��
		ResponseUtil.write(response, result);//д��ǰ̨����
		return null;
	}
	
}
