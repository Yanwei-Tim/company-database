/**
 *name :Σ�ռ�ʻ��������
 *author:wangyunqi
 *date:2016/03/14
 * 
 */
package cy.its.vehTrack.rest.action;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import cy.its.vehTrack.rest.dto.DangerCarDto;

public interface IDangerCarAction {
	
	
	/**
	 * Σ�ռ�ʻ����TOPN
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findDangerCarTopN(DangerCarDto dangerDto) throws Exception;
	
	
	/**
	 * Σ�ռ�ʻ�����������
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findDangerCarWholeAnylsis(DangerCarDto dangerDto) throws Exception;
	
	/**
	 * Σ�ռ�ʻ�����������
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findDangerCarSimpleAnylsis(DangerCarDto dangerDto) throws Exception;
	
	/**
	 * Σ�ռ�ʻ�����������
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findDangerCarMulitAnylsis(DangerCarDto dangerDto) throws Exception;


}
