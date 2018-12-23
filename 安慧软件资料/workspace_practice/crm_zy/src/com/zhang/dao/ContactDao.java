package com.zhang.dao;

import java.util.List;
import java.util.Map;
import com.zhang.entity.Contact;

/**
 * ������¼Dao�ӿ�
 * @author Administrator
 *
 */
public interface ContactDao {

	
	/**
	 * ��ѯ������¼����
	 * @param map
	 * @return
	 */
	public List<Contact> find(Map<String,Object> map);
	
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * �޸Ľ�����¼
	 * @param linkMan
	 * @return
	 */
	public int update(Contact linkMan);
	
	/**
	 * ��ӽ�����¼
	 * @param linkMan
	 * @return
	 */
	public int add(Contact linkMan);
	
	/**
	 * ɾ��������¼
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
}
