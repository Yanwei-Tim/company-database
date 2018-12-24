package cy.its.service.convertFlow.task;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.util.RedisPoolUtil;

/**
* @Title: OneHourTask.java 
* @Package cy.its.service.convertFlow.task 
* @Description:һСʱ�����������5�����ͺ�
* @author lil@cychina.cn
* @date 2015��12��22�� ����8:57:25 
* @version V1.0   
 */
public class OneHourTask implements Runnable {

	//������ǰ����
	public long   currKey = 0;
	
	// ��ǰ����
	public  String   sectionId= "";
	
	@Override
	public void run() {
		JSONObject   jsonobj = new JSONObject();
		//��Ҫ�������һСʱ�����ݣ���������е�������������Ԥ������
		//��ȡ����LIST
		List  listall =  new ArrayList();
		
		for(int i=1;i<12;i++){
			long key = currKey - i*5*60*1000;
			String  keyinfo = "m:"+sectionId+":"+key;
			listall.addAll(RedisPoolUtil.lranage(keyinfo, 0, -1));
		}
		int total = 0;
		//ǰ��û���ݣ�ֻ���㵱ǰʱ������
		if(listall.size() > 0){
			//���е�LSIT
			for(int i=0;i<listall.size();i++){
				JSONObject  temp  = JSONObject.parseObject(listall.get(i).toString());
				if(i == 0){
					jsonobj.put("secondId", temp.getString("secondId"));
					jsonobj.put("orgPrivilegeCode", temp.getString("orgPrivilegeCode"));
					jsonobj.put("totalNum",0);
				}
				total += temp.getIntValue("totalNum");
			}
			jsonobj.put("totalNum",total);
			jsonobj.put("lastTotalNum",total);
			
			String lastkey = "m:"+sectionId+":"+(currKey-12*5*60*1000);
			total  = 0;
			List<String>  list  = RedisPoolUtil.lranage(lastkey, 0, -1);
			for(String  str :list){
				JSONObject  temp  = JSONObject.parseObject(str);
				total += temp.getIntValue("totalNum");
			}
			jsonobj.put("lastTotalNum",jsonobj.getIntValue("lastTotalNum")+total);
			
			String key = "m:"+sectionId+":"+currKey;
			list  = RedisPoolUtil.lranage(key, 0, -1);
			total  = 0;
			for(String  str :list){
				JSONObject  temp  = JSONObject.parseObject(str);
				total += temp.getIntValue("totalNum");
			}
			jsonobj.put("totalNum",jsonobj.getIntValue("totalNum")+total);
		}else{
			//���㵱ǰ��
			String key = "m:"+sectionId+":"+currKey;
			List<String> list  = RedisPoolUtil.lranage(key, 0, -1);
			total  = 0;
			for(String  str :list){
				JSONObject  temp  = JSONObject.parseObject(str);
				if(total == 0){
					jsonobj.put("secondId", temp.getString("secondId"));
					jsonobj.put("orgPrivilegeCode", temp.getString("orgPrivilegeCode"));
					jsonobj.put("totalNum",0);
				}
				total += temp.getIntValue("totalNum");
			}
			jsonobj.put("totalNum",jsonobj.getIntValue("totalNum")+total);
		}
		if(jsonobj.get("secondId") != null){
			//������Ϣ
			MQGateWay.publish("its_section_hour_flow", jsonobj.toJSONString());
		}
	}

}
