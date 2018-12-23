package com.zhang.dao;

import java.util.List;
import java.util.Map;

import com.zhang.entity.Customer;
import com.zhang.entity.CustomerFw;
import com.zhang.entity.CustomerGc;
import com.zhang.entity.CustomerGx;

/**
 * �ͻ�Dao�ӿ�
 *
 */
public interface CustomerDao {

	/**
	 * ��ѯ�ͻ�����
	 * @param map
	 * @return
	 */
	public List<Customer> find(Map<String,Object> map);//��mapΪ��������Ϊ��ӭ��mybatis���
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * ��ӿͻ���Ϣ
	 * @return
	 */
	public int add(Customer customer);
	
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param customer
	 * @return
	 */
	public int update(Customer customer);
	
	/**
	 * ɾ���ͻ���Ϣ
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * ͨ��Id���ҿͻ�
	 * @param id
	 * @return
	 */
	public Customer findById(Integer id);
	
	/**
	 * ������ʧ�Ŀͻ� 6����δ�µ��Ŀͻ�
	 * @return
	 */
	public List<Customer> findLossCustomer();
	
	/**
	 * ��ѯ�ͻ����׼���
	 * @param map
	 * @return
	 */
	public List<CustomerGx> findCustomerGx(Map<String,Object> map);//��mapΪ��������Ϊ��ӭ��mybatis���
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerGx(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ����ɼ���
	 * @return
	 */
	public List<CustomerGc> findCustomerGc();
	
	/**
	 * ��ѯ�ͻ����񼯺�
	 * @return
	 */
	public List<CustomerFw> findCustomerFw();
	
	

	
}
