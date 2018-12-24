package cy.its.service.analysisAlarm.module;

import java.util.List;

import javax.print.DocFlavor.STRING;



import cy.its.service.analysisAlarm.domain.TrafficAlarmValue;
import cy.its.service.util.DBUtil;
import cy.its.service.util.StringUtils;

/**
* @Title: CacheManager.java 
* @Package cy.its.service.section.module 
* @Description:�����������5��ָ�����ֵ��Ϣ �ܼ��ȡ�·�С�����
* @author lil@cychina.cn
* @date 2015��11��4�� ����6:46:17 
* @version V1.0   
* 
 */
public class CacheManager {
	
	//�ܼ���
	private static   List<TrafficAlarmValue> listv=null;
	
	//·���¶�
	private static   List<TrafficAlarmValue> listr=null;
	
	//���
	private static   List<TrafficAlarmValue> listwd=null;
	
	//ˮĤ���
	private static   List<TrafficAlarmValue> listwt=null;
	
	//��ѩpublic
	private static   List<TrafficAlarmValue> listice=null;
	
	
	//��ѩpublic
	private static   List<TrafficAlarmValue> listtr=null;
	
	
	/*
	 * ��·����
	 */
	private static  String    roadType = "0";
	/**
	 * ƽ������ʱ�䳬��Ԥ��
	 */
	public final static String  alermTypetr="04";
	
	/**
	 * Ԥ������ �ܼ���
	 */
	public final static String  alermTypev="31";
	/**
	 * Ԥ������ ·���¶�
	 */
	public final static String  alermTyper="32";
	/**
	 * Ԥ������  ˮĤ���
	 */
	public final static String  alermTypewt="33";
	
	/**
	 * Ԥ������  ��ѩ��Ԥ�� 34
	 */
	public final static String  alermTypeice="34";
	/**
	 * Ԥ������  ����
	 */
	public final static String  alermTypewd="35";
	
	
	
	/**
	 * @param alermType
	 * @return
	 * ��������������ʼ�������Ϊ���ȳ�ʼ������
	 */
	public  static  List<TrafficAlarmValue> getTrafficAlarmDataList(String alermType){
	    if(alermType.equals(alermTypev)){
	    	if(listv == null){
	    		initWarnList(alermType,"");
	    	}
	    	return listv;
	    }else if(alermType.equals(alermTypewt)){
	    	if(listwt == null){
	    		initWarnList(alermType,"");
	    	}
	    	return listwt;
		}else if(alermType.equals(alermTyper)){
			if(listr == null){
	    		initWarnList(alermType,"");
	    	}
	    	return listr;
		}else if(alermType.equals(alermTypeice)){
			if(listice == null){
	    		initWarnList(alermType,"");
	    	}
	    	return listice;
		}else if(alermType.equals(alermTypewd)){
			if(listwd == null){
	    		initWarnList(alermType,"");
	    	}
	    	return listwd;
		}else if(alermType.equals(alermTypetr)){
			if(listtr == null){
	    		initWarnList(alermType,"");
	    	}
			return listtr;
		}else{
			return null;
		}
	}
	//����ˢ�»���
	public static void initWarnList(String alermType,String rt){
		synchronized(CacheManager.class){
			if(StringUtils.isEmpty(rt)){
				rt = roadType;
			}
			if(alermType.equals(alermTypev)){
				listv = DBUtil.queryData(getSql(alermType,rt),TrafficAlarmValue.class);
		    }else if(alermType.equals(alermTypewt)){
		    	listwt = DBUtil.queryData(getSql(alermType,rt),TrafficAlarmValue.class);
			}else if(alermType.equals(alermTyper)){
		    	listr = DBUtil.queryData(getSql(alermType,rt),TrafficAlarmValue.class);
			}else if(alermType.equals(alermTypeice)){
		    	listice = DBUtil.queryData(getSql(alermType,rt),TrafficAlarmValue.class);
			}else if(alermType.equals(alermTypewd)){
		    	listwd = DBUtil.queryData(getSql(alermType,rt),TrafficAlarmValue.class);
			}else if(alermType.equals(alermTypetr)){
				listtr = DBUtil.queryData(getSql(alermType,rt),TrafficAlarmValue.class);
			}
		}
	}
	
	/** 
	* @Title: getSql 
	* @Description: Ԥ������SQL��ȡ
	* @param @param alermType
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	public static String getSql(String  alermType,String roadType){
		
		return  " select  t.alarm_value_type alarmValueType,t.road_type roadType,t.alarm_grade alermGrade,t.min min,t.max max  from  t_traffic_alarm_value  t  where t.road_type='"+roadType+"' and  t.alarm_value_type='"+alermType+"'";
	}
	
}
