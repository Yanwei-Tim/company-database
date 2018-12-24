package cy.its.service.device.faultMaintain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cy.its.service.common.ConstValue;
import cy.its.service.common.JsonUtil;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.DeviceFault;
import cy.its.service.common.dataModel.SurveyUpgrade_DeviceStatus;
import cy.its.service.common.log.LogManager;
import cy.its.service.common.rabbitmqClient.IReceiver;

public class FaultStatusReceiver implements IReceiver {

	/**
	 * ������
	 */
	Map<String, String> faultMap;
	
	/**
	 * ���������
	 */
	Map<String, String> faultTypeMap;
	
	public FaultStatusReceiver() {
		faultMap = new HashMap<String,String>();
		faultTypeMap = new HashMap<String,String>();
		
		faultMap.put("11000","�����쳣");
		faultMap.put("11001","�������ϵ");
		faultMap.put("11002","�����ͼƬ");
		faultMap.put("11003","û��ͼ���ź�");
		faultMap.put("11004","������ݴ���");
		faultMap.put("12000","���״��ź�");
		faultMap.put("12001","�״�����ϵ");
		faultMap.put("12002","�״��޲���");
		faultMap.put("12003","�״����ݴ���");
		faultMap.put("12004","��Ƶ�ʷֻ�����");
		faultMap.put("12005","�Ŵ��·����");
		faultMap.put("12006","CPU����");
		faultMap.put("13000","���������ж�");
		faultMap.put("13001","ups��ص�ѹƫ��");
		faultMap.put("13002","upsʧЧ");
		faultMap.put("13003","û��ups�ź�");
		faultMap.put("14000","��Ȧ����ϵ");
		faultMap.put("14001","û����Ȧ�ź�");
		faultMap.put("14002","��Ȧ���ݹ���");
		faultMap.put("15000","�޷�������������");
		faultMap.put("15001","�޷����ӷ�����");
		faultMap.put("15002","���ܷ����������쳣");
		faultMap.put("16000","�޷���GPSģ��˿�");
		faultMap.put("16001","�޷�����GPS����");
		faultMap.put("16002","GPS���ݽ�������");
		faultMap.put("16003","GPSУʱ����");
		faultMap.put("17000","�ܼ������޴�����");
		faultMap.put("17001","�ض���Ⱦ");
		faultMap.put("17002","USBȱʧ�����");
		faultMap.put("17003","�˿ڴ򿪹���");
		faultMap.put("17004","ʱ���쳣");
		faultMap.put("18000","LED�˿ڴ򿪹���");
		faultMap.put("18001","LED������");
		faultMap.put("99999","�����ӹ���");

		faultTypeMap.put("11","����ӹ���");
		faultTypeMap.put("12","�״��ӹ���");
		faultTypeMap.put("13","��Դ�ӹ���");
		faultTypeMap.put("14","��Ȧ�ӹ���");
		faultTypeMap.put("15","�����ӹ���");
		faultTypeMap.put("16","GPS�����ӹ���");
		faultTypeMap.put("17","�ܼ������ӹ���");
		faultTypeMap.put("18","LED�ӹ���");
		faultTypeMap.put("99","��������");

	}
	
	/**
	 * ��״̬����
	 */
	Class<SurveyUpgrade_DeviceStatus> clazz = SurveyUpgrade_DeviceStatus.class;
	
	/**
	 * 10�ַ���
	 */
	String TEN = "10";

	/**
	 * ���ϱ������� �� 1 ����
	 */
	String FAULT = "1";
	/**
	 * �ɼ���ʽ��1-ǰ���豸�ϴ�
	 */
	String COLLECT_METHOD = "1";
	
	String ERR_MSG = "�������ݴ���ʧ��:%s;����:%s";
    String DUBUG_MSG = "���չ�������:%s";

	@Override
	public Boolean receive(String routingKey, String message) {
		try {
			SurveyUpgrade_DeviceStatus status = JsonUtil.parseObject(message, clazz);
			if (status != null && 
				status.getStatusTime() != null &&
				!StringUtil.isNullOrEmpty(status.getDeviceSysId()) &&
				!StringUtil.isNullOrEmpty(status.getOrgPrivilegeCode())) {
				if (status.getStatusCode() == ConstValue.INT_0 && 
					status.getFaultCodes() != null &&
					status.getFaultCodes().size() > ConstValue.INT_0) {	
					boolean logged = false;
					for (String faultCode : status.getFaultCodes()) {
						if (faultMap.containsKey(faultCode)) {
							if(!logged) {
								logged = true;
							    LogManager.debug(String.format(DUBUG_MSG, message));
							}
							FaultWriter.write(convertToFault(status, faultCode));
						}
					}
				}
			}

			status = null;
		} catch (Throwable e) {
			LogManager.error(String.format(ERR_MSG, StringUtil.getErrorDetail(e), message));
		}

		return ConstValue.BOOL_TRUE;
	}

	/**
	 * ����ת��
	 * @param status
	 * @param faultCode
	 * @return
	 */
	private DeviceFault convertToFault(SurveyUpgrade_DeviceStatus status, String faultCode) {
		DeviceFault fault = new DeviceFault();
		fault.setDeviceId(status.getDeviceSysId());
		fault.setSysComponentId(status.getCameraId());
		fault.setFaultEventTime(new Date(status.getStatusTime()));
		fault.setFaultAlarm(FAULT);
		fault.setFaultType(faultCode.substring(ConstValue.INT_0, ConstValue.INT_2));
		fault.setFaultSubType(faultCode);
		fault.setCollectMethod(COLLECT_METHOD);
		fault.setRemark(String.format("%s:%s", faultTypeMap.get(fault.getFaultType()),
				faultMap.get(fault.getFaultSubType())));
		fault.setOrgPrivilegeCode(status.getOrgPrivilegeCode());
		
		return fault;
	}

}
