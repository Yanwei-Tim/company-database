package cy.its.road.domain.service;

import java.util.List;
import java.util.Map;

import cy.its.road.domain.criteria.RegionCriteria;
import cy.its.road.domain.model.region.Region;

public interface IRegionService {

	/**
	 * ��ѯ���������������б�
	 * 
	 * @param regionCriteria
	 *            ��ѯ����
	 * @return �����б�
	 */
	public List<Region> findRegions(RegionCriteria regionCriteria);

	/**
	 * ��ѯָ����������ϸ��Ϣ
	 * 
	 * @param regionId
	 *            ����Ψһ ��ʶ
	 * @return ������ϸ��Ϣ
	 * @throws Exception 
	 */
	public Region regionOfId(String regionId) throws Exception;

	/**
	 * ����������
	 * 
	 * @param region
	 *            ����
	 */
	public void saveRegion(Region region);

	/**
	 * ��������
	 * 
	 * @param region
	 *            ����
	 */
	public void updateRegion(Region region);

	/**
	 * ɾ��ָ��������
	 * 
	 * @param regionId
	 *            ����Ψһ��ʶ
	 */
	public void deleteRegion(String regionId);
	//����ɾ��
	public void removeRegion(Map<String,Object> regionIds);
	
}