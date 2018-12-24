package cy.its.sysCfg.rest.action;

import java.util.Map;

import cy.its.sysCfg.rest.dto.FestivalDto;

public interface IFestivalAction {
	// ��ѯ
	public Map<String, Object> selectAllFestivalList(FestivalDto festivalDto) throws Exception;

	// ����
	public String updateFestival(FestivalDto festivalDto) throws Exception;

	// ����ϵͳ����
	String createFestival(FestivalDto festivalDto) throws Exception;

	// ����ɾ��
	String removeFestival(String festivalId);
	
	// ����ɾ��
	String deleteFestival(String festivalIds);

}
