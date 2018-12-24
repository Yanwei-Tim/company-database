package cy.its.road.domain.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.road.domain.criteria.RegionCriteria;
import cy.its.road.domain.model.region.Region;
import cy.its.road.domain.repository.region.IRegionRepository;
import cy.its.road.domain.service.IRegionService;

/**
 * �������
 * 
 * @author STJ
 *
 */
@Service
public class RegionService implements IRegionService {

	@Autowired
	IRegionRepository regionRepository;

	/**
	 * ��ѯ���������������б�
	 * 
	 * @param regionCriteria
	 *            ��ѯ����
	 * @return �����б�
	 */
	public List<Region> findRegions(RegionCriteria regionCriteria) {	
		return regionRepository.findRegions(regionCriteria);
	}

	/**
	 * ��ѯָ����������ϸ��Ϣ
	 * 
	 * @param regionId
	 *            ����Ψһ ��ʶ
	 * @return ������ϸ��Ϣ
	 * @throws Exception 
	 */
	public Region regionOfId(String regionId) throws Exception {
		return regionRepository.aggregateOfId(regionId);
	}

	/**
	 * ����������
	 * 
	 * @param region
	 *            ����
	 */
	public void saveRegion(Region region) {
		regionRepository.save(region);
	}

	/**
	 * ��������
	 * 
	 * @param region
	 * ����
	 */
	public void updateRegion(Region region) {
		regionRepository.update(region);
	}

	/**
	 * ɾ��ָ��������
	 * 
	 * @param regionId
	 * ����Ψһ��ʶ
	 */
	public void deleteRegion(String regionId) {
		regionRepository.delete(regionId);
	}
	public void removeRegion(Map<String,Object> regionIds){
		regionRepository.remove(regionIds);
	}

}
