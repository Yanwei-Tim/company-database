/**
 * date:2016/03/11
 * author:wangyunqi
 * name:���򰸼���������(���ô�����)
 */
package cy.its.vehTrack.rest.action;

import com.alibaba.fastjson.JSONObject;

import cy.its.vehTrack.rest.dto.CollAnalyzeInputBean;

public interface ICollAnalyzeAction {
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONObject findCollAnalyResList(CollAnalyzeInputBean bean) throws Exception;

}
