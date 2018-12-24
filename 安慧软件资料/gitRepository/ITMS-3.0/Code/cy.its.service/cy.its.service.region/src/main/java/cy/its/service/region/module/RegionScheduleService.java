package cy.its.service.region.module;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.fastjson.JSONObject;

import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.region.domain.Region;
import cy.its.service.region.domain.RegionSpeed;
import cy.its.service.region.domain.TrafficAlarmValue;
import cy.its.service.util.RedisPoolUtil;
import cy.its.service.util.TimeUtil;



/**
* @Title: RegionScheduleService.java 
* @Package cy.its.service.region.module 
* @Description: ����5���ӵ��ȳ��� 
* @author lil@cychina.cn
* @date 2015��12��4�� ����4:14:17 
* @version V1.0   
 */
public class RegionScheduleService  implements Job {
	
	private static  Logger log=Logger.getLogger(RegionScheduleService.class);
    //�����Է�Ϊ��
	DecimalFormat df3 = new DecimalFormat("#.00");
	
	private  double   a_r  = 1.5;
	
    /**
     * ������������5����ͳ��һ��
     */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//5 ����ˢ��һ��
		CacheManager.initRegionList();
		CacheManager.initTrafficAlarmList();
		//��ȡ������Ч����
		List<Region> list  = CacheManager.getDataList();
		//�Ƿ���һ�λ�ȡ���м�¼��Ȼ���ڴ�����
		final Date currentTime =  new Date();
		//ʱ���������
		final Date endTime = getPeriodkey(currentTime);
		
