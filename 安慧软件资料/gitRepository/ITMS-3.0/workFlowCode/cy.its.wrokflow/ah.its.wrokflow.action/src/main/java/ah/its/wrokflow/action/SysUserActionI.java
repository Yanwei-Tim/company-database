package ah.its.wrokflow.action;

import java.util.Map;

import ah.its.wrokflow.dto.SysUserDto;
import ah.its.wrokflow.repository.dao.SysUser;

/**
* @Title: SysUserActionI.java 
* @Package ah.its.wrokflow.action 
* @Description: �����û���Ϣ��
* @author lil@cychina.cn
* @date 2016��4��5�� ����4:59:25 
* @version V1.0   
 */
public interface SysUserActionI {
	
	/** 
	* @Description: �û���Ϣ��֤ 
	* @param @param loginName
	* @param @param pwd
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public  Map  validateUser(String loginName,String  pwd);
	
	
	/**
	 * @Description: �����û�
	 * @param user
	 * @return
	 */
	public Map findUsers(SysUser user);
	
	/**
	 * ����groupId�����û�
	 * @param String groupId
	 */
	public Map queryUsersByGroupId(String groupId,String startPage,String pageSize);
	/**
	 * ��ѯ�û���Ϣ����group��Ϣ
	 * @param user
	 * @return
	 */
	public Map queryUsersWithGroupinfo(SysUserDto user); 
}
