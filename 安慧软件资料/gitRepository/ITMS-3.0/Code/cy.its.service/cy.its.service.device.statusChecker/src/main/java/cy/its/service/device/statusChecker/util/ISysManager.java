package cy.its.service.device.statusChecker.util;

import java.util.List;

import cy.its.service.common.dataModel.SurveyUpgrade_DeviceStatus;
import cy.its.service.device.statusChecker.model.DeviceCfg;
import cy.its.service.device.statusChecker.model.SurveyData;

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
	 * �����豸����
	 * @param heart
	 * @throws Exception 
	 */
	void handleStatus(SurveyUpgrade_DeviceStatus heart) throws Exception;

	/**
	 * ��������״̬
	 */
	void publishAllStatus();

	/**
	 * ��������豸ϵͳ�ı仯���
	 */
	void checkChangeOfSysCfg();
	
	/**
	 * �����豸�������
	 * @param surveyData
	 */
	void receiveSurveyData(SurveyData surveyData);

}