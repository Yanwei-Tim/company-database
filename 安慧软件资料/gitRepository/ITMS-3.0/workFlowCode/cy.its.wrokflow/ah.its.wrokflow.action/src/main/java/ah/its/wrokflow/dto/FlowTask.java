package ah.its.wrokflow.dto;

/**
* @Description: �����б�
* @author lil@cychina.cn
* @version V1.0   
 */
public class FlowTask {
	
	/**
	 * @Description:����ID,��ѡ
	 */
	private  String flowTaskId;
	
	/**
	 * @Description:������������
	 */
	private  String ProcessDefinitionName;
	
	/**
	 * @Description:���뵥������
	 */
	private  String aprroveUser;
	
	/**
	 * @Description:�������ݼ�飬��Ϊ��
	 */
	private  String aprroveContent;
	
	

	public String getFlowTaskId() {
		return flowTaskId;
	}

	public void setFlowTaskId(String flowTaskId) {
		this.flowTaskId = flowTaskId;
	}

	public String getProcessDefinitionName() {
		return ProcessDefinitionName;
	}

	public void setProcessDefinitionName(String processDefinitionName) {
		ProcessDefinitionName = processDefinitionName;
	}

	public String getAprroveUser() {
		return aprroveUser;
	}

	public void setAprroveUser(String aprroveUser) {
		this.aprroveUser = aprroveUser;
	}

	public String getAprroveContent() {
		return aprroveContent;
	}

	public void setAprroveContent(String aprroveContent) {
		this.aprroveContent = aprroveContent;
	}
	
}
