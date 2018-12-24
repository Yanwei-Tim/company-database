/**
 * date:2016/03/11
 * author:wangyunqi
 * name:���Ƴ�������ѯ(���ô�����)
 */
package cy.its.vehTrack.rest.action;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;


import cy.its.vehTrack.rest.dto.CloneCarDto;

public interface ICloneCarAction {
	
	/**
	 * ���Ƴ�������ѯ
	 * @param cloneCarDto
	 * @return Map
	 */
	public  Map<String, Object> findCloneCarInfo(CloneCarDto cloneCarDto)throws Exception;

	
	 String updateConfirmFlag(@RequestParam("clone_vehicle_id") String clone_vehicle_id,
			@RequestParam("clone_flag") String clone_flag,@RequestParam("confirm_desc") String confirm_desc)throws Exception;
}
