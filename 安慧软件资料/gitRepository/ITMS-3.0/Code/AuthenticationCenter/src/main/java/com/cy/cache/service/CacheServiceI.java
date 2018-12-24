package com.cy.cache.service;

import java.util.List;
import java.util.Map;

import com.cy.cache.domain.CacheDao;



public interface CacheServiceI {
    /**
     *��ʼ����������ʼ�����еĽ�ɫ��Ӧ�����з���
     */
    void initServicesByRoleCode();
    /**
     * @param serviceKey
     * @return
     */
    List<CacheDao> getServicesBykey(String serviceKey);
    /**
     * @param key
     * @param value
     */
    void addMemeryCache(String key,String value);
    
    /**
     * @param key
     * @param value
     */
    void addMemeryCache(String key,String value,int seconds);
    
    /**
     * @param key
     * @param value
     */
    void addMemeryCache(String key,Map value);
    
    /**
     * @param key
     * @param value
     */
    void addMapCache(String key,Map value,int seconds);
    
    /**
     * @param key
     * @param value
     */
    void updateMemeryCache(String key,Object value);
    /**
     * @param key
     */
    void deleteMemeryCache(String key);
	/**
	 * @param key
	 * @return
	 */
	Object getMemeryCacheByKey(String key);
	
	/**
	 * ��ʼ��KEY�ļ��ϣ�LIST<String>
	 */
	void initKeyList();
	
	/** 
	* @Title: freshExpoireKey 
	* @Description: �������ù���ʱ��
	* @param @param tokenId
	* @param @param seconds    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	void freshExpoireKey(String tokenId, int seconds);
	
	/** 
	* @Title: getAllMemeryCacheKeys 
	* @Description:��ȡĳһ��ģ��ƥ��KEY������
	* @param @param string
	* @param @return �趨�ļ� 
	* @return int    �������� 
	* @throws 
	*/
	int getAllMemeryCacheKeys(String keys);
	
}
