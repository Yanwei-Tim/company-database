package cy.its.video.domain.service;

import java.util.List;

import cy.its.video.domain.criteria.TrafficPlanLogCriteria;
import cy.its.video.domain.criteria.TrafficVideoGroupCriteria;
import cy.its.video.domain.model.TrafficPlan;
import cy.its.video.domain.model.TrafficPlanLog;
import cy.its.video.domain.model.TrafficPlanVideo;
import cy.its.video.domain.model.TrafficPreset;
import cy.its.video.domain.model.TrafficVideoGroup;
import cy.its.video.domain.model.TrafficVideoLog;

public interface IVideoCruiseService {

	/**
	 * ��ȡ����Ѳ�������б�
	 * 
	 * @return
	 */
	List<TrafficPlan> getTrafficPlanByCondition(String orgId) throws Exception;

	/**
	 * ��ȡѲ������
	 * 
	 * @return
	 */
	TrafficPlan getVideoCruisePlanByID(String trafficPlanID) throws Exception;

	/**
	 * ��ȡѲ��������������Ƶ�б�
	 * 
	 * @param videoPlanID
	 * @return
	 */
	List<TrafficPlanVideo> getCruisePlanVideo(String videoPlanID) throws Exception;

	/**
	 * ����Ѳ��������ȡѲ����־
	 * 
	 * @param videoPlanID
	 * @return
	 */
	List<TrafficPlanLog> getVideoCruiseLog(TrafficPlanLogCriteria trafficPlanLogCriteria) throws Exception;

	/**
	 * ����Ѳ����־id��ȡ��ص��¼���¼
	 * 
	 * @param videoPlanLogId
	 * @return
	 */
	List<TrafficVideoLog> getVideoCruiseEvent(String videoPlanLogId) throws Exception;

	/**
	 * ������Ƶid��ȡԤ��λ�б�
	 * 
	 * @param videoPlanLogId
	 * @return
	 */
	List<TrafficPreset> getVideoPresetList(String videoDeviceId, String componentId) throws Exception;

	/**
	 * ��ȡ������Ƶ����
	 * 
	 * @param videoPlanLogId
	 * @return
	 */
	List<TrafficVideoGroup> getVideoGroupByCondition(TrafficVideoGroupCriteria criteria) throws Exception;

	/**
	 * ������ƵѲ������
	 * 
	 * @param plan
	 * @return
	 */
	String createVideoCruisePlan(TrafficPlan plan) throws Exception;

	/**
	 * ����Ѳ����Ƶ
	 * 
	 * @param trafficPlanVideo
	 * @return
	 */
	String createCruiseVideo(TrafficPlanVideo trafficPlanVideo) throws Exception;

	/**
	 * ������ƵѲ����־
	 * 
	 * @param trafficPlanLog
	 * @return
	 */
	TrafficPlanLog createVideoCruiseLog(TrafficPlanLog trafficPlanLog) throws Exception;

	/**
	 * ������ƵѲ���¼�
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	String createVideoCruiseEvent(TrafficVideoLog trafficVideoLog) throws Exception;

	/**
	 * ������ƵѲ���¼�
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	String createVideoPreset(TrafficPreset trafficPreset) throws Exception;

	/**
	 * �����û���Ƶ�Զ������
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	String createVideoGroup(TrafficVideoGroup videoGroup) throws Exception;

	/**
	 * ����Ѳ����Ƶ��Ϣ
	 * 
	 * @param trafficPlanVideo
	 * @return
	 */
	int updateCruiseVideo(TrafficPlanVideo trafficPlanVideo) throws Exception;

	/**
	 * ����Ѳ������
	 * 
	 * @param trafficPlan
	 * @return
	 */
	int updateVideoCruisePlan(TrafficPlan trafficPlan) throws Exception;

	/**
	 * ����Ԥ��λ
	 * 
	 * @param TrafficPreset
	 * @return
	 */
	int updateTrafficPreset(TrafficPreset trafficPreset) throws Exception;

	/**
	 * �����û�����
	 * 
	 * @param TrafficPreset
	 * @return
	 */
	int updateVideoGroup(TrafficVideoGroup videoGroup) throws Exception;

	/**
	 * ����Ѳ����־
	 * 
	 * @param TrafficPlanLog
	 * @return
	 */
	int updateTrafficPlanLog(TrafficPlanLog trafficPlanLog) throws Exception;

	/**
	 * ������Ƶ�¼�
	 * 
	 * @param TrafficVideoLog
	 * @return
	 */
	int updateTrafficVideoLog(TrafficVideoLog trafficVideoLog) throws Exception;

	/**
	 * ��ֹѲ��->����Ѳ����־
	 * 
	 * @param TrafficPreset
	 * @return
	 */
	int stopVideoCruise(TrafficPlanLog trafficPlanLog) throws Exception;

	/**
	 * ɾ��Ѳ����Ƶ
	 * 
	 * @param trafficPlanVideo
	 * @return
	 */
	int deleteCruiseVideo(String cruiseVideoID) throws Exception;

	/**
	 * ɾ��Ѳ������
	 * 
	 * @param trafficPlan
	 * @return
	 */
	int deleteVideoCruisePlan(String cruisePlanID) throws Exception;

	/**
	 * ɾ����ƵѲ���¼�
	 * 
	 * @param trafficVideoLog
	 * @return
	 */
	int deleteVideoCruiseEvent(String videoCruiseEventID) throws Exception;

	/**
	 * ɾ����ƵԤ��λ
	 * 
	 * @param trafficPresetID
	 * @return
	 */
	int deleteTrafficPreset(String trafficPresetID) throws Exception;

	/**
	 * ɾ���û��Զ�����Ƶ����
	 * 
	 * @param trafficPresetID
	 * @return
	 */
	int deleteVideoGroup(String videoGroupID) throws Exception;

}
