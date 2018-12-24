package cy.its.sysLog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.sysLog.client.OperateMenuMapper;
import cy.its.sysLog.domain.OperateMenu;
import cy.its.sysLog.service.OperateMenuLogI;

/**
* @Title: OperateMenuLogImpl.java 
* @Package cy.its.sysLog.service.impl 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author lil@cychina.cn
* @date 2016��3��12�� ����3:54:50 
* @version V1.0   
 */
@Service
public class OperateMenuLogImpl implements OperateMenuLogI{
	
	
	@Autowired
	private OperateMenuMapper operateMenuMapper;//ע�����ݿ������
	/* (non-Javadoc)
	 * @see cy.its.sysLog.service.SyOperationLogI#insert(cy.its.sysLog.domain.SyOperationLog)
	 */
	@Override
	public int insert(OperateMenu record) {
		return operateMenuMapper.insert(record);
	}
}
