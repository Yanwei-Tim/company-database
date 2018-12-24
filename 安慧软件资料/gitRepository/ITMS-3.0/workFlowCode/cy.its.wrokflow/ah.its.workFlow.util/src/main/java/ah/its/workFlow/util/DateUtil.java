package ah.its.workFlow.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * ʱ�乤����
 */
public class DateUtil {
    private static final String defaultTimePattern  = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentTime(){
    	return getCurrentTime(defaultTimePattern);
    }
    
    public static String getCurrentTime(String timePattern){
        if(StringUtils.hasText(timePattern)){
            return new SimpleDateFormat(timePattern).format(new Date());
        }else{
            return new SimpleDateFormat(defaultTimePattern).format(new Date());
        }
    }
    
    /**
     * ����ʱ��֮���ʱ����λ����
     */
    public static Long getSubTime(String startTime,String endTime,String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			Date startDate = sdf.parse(startTime);
			Date endDate = sdf.parse(endTime);
			Long subTimes = endDate.getTime() - startDate.getTime();
			return subTimes;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
    
    /**
	  * ������1970-1-1 00:00:00����ǰϵͳʱ������� 
	  */
	public static String getTimestamp(){
		Long time = new Date().getTime();
		time = time / 1000;
		return time.toString();
	}
	
	/**
	 * ��ȡ��������֮���ÿһ��
	 */
	public static List<Date> SubDay(String s_date,String e_date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Long subTimes ;
		Date startDate ;
		Date endDate ;
		try {
			startDate = sdf.parse(s_date);
			endDate = sdf.parse(e_date);
			subTimes = endDate.getTime() - startDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		Long step = subTimes / (24 * 60 * 60 * 1000);// �������
	 	List<Date> dateList = new ArrayList<Date>();
	    dateList.add(endDate);
	    for (int i = 1; i <= step; i++) {
	        dateList.add(new Date(dateList.get(i - 1).getTime()
	                - (24 * 60 * 60 * 1000)));// ����һ���һ
	    }
		return dateList;
	}
	
	/**
	 * ��ת����hh:mm:ss
	 */
	public static String secToTime(int time) {  
        String timeStr = null;  
        int hour = 0;  
        int minute = 0;  
        int second = 0;  
        if (time <= 0)  
            return "00:00";  
        else {  
            minute = time / 60;  
            if (minute < 60) {  
                second = time % 60;  
                timeStr = unitFormat(minute) + ":" + unitFormat(second);  
            } else {  
                hour = minute / 60;  
                if (hour > 99)  
                    return "99:59:59";  
                minute = minute % 60;  
                second = time - hour * 3600 - minute * 60;  
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);  
            }  
        }  
        return timeStr;  
    }  
  
    public static String unitFormat(int i) {  
        String retStr = null;  
        if (i >= 0 && i < 10)  
            retStr = "0" + Integer.toString(i);  
        else  
            retStr = "" + i;  
        return retStr;  
    }  
    
    /**
     * ��ǰ����ǰ���������
     * ����������������ǰ���븺��
     */
    public static String findDay(int d) {  
    	SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd"); //�ַ���ת��
    	Calendar c = Calendar.getInstance(); 
    	c.setTimeInMillis(new Date().getTime());
    	c.add(Calendar.DATE, d);
    	Date date= new Date(c.getTimeInMillis()); //��cת����Date
    	String retdate = formatDate.format(date);
    	return retdate;
    }
    
    /** 
	* @Description: ��ʱ��LONG ת��Ϊ����
	*/
    public static Object toDate(String time) {
		if(StringUtils.isEmpty(time)){
			return null;
		}
		long  dt =  Long.valueOf(time);
		Date  date  = new  Date();
		date.setTime(dt);
		return date;
	}
	
	/** 
	* @Description: ���ַ�������ʱ�� ת��Ϊdate����ʱ��(yyyy-MM-dd HH:mm:ss)
	*/
    public static Object StringtoDate(String time,String pattern) {
		if(StringUtils.isEmpty(time)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);//ע���ʽ���ı��ʽ
		Date d = null;
		try {
			d = sdf.parse(time );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
    
    /**
     * dateת����string
     */
    public static Object DatetoString(Date time,String pattern) {
		if(StringUtils.isEmpty(time)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);//ע���ʽ���ı��ʽ
		String d = sdf.format(time );
		return d;
	}
}
