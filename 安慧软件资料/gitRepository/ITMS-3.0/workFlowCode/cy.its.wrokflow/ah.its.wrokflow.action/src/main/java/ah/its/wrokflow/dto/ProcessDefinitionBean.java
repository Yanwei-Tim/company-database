package ah.its.wrokflow.dto;

/**
* @Title: ProcessDefinitionBean.java 
* @Package cy.its.wrokflow.approve.dto 
* @Description: ǰ̨չʾ���������б���Ϣ
* @author lil@cychina.cn
* @date 2016��3��28�� ����4:02:40 
* @version V1.0   
 */
public class ProcessDefinitionBean {
	
	/**
	 * @Description:ID
	 */
	private  String ProcessDefinitionId;
	
	/**
	 * @Description:��������
	 */
	private  String ProcessDefinitionName;
	

	public String getProcessDefinitionId() {
		return ProcessDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		ProcessDefinitionId = processDefinitionId;
	}

	public String getProcessDefinitionName() {
		return ProcessDefinitionName;
	}

	public void setProcessDefinitionName(String processDefinitionName) {
		ProcessDefinitionName = processDefinitionName;
	}
	
}
