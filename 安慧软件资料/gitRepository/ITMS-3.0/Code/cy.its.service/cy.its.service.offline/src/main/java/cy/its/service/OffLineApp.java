package cy.its.service;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import cy.its.service.domain.OffLineCache;
import cy.its.service.imageQuery.cfg.dataAccess.DataSourceFactory;
import cy.its.service.module.OffLineReceiveModule;
import cy.its.service.util.DBUtil;
import cy.its.service.util.QuartzManager;
import cy.its.service.util.RedisPoolUtil;
import cy.its.service.util.ServiceFileResource;

/**
* @Title: OffLineApp.java 
* @Package cy.its.service 
* @Description: �������������� 
* @author lil@cychina.cn
* @date 2015��11��17�� ����7:55:52 
* @version V1.0   
 */
public class OffLineApp {
	
	private static  Logger log=Logger.getLogger(OffLineApp.class);
	/**
	 * ��ʼ�����е���Դ�ļ�
	 */
	static{
		try {
			ConfigAllProperties();
		} catch (SQLException e) {
			log.error("���ݿ����ӳ����쳣��");
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws SQLException  
	* @Title: ConfigAllProperies 
	* @Description: ���������ļ����������ļ� 
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private static void ConfigAllProperties() throws SQLException {
		//��Դ�ļ���ʼ��
		ServiceFileResource   sfr  = new ServiceFileResource("global.xml","offline.log");
		DataSourceFactory.setDataSource(DBUtil.getDataSource());
		//redisʵ����
		RedisPoolUtil.index  = 2;
		//�����ļ���
		//���ر��������ļ�
		InputStream   is = OffLineApp.class.getResourceAsStream("/config/properies/export.properties");
        Properties props = new Properties();
		try {
			props.load(is);
			is.close();
			Map  map  = new HashMap();
			for(Object t:props.keySet()){  
			    map.put(t.toString(),props.getProperty(t.toString()));
		    }  
			Constructor c0=OffLineCache.class.getDeclaredConstructor(new Class[]{Map.class,String.class,String.class});   
			c0.setAccessible(true);
			c0.newInstance(new Object[]{map,props.get("rootPath"),props.get("httpIp")});
		} catch (Exception e) {
			log.error("�����ļ������쳣��");
			e.printStackTrace();
		}
		
		
	}
	
	public  static  void main(String[] args){
		System.out.println("��ʼ");
		OffLineReceiveModule  pl  = new OffLineReceiveModule();
		try {
			QuartzManager.addJob("offlineTriger", "offline", new Date(), OffLineReceiveModule.class, 60);
		} catch (SchedulerException | ParseException e) {
			log.error("��ʱ��������ʧ�ܣ������´���");
			e.printStackTrace();
		}
	}
}
