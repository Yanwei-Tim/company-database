package ah.its.wrokflow.repository.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.ApproveChk;
import ah.its.wrokflow.repository.dao.SysApprove;

public interface SysApproveMapper {
    int deleteByPrimaryKey(String systemApproveId);

    int insert(SysApprove record);

    int insertSelective(SysApprove record);

    SysApprove selectByPrimaryKey(String systemApproveId);

    int updateByPrimaryKeySelective(SysApprove record);

    int updateByPrimaryKey(SysApprove record);
    
    List<SysApprove> selectAllData(@SuppressWarnings("rawtypes") Map map);
    
    /**
	 * ϵͳ��������ʷ��ѯ
	 * @param map
	 * @return
	 */
	List<SysApprove> querySystemApproveHistory(Map map);

	/**
	 * ϵͳ������ʷ��¼����
	 * @param approveId
	 * @return
	 */
	List<ApproveChk> querySystemApproveHistoryDetail(String systemApproveId);
}