package cy.its.vehTrack.rest.action;

import com.alibaba.fastjson.JSONObject;

import cy.its.vehTrack.rest.dto.VioSnapRateSearchInputBean;

public interface IVioSnapRateAction {

	/**
	 * Υ���豸��ץ����
	 * @param inputBean
	 * @return
	 */
	public JSONObject queryVioSnapRate(VioSnapRateSearchInputBean inputBean);

}
