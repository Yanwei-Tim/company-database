package ah.its.wrokflow.domain;

import java.util.List;

import ah.its.wrokflow.repository.dao.SysGroup;

/**
* @Title: SysGroupDomainI.java 
* @Package ah.its.wrokflow.domain 
* @Description: ����group���������� 
* @author chengj@cychina.cn
 */
public interface SysGroupDomainI {
	/**
	 * ��ѯ����group
	 * @param SysGroup record
	 * @return
	 */
	List querygroups(SysGroup record);
}
