/**
 * @Title: IDeviceGroupAction.java
 * @Package cy.its.violation.rest.action
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��9�� ����7:14:53
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.violation.rest.action;

import java.util.ArrayList;
import java.util.Map;

import cy.its.violation.rest.dto.DeviceGroupDto;

/**
  * @ClassName: IDeviceGroupAction
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��11��9�� ����7:14:53
  *
  */

public interface IDeviceGroupAction {
	
	ArrayList<DeviceGroupDto> findDeviceAction(DeviceGroupDto deviceGroupDto) throws Exception;
	Map findDGroupAction() throws Exception;
	Map findDeviceList(String  orgId);
	public String createDGroupAction( String deviceSysNbrStr , String userId);
	public String updateDGroupAction(DeviceGroupDto deviceGroupDto);
	public String deleteDGroupAction(String deviceGroupStrId);
	public String removeDGroupAction(String userId);
}
