package ah.its.wrokflow.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.SysUser;

/**
* @Title: SysUserDomainI.java 
* @Package ah.its.wrokflow.domain 
* @Description: �û����������� 
* @author lil@cychina.cn
* @date 2016��4��5�� ����6:41:42 
* @version V1.0   
 */
public interface SysUserDomainI {
	
	
	/** 
	* @Description: ����MAP��״̬ status 0 ʧ�ܣ�1 �ɹ� 
	* @param @param userId
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	Map queryUserShipById(String  userId,String pwd);
	
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	Map queryUsers(SysUser user);
	List queryUsersWithGroupinfo(SysUser user);
	
	/**
	 * ����groupId�����û�
	 * @param String groupId
	 */
	List queryUsersByGroupId(String groupId);
}
