package cy.its.syscfg.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.syscfg.domain.criteria.OperationLogCriteria;
import cy.its.syscfg.domain.model.sysLog.OperationLog;
import cy.its.syscfg.domain.repository.sysLog.ISysLogRepository;
import cy.its.syscfg.domain.service.ISysLogService;

/**
 * ϵͳ��־����
 *
 */
@Service
public class SysLogService implements ISysLogService {

	@Autowired
	ISysLogRepository sysLogRepository;

	/**
	 * ��ѯ����������ϵͳ��־��Ϣ�б�
	 * 
	 * @param criteria
	 *            ϵͳ��־��ѯ����
	 * @return ϵͳ��־��Ϣ�б�
	 */
	public List<OperationLog> findSysLogs(OperationLogCriteria criteria) {
		return sysLogRepository.findOperationLogs(criteria);
	}

	/**
	 * �����²�����־
	 * 
	 * @param operationLog
	 *            ������־��Ϣ
	 */
	public void createSysLog(OperationLog operationLog) {
		sysLogRepository.save(operationLog);
	}
}
