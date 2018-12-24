package ah.its.workFlow.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSONArray;

/**
* @Title: DictionaryUtil.java 
* @Package ah.its.workFlow.util 
* @Description: �����ֵ��ʼ���������ļ�Ϊ 
* @author lil@cychina.cn
* @date 2016��4��8�� ����9:26:06 
* @version V1.0   
 */
public class DictionaryUtil {
	
	
	private static Logger logger = Logger.getLogger(DictionaryUtil.class);
	
	private static DataSource  dataSource;
	
	private static String   path;
	
	/** 
	* @Description: ÿһ��ID ��Ӧһ�������б��ļ���Ϣ
	* @param @param config    ��ȡspring�������datasource
	* @return void    �������� 
	* @throws 
	*/
	public static void initAll(ServletConfig config,String  pathinfo){
		 path = pathinfo;
		 ApplicationContext springBeanFactory = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		 dataSource = (DataSource) springBeanFactory.getBean("dataSource");
		 Map  map =  JacksonXmlUtil.convertXMLtoMap(pathinfo);//��XMLת��ΪMAP
		 for (Object key : map.keySet()) {
			if(key != null){
				try{
					queryDataList(key,map.get(key));//������ѯ����
				}catch(Exception e){
					logger.error("�����ֵ䣺"+key+"--�����쳣��");
				}
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
	private static void queryDataList(Object key,Object sql) {
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
