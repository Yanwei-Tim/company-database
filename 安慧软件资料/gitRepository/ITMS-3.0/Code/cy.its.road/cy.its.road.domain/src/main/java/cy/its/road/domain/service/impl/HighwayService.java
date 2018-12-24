package cy.its.road.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.road.domain.criteria.ServiceAreaCriteria;
import cy.its.road.domain.criteria.SpecialSectionCriteria;
import cy.its.road.domain.criteria.ServiceResourceCriteria;
import cy.its.road.domain.model.highway.ServiceArea;
import cy.its.road.domain.model.highway.SpecialSection;
import cy.its.road.domain.model.highway.ServiceResource;
import cy.its.road.domain.repository.highway.IServiceAreaRepository;
import cy.its.road.domain.repository.highway.IServiceResourceRepository;
import cy.its.road.domain.repository.highway.ISpecialSectionRepository;
import cy.its.road.domain.service.IHighwayService;

/**
 * ������ط���
 * @author STJ
 *
 */
@Service
public class HighwayService implements IHighwayService {

	@Autowired
	IServiceAreaRepository serviceAreaRepository;
	
	@Autowired
	IServiceResourceRepository serviceResourceRepository;
	
	@Autowired
	ISpecialSectionRepository specialSectionRepository;
	

	/**
	 * ��ѯ���������ĵĸ��ٷ������б�
	 * 
	 * @param highwayServiceAreaCriteria
	 *            ��ѯ����
	 * @return ���ٷ������б�
	 */
	public List<ServiceArea> findServiceAreas(
			ServiceAreaCriteria serviceAreaCriteria) {
		if(serviceAreaCriteria.getNeedTotal()){
			serviceAreaCriteria.setTotal(serviceAreaRepository
			.countHighwayServiceAreas(serviceAreaCriteria));
		}
		
		return serviceAreaRepository
				.findHighwayServiceAreas(serviceAreaCriteria);
	}

	/**
	 * ��ѯָ���ĸ��ٷ�������Ϣ
	 * 
	 * @param highwayServiceAreaId
	 *            ���ٷ�����Ψһ��ʶ
	 * @return ���ٷ�������Ϣ
	 * @throws Exception 
	 */
	public ServiceArea serviceAreaOfId(String highwayServiceAreaId) throws Exception {
		return serviceAreaRepository.aggregateOfId(highwayServiceAreaId);
	}

	/**
	 * �����¸��ٷ�����
	 * 
	 * @param serviceArea
	 *            ���ٷ�������Ϣ
	 */
	public void saveServiceArea(ServiceArea serviceArea) {
		serviceAreaRepository.save(serviceArea);
	}

	/**
	 * ���¸��ٷ�����
	 * 
	 * @param serviceArea
	 *            ��������Ϣ
	 */
	public void updateServiceArea(ServiceArea serviceArea) {
		serviceAreaRepository.update(serviceArea);
	}

	/**
	 * ɾ��ָ���ĸ��ٷ�����
	 * 
	 * @param serviceAreaId
	 *            ���ٷ�����Ψһ��ʶ
	 */
	public void deleteServiceArea(String serviceAreaId) {
		serviceAreaRepository.delete(serviceAreaId);
	}

	/**
	 * ��ѯ���������ķ�����Դ��Ϣ�б�
	 * 
	 * @param resourceCriteria
	 *            ��ѯ����
	 * @return ������Դ��Ϣ�б�
	 */
	public List<ServiceResource> findServiceResources(
			ServiceResourceCriteria resourceCriteria) {
		if(resourceCriteria.getNeedTotal()){
			resourceCriteria.setTotal(serviceResourceRepository
			.countServiceResources(resourceCriteria));
		}
		return serviceResourceRepository.findServiceResources(resourceCriteria);
	}

	/**
	 * ��ѯָ���ķ�����Դ
	 * 
	 * @param serviceResourceId
	 *            ������ԴΨһ��ʶ
	 * @return ������Դ
	 * @throws Exception 
	 */
	public ServiceResource serviceResourceOfId(String serviceResourceId) throws Exception {
		return serviceResourceRepository.aggregateOfId(serviceResourceId);
	}

	/**
	 * �����·�����Դ
	 * 
	 * @param serviceResource
	 *            ������Դ
	 */
	public void saveServiceResource(ServiceResource serviceResource) {
		serviceResourceRepository.save(serviceResource);
	}

	/**
	 * ���·�����Դ
	 * 
	 * @param serviceResource
	 *            ������Դ
	 */
	public void updateServiceResource(ServiceResource serviceResource) {
		serviceResourceRepository.update(serviceResource);
	}

	/**
	 * ɾ��ָ���ķ�����Դ
	 * 
	 * @param serviceResourceId
	 *            ������ԴΨһ��ʶ
	 */
	public void deleteServiceResource(String serviceResourceId) {
		serviceResourceRepository.delete(serviceResourceId);
	}

	/**
	 * ��ѯ��������������·���б�
	 * 
	 * @param specialSectionCriteria
	 *            ��ѯ����
	 * @return ����·���б�
	 */
	public List<SpecialSection> findHighwaySpecialSections(
			SpecialSectionCriteria specialSectionCriteria) {
		if(specialSectionCriteria.getNeedTotal()){
			specialSectionCriteria.setTotal(specialSectionRepository
			.countHighwaySpecialSections(specialSectionCriteria));
		}
		return specialSectionRepository
				.findHighwaySpecialSections(specialSectionCriteria);
	}

	/**
	 * ��ѯָ��������·��
	 * 
	 * @param specialSectionId
	 *            ����·��Ψһ��ʶ
	 * @return ����·��
	 * @throws Exception 
	 */
	public SpecialSection specialSectionOfId(String specialSectionId) throws Exception {
		return specialSectionRepository.aggregateOfId(specialSectionId);
	}

	/**
	 * ������������·��
	 * 
	 * @param specialSection
	 *            ����·����Ϣ
	 */
	public void saveSpecialSection(SpecialSection specialSection) {
		specialSectionRepository.save(specialSection);
	}

	/**
	 * ���¸�������·��
	 * 
	 * @param specialSection
	 *            ����·��
	 */
	public void updateSpecialSection(SpecialSection specialSection) {
		specialSectionRepository.update(specialSection);
	}

	/**
	 * ɾ��ָ���ĸ�������·��
	 * 
	 * @param specialSectionId
	 *            ����·��Ψһ��ʶ
	 */
	public void deleteSpecialSection(String specialSectionId) {
		specialSectionRepository.delete(specialSectionId);
	}

}
