package com.zhang.dao;

import java.util.List;
import java.util.Map;

import com.zhang.entity.Product;

/**
 * ��ƷDao�ӿ�
 *
 */
public interface ProductDao {

	/**
	 * ��ѯ��Ʒ����
	 * @param map
	 * @return
	 */
	public List<Product> find(Map<String,Object> map);//��mapΪ��������Ϊ��ӭ��mybatis���
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
}
