package com.zhang.service;

import java.util.List;
import java.util.Map;

import com.zhang.entity.DataDic;

/**
 * �����ֵ�DataDic�ӿ�
 * @author zhangyu
 *
 */
public interface DataDicService {
	
	/**
	 * ��ѯ�����ֵ伯��
	 * @param map
	 * @return
	 */
	public List<DataDic> find(Map<String,Object> map);//��mapΪ��������Ϊ��ӭ��mybatis���
	
	/**
	 * ��ѯ���е������ֵ�ֵ
	 * @return
	 */
	public List<DataDic> findAll();
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * ��������ֵ�
	 * @param dataDic
	 * @return ��ӵļ�¼��
	 */
	public int add(DataDic dataDic);
	
	/**
	 * ɾ�������ֵ�
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * �޸������ֵ�
	 * @param dataDic
	 * @return
	 */
	public int update(DataDic dataDic);

}
