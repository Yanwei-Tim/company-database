package cy.its.vehTrack.rest.action;

import java.util.Map;

import cy.its.vehTrack.rest.dto.PassDto;

public interface IPassAction {

	
	/**
	  * 
	  * findPassInfo ��ѯ������Ϣ
	  * @Title: findPassInfo
	  * @Description: ����ǰ�˲�ѯ������ѯ����������
	  * @param @param passDto ������ѯ������װDTO
	  * @param @return
	  * @param @throws Exception    �趨�ļ�
	  * @return Map    ��������
	  * @throws
	 */
	public Map findPassInfo(PassDto passDto) throws Exception;
}

