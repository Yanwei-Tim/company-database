package ah.its.workFlow.web.servlet;

import java.util.Properties;
/**
 * @author lilei
 * ϵͳȫ�����Գ�ʼ��
 */
public final class GlobalProerty {
	
   public final   String projectPath;//��Ŀ·��
   public final   String model;//Ŀǰģʽ������������
   public final   String service_ip; //�ֲ�ʽ��ַ
   public final   String service_img; //ͼƬ��������ַ
   public final   String validate_ip;//�û���֤��Ȩ��������ַ
   public final   String authorityPName;//Ȩ����֤��Ŀ����
   private static GlobalProerty globalProerty;  
   
   private GlobalProerty(Properties prop){
       service_ip=prop.getProperty("service_ip");
       model=prop.getProperty("model");
       projectPath=prop.getProperty("prefix");
       service_img=prop.getProperty("service_img");
       validate_ip=prop.getProperty("validate_ip");
       authorityPName=prop.getProperty("authorityPName");
   }
   
	/** 
	* @Title: setGlobalProerty 
	* @Description: ����ʼ��һ�� �����Ʒ����ڷ���
	* @param @param prop    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
   static void setGlobalProerty(Properties prop){
		   globalProerty = new GlobalProerty(prop);
   }
   
   /** 
	* @Title: getGlobalProerty 
	* @Description:�ṩȫ�ֵķ��ʵ� 
	* @param @return    �趨�ļ� 
	* @return GlobalProerty    �������� 
	* @throws 
	*/
	public  static GlobalProerty getGlobalProerty(){
		   return globalProerty; 
   }
}
