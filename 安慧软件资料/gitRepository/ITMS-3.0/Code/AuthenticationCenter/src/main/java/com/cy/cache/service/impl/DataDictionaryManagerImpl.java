package com.cy.cache.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.cy.cache.domain.CacheDao;
import com.cy.cache.service.DataDictionaryManagerI;

import cy.its.platform.common.utils.DBUtil;
import cy.its.platform.common.utils.JacksonXmlUtil;
import cy.its.platform.common.utils.Log4jFactoryProxy;
import cy.its.platform.common.utils.RedisPoolUtil;

/** 
* @Title: DataDictionaryManagerImpl.java 
* @Package com.cy.cache.service.impl 
* @Description: �����ֵ������ 
* @author lil@cychina.cn
* @date 2015��8��19�� ����4:52:46 
* @version V1.0   
 */
//@Service
public class DataDictionaryManagerImpl implements DataDictionaryManagerI {

	private  Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(DataDictionaryManagerImpl.class);
	
	private  String  path ="";
	
	@Autowired
	private  DataSource  dataSource;//ע������Դ������JDBC��ѯ���ݿ�����
	
	/* (non-Javadoc)
	 * @see com.cy.cache.service.DataDictionaryManagerI#initMemoryCache(java.lang.String)
	 * ��ʼ�����е������ֵ�
	 */
	@Override
	public void initMemoryCache(String  pathinfo) {
		path = pathinfo;//����XML�ļ�·��
		Map  map =  JacksonXmlUtil.convertXMLtoMap(path);//��XMLת��ΪMAP
		for (Object key : map.keySet()) {
			if(key != null){
				queryDataList(key,map.get(key));//������ѯ����
			}
		}
	}

	/** 
	* @Title: queryDataList 
	* @Description:  
	* @param @param object    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private void queryDataList(Object key,Object sql) {
         if(!StringUtils.isEmpty(sql)){ //sql��Ϊ�գ�ִ�в�ѯ
        	List list =  DBUtil.queryData(sql.toString(),dataSource);
        	if(list.size()>0){
        		RedisPoolUtil.put(key.toString(), JSONArray.toJSONString(list));
        	}
         }		
	}

	/* (non-Javadoc)
	 * @see com.cy.cache.service.DataDictionaryManagerI#updateMemoryCache(java.lang.String[])
	 * �ֶ����»���
	 */
	@Override
	public void updateMemoryCache(String[] keys) {
		for(String  key  : keys){
			if(!StringUtils.isEmpty(key)){
				Map  map =  JacksonXmlUtil.convertXMLtoMap(path);//��XMLת��ΪMAP
				String  sql = map.get(key)==null?"":map.get(key).toString();
				if(!StringUtils.isEmpty(sql)){
					RedisPoolUtil.del(key.toString());
					queryDataList(key,sql);
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.cy.cache.service.DataDictionaryManagerI#queryMemoryCache(java.lang.String[])
	 * ���ݴ����KEY ����LIST 
	 */
	@Override
	public Map queryMemoryCache(String[] keys) {
		// TODO Auto-generated method stub
		Map map  = new  HashMap();
		for(String  key  : keys){
			if(!StringUtils.isEmpty(key)){
				Object obj =  RedisPoolUtil.get(key.toString());
				if(obj!=null){
					List<CacheDao>  list  = JSONArray.parseArray(obj.toString(), CacheDao.class);
					map.put(key,list);
				}
			}
		}
		return map;
	}

}
