package com.cy.web;


/**
* @Title: GlobalProerty.java 
* @Package com.cy.web 
* @Description: ϵͳ��ʼ����Ϣ��ֻ�ṩget����
* @author lil@cychina.cn
* @date 2015��10��30�� ����10:02:44 
* @version V1.0   
 */
public class GlobalProerty {
	
   private static  String projectPath="";//��Ŀ·��
   private static  String model="";//Ŀǰģʽ������������
   private static  String isDistributed="";//�Ƿ�ֲ�ʽ
   private static  String service_ip=""; //�ֲ�ʽ��ַ
   private static  String validate_ip="";//�û���¼��������֤�������ֵ䡢wescoket ���� ip ��ַ
   private static  String servicePName="";//������Ŀ����
   private static  String authorityPName="";//��֤��Ȩ��֤������Ŀ����
   
   private GlobalProerty(String projectPathc,String modelc,String isDistributedc,String service_ipc
		   ,String validate_ipc,String servicePNamec,String authorityPNamec){
	   projectPath=projectPathc;
	   model=modelc;
	   isDistributed=isDistributedc;
	   service_ip=service_ipc;
	   validate_ip=validate_ipc;
	   servicePName=servicePNamec;
	   authorityPName=authorityPNamec;
    }
   
	public static String getProjectPath() {
		return projectPath;
	}
	public static String getModel() {
		return model;
	}
	public static String getIsDistributed() {
		return isDistributed;
	}
	public static String getService_ip() {
		return service_ip;
	}
	public static String getValidate_ip() {
		return validate_ip;
	}
	public static String getServicePName() {
		return servicePName;
	}
	public static String getAuthorityPName() {
		return authorityPName;
	}
	
}
