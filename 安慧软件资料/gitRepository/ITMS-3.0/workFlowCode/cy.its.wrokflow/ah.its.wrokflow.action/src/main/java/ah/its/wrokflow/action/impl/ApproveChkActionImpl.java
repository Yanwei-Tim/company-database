package ah.its.wrokflow.action.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ah.its.workFlow.util.CodeGenUtil;
import ah.its.wrokflow.action.ApproveChkActionI;
import ah.its.wrokflow.action.DeviceApproveFormActionI;
import ah.its.wrokflow.action.SysApproveFormActionI;
import ah.its.wrokflow.action.WorkflowEngineActionI;
import ah.its.wrokflow.domain.ApproveChkServiceI;
import ah.its.wrokflow.domain.WfNoticeServiceI;
import ah.its.wrokflow.domain.Impl.SysApproveCompleteServiceImpl;
import ah.its.wrokflow.repository.dao.ApproveChk;
import ah.its.wrokflow.repository.dao.DeviceApprove;
import ah.its.wrokflow.repository.dao.SysApprove;
import ah.its.wrokflow.repository.dao.SysApproveFile;

/**
* @Title: ApproveChkActionImpl.java 
* @Package ah.its.wrokflow.action.impl 
* @Description: ���������� 
* @author lil@cychina.cn
* @date 2016��4��27�� ����9:17:36 
* @version V1.0   
 */
@RestController
@RequestMapping("/workFlow/aCservice")
public class ApproveChkActionImpl implements ApproveChkActionI {
	   
	@Autowired
	private WfNoticeServiceI  wfNoticeServiceImpl;
	@Autowired
	private ApproveChkServiceI   approveChkServiceImpl;
	
	@Autowired
	private WorkflowEngineActionI workflowEngineActionImpl;//���̴�����
	
	@Autowired
	private DeviceApproveFormActionI deviceApproveFormActionImpl;//���̴�����
	
	@Autowired
	private SysApproveFormActionI sysApproveFormActionI;
	
	@Autowired
	private SysApproveCompleteServiceImpl sysApproveCompleteServiceImpl;
	
	@Override
	@RequestMapping(value = "/queryChkRecord")
	public Map queryChkRecord(String approveId) {
		Map   map = new HashMap();
		JSONArray  array  =  new JSONArray();
		SimpleDateFormat   sd  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ApproveChk>  lists= approveChkServiceImpl.queryApproveChkData(approveId);
		for(ApproveChk approveChk:lists){
			JSONObject  obj = JSONObject.parseObject(JSONObject.toJSONString(approveChk));
			obj.put("approvalResult","0".equals(approveChk.getApprovalResult())?"��ͨ��":"ͨ��");
			obj.put("approvalTime",sd.format(approveChk.getApprovalTime()));
			array.add(obj);
		}
		map.put("status", "1");
		map.put("data",array);
		return map;
	}

	@Override
	@RequestMapping(value = "/processChkRecord")
	public Map processChkRecord(@RequestBody ApproveChk form) {
		String  flag  = form.getApprovalId();//�Ƿ�ͨ����־
		form.setApprovalTime(new Date());
		form.setApprovalId(CodeGenUtil.getUDDICode());
		//���ù������� Ȼ�󱣴��¼
		Map map = new HashMap();
		map.put("checkResult", form.getApprovalResult());
		map.put("flag",flag);
		
		workflowEngineActionImpl.completeCheckTask(form.getApprovalUser(), form.getTaskId(), map);
		
		if(workflowEngineActionImpl.isOverByTask(form.getExtension())){
			if("0".equals(form.getIsSystem())){//�豸����
				//�������뵥״̬Ϊ����
				DeviceApprove deviceApprove = new DeviceApprove();
				deviceApprove.setDeviceApproveId(form.getApplyId());
				if("0".equals(flag)){
					deviceApprove.setStatus("3");
				}else{
					deviceApprove.setStatus("2");
				}
				deviceApproveFormActionImpl.updateDeviceApprove(deviceApprove);
			}
			if("1".equals(form.getIsSystem())){//ϵͳ����
				//�������뵥״̬Ϊ����
				SysApprove sysApprove = new SysApprove();
				sysApprove.setSystemApproveId(form.getApplyId());
				if("0".equals(flag)){
					sysApprove.setStatus("3");
				}else{
					sysApprove.setStatus("2");
					//ϵͳ����ͨ�����Զ���ϵͳ����systemApproveId��ϵͳ��������
					SysApproveFile SAF = new SysApproveFile();
					SAF.setId(CodeGenUtil.getUDDICode());
					SAF.setSystemApproveId(sysApprove.getSystemApproveId());//�������
					SAF.setApproveTime(new Date());
					SAF.setDisabled("0");
//					SAF.setStatus("0");
					sysApproveCompleteServiceImpl.saveSystemApproveComplete(SAF);
				}
				sysApproveFormActionI.updateSystemApprove(sysApprove);
			}
			if("2".equals(form.getIsSystem())){//ϵͳ��������
				//�������뵥״̬Ϊ����
				SysApproveFile SAF = new SysApproveFile();
				SAF.setId(form.getApplyId());
				if("0".equals(flag)){
					SAF.setStatus("3");
				}else{
					SAF.setStatus("2");
				}
				sysApproveCompleteServiceImpl.updateSystemApproveComplete(SAF);
			}
			//�����ɺ󣬲�����Ϣ��֪ͨ���У���ǰ�û��Ͳ���֪ͨ
			map.put("user",form.getApprovalUser());
			map.put("applyId",form.getApplyId());
			wfNoticeServiceImpl.insertBatch(map);
			
		}
		approveChkServiceImpl.saveApproveChkData(form);
		map.clear();
		map.put("status", "1");
		map.put("info", "������ɣ������Զ��رոý��棡");
		return map;
	}

}
