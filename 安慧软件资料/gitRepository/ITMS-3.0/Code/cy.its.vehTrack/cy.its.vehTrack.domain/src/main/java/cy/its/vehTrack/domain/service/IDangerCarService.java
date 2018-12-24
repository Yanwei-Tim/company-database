/**
 *name :Σ�ռ�ʻ��������
 *author:wangyunqi
 *date:2016/03/14
 * 
 */
package cy.its.vehTrack.domain.service;

import java.util.Map;

public interface IDangerCarService {
	/**
	 * Σ�ռ�ʻ����TOPN
	 * 
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	public String findDangerCarTopN(String query) throws Exception;

	/**
	 * Σ�ռ�ʻ�����������
	 * 
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	public String findDangerCarWholeAnylsis(String query) throws Exception;

	/**
	 * Σ�ռ�ʻ�����������
	 * 
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findDangerCarSimpleAnylsis(String query) throws Exception;

	/**
	 * Σ�ռ�ʻ�����������
	 * 
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	public String findDangerCarMulitAnylsis(String query) throws Exception;

}
