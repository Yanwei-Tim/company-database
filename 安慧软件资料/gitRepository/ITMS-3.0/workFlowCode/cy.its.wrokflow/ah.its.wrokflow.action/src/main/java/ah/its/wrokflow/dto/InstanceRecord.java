package ah.its.wrokflow.dto;

import java.util.Date;

/**
* @Title: InstanceRecord.java 
* @Package cy.its.wrokflow.approve.dto 
* @Description: ����ʵ����Ϣ
* @author lil@cychina.cn
* @date 2016��3��28�� ����8:12:31 
* @version V1.0   
 */
public class InstanceRecord {
	
    /**
     * @Description:ʵ��ID
     */
    private String   recordId;
    
    /**
     * @Description:��������
     */
    private String   ProcessDefinitionName;
    
    /**
     * @Description:������
     */
    private String   approveUsr;
    
    /**
     * @Description:�������ݼ��
     */
    private String   approveContent;
    
    /**
     * @Description:����ʱ��
     */
    private Date   approveTime;
    
    
    /**
     * @Description:���̺�ʱ���죩
     */
    private int   consumeTime;


	public String getRecordId() {
		return recordId;
	}


	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}


	public String getProcessDefinitionName() {
		return ProcessDefinitionName;
	}


	public void setProcessDefinitionName(String processDefinitionName) {
		ProcessDefinitionName = processDefinitionName;
	}


	public String getApproveUsr() {
		return approveUsr;
	}


	public void setApproveUsr(String approveUsr) {
		this.approveUsr = approveUsr;
	}


	public String getApproveContent() {
		return approveContent;
	}


	public void setApproveContent(String approveContent) {
		this.approveContent = approveContent;
	}


	public Date getApproveTime() {
		return approveTime;
	}


	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}


	public int getConsumeTime() {
		return consumeTime;
	}


	public void setConsumeTime(int consumeTime) {
		this.consumeTime = consumeTime;
	}
    
}
