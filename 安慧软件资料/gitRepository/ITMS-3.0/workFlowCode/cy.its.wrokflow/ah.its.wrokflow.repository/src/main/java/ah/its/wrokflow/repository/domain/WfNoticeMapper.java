package ah.its.wrokflow.repository.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.WfNotice;

public interface WfNoticeMapper {
    int deleteByPrimaryKey(String noticeId);

    int insert(WfNotice record);

    int insertSelective(WfNotice record);
    
    int insertBatch(Map map);

    WfNotice selectByPrimaryKey(String noticeId);

    int updateByPrimaryKeySelective(WfNotice record);

    int updateByPrimaryKey(WfNotice record);

	/** 
	* @Description: ȡ���µ�15��֪ͨ��¼
	* @param @param notice
	* @param @return  �趨�ļ� 
	* @return List<WfNotice>    �������� 
	* @throws 
	*/
	List<WfNotice> selectTop15Data(WfNotice notice);
}