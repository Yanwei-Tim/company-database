package cy.its.service.device.statusAnalysis.util;

import java.util.List;

import cy.its.service.common.dataModel.DeviceStatus;
import cy.its.service.device.statusAnalysis.data.SurveyData;
import cy.its.service.device.statusAnalysis.model.DeviceCfg;

/**
 * @Title: ISysManager.java
 * @Package cy.its.service.device.statusAnalysis.util
 * @Description: �豸ϵͳ����ӿڶ���
 * @author STJ lijun@cychina.cn
 * @date 2015��11��9�� ����5:00:33
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */
public interface ISysManager {

	/**
	 * ��ʼ����
	 * @param lstDevCfg
	 */
	void start(List<DeviceCfg> lstDevCfg);

	/**
	 * ֹͣ����
	 */
	void stop();

	/**
	 *  ��ȡ״̬������ע���豸����
	 * @return
	 */
	String[] focusDeviceTypes();

	/**
	 * ����������
	 * ����ȷ�����µ������ϴ�ʱ��
	 * @param data
	 */
	void handleSurveyData(SurveyData data);

	/**
	 * �����豸����
	 * @param heart
	 */
	void handleStatus(DeviceStatus heart);

	/**
	 * ��������״̬
	 */
	void publishAllStatus();

	/**
	 * ��������豸ϵͳ�ı仯���
	 */
	void checkChangeOfSysCfg();

}