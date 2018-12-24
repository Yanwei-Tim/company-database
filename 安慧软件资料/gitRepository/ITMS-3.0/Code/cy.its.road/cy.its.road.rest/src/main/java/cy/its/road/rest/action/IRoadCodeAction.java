package cy.its.road.rest.action;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import cy.its.road.rest.dto.RoadDto;
import cy.its.road.rest.dto.RoadTreeDto;

public interface IRoadCodeAction {
	/**
	 * ��ȡ��·������
	 * @return ��·������
	 * @throws Exception
	 */
	public List<RoadTreeDto> getRoadCodeTree(String currentOrgPrivilegeCode) throws Exception;
	//������·��Ϣ 
	public  String createRoad(RoadDto roadDto) throws Exception;
	//��ѯ
	public Map<String, Object> searchRoad(RoadDto roadDto) throws Exception;
	//����
	public int goUpdateRoad(RoadDto road) throws Exception;
	//����ɾ��
	public String goDeleteRoad(String roadId);
	//����ɾ��
	public String goRemoveRoad(String roadIdStr);
	
	//���ݵ�·Code��ѯ�õ�·�Ƿ���ͨ������Ӷ���
	public int querySectionByRoadId(String roadId) throws Exception;
	//����roadId��ȡ��·��Ϣ
	public RoadDto queryRoadInfoById(String roadId) throws Exception;
}
