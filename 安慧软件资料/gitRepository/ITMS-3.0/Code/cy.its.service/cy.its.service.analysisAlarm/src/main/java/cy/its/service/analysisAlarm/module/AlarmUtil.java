package cy.its.service.analysisAlarm.module;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import cy.its.service.analysisAlarm.domain.WeatherAlarm;
import cy.its.service.util.TableColumn;

/**
* @Title: AlarmUtil.java 
* @Package cy.its.service.analysisAlarm.module 
* @Description: Ԥ����Ϣ������
* @author lil@cychina.cn
* @date 2015��12��16�� ����9:42:56 
* @version V1.0   
 */
public class AlarmUtil {
	
	//���ڸ�ʽ��
	private static SimpleDateFormat  df  = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//����
	public  final  static  String  alarmEventTypeF = "506"; 
	//����
	public  final  static  String  alarmEventTypeW = "502"; 
	//�¼�ץ��
	public  final  static  String  alarmEventTypeR = "434"; 
	
	//�ܼ���Ԥ��
	public  final  static  String  TYPE_5021 = "1";
	
	//·���¶�Ԥ��
	public  final  static  String  TYPE_5022 = "2";
	//·���ˮԤ��
	public  final  static  String  TYPE_5023 = "3";
	//����Ԥ��
	public  final  static  String  TYPE_5024 = "4";
	//·����Ԥ��
	public  final  static  String  TYPE_5025 = "5";
	
	
	//����ͻ��Ԥ��
	public  final  static  String  TYPE_50601 = "01";
	//����Ԥ��
	public  final  static  String  TYPE_50602 = "02";
	//��������ʱ�䳬��Ԥ��
	public  final  static  String  TYPE_50604 = "04";
	
	/** 
	* @Title: generatorId 
	* @Description: ����Ψһ�� 
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	public  static String generatorId(){
	   String  id = UUID.randomUUID().toString().replace("-",""); 
	   return  id;
    }
	
	/**
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException  
	* @Title: getSql 
	* @Description:��ȡSQLִ�����
	* @param @param alarm
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	public static String getSql(WeatherAlarm alarm) throws IllegalArgumentException, IllegalAccessException {
		StringBuffer   sb = new StringBuffer();
		StringBuffer   sb2 = new StringBuffer();
		sb.append(" insert  into T_TRAFFIC_ALARM_EVENT( ");
		sb2.append(" values( ");
		Field[] fs = WeatherAlarm.class.getDeclaredFields(); 
		for(int i = 0 ; i < fs.length; i++){  
			 Field f = fs[i];  
			 if(f.isAnnotationPresent(TableColumn.class)){
				 TableColumn tableColumn = f.getAnnotation(TableColumn.class);
				 sb.append(tableColumn.name()+",");
				 f.setAccessible(true); //����Щ�����ǿ��Է��ʵ� 
				 Object val = f.get(alarm);//�õ������Ե�ֵ
				 String type = f.getType().toString();//�õ������Ե����� 
				 if (type.endsWith("String")) {  
					 sb2.append("'"+val+"',");
				 }else if(type.endsWith("Date")){
					 sb2.append(" to_date('"+df.format(val)+"','yyyy-mm-dd hh24:mi:ss'),");
				 }else{
					 sb2.append(val+",");
				 }
	         }
		}
		if(sb.length() > 1){
			sb.deleteCharAt(sb.length()-1);
		}
		if(sb2.length() > 1){
			sb2.deleteCharAt(sb2.length()-1);
		}
		sb.append(" ) ");
		sb2.append(") ");
		return sb.toString() + sb2.toString();
	}
	
	public static String getUpdateSql(WeatherAlarm alarm,Date  startTIme) {
		String sql  = " update T_TRAFFIC_ALARM_EVENT set END_ALARM_TIME = to_date('"+df.format(startTIme)+"','yyyy-mm-dd hh24:mi:ss') ";
		sql  += " where  ALARM_EVENT_ID = '"+alarm.getAlarmEventId()+"'";
		return sql;
	}
}
