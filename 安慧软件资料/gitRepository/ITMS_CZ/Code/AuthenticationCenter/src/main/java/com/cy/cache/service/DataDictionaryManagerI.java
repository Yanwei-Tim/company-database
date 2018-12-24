package com.cy.cache.service;

import java.util.Map;


public interface DataDictionaryManagerI {
	
	/** 
	* @Title: initMemoryCache 
	* @Description:�����ļ��̶�����ʼ�����������ֵ���Ϣ
	* @return void �������� 
	* @throws 
	*/
	public void initMemoryCache(String path);
	
	/** 
	* @Title: initMemoryCache 
	* @Description:���ݳ����KEY������ָ������
	* @param @param path    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public void updateMemoryCache(String[] keys);
	
	
	/** 
	* @Title: initMemoryCache 
	* @Description:���ݳ����KEY����ѯ�����е���Ϣ���绺���в����ڣ����ѯ���ݿ��ȡ���ݲ����»���
	* @param @param path    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public Map queryMemoryCache(String[] keys);
	
}
