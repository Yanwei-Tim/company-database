package cy.its.service.convertFlow.service;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.convertFlow.domain.TrafficSectionFlow;
import cy.its.service.convertFlow.task.TrafficFlowExcute;
import cy.its.service.util.DBUtil;
import cy.its.service.util.ExecutorServiceUtil;
import cy.its.service.util.RedisPoolUtil;
import cy.its.service.util.StringUtils;
import cy.its.service.util.TableColumn;


/**
* @Title: FlowScheduleService.java 
* @Package cy.its.road.convertFlow.service 
* @Description: 5���Ӷ�ʱ����
* @author lil@cychina.cn
* @date 2015��10��29�� ����4:16:26 
* @version V1.0   
 */
public class FlowScheduleService implements Job {
	//
	private SimpleDateFormat  df2  = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//���ݸ�ʽ��
	DecimalFormat df3 = new DecimalFormat("#.00"); 
	
	/**
	 * ��־�ļ�
	 */
	private static  Logger log=Logger.getLogger(FlowScheduleService.class);
	/* 
	 * ��ʱ������Ҫִ�еķ���
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		int  count = 0;
		//��ȡͳ������
		Date  currentTime  = new Date();
		long  key = getPeriodkey(currentTime);
		
		if(key != CacheManager.cuurnKey){
			log.info("��ǰ���ڣ�"+key+",��һ���ڣ�"+CacheManager.cuurnKey);
			CacheManager.initSectionist();
		}
		//ͨ�����ڻ�ȡ����
		//���ȴ����ӳټ�¼���ݣ�ÿһ��sectionId + ʱ����Ϊһ������Ԫ
		Set<String>  dsets = RedisPoolUtil.keys("d:*");
		TrafficFlowExcute  excuteTask = new TrafficFlowExcute();
		//dsets != null
		if(dsets != null){
			for (String  keys : dsets) {  
				List<String>  array  = RedisPoolUtil.lranage(keys, 0, -1);
				//ɾ������
				RedisPoolUtil.del(keys);
				TrafficSectionFlow  flow  = getTrafficSectionFlow(key,array);
				//�ж��Ǹ��»�������  ���� +����
				try {
					processDelay(flow,excuteTask);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(excuteTask.sqlList.size()>0){
			log.info("���������ӳټ�¼����Ϊ��"+excuteTask.sqlList.size());
			//��ӵ�ִ��������
			ExecutorServiceUtil.addTask(excuteTask);
		}
		//5���ӻ�������
		Map<String,String>  map  = CacheManager.getSectionMap();
		for(String tmp : map.keySet()){
			String  sectionId  = map.get(tmp);
			String  keyinfo = "m:"+sectionId+":"+key;
			List<String>  array  = RedisPoolUtil.lranage(keyinfo, 0, -1);
			if(array.size()==0){
				continue;
			}
			TrafficSectionFlow  flow  = getTrafficSectionFlow(key,array);
			//���Ϊ�ղ�������
			if(flow == null){
				log.info("���棺"+sectionId+"��ǰ����û�����ݽ��롣");
				continue;
			}
			try {
				//��������
				DBUtil.execute(getSql(flow));
				//������Ϣ
				MQGateWay.publish("its_section_flow", JSONObject.toJSONString(flow));
				
				log.info("���棺"+sectionId+"��Ϣ�����͡�");
				
				count++;
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//����1Сʱ��������Ϣ��������1Сʱ������Ϣ,��������5��������
			RedisPoolUtil.del(keyinfo);
			//����1Сʱ��������ΪҪƵ���ķ���redis�����Ҫ�ŶӴ���,ÿ������һ������
//			OneHourTask  onetask  =  new   OneHourTask();
//			onetask.currKey  = key;
//			onetask.sectionId  = sectionId;
//			ExecutorServiceUtil.addTask(onetask);
		}
		log.info("��ǰ���ڷ���"+count+"����¼��");
	}
	
	/**
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException  
	* @Title: processDelay 
	* @Description: �����ӳ����ڵ�����
	* @param @param flow    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private void processDelay(TrafficSectionFlow flow,TrafficFlowExcute excuteTask) throws IllegalArgumentException, IllegalAccessException {
		//�ж��Ƿ����
		String  sql  = " select  count(1) CNUM from t_traffic_section_flow  where section_id = '"+flow.getSectionId()+"' and update_time = to_date('"+df2.format(flow.getUpdateTime())+"','yyyy-mm-dd hh24:mi:ss')";
		JSONArray  jsonObj  =  DBUtil.queryJSONData(sql);
		JSONObject  jsonObject  = (JSONObject)jsonObj.get(0);
		int  count = jsonObject.getIntValue("CNUM");
		if(count >0){
			//����
			excuteTask.sqlList.add(getUpdateSql(flow));
		}else {
			//����
			excuteTask.sqlList.add(getSql(flow));
		}
	}
	/** 
	* @Title: getUpdateSql 
	* @Description: ��ȡ�������
	* @param @param flow
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	private String getUpdateSql(TrafficSectionFlow flow) {
		String  updateSql = " update t_traffic_section_flow  set  ";
		updateSql  += " total_num = total_num + "+flow.getTotalNum()+",";
		updateSql  += " large_num = large_num + "+flow.getLargeNum()+",";
		updateSql  += " small_num = small_num + "+flow.getSmallNum()+",";
		updateSql  += " other_num = other_num + "+flow.getOtherNum()+",";
		updateSql  += " avg_speed =case when total_num+"+flow.getTotalNum()+" = 0 then 0.00 else  trunc(avg_speed*total_num +"+flow.getAvgSpeed()*flow.getTotalNum()+")/(total_num+"+flow.getTotalNum()+"),2) end, ";
		updateSql  += " veh_tail_space =case when total_num+"+flow.getTotalNum()+" = 0 then 0.00 else trunc(veh_tail_space*total_num +"+flow.getVehTailSpace()*flow.getTotalNum()+")/(total_num+"+flow.getTotalNum()+"),2) end ";
		updateSql  += " where  = section_id + '"+flow.getSectionId()+"'  and  update_time = to_date('"+df2.format(flow.getUpdateTime())+"','yyyy-mm-dd hh24:mi:ss')";
		return updateSql;
	}

	/**
	 * @param key  
	* @Title: getTrafficSectionFlow 
	* @Description: ��������
	* @param @param  array
	* @param @return �趨�ļ� 
	* @return JSONObject �������� 
	* @throws 
	*/
	private TrafficSectionFlow getTrafficSectionFlow(long timekey, List<String> array) {
		if(array.size() ==0){
			return null;
		}
		TrafficSectionFlow object  = new TrafficSectionFlow();
		JSONObject jsonObject = JSONObject.parseObject(array.get(0));
		String sectionStateId  = UUID.randomUUID().toString().replace("-","");
		String  secondId  = jsonObject.getString("sectiondId");
		if(StringUtils.isEmpty(secondId)){
			return null; //��������
		}
		int totalNum=0;
	    int largeNum=0;
	    int smallNum=0;
	    int otherNum=0;
	    double avgSpeed=0;
	    double vehTailSpace=0;
		for(int i=0;i<array.size();i++){
			JSONObject  obj  = JSONObject.parseObject(array.get(i));
			totalNum += obj.getIntValue("totalNum");
			largeNum += obj.getIntValue("largeNum");
			smallNum += obj.getIntValue("smallNum");
			otherNum += obj.getIntValue("totalNum")-obj.getIntValue("largeNum")-obj.getIntValue("smallNum");
			avgSpeed += obj.getIntValue("totalNum")*obj.getDoubleValue("avrSpeed");
			vehTailSpace+= obj.getIntValue("totalNums")*obj.getDoubleValue("vehTailSpace");
		}
		int  devideNum = totalNum == 0 ? 1:totalNum;
		String avgValue = df3.format(avgSpeed/devideNum);
		String vehValue= df3.format(vehTailSpace/devideNum);
		object.setSectionStateId(sectionStateId);
		object.setSectionId(secondId);
		object.setTotalNum(totalNum);
		object.setLargeNum(largeNum);
		object.setSmallNum(smallNum);
		object.setOtherNum(otherNum);
		object.setAvgSpeed(Double.valueOf(avgValue));
		object.setVehTailSpace(Double.valueOf(vehValue));
		object.setUpdateTime(getUpdateTime(timekey));
		object.setOrgPrivilegeCode(jsonObject.getString("orgPrivilegeCode"));
		return object;
	}

