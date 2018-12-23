package com.zhang.dao;

import java.util.List;
import java.util.Map;

import com.zhang.entity.CustomerService;

/**
 * �ͻ�����Dao�ӿ�
 * @author zhangyu
 *
 */
public interface CustomerServiceDao {
	
	/**
	 * �����ͻ�����
	 * @param customerService
	 * @return
	 */
	public int add(CustomerService customerService);
	
	/**
	 * ��ѯ�ͻ�����
	 * @param map
	 * @return
	 */
	public List<CustomerService> find(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ������¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * �޸Ŀͻ�����
	 * @param customerService
	 * @return
	 */
	public int update(CustomerService customerService);

}
