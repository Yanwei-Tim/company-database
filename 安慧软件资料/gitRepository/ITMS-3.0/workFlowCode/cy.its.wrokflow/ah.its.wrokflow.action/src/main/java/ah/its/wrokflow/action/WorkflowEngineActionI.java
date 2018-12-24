package ah.its.wrokflow.action;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.dto.CheckRecord;
import ah.its.wrokflow.dto.InstanceRecord;

/**
* @Package cy.its.wrokflow.approve.action 
* @Description: ��Ҫ��������������淽��Ľӿ�
* @author lil@cychina.cn
* @version V1.0   
 */
public interface WorkflowEngineActionI {
	
	/** 
	* @Description: �������̣������̲���ָ��Ŀ¼���ɱ����ϴ�Ȼ�����ַ 
	* @param @param fileUrl
	* @param @return  �ɹ���־ 1����ɹ� 0ʧ��
	* @return Map    ��������
	* @throws 
	*/
	public Map deployById(String fileUrl);
	
	
	
	/** 
	* @Description: ��ҳ��ʽ��ȡ���е����̲�������
	* @param @param startPage
	* @param @param pageSize
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public Map queryDeployAll(String startPage, String pageSize);
	
	
	/** 
	* @Description: �ύ���뵥��Ȼ���������̣���������ʵ��ID
	* @param @param ProcessDefinitionId
	* @param @param approveId
	* @param @return    ��������ʵ����ID 
	* @return String    �������� 
	* @throws 
	*/
	public String  startProcessDefinitionById(String ProcessDefinitionId,String approveId);
	
	
	
	/** 
	* @Description: ����ǩ�գ���������IDǩ������,����ѷ��䱾�� Ҳ���Ե��ô˷������˴�ǩ
	* @param @param userId
	* @param @param taskId
	* @param @return   �ɹ�1 ʧ��0
	* @return Map    �������� 
	* @throws 
	*/
	public Map  completeClaimTask(String userId,String taskId);
	
	
	/** 
	* @Description: ���ݲ��ŵ�ID ��ȡ���������е�������Ϣ
	* @param @param groupId
	* @param @return     ��������FlowTask����,data list
	* @return Map    �������� 
	* @throws 
	*/
	public Map  getAllClaimTask(String groupId);
	
	/** 
	* @Description: ͨ���û���ȡ�û������еĹ��������� 
	* @param @param userId
	* @param @return   �����û������й���������
	* @return List<FlowTask>    �������� 
	* @throws 
	*/
	public Map  getAllClaimTaskByUser(String userId);
	
	
	
	/** 
	* @Description: �û�ѡ�� ��������
	* @param @param userId
	* @param @param taskId
	* @param @param variables
	* @param @return  �ɹ�1 ʧ��0 
	* @return Map    �������� 
	* @throws 
	*/
	public Map  completeCheckTask(String userId,String taskId,Map<String, Object> variables);
	
	/** 
	* @Description: ����ʵ��ID��ȡ������¼ 
	* @param @param ProcessDefinitionInstancetId
	* @param @return    ����������¼�ļ��� 
	* @return List<CheckResult>    �������� 
	* @throws 
	*/
	public List<CheckRecord>  getProcessCheckRecord(String ProcessDefinitionInstancetId);
	
	
	/** 
	* @Description: ��������ID��ȡ������һ���������ٸ�ʵ��
	* @param @param ProcessDefinitionId
	* @param @return    ʵ����¼ 
	* @return List<InstanceRecord>    �������� 
	* @throws 
	*/
	public List<InstanceRecord>  queryHistoryProcessInstance(String ProcessDefinitionId);
	
	/** 
	* @Description: ��������ʵ��ID���ж������Ƿ��Ѿ����
	* @param @param ProcessDefinitionInstanceId
	* @param @return    staus �ɹ� 1  ʧ��0 
	* @return Map    �������� 
	* @throws 
	*/
	public Map  queryProcessInstanceStatus(String ProcessDefinitionInstanceId);

	/** 
	* @Description: ͨ��KEY ��������ʵ��
	* @param @param processDefinitionkey
	* @param @param approveId
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	public String startProcessDefinitionByKey(String processDefinitionkey,
			String approveId);



	/** 
	* @Description: �����¸��ڵ㴦����Ϣ�����û����˵�������Ѿ����� 
	* @param @param prcesssInsId
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	public String getNextChk(String prcesssInsId);
	
	
	/** 
	* @Description: �ж������Ƿ��ѽ���
	* @param @param taskId
	* @param @return    �趨�ļ� 
	* @return boolean    �������� 
	* @throws 
	*/
	public boolean isOverByTask(String processInstanceId);
	
	
}
