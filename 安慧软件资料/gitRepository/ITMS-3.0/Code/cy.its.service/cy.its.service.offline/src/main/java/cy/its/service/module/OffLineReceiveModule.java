package cy.its.service.module;

import java.lang.reflect.Constructor;
import java.text.DecimalFormat;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.druid.util.StringUtils;

import cy.its.service.domain.OffLine;
import cy.its.service.domain.OffLineCache;
import cy.its.service.domain.OffLineTask;
import cy.its.service.util.DBUtil;
import cy.its.service.util.ExecutorServiceUtil;


/**
* @Title: OffLineReceiveModule.java 
* @Package cy.its.service.module 
* @Description:MQ������Ϣ�����յ���Ϣ˵����������Ҫ����
* @author lil@cychina.cn
* @date 2015��11��17�� ����7:58:09 
* @version V1.0   
 */
public class OffLineReceiveModule implements Job{
	//���ݸ�ʽ��
	DecimalFormat df3 = new DecimalFormat("#.00");
	
	String  sql= " select  task_id taskId,func_key funcKey,file_name fileName,export_sql exportSql,export_sql2 exportSql2,status,update_time updateTime,login_name loginName from T_SYS_EXPORT where  status = '1' ";//������
	
	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 * ��ʱ���񴥷�����
	 */
	@Override
	public void execute(JobExecutionContext context){
		//��ѯ���ݿ�����
		List<OffLine>   list = DBUtil.queryData(sql,OffLine.class);
		//������¼
		list.stream().forEach(ol->{
			String sql  = ol.getExportSql();
			//SQL��Ϊ�յ�ʱ��Ŵ���
			if(!StringUtils.isEmpty(sql)){
				String  className = (String) OffLineCache.getMap().get(ol.getFuncKey());
				Class cl;
				try {
					cl = Class.forName(className);
					Constructor c0=cl.getConstructor(new Class[]{String.class,String.class,String.class,String.class}); 
					OffLineTask  otask  = (OffLineTask) c0.newInstance(new String[]{ol.getTaskId(),ol.getExportSql(),ol.getFileName(),ol.getLoginName()});
					//����Ϊ�Ŷ���
					updateTask(ol.getTaskId(),"2");
					//�����������Դ����
					ExecutorServiceUtil.addTask(otask);
				} catch (Exception e) {
					//����״̬��Ȼ���׳��쳣
					updateTask(ol.getTaskId(),"5");
					e.printStackTrace();
				}
				
			}else{
				//����Ϊ����ʧ��
				updateTask(ol.getTaskId(),"5");
			}
		});
	}
	
	/** 
	* @Title: updateTask 
	* @Description: ���������״̬
	* @param @param taskId
	* @param @param string    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private void updateTask(String taskId, String status) {
		String  updateSql = "update T_SYS_EXPORT set  status = '"+status+"' where task_id= '"+taskId+"'";
		DBUtil.updateData(updateSql);
	}
}
