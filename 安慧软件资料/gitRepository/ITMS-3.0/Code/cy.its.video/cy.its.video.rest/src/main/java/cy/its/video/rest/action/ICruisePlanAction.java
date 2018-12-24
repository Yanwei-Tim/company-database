package cy.its.video.rest.action;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

import cy.its.video.domain.criteria.TrafficPlanLogCriteria;

public interface ICruisePlanAction {

	/**
	 * ��ȡ����Ѳ�������б�
	 * 
	 * @return
	 */
	JSONObject getAllVideoCruisePlan(HttpServletRequest request);

	/**
	 * ��ȡ����Ѳ�������б�
	 * 
	 * @return
	 */
	JSONObject getVideoCruisePlanList(HttpServletRequest request);

	/**
	 * ��ȡѲ��������������Ƶ�б�
	 * 
	 * @param videoPlanID
	 * @return
	 */
	JSONObject getCruisePlanVideo(HttpServletRequest request);

	/**
	 * ����Ѳ��������ȡѲ����־
	 * 
	 * @param videoPlanID
	 * @return
	 */
	JSONObject getVideoCruiseLog(HttpServletRequest request, TrafficPlanLogCriteria trafficPlanLogCriteria);

	/**
	 * ����Ѳ����־id��ȡ��ص��¼���¼
	 * 
	 * @param videoPlanLogId
	 * @return
	 * @throws ParseException
	 */
	JSONObject getVideoCruiseEvent(HttpServletRequest request) throws ParseException;

	/**
	 * �����豸id��ȡԤ��λ�б�
	 * 
	 * @param videoPlanLogId
	 * @return
	 */
	JSONObject getVideoPresetList(HttpServletRequest request);

	/**
	 * ������ƵѲ������
	 * 
	 * @param plan
	 * @return
	 */
	JSONObject createVideoCruisePlan(HttpServletRequest request);

	/**
	 * ������ƵѲ����־
	 * 
	 * @param trafficPlanLog
	 * @return
	 */
	JSONObject createVideoCruiseLog(HttpServletRequest request);

	/**
	 * ������ƵѲ���¼�
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	JSONObject createVideoCruiseEvent(HttpServletRequest request);

	/**
	 * ������ƵԤ��λ
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	JSONObject createVideoPreset(HttpServletRequest request);

	/**
	 * �����û��Զ�����Ƶ��
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	JSONObject createVideoGroup(HttpServletRequest request) throws Exception;

	/**
	 * ����Ѳ����Ƶ
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	JSONObject createCruiseVideo(HttpServletRequest request);

	/**
	 * ����Ѳ������
	 * 
	 * @param trafficPlan
	 * @return
	 */
	JSONObject updateVideoCruisePlan(HttpServletRequest request);

	/**
	 * ����Ѳ��������Ƶ
	 * 
	 * @param request
	 * @return
	 */
	JSONObject updateCruiseVideo(HttpServletRequest request);

	/**
	 * �����û���Ƶ��
	 * 
	 * @param request
	 * @return
	 */
	JSONObject updateVideoGroup(HttpServletRequest request);

	/**
	 * ��ֹѲ��->����Ѳ����־
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	JSONObject stopCruise(HttpServletRequest request) throws ParseException;

	/**
	 * ɾ��Ѳ������
	 * 
	 * @param trafficPlan
	 * @return
	 */
	JSONObject deleteVideoCruisePlan(HttpServletRequest request);

	/**
	 * ɾ����ƵѲ���¼�
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	JSONObject deleteVideoCruiseEvent(HttpServletRequest request);

	/**
	 * ɾ����ƵԤ��λ
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	JSONObject deleteVideoPreset(HttpServletRequest request);

	/**
	 * ������ƵԤ��λ
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	JSONObject updateVideoPreset(HttpServletRequest request);

	/**
	 * ɾ���û���Ƶ��
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	JSONObject deleteVideoGroup(HttpServletRequest request);

	/**
	 * ɾ��Ѳ����Ƶ
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	JSONObject deleteCruiseVideo(HttpServletRequest request);
}
