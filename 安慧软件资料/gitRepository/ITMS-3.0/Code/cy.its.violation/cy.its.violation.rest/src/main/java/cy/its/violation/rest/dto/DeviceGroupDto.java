/**
 * @Title: DeviceGroupDto.java
 * @Package cy.its.violation.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��9�� ����7:17:17
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.violation.rest.dto;

import java.util.List;

/**
  * @ClassName: DeviceGroupDto
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��11��9�� ����7:17:17
  *
  */

public class DeviceGroupDto {
	//�����û��豸Id
	private String assoUserDeviceId;
	//����Id
	private String orgId;
	//�û�Id
	private String userId;
	//�û���
	private String userName;
	//�豸���
	private String deviceSysNbr;
	private String deviceName;
	//�豸����
	String  deviceNames;
	//�豸Ids
	String deviceSysNbrs;
	
	public String getAssoUserDeviceId() {
		return assoUserDeviceId;
	}
	public void setAssoUserDeviceId(String assoUserDeviceId) {
		this.assoUserDeviceId = assoUserDeviceId;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	  
	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}
	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceNames() {
		return deviceNames;
	}
	public void setDeviceNames(String deviceNames) {
		this.deviceNames = deviceNames;
	}
	public String getDeviceSysNbrs() {
		return deviceSysNbrs;
	}
	public void setDeviceSysNbrs(String deviceSysNbrs) {
		this.deviceSysNbrs = deviceSysNbrs;
	}
	
}