	/** 
	* @Title: getPeriodkey 
	* @Description:���ݴ�������������ǰ�����Ǹ�����
	* @param @param format
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	private long getPeriodkey(Date currentTime) {
		int  value  = currentTime.getMinutes();
		int s = value/10;
		value = value%10;
		if(value>=5){
			currentTime.setMinutes(s*10+5);
		}else{
			currentTime.setMinutes(s*10);
		}
		currentTime.setSeconds(0);
		currentTime.setTime(currentTime.getTime()-1000*5*60);
		return 1000*(currentTime.getTime()/1000);
	}
	
	/** 
	* @Title: getUpdateTime 
	* @Description: ���ݿ����ʱ�� 
	* @param @param dataKey
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	private Date getUpdateTime(long dataKey) {
		Date   date  = new Date();
		date.setTime(dataKey);
		return date;
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException  
	* @Title: getSql 
	* @Description:��ȡSQLִ�����
	* @param @param alarm
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	public String getSql(TrafficSectionFlow alarm) throws IllegalArgumentException, IllegalAccessException {
		StringBuffer   sb = new StringBuffer();
		StringBuffer   sb2 = new StringBuffer();
		sb.append(" insert  into t_traffic_section_flow( ");
		sb2.append(" values( ");
		Field[] fs = TrafficSectionFlow.class.getDeclaredFields(); 
		for(int i = 0 ; i < fs.length; i++){  
			 Field f = fs[i];  
			 if(f.isAnnotationPresent(TableColumn.class)){
				 TableColumn tableColumn = f.getAnnotation(TableColumn.class);
				 sb.append(tableColumn.name()+",");
				 f.setAccessible(true); //����Щ�����ǿ��Է��ʵ� 
				 Object val = f.get(alarm);//�õ������Ե�ֵ
				 String type = f.getType().toString();//�õ������Ե����� 
				 if (type.endsWith("String")) {  
					 sb2.append("'"+val+"',");
				 }else if(type.endsWith("Date")){
					 sb2.append(" to_date('"+df2.format(val)+"','yyyy-mm-dd hh24:mi:ss'),");
				 }else{
					 sb2.append(val+",");
				 }
	         }
		}
		if(sb.length() > 1){
			sb.deleteCharAt(sb.length()-1);
		}
		if(sb2.length() > 1){
			sb2.deleteCharAt(sb2.length()-1);
		}
		sb.append(" ) ");
		sb2.append(") ");
		return sb.toString() + sb2.toString();
	}
	
}
