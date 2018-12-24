package cy.its.syscfg.domain.service;

import java.util.List;

import cy.its.syscfg.domain.model.config.SysFestival;
import cy.its.syscfg.domain.model.sysCode.Code;

public interface ISysFestivalService {
	/**
	 * ��ѯ���еĽڼ�������
	 * 
	 * @return ��ϵͳ���������б�
	 */
	public List<Code> findFestivalsType();
	
	/**
	 * ��ѯ���еĽڼ�����Ϣ�б�
	 * 
	 * @return ϵͳ�ڼ�����Ϣ�б�
	 */
	public List<SysFestival> findAllFestivals(String year, String festivalType);
	
	
	/**
	 * �����ڼ���
	 * 
	 * @param sysFestival
	 *            ϵͳ�ڼ�����Ϣ
	 */
	public void createFestival(SysFestival sysFestival);

	/**
	 * ���½ڼ���
	 * 
	 * @param sysFestival
	 *            ϵͳ�ڼ�����Ϣ
	 */
	public void updateFestival(SysFestival sysFestival);
	
	/**
	 * ɾ��ָ���Ľڼ���
	 * 
	 * @param festivalId
	 *            ϵͳ�ڼ���Ψһ��ʶID
	 */
	public void removeFestival(String festivalId);
	
}
