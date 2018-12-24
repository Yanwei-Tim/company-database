package com.cy.security.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.security.dao.SecurityMapper;
import com.cy.security.domain.SecurityDao;
import com.cy.security.service.SecurityServiceI;

import cy.its.platform.common.utils.Log4jFactoryProxy;


/**
 * @author lilei
 * ʹ��@Serviceע�⽫UserServiceImpl���עΪһ��service
 * service��id��userService
 */

@Service("securityServiceImpl")
public class SecurityServiceImpl implements SecurityServiceI {

	
	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(SecurityServiceImpl.class);
	/**
     * ʹ��@Autowiredע���עuserMapper������
     * ����Ҫʹ��securityMapperʱ��Spring�ͻ��Զ�ע��securityMapper
     */
    @Autowired
    private SecurityMapper securityMapper;//ע��dao
    
	public List<SecurityDao> getAllRoleByStaffCode(String userName) {
		 return securityMapper.getAllRoleByStaffCode(userName);
	}
	
	public List<SecurityDao> getPwdByStaffCode(String userName) {
		 return securityMapper.getPwdByStaffCode(userName);
	}
}
