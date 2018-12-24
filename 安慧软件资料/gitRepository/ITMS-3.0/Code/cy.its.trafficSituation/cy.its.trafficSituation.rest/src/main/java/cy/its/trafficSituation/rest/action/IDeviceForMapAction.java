/**
 * @Title: IDeviceForTraffic.java
 * @Package cy.its.trafficSituation.rest.action
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��13�� ����2:46:41
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.rest.action;

import java.util.List;

import cy.its.trafficSituation.rest.dto.DeviceDto;

public interface IDeviceForMapAction {
	/**
	 * 
	  * @Title: selectByType
	  * @Description: �����豸���ͻ�ȡ���е��豸
	  * @param @param deviceType
	  * @param @return
	  * @param @throws Exception    �趨�ļ�
	  * @return List<DeviceDto>    ��������
	  * @throws
	 */
	List<DeviceDto> selectByType(String deviceType,String currentOrgPrivilegeCode) throws Exception;
}
