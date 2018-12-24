package cy.its.service.analysisAlarm;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cy.its.service.analysisAlarm.module.CacheManager;

/**
 * @author ����
 * 5����  ˢһ�λ�����Ϣ
 */
public class AlarmScheduleService  implements Job{

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		//���¼��أ�������Ϣ
		CacheManager.initWarnList(CacheManager.alermTypev, "");
		CacheManager.initWarnList(CacheManager.alermTypewt, "");
		CacheManager.initWarnList(CacheManager.alermTyper, "");
		CacheManager.initWarnList(CacheManager.alermTypeice, "");
		CacheManager.initWarnList(CacheManager.alermTypewd, "");
		CacheManager.initWarnList(CacheManager.alermTypetr, "");
	}

}
