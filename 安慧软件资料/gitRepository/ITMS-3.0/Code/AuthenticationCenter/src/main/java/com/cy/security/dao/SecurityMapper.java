package com.cy.security.dao;

import java.util.List;
import java.util.Map;

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
   
    /**
     * ����Ǵ��걨����ϵͳact_id_user��ѯ�û���Ϣ����Ϊ�ܿ�ƽ̨�û���Ϣ��t_sys_user��
     * ����2�������ݲ�һ�������һ����ɾ�����淽������getPwdByStaffCode
     * @param userName
     * @return
     */
    SecurityDao queryAppUserById(String id);
 }