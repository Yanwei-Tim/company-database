package cy.its.sysLog.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @Title: LogTaskThroadManager.java 
* @Package cy.its.sysLog.task 
* @Description: �̳߳أ�һ�㲻�ر� 
* @author lil@cychina.cn
* @date 2015��8��31�� ����7:07:55 
* @version V1.0   
 */
public class LogTaskThroadManager {
	
   private  static ExecutorService pool = Executors.newFixedThreadPool(3);//����Ҫ�ر��̳߳�
   
   /** 
	* @Title: addTaskPool 
	* @Description: ���̳߳ؼ�������
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public static void  addTaskPool(Thread task){
		
		pool.execute(task);//��������̳߳��У����̳߳ش���
	
	}
}
