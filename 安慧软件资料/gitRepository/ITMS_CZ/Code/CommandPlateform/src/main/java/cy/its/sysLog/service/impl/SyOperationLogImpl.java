package cy.its.sysLog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.platform.common.utils.SqlHelper;
import cy.its.sysLog.client.SyOperationLogMapper;
import cy.its.sysLog.domain.SyOperationLog;
import cy.its.sysLog.service.SyOperationLogI;

/**
* @Title: SyOperationLogImpl.java 
* @Package cy.its.sysLog.service.impl 
* @Description: ��ͬ��־���ݿ����
* @author lil@cychina.cn
* @date 2015��8��31�� ����3:44:15 
* @version V1.0   
 */
@Service
public class SyOperationLogImpl implements SyOperationLogI{

	@Autowired
	private SyOperationLogMapper syOperationLogMapper;//ע�����ݿ������
	
	/* (non-Javadoc)
	 * @see cy.its.sysLog.service.SyOperationLogI#insert(cy.its.sysLog.domain.SyOperationLog)
	 */
	@Override
	public int insert(SyOperationLog record) {
		return syOperationLogMapper.insert(record);
	}

}
