package com.cy.rest.service;

import java.util.List;
import java.util.Map;

import com.cy.security.domain.SecurityDao;


public interface SecurityServiceReSetI {
    
    /**��ȡ�����û���Ϣ
     * @return List<User>
    */
	 List<SecurityDao> getPwdByStaffCode(String param);
	 
	 
	 
    /**��ȡ�����û���Ϣ
     * @return List<User>
    */
	 List<SecurityDao> getAllRoleByStaffCode(String param);
	 
	 
	/**
	 * @param paramInfo
	 * @return
	 * ��½��֤�ķ���
	 */
	Map  validatelogin(String paramInfo);
	
	
	/**
	 * @param paramInfo
	 * @return
	 * �û�ע������
	 */
	Map  loginOut(String paramInfo);
	
	/**
	 * @param paramInfo
	 * @return
	 * ������ʵķ���
	 */
	Map  authorityService(String paramInfo);
	
	/**
	 * @param paramInfo
	 * @return
	 * ������ʵķ���
	 */
	Map  reFreshToken(String paramInfo);
	
	/**
	 * @param paramInfo
	 * @return
	 * ͳ�������û���
	 */
	Map  onlineUsers();
	
	/**
	 * �ӹܿ�ƽ̨��ת������Ȩ
	 * @param paramInfo
	 * @return
	 */
	Map  validateFrom3(String paramInfo);
}
