package cy.its.service.domain;

import java.util.Date;

/**
* @Title: Section.java 
* @Package cy.its.service.section.domain 
* @Description: �������
* @author lil@cychina.cn
* @date 2015��11��4�� ����2:01:17 
* @version V1.0   
 */
public class OffLine {
	/**
	 * Ψһ��ʶ
	 */
	private  String  taskId;
	/**
	 *��Ӧ����Ψһ��
	 */
	private  String  funcKey;
	
	/**
	 *�����ļ�����
	 */
	private  String  fileName;
	
	/**
	 *�����ļ�sql
	 */
	private  String  exportSql;
	
	
	/**
	 *�����ļ�����SQL�����SQL���������и���������ֶμ��Ͽ���ʱ������
	 */
	private  String  exportSql2;
	
	
	/**
	 *����״̬
	 */
	private  String  status;
	
	/**
	 *����ʱ��
	 */
	private  Date  updateTime;
	
	/**
	 *������
	 */
	private  String  loginName;


	public String getFuncKey() {
		return funcKey;
	}

	public void setFuncKey(String funcKey) {
		this.funcKey = funcKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExportSql() {
		return exportSql;
	}

	public void setExportSql(String exportSql) {
		this.exportSql = exportSql;
	}

	public String getExportSql2() {
		return exportSql2;
	}

	public void setExportSql2(String exportSql2) {
		this.exportSql2 = exportSql2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
    
}
