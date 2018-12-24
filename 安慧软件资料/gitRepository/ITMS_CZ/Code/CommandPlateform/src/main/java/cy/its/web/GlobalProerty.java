package cy.its.web;

import java.util.HashMap;
import java.util.Map;

import cy.its.platform.common.utils.OrderedProperties;


/**
 * @author lilei
 * ϵͳȫ�����Գ�ʼ��
 */
public final class GlobalProerty {
	
   public final   String projectPath;//��Ŀ·��
   public final   String model;//Ŀǰģʽ������������
   public final   String service_ip; //�ֲ�ʽ��ַ
   public final   String validate_ip;//�û���¼��������֤�������ֵ䡢wescoket ���� ip ��ַ
   public final   String servicePName;//������Ŀ����
   public final   String authorityPName;//��֤��Ȩ��֤������Ŀ����
   public final   Map 	 routeMap;
   
   
   private static GlobalProerty globalProerty;  
   
   private GlobalProerty(OrderedProperties prop){
       service_ip=prop.getProperty("service_ip");
       model=prop.getProperty("model");
       projectPath=prop.getProperty("prefix");
       validate_ip=prop.getProperty("validate_ip");
       servicePName=prop.getProperty("servicePName");
       authorityPName=prop.getProperty("authorityPName");
       routeMap = new HashMap();
       /**
        *·������ ,��ʽ���£�
        *routeKeys=device,sysManager
        * device=192.168.10.33:8080
        * sysManager=192.168.10.33:8081
        */
       String keys  = prop.getProperty("routeKeys")==null?"":prop.getProperty("routeKeys");
       if(!keys.equals("")){
    	   if(keys.indexOf(",")>-1){
    		   String key[] = keys.split(",");
    		   for(String tkey:key){
    			   routeMap.put(tkey, prop.getProperty(tkey));
    		   }
    	   }else{
    		   routeMap.put(keys, prop.getProperty(keys));
    	   }
       }
   }
   
	/** 
	* @Title: setGlobalProerty 
	* @Description: ����ʼ��һ�� �����Ʒ����ڷ���
	* @param @param prop    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
   static void setGlobalProerty(OrderedProperties prop){
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
