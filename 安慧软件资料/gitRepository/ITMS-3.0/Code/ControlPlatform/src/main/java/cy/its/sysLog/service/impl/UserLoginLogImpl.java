package cy.its.sysLog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.platform.common.utils.SqlHelper;
import cy.its.sysLog.client.UserLoginMapper;
import cy.its.sysLog.domain.UserLogin;
import cy.its.sysLog.service.UserLoginLogI;

/**
* @Title: UserLoginLogImpl.java 
* @Package cy.its.sysLog.service.impl 
* @Description: �û���¼ ��¼ 
* @author lil@cychina.cn
* @date 2016��3��11�� ����4:25:29 
* @version V1.0   
 */
@Service
public class UserLoginLogImpl implements UserLoginLogI{
	@Autowired
	private UserLoginMapper userLoginMapper;//ע�����ݿ������
	
	@Override
	public int insert(UserLogin record) {
		return userLoginMapper.insert(record);
	}

	@Override
	public String getUserId(String name) {
		return userLoginMapper.getUserId(name);
	}

}
