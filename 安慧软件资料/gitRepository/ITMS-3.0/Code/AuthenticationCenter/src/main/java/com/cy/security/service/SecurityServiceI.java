package com.cy.security.service;

import java.util.List;
import java.util.Map;

import com.cy.security.domain.SecurityDao;


public interface SecurityServiceI {
    
    /**��ȡ�����û���Ϣ
     * @return List<User>
    */
    List<SecurityDao> getPwdByStaffCode(String userName);
    
    
    /**��ȡ�����û���Ϣ
     * @return List<User>
    */
    List<SecurityDao> getAllRoleByStaffCode(String userName);


    /**
     * ����Ǵ��걨����ϵͳact_id_user��ѯ�û���Ϣ����Ϊ�ܿ�ƽ̨�û���Ϣ��t_sys_user��
     * ����2�������ݲ�һ�������һ����ɾ�����淽������getPwdByStaffCode
     * @param upperCase
     * @return
     */
	SecurityDao queryAppUserById(String upperCase);
}
