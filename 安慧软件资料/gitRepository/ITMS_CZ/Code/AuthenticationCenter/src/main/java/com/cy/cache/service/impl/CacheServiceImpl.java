package com.cy.cache.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cy.cache.dao.CacheMapper;
import com.cy.cache.domain.CacheDao;
import com.cy.cache.service.CacheServiceI;

import cy.its.platform.common.utils.Log4jFactoryProxy;
import cy.its.platform.common.utils.RedisPoolUtil;

/**
* @Title: CacheServiceImpl.java 
* @Package com.cy.cache.service.impl 
* @Description:ϵͳ�����Ϣ���� 
* @author lil@cychina.cn
* @date 2015��11��12�� ����9:51:17 
* @version V1.0   
 */
@Service("cacheServiceImpl")

public class CacheServiceImpl implements CacheServiceI {

	
	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(CacheServiceImpl.class);
	/**
     * ʹ��@Autowiredע���עuserMapper������
     * ����Ҫʹ��securityMapperʱ��Spring�ͻ��Զ�ע��securityMapper
     */
    @Autowired
    private CacheMapper cacheMapper;//ע��dao
    
    @Autowired
    private DataSource  dataSource;//ע�����ݿ����ӳ�
    
	@Override
	public void initServicesByRoleCode() {
		 log.info("���濪ʼ��ʼ��");
	     List<CacheDao> list = cacheMapper.getServicesByRoleCode();
	     System.out.println("��������ȡ");
	     list.stream() 
	                .collect( 
	                        Collectors.groupingBy( 
	                        		CacheDao::getCode, 
	                                Collectors.mapping(CacheDao::getName, 
	                                        Collectors.toList())))
	     .forEach((k,v)->{
	    	    //��ʼ��֮ǰ ��ɾ����ǰ�Ļ���
	    	    if(RedisPoolUtil.get(k)!=null){
	    	    	RedisPoolUtil.del(k);
	    	    }
	    	    //���³�ʼ��
	    	 	RedisPoolUtil.put(k,JSONObject.toJSONString(v));
	    	 }
	     );
	     log.info("�����������");
	}
	
	@Override
	public void addMemeryCache(String key,String value) {
		RedisPoolUtil.put(key,value);
	}
	
	@Override
	public void addMemeryCache(String key,Map value) {
		RedisPoolUtil.hmput(key,value);
	}
	
	@Override
	public void updateMemeryCache(String key, Object value) {
		RedisPoolUtil.del(key);
		RedisPoolUtil.put(key,JSONObject.toJSONString(value));
	}

	@Override
	public void deleteMemeryCache(String key) {
		RedisPoolUtil.del(key);
	}
	@Override
	public Object getMemeryCacheByKey(String key) {
		return RedisPoolUtil.get(key);
	}
    
	/* (non-Javadoc)
	 * @see com.cy.cache.service.CacheServiceI#getServicesBykey(java.lang.String)
	 * ���ݴ���KEY ��ȡ�����ķ����ַ
	 */
	@Override
	public List<CacheDao> getServicesBykey(String serviceKey) {
		//SqlHelper.getMapperSql(cacheMapper, "getServicesBykey", serviceKey);
		return cacheMapper.getServicesBykey(serviceKey);
	}

	@Override
	public void initKeyList() {
		List<String> keyList  = new ArrayList<String>();
		RedisPoolUtil.put("keyList", JSONArray.toJSONString(keyList));
	}

	@Override
	public void freshExpoireKey(String tokenId,int seconds) {
		RedisPoolUtil.updateExpireTime(tokenId, seconds);
	}

	@Override
	public void addMapCache(String key, Map value, int seconds) {
		RedisPoolUtil.hmputExpoire(key, value,seconds);
	}

	/* (non-Javadoc)
	 * @see com.cy.cache.service.CacheServiceI#addMemeryCache(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void addMemeryCache(String key, String value, int seconds) {
		RedisPoolUtil.putExpire(key, value, seconds);
	}

	/* (non-Javadoc)
	 * @see com.cy.cache.service.CacheServiceI#getAllMemeryCacheKeys(java.lang.String)
	 */
	@Override
	public int getAllMemeryCacheKeys(String keys) {
		Set<String> list =  RedisPoolUtil.getKeys(keys);
		return list.size();
	}
}
