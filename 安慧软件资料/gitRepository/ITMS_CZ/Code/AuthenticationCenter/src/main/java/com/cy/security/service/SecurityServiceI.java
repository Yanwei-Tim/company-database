package com.cy.security.service;

import java.util.List;

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
}
