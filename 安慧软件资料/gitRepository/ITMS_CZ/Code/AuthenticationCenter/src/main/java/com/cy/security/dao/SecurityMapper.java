package com.cy.security.dao;

import java.util.List;

import com.cy.security.domain.SecurityDao;


public interface SecurityMapper {
    /**
     * @param userName
     * @return LIST
     * �û���½�����û������ؽ�ɫ��Ϣ
     */
    List<SecurityDao> getAllRoleByStaffCode(String userName);
    
    
    
    /**
     * @param userName
     * @return LIST
     * �û���½�����û�������������Ϣ
     */
    List<SecurityDao> getPwdByStaffCode(String userName);
    
 }