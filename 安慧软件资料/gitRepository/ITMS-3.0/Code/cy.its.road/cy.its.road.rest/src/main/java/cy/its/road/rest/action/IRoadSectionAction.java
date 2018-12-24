/**
 * @Title: ISectionAction.java
 * @Package cy.its.road.rest.action
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��10��29�� ����4:06:41
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.road.rest.action;

import java.util.Map;

import cy.its.road.rest.dto.RoadSectionDto;

/**
  * @ClassName: ISectionAction
  * @Description: TODO(SectionDto��Ӧҳ��������Dto����)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��10��29�� ����4:06:41
  *
  */

public interface IRoadSectionAction {
	
	//����·����Ϣ 
	public  int createRoadSection(RoadSectionDto roadSectionDto) throws Exception;
	//��ѯ
	public Map<String,Object> searchRoadSection(RoadSectionDto roadSectionDto) throws Exception;
	//����
	public int goUpdateRoadSection(RoadSectionDto roadSectionDto) throws Exception;
	//����ɾ��
	public String goDeleteRoadSection(String roadSectionIdStr);
	//����ɾ��
	public String goRemoveRoadSection(String roadSectionId);
	//����·��Id��ѯ�������
	public int querySectionByRoadSectionId(String roadSectionId)  throws Exception;
}
