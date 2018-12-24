package cy.its.violation.rest.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

import cy.its.violation.rest.dto.DataGridResult;
import cy.its.violation.rest.dto.OperationCondition;
import cy.its.violation.rest.dto.OperationResult;
import cy.its.violation.rest.dto.StatisticChartData;
import cy.its.violation.rest.dto.StatisticCondition;

/**
 * @title:IViolationAction.java
 * @Package:cy.its.violation.rest.action
 * @Description:TODO
 * @author:jinhb@cychina.cn
 * @date: 2015��10��9�� ����10:24:21
 * @version v1.0
 */
public interface IViolationAction {

	/**
	 * ��ѯ��ҳ����
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public DataGridResult queryViolationSet(HttpServletRequest request, OperationCondition form) throws Exception;

	/**
	 * ��ѯ��ҳ����
	 * 
	 * @param form
	 * @return
	 */
	public JSONObject exportViolationSet(HttpServletRequest request) throws Exception;

	/**
	 * ��ѯ�ϴ���־
	 * 
	 * @param form
	 * @return
	 */
	public JSONObject queryUploadLog(HttpServletRequest request);

	/**
	 * ��ȡͳ������
	 * 
	 * @param form
	 * @return
	 */
	public StatisticChartData getStatisticChartData(HttpServletRequest request);

	/**
	 * ��ȡΥ�������б�
	 * 
	 * @param form
	 * @return
	 */
	public List getStatisticDataForCollateFilter(StatisticCondition opCondition);

	/**
	 * ¼����Υ����¼
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult inputConfirmDigitalViolation(HttpServletRequest request) throws Exception;

	/**
	 * ¼����Υ����¼
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult inputBulkImportViolation(HttpServletRequest request) throws Exception;

	/**
	 * ��¼�޸Ĳ���
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult abandonViolation(HttpServletRequest request) throws Exception;

	/**
	 * ��¼�޸Ĳ���
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult filterViolation(HttpServletRequest request) throws Exception;

	/**
	 * ��¼�޸Ĳ���
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult viewViolationOfIdWithLock(HttpServletRequest request) throws Exception;

	/**
	 * ��¼�޸Ĳ���
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult isWhiteVeh(HttpServletRequest request) throws Exception;

	/**
	 * ��¼�޸Ĳ���
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult unLockViolation(HttpServletRequest request) throws Exception;

	/**
	 * ��¼
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult reInputViolation(HttpServletRequest request) throws Exception;

	/**
	 * ¼��
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult inputViolationForConfirm(HttpServletRequest request) throws Exception;

	/**
	 * �ϴ�
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult uploadViolation(HttpServletRequest request) throws Exception;

	/**
	 * ɾ��
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult deleteViolation(HttpServletRequest request) throws Exception;

	/**
	 * ��ԭ
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult restoreViolation(HttpServletRequest request) throws Exception;

	/**
	 * �޸Ĳ������ϴ�
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public OperationResult verifyUploadFailViolation(HttpServletRequest request) throws Exception;

}
