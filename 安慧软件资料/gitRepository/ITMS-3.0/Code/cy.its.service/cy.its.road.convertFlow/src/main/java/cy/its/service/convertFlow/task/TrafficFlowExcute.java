package cy.its.service.convertFlow.task;

import java.util.ArrayList;
import java.util.List;

import cy.its.service.util.DBUtil;

/**
* @Title: TrafficFlowInsert.java 
* @Package cy.its.road.convertFlow.task 
* @Description:���ݲ��������
* @author lil@cychina.cn
* @date 2015��10��29�� ����4:07:07 
* @version V1.0   
 */
public class TrafficFlowExcute implements Runnable {
    
	//�����б�
	public List<String>  sqlList  = new  ArrayList<String>();
	
	/* 
	 * ִ�в��뷽��
	 */
	@Override
	public void run() {
		//����ִ�еķ���
        DBUtil.executeBatchData(sqlList);
        
	}

}
