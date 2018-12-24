package cy.its.common.offLine.service;

import java.util.List;
import java.util.Map;

import cy.its.common.offLine.domain.OffLineExport;

/**
* @Title: IOffLineExportService.java 
* @Package cy.its.common.offLine.service 
* @Description:�������أ�ҵ������
* @author lil@cychina.cn
* @date 2015��11��26�� ����5:07:59 
* @version V1.0   
 */
public interface IOffLineExportService {
	
	/** 
	* @Title: selectAllListLoginName 
	* @Description:��ȡ������������
	* @param @param map
	* @param @return    �趨�ļ� 
	* @return List<OffLineExport>    �������� 
	* @throws 
	*/
	List<OffLineExport>  selectAllList(Map map);
	
	
    /** 
    * @Title: insert 
    * @Description:�����¼
    * @param @param offLineExport
    * @param @return    �趨�ļ� 
    * @return int    �������� 
    * @throws 
    */
    int   insert(OffLineExport offLineExport);
    
    
    /** 
    * @Title: updateOffLineExport 
    * @Description:�����Ҫ�����������������
    * @param @param map
    * @param @return    �趨�ļ� 
    * @return int    �������� 
    * @throws 
    */
    int   updateOffLineExport(Map map);
    /** 
     * @Title: delete 
     * @Description:ɾ��
     * @param @param map
     * @param @return    �趨�ļ� 
     * @return int    �������� 
     * @throws 
     */
     int   delete(String id);
}
