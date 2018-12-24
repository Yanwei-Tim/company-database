package cy.its.service.util;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @Title: ExecutorServiceUtil.java 
* @Package cy.its.road.convertFlow.util 
* @Description: �����̳߳� ��Ҫ˳��
* @author lil@cychina.cn
* @date 2015��10��29�� ����11:08:34 
* @version V1.0   
 */
public class ExecutorServiceUtil {
    
	/*
     * �̳߳�
     */
	private static ExecutorService singleThreadExecutor;
	
	/**
	 * ÿ������ʼ֮ǰ�ȼ��ظ�����
	 */
	private static CopyOnWriteArrayList  preTask;
	
    static{
    	singleThreadExecutor = Executors.newCachedThreadPool();
    	preTask  = new CopyOnWriteArrayList();
    }
    
    /** 
    * @Title: addTask 
    * @Description:����������̳߳���
    * @param @param task    �趨�ļ� 
    * @return void    �������� 
    * @throws 
    */
    public static void  addTask(Runnable task){
    	singleThreadExecutor.execute(task);
    }
    
    /** 
    * @Title: shutdown 
    * @Description: �������Ҫ��ر��̳߳�
    * @param     �趨�ļ� 
    * @return void    �������� 
    * @throws 
    */
    public  static  void shutdown(){
    	if(!singleThreadExecutor.isShutdown()){
    		singleThreadExecutor.shutdown();
    	}
    }
    
    /** 
    * @Title: removeAllPre 
    * @Description: ɾ������
    * @param @param object �趨�ļ� 
    * @return void    ��������  
    * @throws 
    */
    public static  void  removePre(Object  object){ 
       	preTask.remove(object);
    }
    
    /** 
    * @Title: getPreList 
    * @Description: ��ȡǰ������
    * @param @param object    �趨�ļ� 
    * @return void    �������� 
    * @throws 
    */
    public static  List   getPreList(){
     	
    	return preTask;
    
    }
}
