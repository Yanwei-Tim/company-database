package cy.its.common.offLine.domain;

import java.util.Date;

/**
 * @Title: OffLineExport.java
 * @Package cy.its.common.offLine.domain
 * @Description:��������
 * @author lil@cychina.cn
 * @date 2015��11��26�� ����3:56:44
 * @version V1.0
 */
public class OffLineExport {

	/**
	 * ����ID
	 */
	private String taskId;

	/**
	 * �������ͣ�
	 */
	private String funcKey;

	/**
	 * �����ļ�������
	 */
	private String fileName;

	/**
	 * ���SQL
	 */
	private String exportSql;
	/**
	 * ���SQL
	 */
	private String exportSql2 = "";

	/**
	 * ����״̬
	 */
	private String status;

	/**
	 * ����ʱ��
	 */
	private Date updateTime;

	/**
	 * ���������
	 */
	private String loginName;

	/**
	 * �ļ���ַ
	 */
	private String fileUrl = "";

	/**
	 * ��ע����
	 */
	private String remark = "";

	private String funcName;
	private Date createTime;

	public OffLineExport() {

	}

	public OffLineExport(String taskId, String funcKey, String fileName, String exportSql, String status,
			Date updateTime, String loginName, String funcName, String remark) {
		this.taskId = taskId;
		this.funcKey = funcKey;
		this.fileName = fileName;
		this.exportSql = exportSql;
		this.status = status;
		this.updateTime = updateTime;
		this.createTime = new Date();
		this.loginName = loginName;
		this.funcName = funcName;
		this.remark = remark;
	}

	public OffLineExport(String taskId, String funcKey, String fileName, String exportSql, String exportSql2,
			String status, Date updateTime, String loginName, String funcName, String remark) {
		this.taskId = taskId;
		this.funcKey = funcKey;
		this.fileName = fileName;
		this.exportSql2 = exportSql2;
		this.exportSql = exportSql;
		this.status = status;
		this.updateTime = updateTime;
		this.createTime = new Date();
		this.loginName = loginName;
		this.funcName = funcName;
		this.remark = remark;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * getter method
	 * 
	 * @return the funcName
	 */

	public String getFuncName() {
		return funcName;
	}

	/**
	 * setter method
	 * 
	 * @param funcName
	 *            the funcName to set
	 */

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	/**
	 * getter method
	 * 
	 * @return the createTime
	 */

	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * setter method
	 * 
	 * @param createTime
	 *            the createTime to set
	 */

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}