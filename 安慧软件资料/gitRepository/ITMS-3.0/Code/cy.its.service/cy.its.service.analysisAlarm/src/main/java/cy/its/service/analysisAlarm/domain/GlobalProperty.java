package cy.its.service.analysisAlarm.domain;

/**
* @Title: GlobalProperty.java 
* @Package cy.its.service.zeroFlow.domain 
* @Description:ȫ�ֲ���
* @author lil@cychina.cn
* @date 2015��11��12�� ����6:57:19 
* @version V1.0   
 */
public class GlobalProperty {
  //������Сֵ
  //1����Ԥ���ɿ�ʼʱ��
  private static  int startTime  =0;
  //1����Ԥ������ʱ��
  private static  int  endTime  =0;
  
  //����
  private static  int  delayTime = 30;
  
  private GlobalProperty(int value2,int  value3,int value4){
	  startTime = value2;
	  endTime = value3;
	  delayTime = value4;
  }
  
   public static int getStartTime() {
		return startTime;
   }
   public static int getEndTime() {
		return endTime;
   }
	
   public static int getDelayTime() {
	   return delayTime;
   }
}
