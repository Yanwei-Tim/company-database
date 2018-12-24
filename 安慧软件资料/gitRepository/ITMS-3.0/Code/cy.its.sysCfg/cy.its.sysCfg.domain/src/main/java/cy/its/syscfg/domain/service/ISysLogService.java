package cy.its.syscfg.domain.service;

import java.util.List;

import cy.its.syscfg.domain.criteria.OperationLogCriteria;
import cy.its.syscfg.domain.model.sysLog.OperationLog;

public interface ISysLogService {

	/**
	 * ��ѯ����������ϵͳ��־��Ϣ�б�
	 * 
	 * @param criteria
	 *            ϵͳ��־��ѯ����
	 * @return ϵͳ��־��Ϣ�б�
	 */
	public List<OperationLog> findSysLogs(OperationLogCriteria criteria);

	/**
	 * �����²�����־
	 * 
	 * @param operationLog
	 *            ������־��Ϣ
	 */
	public void createSysLog(OperationLog operationLog);

}