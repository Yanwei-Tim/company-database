/**
 * @Title: IReglonalAction.java
 * @Package cy.its.road.rest.action
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��21�� ����11:18:37
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.road.rest.action;

import java.util.Map;

import cy.its.road.rest.dto.RegionalDto;
import cy.its.road.rest.dto.RoadDto;

/**
  * @ClassName: IReglonalAction
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��11��21�� ����11:18:37
  *
  */

public interface IRegionalAction {
	//����������Ϣ 
	public  String createRegional(RegionalDto regionalDto) throws Exception;
	//��ѯ
	public Map<String, Object> findRegional(RegionalDto regionalDto) throws Exception;
	//����
	public String goUpdateRegional(RegionalDto regionalDto) throws Exception ;
	//����ɾ��
	public String goDeleteRegional(String regionalId);
	//����ɾ��
	public String goRemoveRegional(String regionalIdStr);
		
		
}
