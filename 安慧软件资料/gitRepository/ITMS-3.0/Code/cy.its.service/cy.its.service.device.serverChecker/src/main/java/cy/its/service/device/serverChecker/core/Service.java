package cy.its.service.device.serverChecker.core;

import java.util.Date;
import java.util.Map;

import cy.its.service.common.ConstValue;
import cy.its.service.common.dataModel.SurveyUpgrade_ServiceStatus;
import cy.its.service.common.dataModel.SurveyUpgrade_ServiceStatusResult;

public class Service {
	String processName; // ������
	int processID; // ����ID
	String processDesc; // ��������
	long processStartTime; // ��������ʱ�� yyyy-MM-dd HH:mm:ss
	String userName; // ���̵��û���
	int expires; // ע����Ч��,units(minutes)
	int messageType; // 0: ע����Ϣ��1��״̬��Ϣ
	String softVersion; // ����汾
	long statusGenTime; // ����״̬����ʱ��,yyyy-MM-dd HH:mm:ss
	int processStatus; // ����״̬��ȡֵ������
	int processMemory; // ����ռ���ڴ棬��λK
	int processCpu; // ����ռ��cpu��%
	int handleNum; // ����ռ�þ����
	String doRecordNum; // ���̴����¼����
	Map<String, String> typeNums; // ����Ĵ��������Ŀǰkey��ֵ��:
									// passingVehicleNum,violationVehicleNum
	long countStartTime; // ���̼�¼ͳ�ƿ�ʼʱ��
	int countCycle; // ͳ������
	int reportCycle;

	long updateTime;

	public Service(SurveyUpgrade_ServiceStatus status) {
		this.set(status);
	}

	public boolean receiveStatus(SurveyUpgrade_ServiceStatus status) {
		return this.set(status);
	}

	public SurveyUpgrade_ServiceStatusResult generateResult() {
		SurveyUpgrade_ServiceStatusResult rslt = new SurveyUpgrade_ServiceStatusResult();
		rslt.setProcessName(this.processName);
		rslt.setProcessID(this.processID);
		rslt.setProcessDesc(this.processDesc);
		rslt.setProcessStartTime(new Date(this.processStartTime));
		rslt.setSoftVersion(this.softVersion);
		rslt.setStatusGenTime(new Date(this.statusGenTime));
		rslt.setProcessStatus(this.processStatus);
		rslt.setProcessMemory(this.processMemory);
		rslt.setProcessCpu(this.processCpu);
		rslt.setHandleNum(this.handleNum);
		rslt.setDoRecordNum(this.doRecordNum);
		rslt.setReportCycle(this.reportCycle);
		rslt.setTypeNums(this.typeNums);
		
		return rslt;
	}

	private boolean set(SurveyUpgrade_ServiceStatus status) {
		if (this.statusGenTime >= status.getStatusGenTime()) {
			return ConstValue.BOOL_FALSE;
		}

		this.processName = status.getProcessName();
		this.processID = status.getProcessID();
		this.processDesc = status.getProcessDesc();
		this.processStartTime = status.getProcessStartTime();
		this.userName = status.getUserName();
		this.expires = status.getExpires();
		this.messageType = status.getMessageType();
		this.softVersion = status.getSoftVersion();
		this.statusGenTime = status.getStatusGenTime();
		this.processStatus = status.getProcessStatus();
		this.processMemory = status.getProcessMemory();
		this.processCpu = status.getProcessCpu();
		this.handleNum = status.getHandleNum();
		this.doRecordNum = status.getDoRecordNum();
		this.typeNums = status.getTypeNums();
		this.countStartTime = status.getCountStartTime();
		this.countCycle = status.getCountCycle();
		this.reportCycle = status.getReportCycle();

		this.updateTime = System.currentTimeMillis();

		return ConstValue.BOOL_TRUE;

	}

}
