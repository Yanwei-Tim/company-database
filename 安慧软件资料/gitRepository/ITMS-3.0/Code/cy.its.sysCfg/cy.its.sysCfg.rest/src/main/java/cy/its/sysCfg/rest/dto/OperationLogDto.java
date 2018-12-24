/**
 * @Title: opterationLogDto.java
 * @Package cy.its.sysCfg.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��12��3�� ����9:12:05
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.sysCfg.rest.dto;


import cy.its.com.dto.BaseDto;

/**
  * @ClassName: opterationLogDto
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��12��3�� ����9:12:05
  *
  */

public class OperationLogDto extends BaseDto {
	/**
	 * ��־id
	 */
	private String opeLogId;

	/**
	 * ϵͳ���ܱ���
	 */
	private String functionCode;

	private String sysFunctionCode;
	/**
	 * �����û�
	 */
	private String opeUserName;
	
	private String userId;
	
	//����ʱ��
	private String operateTime;
	
	/**
	 * ��ʼ����ʱ��
	 */
	private	String operateBeginTime;
	/**
	 * ��������ʱ��
	 */
	private	String operateEndTime;

	/**
	*
	*/
	private String operateRecordCounts;

	/**
	 * ���������1-�ɹ���2-ʧ��
	 */
	private String operateResult;

	/**
	 * ������ʱ
	 */
	private String consumeSeconds;

	/**
	 * ����ʧ��ԭ��
	 */
	private String errorDesc;


	/**
	 * ����IP
	 */
	private String computerIp;

	/**
	 * 0����֧�֣� 1��֧�֣�֧�ֵ�ʱ�������ݿ�������ݱ��м�¼�������ݡ�
	 */
	private String rebackable;

	public String getOpeLogId() {
		return opeLogId;
	}

	public void setOpeLogId(String opeLogId) {
		this.opeLogId = opeLogId;
	}
	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getSysFunctionCode() {
		return sysFunctionCode;
	}

	public void setSysFunctionCode(String sysFunctionCode) {
		this.sysFunctionCode = sysFunctionCode;
	}

	public String getOpeUserName() {
		return opeUserName;
	}

	public void setOpeUserName(String opeUserName) {
		this.opeUserName = opeUserName;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateBeginTime() {
		return operateBeginTime;
	}

	public void setOperateBeginTime(String operateBeginTime) {
		this.operateBeginTime = operateBeginTime;
	}

	public String getOperateEndTime() {
		return operateEndTime;
	}

	public void setOperateEndTime(String operateEndTime) {
		this.operateEndTime = operateEndTime;
	}

	public String getOperateRecordCounts() {
		return operateRecordCounts;
	}

	public void setOperateRecordCounts(String operateRecordCounts) {
		this.operateRecordCounts = operateRecordCounts;
	}

	public String getOperateResult() {
		return operateResult;
	}

	public void setOperateResult(String operateResult) {
		this.operateResult = operateResult;
	}

	public String getConsumeSeconds() {
		return consumeSeconds;
	}

	public void setConsumeSeconds(String consumeSeconds) {
		this.consumeSeconds = consumeSeconds;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getComputerIp() {
		return computerIp;
	}

	public void setComputerIp(String computerIp) {
		this.computerIp = computerIp;
	}

	public String getRebackable() {
		return rebackable;
	}

	public void setRebackable(String rebackable) {
		this.rebackable = rebackable;
	}
	
	
}
