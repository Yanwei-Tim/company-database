package cy.its.service.common.dataModel;

import java.util.Date;

public class MsgInfo extends Model {
//	/**
//	* ������ϢID
//	*/
//	@Mapper("ID")
//	private String id;
	
	/**
	* ������
	*/
	@Mapper("SENDER")
	private String sender;
	
	/**
	* ����ʱ��
	*/
	@Mapper("SEND_TIME")
	private Date sendTime;
	
	/**
	* ����״̬
	*/
	@Mapper("SEND_STATUS")
	private String sendStatus;
	
	/**
	* ��������
	*/
	@Mapper("MSG_TYPE")
	private String msgType;
	
	/**
	* ���ݱ���
	*/
	@Mapper("MSG_TITLE")
	private String msgTitle;
	
	/**
	* ��������
	*/
	@Mapper("MSG_CONTENT")
	private String msgContent;
	
	/**
	* ������
	*/
	@Mapper("RECEIVER")
	private String receiver;
	
	/**
	* ��ע
	*/
	@Mapper("REMARK")
	private String remark;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
