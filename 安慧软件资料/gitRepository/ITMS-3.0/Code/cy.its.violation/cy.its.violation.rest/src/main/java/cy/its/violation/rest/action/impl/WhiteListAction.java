/**
 * @Title: WhiteListAction.java
 * @Package cy.its.violation.rest.action.impl
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��4�� ����3:32:10
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.violation.rest.action.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cy.its.com.util.ObjectMapUtils;
import cy.its.violation.domain.criteria.WhiteVehicleCriteria;
import cy.its.violation.domain.model.config.WhiteVehicle;
import cy.its.violation.domain.service.IWhiteVehicleService;
import cy.its.violation.rest.action.IWhiteListAction;
import cy.its.violation.rest.dto.WhiteListDto;

/**
 * @ClassName: WhiteListAction
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��4�� ����3:32:10
 *
 */
@RestController
@RequestMapping("/violaton/whiteListAction")
public class WhiteListAction implements IWhiteListAction {

	@Autowired
	IWhiteVehicleService whiteVehicleService;

	/*
	 * <p>Title: searchWhiteList</p> <p>Description:��ѯ </p>
	 * 
	 * @param whiteListDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IWhiteListAction#searchWhiteList(cy.its.
	 * violation.rest.dto.WhiteListDto)
	 */

	@RequestMapping("/searchWhiteList")
	@Override
	public Map searchWhiteList(WhiteListDto whiteListDto) {
		WhiteVehicleCriteria whiteCriteria = new WhiteVehicleCriteria();
		// �ͻ��˵�����ת������������(���ƺ���,��������)
		whiteCriteria.plateNbr = whiteListDto.getPlateNbr();
		whiteCriteria.plateType = whiteListDto.getPlateType();
		ObjectMapUtils.parseObject(whiteCriteria, whiteListDto);
		ArrayList<WhiteListDto> lstView = new ArrayList<WhiteListDto>();
		List<WhiteVehicle> lst = whiteVehicleService.findWhiteVehicles(whiteCriteria);
		for (WhiteVehicle whiteV : lst) {
			WhiteListDto whiteLst = new WhiteListDto();
			// �����������Date����ת���ͻ���String
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			whiteLst.setValidEndDate(sdf.format(whiteV.getValidEndDate()));
			ObjectMapUtils.parseObject(whiteLst, whiteV);
			lstView.add(whiteLst);
		}
		Map map = new HashMap();
		map.put("error", "");
		Map maprow = new HashMap();
		maprow.put("rows", lstView);
		map.put("result", maprow);
		return map;
	}

	@RequestMapping("/searchWhiteVioList")
	@Override
	public Map searchWhiteVioList(WhiteListDto whiteListDto) {
		// TODO
		Map map = new HashMap();
		map.put("error", "");
		Map maprow = new HashMap();
		maprow.put("rows", "");
		map.put("result", maprow);
		return map;
	}

	/*
	 * <p>Title: createWhiteList</p> <p>Description:�����³�����Ϣ </p>
	 * 
	 * @param whiteListDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IWhiteListAction#createWhiteList(cy.its.
	 * violation.rest.dto.WhiteListDto)
	 */

	@RequestMapping("/saveWhiteLst")
	@Override
	public String createWhiteList(WhiteListDto whiteListDto) throws ParseException {
		WhiteVehicle whiteVehicle = new WhiteVehicle();
		// ���ͻ�������String����ת��Ϊ����Date����
		DateFormat dfmat = new SimpleDateFormat("yyyy-MM-dd");
		whiteVehicle.setValidEndDate(dfmat.parse(whiteListDto.getValidEndDate()));
		ObjectMapUtils.parseObject(whiteVehicle, whiteListDto);

		whiteVehicleService.save(whiteVehicle);
		return "success";
	}

	/*
	 * <p>Title: goUpdateRoad</p> <p>Description:���³�����Ϣ</p>
	 * 
	 * @param whiteListDto
	 * 
	 * @return
	 * 
	 * @see cy.its.violation.rest.action.IWhiteListAction#goUpdateRoad(cy.its.
	 * violation.rest.dto.WhiteListDto)
	 */

	@RequestMapping("/updateWhiteLst")
	@Override
	public String goUpdateWhiteList(WhiteListDto whiteListDto) throws ParseException {
		DateFormat dfmat = new SimpleDateFormat("yyyy-MM-dd");
		WhiteVehicle whiteVehicle = new WhiteVehicle();
		whiteVehicle.setValidEndDate(dfmat.parse(whiteListDto.getValidEndDate()));
		ObjectMapUtils.parseObject(whiteVehicle, whiteListDto);
		int resultWhite = whiteVehicleService.update(whiteVehicle);

		if (resultWhite == 1) {
			return "success";
		} else {
			return "false";
		}
	}

	/*
	 * <p>Title: goDeleteRoad</p> <p>Description:����ɾ��������Ϣ </p>
	 * 
	 * @param whiteListStrId
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IWhiteListAction#goDeleteRoad(java.lang.
	 * String)
	 */

	@RequestMapping("/deleteWhiteLst")
	@Override

	public String goDeleteWhiteList(@RequestParam("vehicleIdStr") String whiteListStrId) {
		String whiteLstId[] = whiteListStrId.split(",");
		int resultWhiteId = 0;
		for (int i = 0; i < whiteLstId.length; i++) {
			resultWhiteId += whiteVehicleService.delete(whiteLstId[i]);
		}
		if (resultWhiteId == whiteLstId.length) {
			return "success";
		} else {

			return "false";
		}
	}

	/*
	 * <p>Title: goRemoveRoad</p> <p>Description:����ɾ����Ϣ </p>
	 * 
	 * @param whiteListId
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IWhiteListAction#goRemoveRoad(java.lang.
	 * String)
	 */
	@RequestMapping("/removeWhiteLst")
	@Override
	public String goRemoveWhiteList(@RequestParam("vehicleId") String whiteListId) {
		int resultWhiteListId = whiteVehicleService.delete(whiteListId);
		if (resultWhiteListId == 1) {
			return "success";
		} else {
			return "false";
		}
	}

}
