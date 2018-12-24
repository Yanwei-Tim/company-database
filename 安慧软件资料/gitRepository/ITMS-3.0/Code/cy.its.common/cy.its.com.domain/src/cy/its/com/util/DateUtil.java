package cy.its.com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private final static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>();
	private final static String formatStr = "yyyy-MM-dd";
	
	/**
	 * ������ת�����ַ���  yyyy-MM-dd HH:mm:ss
	 *
	 * @param date
	 * @return String
	 */
	public static String formatDate(Date date) {
		return getDataFormat().format(date);
	}

	/**
	 * ���ַ���ת������������    yyyy-MM-dd HH:mm:ss
	 * �ַ���Ϊ�շ���null��
	 * ת�����쳣�򷵻ص�ǰʱ��
	 * @param dataStr
	 * @return Date
	 */
	public static Date parseDate(String dataStr) {
		if (!StringUtil.isNullOrEmpty(dataStr)) {
			try {
				return getDataFormat().parse(dataStr);
			} catch (Exception e) {
				return new Date();
			}
		}
		return null;
	}

	private static SimpleDateFormat getDataFormat() {
		SimpleDateFormat sdf = local.get();
		if (sdf == null) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			local.set(sdf);
		}
		return sdf;
	}
	

	public static Date addDateByHour(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hour);
		return calendar.getTime();
	}
	
	
	/**
	 * ���ַ���ת������������   
	 * �ַ���Ϊ�ջ�ת�����쳣�򷵻�null��
	 * @param dataStr �����ַ���
	 * @param format  ���ڸ�ʽ
	 * @return Date
	 */
	public static  Date parseFormatDate(String dataStr,String format) {
		if (!StringUtil.isNullOrEmpty(dataStr)) {
			try {
				return new SimpleDateFormat(format).parse(dataStr);
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * ���ַ���ת������������(��ʽ��yyyy-MM-dd)
	 * �ַ���Ϊ�ջ�ת�����쳣�򷵻�null��
	 * @param dataStr �����ַ���
	 * @return
	 * @return Date
	 */
	public static  Date parseFormatDate(String dataStr) {
		return parseFormatDate(dataStr,formatStr);
	}
	
	
	/**
	 * ����������ת�����ַ���   
	 * ����Ϊ�ջ�ת�����쳣�򷵻�null��
	 * @param dataStr �����ַ���
	 * @param format  ���ڸ�ʽ
	 * @return Date
	 */
	public static  String parseFormatDate(Date date,String format) {
		if (date != null) {
			try {
				return new SimpleDateFormat(format).format(date);
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * ����������ת�����ַ���(��ʽ��yyyy-MM-dd)
	 * ����Ϊ�ջ�ת�����쳣�򷵻�null��
	 *
	 * @param date
	 * @return String
	 */
	public static  String parseFormatDate(Date date) {
		return parseFormatDate(date,formatStr);
	}
	
}