		//��СʱKEY,��ǰʱ������ͺ�����������ʱ��ȡ����Ӧ�����ϸ�Сʱ�����ݣ������Ҫ - 3���ӵ�ʱ��
		final String twoHoursKey = TimeUtil.twoHoursKey(new Date(),3);
		//����
		final Date startTime=TimeUtil.reduceFiveMinute(endTime);
		//�������е������յ㣬Ȼ����д���
		for(Region st:list){
			//���ù���ʱ��
			expoireKey(twoHoursKey,st.getRegionalId());
			List<String> strs = RedisPoolUtil.lranage("pv:"+twoHoursKey+"-"+st.getRegionalId(), 0, -1);
			RegionSpeed   ssp = new RegionSpeed();
			ssp.setRegionalId(st.getRegionalId());
			ssp.setUpdateTime(endTime);
			ssp.setOrgPrivilegeCode(st.getOrgPrivilegeCode());
			//��ȡ�µ�LIST
			List<RegionSpeed> newList  = getNewList(strs,startTime,endTime,st.getRegionalId());
			try {
				//��list��������
				newList = newList.stream().sorted((s1,s2)->{
				    return (int) (s1.getAvgSpeed()-s2.getAvgSpeed());
				}).collect(Collectors.toList());
				//���û�м�¼�ٶ�Ϊ��
				if(newList.size()==0){
					ssp.setAvgSpeed(0);
					ssp.setRoadType("0");
				}else{
					ssp.setRoadType(newList.get(0).getRoadType());
					ssp.setOrgCode(newList.get(0).getOrgCode());
				}
				//����ƽ��ֵ
				setAvgBylist(ssp,newList);
			    //��������
			    processStatus(ssp,st.getEndSiteCode());
			} catch (Exception e) {	
				// TODO Auto-generated catch  w
				log.error("���䣺"+st.getRegionalId()+"�������������");
				e.printStackTrace();
			}
		}
	}
	
	private void setAvgBylist(RegionSpeed ssp, List<RegionSpeed> newList) {
		// TODO Auto-generated method stub
	    if(newList.size()<10){
	    	//����ƽ��ֵ
	    	double avgSpeed  = (double) newList.stream().collect(Collectors.averagingDouble(RegionSpeed::getAvgSpeed));
	    	double avgTravlTime  = (double) newList.stream().collect(Collectors.averagingDouble(RegionSpeed::getAvgTravelTime));
	    	ssp.setAvgSpeed(Double.valueOf(df3.format(avgSpeed)));
	    	ssp.setAvgTravelTime(Double.valueOf(df3.format(avgTravlTime)));
	    }
	    //��������������������������������㣬ƽ���ٶ�
	    if(newList.size()>=10){
	    	//�������㷨
	    	double  Value41  = ((RegionSpeed)newList.get(newList.size()/4)).getAvgSpeed();
	    	double  Value43  = ((RegionSpeed)newList.get(newList.size()*3/4)).getAvgSpeed();
	    	double  IRQ  = Value43 - Value41;
	    	final double minValue = Value41 - IRQ*a_r;
	    	final double maxValue = Value43 + IRQ*a_r;
	    	//�޳�����Ҫ��������ƽ��ֵ
	    	List<RegionSpeed> listrs  = newList.stream().filter(sp->{
	    		if(sp.getAvgSpeed()>= minValue && sp.getAvgSpeed()<=maxValue){
	    			return true; 
	    		}
	    		return false;
	    	}).collect(Collectors.toList());
	    	//
	    	double avgSpeed   = listrs.stream().collect(Collectors.averagingDouble(RegionSpeed::getAvgSpeed));
	    	double avgTime  = listrs.stream().collect(Collectors.averagingDouble(RegionSpeed::getAvgTravelTime));
	    	ssp.setAvgSpeed(Double.valueOf(df3.format(avgSpeed)));
	    	ssp.setAvgTravelTime(Double.valueOf(df3.format(avgTime)));
	    }
	}

	private List<RegionSpeed> getNewList(List<String> strs, Date startTime, Date endTime, String regionalId) {
		List<RegionSpeed> newList = new ArrayList();
		for(int i=0;i<strs.size();i++){
			//ʱ����5�����ڵ����ݣ���������ڶ���������
			RegionSpeed jsonobj  = JSONObject.parseObject(strs.get(i),RegionSpeed.class);
			//��¼���ƺ��� plateNbr
			String plateNbr  = JSONObject.parseObject(strs.get(i)).getString("plateNbr");
			Date passTime=null;
			try {
				passTime =jsonobj.getUpdateTime();
			} catch (Exception e) {
				log.error("�������ʱ��ת���������⣡");
				log.error(e);
			}
			//���ʱ��Ϊ�գ���ֱ�ӷ���
			if(passTime ==null ){
				continue;
			}
			if(passTime.getTime() > startTime.getTime() && passTime.getTime() <= endTime.getTime()){
				log.info("����ID:"+regionalId+",�������룺"+plateNbr);
				//���봦��Ԫ
				newList.add(jsonobj);
			}
		}
		return newList;
	}

	/**
	 * @param twoHoursKey
	 * @param regionalId
	 * ����KEY ��������Сʱ
	 */
	private void expoireKey(String twoHoursKey,String regionalId) {
		if(RedisPoolUtil.exists(twoHoursKey+"-"+regionalId)&&RedisPoolUtil.pttl(twoHoursKey+"-"+regionalId)==-1){
			RedisPoolUtil.expire(twoHoursKey+"-"+regionalId,60*60*2);
		}
		if(RedisPoolUtil.exists("pv:"+twoHoursKey+"-"+regionalId)&&RedisPoolUtil.pttl("pv:"+twoHoursKey+"-"+regionalId)==-1){
			RedisPoolUtil.expire("pv:"+twoHoursKey+"-"+regionalId,60*60*2);
		}

	}

	/**
	 * @param publishList 
	 * @param string  
	* @Title: processStatus 
	* @Description:�����ٶȼ�������״̬��ͬʱ�ų���ͨ���Ƶĵ�λ
	* @param @param ssp �趨�ļ� 
	* @return void �������� 
	* @throws 
	*/
	private void processStatus(RegionSpeed ssp, String siteCode) {
		//�ܹ��Ƶĵ�λ��Ϣ
		ssp.setTrafficState("0");
		//��ȡ״̬��ֵ��Ϣ,����״̬����ֵ��������״̬
		List<TrafficAlarmValue> list  =CacheManager.getTrafficAlarmDataList();
		
		for(TrafficAlarmValue tdv:list){
			if(ssp.getAvgSpeed()>tdv.getMin() && ssp.getAvgSpeed() <=tdv.getMax()){
				ssp.setTrafficState(tdv.getAlermGrade());
			}
		}
		MQGateWay.publish("its_region_speed",JSONObject.toJSONString(ssp));
		log.info("�����������ݣ�"+JSONObject.toJSONString(ssp));
	}

	/**
	 * @throws ParseException  
	* @Title: getPeriodkey 
	* @Description:���ݴ�������������ǰ�����Ǹ�����
	* @param @param format
	* @param @return �趨�ļ� 
	* @return String �������� 
	* @throws 
	*/
	private  Date getPeriodkey(Date currentTime) {
		int  value  = currentTime.getMinutes();
		int  s = value/10;
		value = value%10;
		if(value>=5){
			currentTime.setMinutes(s*10+5);
		}else{
			currentTime.setMinutes(s*10);
		}
		currentTime.setSeconds(0);
		return currentTime;
	}
}
