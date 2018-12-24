package cy.its.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ʱ�䴦������
 *
 */
public class TimeUtil {
	/** 
	* @Title: getPeriodkey 
	* @Description:���ݴ�������������ǰ�����Ǹ�����
	* @param @param format
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	public static long getPeriodkey(Date currentTime) {
		int  value  = currentTime.getMinutes();
		int  s = value/10;
		value = value%10;
		if(value>=5){
			currentTime.setMinutes(s*10+5);
		}else{
			currentTime.setMinutes(s*10);
		}
		currentTime.setSeconds(0);
		//���ڵ��������5���ӣ������Ҫ��5����
		currentTime.setTime(currentTime.getTime());
		return 1000*(currentTime.getTime()/1000);
	}
	

	/**
	 * @throws ParseException  
	* @Title: getPeriodkey 
	* @Description:���ݴ�������������ǰ�����Ǹ�����
	* @param @param format
	* @param @return �趨�ļ� 
	* @return String �������� 
	* @throws 
	*/
	public static  Date getPeriodkey1(Date currentTime) throws ParseException {
		int  value  = currentTime.getMinutes();
		int  s = value/10;
		value = value%10;
		if(value>=5){
			currentTime.setMinutes(s*10+5);
		}else{
			currentTime.setMinutes(s*10);
		}
		currentTime.setSeconds(0);
		return currentTime;
	}

	/**
	 * @param startTime
	 * ���ݴ���ֵ��ȡ�����5��������
	 * @return
	 */
	public static Date reduceFiveMinute(Date startTime) {
		long time  = startTime.getTime();
		Date endDate  = new Date();
		endDate.setTime(time - 5*60*1000);
		return endDate;
	}
	
	/**
	 * @param ��ȡ����Сʱ��KEYֵ
	 * ��Ϊredis KEY��������Сʱ�Զ�����
	 * @return
	 */
	public static String twoHoursKey(Date startTime) {
		Date date  = new Date();
		date.setTime(startTime.getTime());
		int hours  = date.getHours();
		if(hours%2 != 0){
			hours =hours  -1;
		}
		date.setHours(hours);
		SimpleDateFormat  sf  = new SimpleDateFormat("yyyyMMddHH");
		return sf.format(date);
	}
	
	/**
	 * @param ��ȡ����Сʱ��KEYֵ
	 * ��Ϊredis KEY��������Сʱ�Զ�����
	 * @return
	 */
	public static String twoHoursKey(Date time,int min) {
		Date startTime  = new Date();
		startTime.setTime(time.getTime());
		//��������
		int minutes = startTime.getMinutes();
		minutes= minutes -min;
		startTime.setMinutes(minutes);
		
		int hours  = startTime.getHours();
		if(hours%2 != 0){
			hours =hours  -1;
		}
		startTime.setHours(hours);
		SimpleDateFormat  sf  = new SimpleDateFormat("yyyyMMddHH");
		return sf.format(startTime);
	}
	
	public static void main(String[] args) throws ParseException{
		
		SimpleDateFormat  sf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<40;i++){
			Date  date = new Date();
			date.setHours(i);
			System.out.println(twoHoursKey(date));
		}
	}
}
