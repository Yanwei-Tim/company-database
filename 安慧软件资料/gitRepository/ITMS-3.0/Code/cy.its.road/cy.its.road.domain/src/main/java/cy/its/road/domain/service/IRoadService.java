package cy.its.road.domain.service;

import java.util.List;
import java.util.Map;

import cy.its.road.domain.criteria.CrossCriteria;
import cy.its.road.domain.criteria.RoadCriteria;
import cy.its.road.domain.criteria.RoadSectionCriteria;
import cy.its.road.domain.model.road.Cross;
import cy.its.road.domain.model.road.Road;
import cy.its.road.domain.model.road.RoadSection;

public interface IRoadService {

	/**
	 * ��ѯ���������ĵ�·��Ϣ �б�
	 * 
	 * @param roadCriteria
	 *            ��ѯ����
	 * @return ��·��Ϣ�б�
	 */
	public List<Road> findRoads(RoadCriteria roadCriteria);

	/**
	 * ��ѯָ���ĵ�·
	 * 
	 * @param roadId
	 *            ��·Ψһ��ʶID
	 * @return ��·��ϸ
	 * @throws Exception 
	 */
	public Road roadOfId(String roadId) throws Exception;

	/**
	 * �����µ�·
	 * 
	 * @param road
	 *            ��·��Ϣ
	 * @return 
	 */
	public String saveRoad(Road road);

	/**
	 * ���µ�·
	 * 
	 * @param road
	 *            ��·
	 */
	public void updateRoad(Road road);

	/**
	 * ɾ��ָ���ĵ�·
	 * 
	 * @param roadId
	 *            ��·Ψһ��ʶID
	 */
	public void deleteRoad(String roadId);
	
	//����ɾ��
	public void removeRoad(Map<String,Object> roadIds);
	/**
	 * ��ѯ����������·���б�
	 * 
	 * @param crossCriteria
	 *            ��ѯ����
	 * @return ·���б�
	 */
	public List<Cross> findCrosses(
			CrossCriteria crossCriteria);

	/**
	 * ��ѯָ����·��
	 * 
	 * @param crossId
	 *            ·��Ψһ��ʶID
	 * @return ·��
	 * @throws Exception 
	 */
	public Cross crossOfId(String crossId) throws Exception;
	
	/**
	 * ������ ·��
	 * 
	 * @param roadJunction
	 *            ·��
	 */
	public void saveCross(Cross cross);
	
	
	/**
	 * ����·��
	 * 
	 * @param cross
	 *            ·��
	 */
	public void updateCross(Cross cross);

	/**
	 * ɾ��ָ����·��
	 * 
	 * @param crossId
	 * ·��Ψһ��ʶID
	 */
	public void deleteCross(String crossId);
	
	public void removeCross(Map<String,Object> crossIds);
	
	/**
	 * ��ѯ����������·���б�
	 * 
	 * @param roadSectionCriteria
	 *            ��ѯ����
	 * @return ·���б�
	 */
	public List<RoadSection> findRoadSectiones(
			RoadSectionCriteria roadSectionCriteria);

	/**
	 * ��ѯָ����·��
	 * 
	 * @param roadSectionId
	 *            ·��Ψһ��ʶID
	 * @return ·��
	 * @throws Exception 
	 */
	public RoadSection roadSectionOfId(String roadSectionId) throws Exception;
	
	/**
	 * ������ ·��
	 * 
	 * @param roadJunction
	 *            ·��
	 */
	public void saveRoadSection(RoadSection roadSection);
	
	
	/**
	 * ����·��
	 * 
	 * @param roadSection
	 *            ·��
	 */
	public void updateRoadSection(RoadSection roadSection);

	/**
	 * ɾ��ָ����·��
	 * 
	 * @param roadSectionId
	 *            ·��Ψһ��ʶID
	 */
	public void deleteRoadSection(String roadSectionId);
	
	public void removeRoadSection(Map<String,Object> roadSectionIds);
	/**
	 * ��·���֪ͨ
	 */
	public void roadChanged();
}