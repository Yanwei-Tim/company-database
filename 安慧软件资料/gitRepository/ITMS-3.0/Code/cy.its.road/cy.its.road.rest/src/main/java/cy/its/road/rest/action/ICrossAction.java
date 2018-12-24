/**
 * @Title: ICrossAction.java
 * @Package cy.its.road.rest.action
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��24�� ����2:09:40
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.road.rest.action;

import java.util.Map;

import cy.its.road.rest.dto.CrossDto;

/**
  * @ClassName: ICrossAction
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��11��24�� ����2:09:40
  *
  */

public interface ICrossAction {
	//����·��
	public String createCross(CrossDto crossDto) throws Exception;
	//��ѯ·����Ϣ
	public Map<String, Object> findCross(CrossDto crossDto) throws Exception;
	//����·����Ϣ
	public String updateCross(CrossDto crossDto) throws Exception;
	//����ɾ��·����Ϣ
	public String removeCrossIds(String crossIdStr);
	//����ɾ��·��
	public String deleteCrossId(String crossId);
	
}
