package cy.its.service.region.module;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cy.its.service.common.rabbitmqClient.IReceiver;
import cy.its.service.region.domain.Region;
import cy.its.service.region.domain.VehTrackPass;
import cy.its.service.util.RedisPoolUtil;
import cy.its.service.util.StringUtils;
import cy.its.service.util.TimeUtil;


/**
* @Title: RegionReceiveModule.java 
* @Package cy.its.service.Region.module 
* @Description: ����ƽ���������ù�������
* @author lil@cychina.cn
* @date 2015��11��4�� ����1:49:57 
* @version V1.0   
 */
public class RegionReceiveModule implements IReceiver{
	
	private static  Logger log=Logger.getLogger(RegionReceiveModule.class);
	
	//���ݸ�ʽ��
	DecimalFormat df3 = new DecimalFormat("#.00");
	
	private  DecimalFormat df = new DecimalFormat("#.0000"); 
	
	private SimpleDateFormat  df2  = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private  String  twoHourkey=null;
	
	/* (non-Javadoc)
	 * @see cy.its.service.com.rabbitmqClient.IReceiver#receive(java.lang.String, java.lang.String)
	 * ���չ�������
	 * �����������
	 * ���Ҹýڵ������Ǹ����䣨������������������䣩
	 * �鿴�õ�λ�ǿ�ʼ��λ���ǽ�����λ��һ��ƥ�䵽�����յ㣩
	 * ��ʼ��������ݴ��������Ϣ
	 * �յ������ƽ�����ٷ����յ�
	 * ���������ɾ�������Ϣ
	 * ������ں���δʶ��Ŀ���һֱ�����յ㣬����Ҫ�ų�������󱣴�2��Сʱ
	 * ���ֻ���յ���Ϣ������������¼��������
	 */
	@Override
	public Boolean receive(String arg0, String jsonObject) {
		//������¼
		VehTrackPass vp = JSONObject.parseObject(jsonObject,VehTrackPass.class);
		
		twoHourkey  = TimeUtil.twoHoursKey(vp.getPassTime());
		if(vp!=null){
			if("δ֪".equals(vp.getPlateNbr())){
				return true;
			}
		}
		List<Region> Lists = CacheManager.getDataList();
		
		for(Region redgion:Lists){
			if(redgion.getStartSiteCode() != null&&redgion.getDirectionType() != null){
				/**
				 * ���ƥ��
				 */
				if(redgion.getStartSiteCode().equals(vp.getSiteCode())&&redgion.getDirectionType().equals(vp.getDirectionType())){
					//���
					RedisPoolUtil.hset(twoHourkey+"-"+redgion.getRegionalId(), vp.getPlateNbr()+":"+vp.getPlateColor(), JSONObject.toJSONString(vp));
				}
				/**
				 * �յ�ƥ��
				 */
				if(redgion.getEndSiteCode() != null&&redgion.getDirectionType() != null){
					if(redgion.getEndSiteCode().equals(vp.getSiteCode())&&redgion.getDirectionType().equals(vp.getDirectionType())){
						processEndSite(redgion,vp);
					}
				}
			}
		}
		
		return  true;
	}

	/** 
	* @Title: processEndSite 
	* @Description: �����յ㴦��
	* @param @param vpl
	* @param @param vp    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private void processEndSite(Region vpl,VehTrackPass vp) {
		//�������������ͬ�ĺ��ƼӺ�����ɫ�ĳ������ֻ��¼����һ����¼
		String  str   =  RedisPoolUtil.hget(twoHourkey+"-"+vpl.getRegionalId(), vp.getPlateNbr()+":"+vp.getPlateColor());
		//���û��¼�򣬲�������
		if(StringUtils.isEmpty(str)){
			return;
		}
		VehTrackPass  startVp  = JSONObject.parseObject(str,VehTrackPass.class);
		//�ҵ�����¼�������ʱ��
		process(vpl,vp,startVp);
	}

	private void process(Region vpl,VehTrackPass vp, VehTrackPass startVp) {
		Date  startDate = startVp.getPassTime();
		Date  endDate = vp.getPassTime();
		if(endDate.getTime() < startDate.getTime()){
			log.info("���ʱ������յ�ʱ�䣬�����쳣����������");
		}
		if(startDate !=null&&endDate !=null){
			long  value  = endDate.getTime()-startDate.getTime();
			//ʱ�任���Сʱ
			double  time = Double.valueOf(df.format(value*1.00/(1000)));
			double  distance  = Double.valueOf(vpl.getDistance());
			double  avgSpeed= Double.valueOf(df.format(distance*1.00*60*60/time));
			JSONObject   jsonobj = new  JSONObject();
			jsonobj.put("orgCode",vp.getOrgCode());//����
			jsonobj.put("avgTravelTime",time);//ʱ����
			jsonobj.put("updateTime",df2.format(vp.getPassTime()));
			jsonobj.put("avgSpeed",avgSpeed);
			jsonobj.put("roadType",vpl.getRoadType());
			jsonobj.put("plateNbr",vp.getPlateNbr());//���ƺ���
			jsonobj.put("plateColor",vp.getPlateColor());//���ƺ���
			//�Ѽ����������յ�Ļ�����
			log.info("������������Ϣ��"+"pv:"+twoHourkey+"-"+vpl.getRegionalId()+"�����ƺ��룺"+vp.getPlateNbr());
			RedisPoolUtil.lpush("pv:"+twoHourkey+"-"+vpl.getRegionalId(), jsonobj.toJSONString());
	    }
	}

}
