package com.zhang.dao;

import java.util.List;
import java.util.Map;

import com.zhang.entity.SaleChance;

/**
 * Ӫ������Dao�ӿ�
 * @author zhangyu
 *
 */
public interface SaleChanceDao {
	
	/**
	 * ��ѯӪ�����Ἧ��
	 * @param map
	 * @return
	 */
	public List<SaleChance> find(Map<String,Object> map);//��mapΪ��������Ϊ��ӭ��mybatis���
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * ����Ӫ������
	 * @param saleChance
	 * @return
	 */
	public int add(SaleChance saleChance);
	
	/**
	 * �޸�Ӫ������
	 * @param saleChance
	 * @return
	 */
	public int update(SaleChance saleChance);
	
	/**
	 * ɾ��Ӫ������
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * ͨ��Id����ʵ��
	 * @param id
	 * @return
	 */
	public SaleChance findById(Integer id);

}
