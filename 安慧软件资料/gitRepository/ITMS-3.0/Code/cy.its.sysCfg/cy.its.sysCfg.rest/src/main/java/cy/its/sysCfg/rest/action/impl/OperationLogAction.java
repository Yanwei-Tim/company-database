/**
 * @Title: Operation.java
 * @Package cy.its.sysCfg.rest.aciton.impl
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��12��3�� ����9:33:36
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.sysCfg.rest.action.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cy.its.com.util.ObjectMapUtils;
import cy.its.sysCfg.rest.action.IOperationLogAction;
import cy.its.sysCfg.rest.dto.OperationLogDto;
import cy.its.syscfg.domain.criteria.OperationLogCriteria;
import cy.its.syscfg.domain.criteria.UserCriteria;
import cy.its.syscfg.domain.model.duty.User;
import cy.its.syscfg.domain.model.sysLog.OperationLog;
import cy.its.syscfg.domain.service.IDutyService;
import cy.its.syscfg.domain.service.ISysLogService;

/**
 * @ClassName: Operation
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��12��3�� ����9:33:36
 *
 */
@RestController
@RequestMapping("/sysCfg/OperationLog")
public class OperationLogAction implements IOperationLogAction {
	@Autowired
	ISysLogService sysLogService;

	@Autowired
	IDutyService dutyService;
	/*
	 * <p>Title: findByOperationLog</p> <p>Description: ��ѯ</p>
	 * 
	 * @param operationLogDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.sysCfg.rest.aciton.IOperationLogAction#findOperationLog(cy.its.
	 * sysCfg.rest.dto.OperationLogDto)
	 */

	@RequestMapping("/findByOperationLog")
	@Override
	public Map<String, Object> goFindByOperationLog(OperationLogDto operationLogDto) throws Exception {
		// TODO Auto-generated method stub
		OperationLogCriteria optLogCriteria = new OperationLogCriteria();
		// ��ҳ��Ϣ
		optLogCriteria.setNeedTotal(true);
		optLogCriteria.setPageNum(operationLogDto.getPageNumber());
		optLogCriteria.setPageSize(operationLogDto.getPageSize());
		// �����ѯ����
		
		optLogCriteria.opeUserName = operationLogDto.getOpeUserName();
		optLogCriteria.orgPrivilegeCode=operationLogDto.getCurrentOrgPrivilegeCode();
		optLogCriteria.sysFunctionCode = operationLogDto.getFunctionCode();
		optLogCriteria.operateBeginTime = operationLogDto.getOperateBeginTime();
		optLogCriteria.operateEndTime = operationLogDto.getOperateEndTime();
		optLogCriteria.operateResult = operationLogDto.getOperateResult();
		// ����lstView����
		ArrayList<OperationLogDto> lstView = new ArrayList<OperationLogDto>();
		// �����־��Ϣ
		List<OperationLog> optLogList = sysLogService.findSysLogs(optLogCriteria);
		for (OperationLog optLog : optLogList) {
			OperationLogDto optLogDto = new OperationLogDto();
			// ��dateתString
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (optLog.getOperateTime() != null) {
				optLogDto.setOperateTime(sdf.format(optLog.getOperateTime()));
			}

			if (optLog.getConsumeSeconds() != null) {
				optLogDto.setConsumeSeconds(Double.toString(optLog.getConsumeSeconds()));
			}
			// ���������Dtoת��Ϊ�ͻ���Dto
			ObjectMapUtils.parseObject(optLogDto, optLog);
			lstView.add(optLogDto);
		}
		// ��װҳ�淵������
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "");
		Map<String, Object> maprows = new HashMap<String, Object>();
		maprows.put("rows", lstView);
		maprows.put("total", optLogCriteria.getTotal());
		map.put("result", maprows);
		return map;
	}

}
