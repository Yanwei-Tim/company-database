package cy.its.common.offLine.client;

import java.util.List;
import java.util.Map;

import cy.its.common.offLine.domain.OffLineExport;

/**
* @Title: OffLineExportMapper.java 
* @Package cy.its.common.offLine.client 
* @Description:�ļ����ߵ������������
* @author lil@cychina.cn
* @date 2015��11��26�� ����4:03:11 
* @version V1.0   
 */
public interface OffLineExportMapper {
	
    /** 
    * @Title: insert 
    * @Description: �������� 
    * @param @param record
    * @param @return    �趨�ļ� 
    * @return int    �������� 
    * @throws 
    */
    int insert(OffLineExport record);

    
    /** 
    * @Title: selectByPrimaryKey 
    * @Description:��ѯ����
    * @param @param loginName
    * @param @return    �趨�ļ� 
    * @return List<OffLineExport>    �������� 
    * @throws 
    */
    List<OffLineExport> selectAllListloginName(Map  map);

    
    /** 
    * @Title: updateByPrimaryKey 
    * @Description: ���������Ҫ��������
    * @param @param recordId
    * @param @return    �趨�ļ� 
    * @return int    �������� 
    * @throws 
    */
    int updateByPrimaryKey(Map  map);
    int deleteByPrimaryKey(String taskId);
}