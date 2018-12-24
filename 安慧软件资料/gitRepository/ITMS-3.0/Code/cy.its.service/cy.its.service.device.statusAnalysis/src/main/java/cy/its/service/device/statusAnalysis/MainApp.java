package cy.its.service.device.statusAnalysis;

import cy.its.service.common.ice.grid.AppService;
import cy.its.service.common.ioc.AppContext;
import cy.its.service.common.ioc.Export;
import cy.its.service.common.ioc.Import;
import cy.its.service.common.log.LogManager;

/**
 * @Title: MainApp.java
 * @Package cy.its.service.device.statusAnalysis
 * @Description: ״̬�������������
 * @author lijun@cychina.cn
 * @date 2015��11��4�� ����3:21:24
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 *      Company: ���ճ�Զ��Ϣ�������޹�˾ Copyright: Copyright (c) 2015
 */
@Export
public class MainApp extends AppService {

	@Import
	LoadRunner loadRunner;

	/**
	 * �������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LogManager.createDefaultLogger("status", "status");
			AppContext.init("cy.its.service.device.statusAnalysis");
			Run(AppContext.getBean(MainApp.class), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Start(String[] args) throws Exception {
		loadRunner.start();
	}

	@Override
	public void Stop() throws Exception {
		loadRunner.stop();
	}

	@Override
	public String getAppName() {
		return "statusAnalysis";
	}
}
