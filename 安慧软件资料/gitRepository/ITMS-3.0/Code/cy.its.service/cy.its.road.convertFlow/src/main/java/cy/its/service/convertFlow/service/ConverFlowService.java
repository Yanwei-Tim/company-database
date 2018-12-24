package cy.its.service.convertFlow.service;

import java.util.Date;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import cy.its.service.common.rabbitmqClient.IReceiver;
import cy.its.service.util.RedisPoolUtil;
import cy.its.service.util.StringUtils;

/**
* @Title: ConverFlowService.java 
* @Package cy.its.road.convertFlow.service 
* @Description:�������ݽ��գ�ֻ�洢��ǰ���ڵĵ����ݣ�����δ�����ڵ�����
* @author lil@cychina.cn
* @date 2015��10��28�� ����1:49:16 
* @version V1.0   
 */
public class ConverFlowService implements IReceiver{
	
	/**
	 * ��־�ļ�
	 */
	private static  Logger log=Logger.getLogger(ConverFlowService.class);
	/**
	 * 5�������ݣ�����2��Сʱ��������Ϣ�����ݿ��ֶβ�����һ��Сʱ������
	 * ���ݽ������ù���ʱ��2��Сʱ10����
	 * ����KEY����̫����redis��f:regionId:ʱ��----value��ֵ
	 * �ӳٵ����ݼ������������»�����¼����������
	 * �ӳ����ݲ��� redis  hashset ��ʽ����
	 * �ӳٵ����� ��5���Ӷ�ʱ����֮ǰ�ȼ���
	 */
	@Override
	public Boolean receive(String arg0, String jsonstring) {
		
		JSONObject   jsonObject  = JSONObject.parseObject(jsonstring);
		Date  currentTime  = new Date();
		//��ȡ��ǰ���ڣ���������ʱ��
		long  key = getPeriodkey(currentTime);
		//��ȡͳ�����ڵ�ʱ��
		Date   dataDate  = jsonObject.getDate("countTime");
		//�������ݵ�����
		long dataKey = getPeriodkey(dataDate);
		//��λ�ӷ���������ΪKEYֵ
		//�ҳ������ID������Ҳ��������������
		String  sectionId  = CacheManager.getSectionByKey(jsonObject.getString("siteCode")+":"+jsonObject.getString("directionType"));
		if(StringUtils.isEmpty(sectionId)){
			return true;
		}
		//����ID
		jsonObject.put("sectiondId",sectionId);
		//���DATA���ڵ��ڵ�ǰ��key����
		if(key==dataKey){
			addObjectToRedis(key,"m:"+sectionId,jsonObject);
		}else{
			//���ͳ��ʱ����ڵ�ǰʱ��������ݷ���ͳ��ʱ����dataKey
			if(dataKey > key){
			    //ֱ�ӷ����µ�������
			   addObjectToRedis(dataKey,"m:"+sectionId,jsonObject);
			}else{
			   //��¼���ݣ��������ݿ���Ϣ����¼��Ϣ��ֻ����5���ݿ�5 ���ӵ���Ϣ һСʱ�����ݲ�������
			   log.info("�ӳ����ݣ�"+sectionId+":"+dataKey+":����redis���棡");
			   delayComputeObject(dataKey,key,sectionId,jsonObject);
			}
		}
		return true;
	}

	/** 
	* @Title: delayComputeObject 
	* @Description:��¼���ݣ����ж���ǰ�������� �����Ƿ����
	* @param @param dataKey
	* @param @param secondId
	* @param @param jsonObject    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private void delayComputeObject(long lastKey,long  currKey,String secondId,
			JSONObject jsonObject) {
		//�����ŵ�ʱ��Ϊ13���������ݣ��������8��5�ֵ�����  ����Ҫ 8��05- 7��05 ������ 8��--7�������  ����������ʱ����
//		long  min  = currKey - 5*60*1000;//5 ���ӵ�����
//		if(lastKey > min && lastKey < currKey){
//			 //���»�������
//			 addObjectToRedis(lastKey,"m:"+secondId,jsonObject);
//		}
		//����redis��Ϣ
		addObjectToRedis(lastKey,"d:"+secondId,jsonObject);
	}
	/** 
	* @Title: addObjectToRedis 
	* @Description: �Ѽ�¼���뻺���У��Թ���������ʹ��
	* @param @param key regionId+ʱ��+
	* @param @param filed
	* @param @param jsonObject    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private void addObjectToRedis(long key,String secondId, JSONObject jsonObject) {
		
		RedisPoolUtil.lpush(secondId+":"+key, jsonObject.toJSONString());
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
		int  s = value/10;
		value = value%10;
		if(value>=5){
			currentTime.setMinutes(s*10+5);
		}else{
			currentTime.setMinutes(s*10);
		}
		currentTime.setSeconds(0);
		//���ڵ��������5���ӣ������Ҫ��5����
		currentTime.setTime(currentTime.getTime());
		return 1000*(currentTime.getTime()/1000);
	}
}
