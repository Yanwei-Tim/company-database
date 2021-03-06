package cy.its.trafficSituation.rest.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cy.its.trafficSituation.rest.dto.TrafficPlanVideoDto;
import cy.its.trafficSituation.rest.dto.easyUITree;

/**
 * @author Administrator
 *
 */
public interface IVideoPlayAction {

	/**
	 * @param request
	 * @return
	 */
	List<easyUITree> getVideoDeviceTrees(HttpServletRequest request) throws Exception;

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<TrafficPlanVideoDto> getVideoByIds(HttpServletRequest request) throws Exception;

}
