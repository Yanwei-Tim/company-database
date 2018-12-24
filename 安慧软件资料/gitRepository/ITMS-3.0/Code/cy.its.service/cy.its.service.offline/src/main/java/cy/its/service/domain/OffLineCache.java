package cy.its.service.domain;

import java.util.Map;

/**
* @Title: OffLineCache.java 
* @Package cy.its.service.domain 
* @Description: ���߻����ļ�
* @author lil@O.cn
* @date 2015��11��18�� ����3:52:56 
* @version V1.0   
 */
public class OffLineCache {
	
	//�ļ�·��Ϊ��root
	private static String  filePath = "D:/temp";
	
	//�ļ�·��Ϊ��root
	private static String  httpIp = "127.0.0.1:8080";

	/**
     * ��Ų�ͬ����ĵ���
     */
	private  static  Map   exportMap;
	
	/**
	 * ��ʼ����
	 */
	private  OffLineCache(Map map,String  fpath,String httpip){
		exportMap = map;
		filePath = fpath;
		httpIp = httpip;
	}

	public static String getFilePath() {
		return filePath;
	}

	public static Map getMap() {
		return exportMap;
	}
	
	
	/** 
	* @Title: udateMap 
	* @Description: ���������ļ�ʱ���ã���������
	* @param @param map    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public static void udateMap(Map map) {
		synchronized(OffLineCache.class){
			exportMap = map;
		}
	}
	
	public static String getHttpIp() {
		return httpIp;
	}
}
