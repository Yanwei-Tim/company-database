package ah.its.wrokflow.repository;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.SysUser;

/**
* @Title: SysUserRepositoryI.java 
* @Package ah.its.wrokflow.repository 
* @Description:
* @author lil@cychina.cn
* @date 2016��4��5�� ����5:45:27 
* @version V1.0   
 */
public interface SysUserRepositoryI {
	
	/** 
	* @Description: �����û�ID����ȡ�û����黹��pwd
	* @param @param userId
	* @param @return    �趨�ļ� 
	* @return SysUser    �������� 
	* @throws 
	*/
	SysUser queryUserShipById(String  userId);
	
	
	/**
	 * �����û�
	 * @param user
	 * @return Map �������� 
	 */
	List<SysUser> queryUsers(SysUser user);
	/**
	 * �����û�����Group��Ϣ��
	 * @param user
	 * @return Map �������� 
	 */
	List<SysUser> queryUsersWithGroupinfo(SysUser user);
	
	/**
	 * ����groupId�����û�
	 * @param String groupId
	 */
	List<SysUser> queryUsersByGroupId(String groupId);
	
}
