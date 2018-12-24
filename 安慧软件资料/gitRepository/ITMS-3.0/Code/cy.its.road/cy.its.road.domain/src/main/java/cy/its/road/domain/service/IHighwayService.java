package cy.its.road.domain.service;

import java.util.List;

import cy.its.road.domain.criteria.ServiceAreaCriteria;
import cy.its.road.domain.criteria.ServiceResourceCriteria;
import cy.its.road.domain.criteria.SpecialSectionCriteria;
import cy.its.road.domain.model.highway.ServiceArea;
import cy.its.road.domain.model.highway.ServiceResource;
import cy.its.road.domain.model.highway.SpecialSection;

public interface IHighwayService {

	/**
	 * ��ѯ���������ĵĸ��ٷ������б�
	 * 
	 * @param highwayServiceAreaCriteria
	 *            ��ѯ����
	 * @return ���ٷ������б�
	 */
	public List<ServiceArea> findServiceAreas(
			ServiceAreaCriteria highwayServiceAreaCriteria);

	/**
	 * ��ѯָ���ĸ��ٷ�������Ϣ
	 * 
	 * @param highwayServiceAreaId
	 *            ���ٷ�����Ψһ��ʶ
	 * @return ���ٷ�������Ϣ
	 * @throws Exception 
	 */
	public ServiceArea serviceAreaOfId(String highwayServiceAreaId) throws Exception;

	/**
	 * �����¸��ٷ�����
	 * 
	 * @param serviceArea
	 *            ���ٷ�������Ϣ
	 */
	public void saveServiceArea(ServiceArea serviceArea);

	/**
	 * ���¸��ٷ�����
	 * 
	 * @param serviceArea
	 *            ��������Ϣ
	 */
	public void updateServiceArea(ServiceArea serviceArea);

	/**
	 * ɾ��ָ���ĸ��ٷ�����
	 * 
	 * @param serviceAreaId
	 *            ���ٷ�����Ψһ��ʶ
	 */
	public void deleteServiceArea(String serviceAreaId);

	/**
	 * ��ѯ���������ķ�����Դ��Ϣ�б�
	 * 
	 * @param resourceCriteria
	 *            ��ѯ����
	 * @return ������Դ��Ϣ�б�
	 */
	public List<ServiceResource> findServiceResources(
			ServiceResourceCriteria resourceCriteria);

	/**
	 * ��ѯָ���ķ�����Դ
	 * 
	 * @param serviceResourceId
	 *            ������ԴΨһ��ʶ
	 * @return ������Դ
	 * @throws Exception 
	 */
	public ServiceResource serviceResourceOfId(String serviceResourceId) throws Exception;

	/**
	 * �����·�����Դ
	 * 
	 * @param serviceResource
	 *            ������Դ
	 */
	public void saveServiceResource(ServiceResource serviceResource);

	/**
	 * ���·�����Դ
	 * 
	 * @param serviceResource
	 *            ������Դ
	 */
	public void updateServiceResource(ServiceResource serviceResource);

	/**
	 * ɾ��ָ���ķ�����Դ
	 * 
	 * @param serviceResourceId
	 *            ������ԴΨһ��ʶ
	 */
	public void deleteServiceResource(String serviceResourceId);

	/**
	 * ��ѯ��������������·���б�
	 * 
	 * @param specialSectionCriteria
	 *            ��ѯ����
	 * @return ����·���б�
	 */
	public List<SpecialSection> findHighwaySpecialSections(
			SpecialSectionCriteria specialSectionCriteria);

	/**
	 * ��ѯָ��������·��
	 * 
	 * @param specialSectionId
	 *            ����·��Ψһ��ʶ
	 * @return ����·��
	 * @throws Exception 
	 */
	public SpecialSection specialSectionOfId(String specialSectionId) throws Exception;

	/**
	 * ������������·��
	 * 
	 * @param specialSection
	 *            ����·����Ϣ
	 */
	public void saveSpecialSection(SpecialSection specialSection);

	/**
	 * ���¸�������·��
	 * 
	 * @param specialSection
	 *            ����·��
	 */
	public void updateSpecialSection(SpecialSection specialSection);

	/**
	 * ɾ��ָ���ĸ�������·��
	 * 
	 * @param specialSectionId
	 *            ����·��Ψһ��ʶ
	 */
	public void deleteSpecialSection(String specialSectionId);

}