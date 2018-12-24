package cy.its.syscfg.domain.repository.sysLog;

import java.util.List;

import cy.its.com.domain.IRepository;
import cy.its.syscfg.domain.criteria.OperationLogCriteria;
import cy.its.syscfg.domain.model.sysLog.OperationLog;

/**
 * ϵͳ������־
 * @author STJ
 * ����ʵ���޸ĺ�ɾ������
 */
public interface ISysLogRepository extends IRepository<OperationLog> {
	List<OperationLog> findOperationLogs(OperationLogCriteria criteria);
	int countOperationLogs(OperationLogCriteria criteria);
}
