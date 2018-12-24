/**
 * @Title: ManualWeatherRepository.java
 * @Package cy.its.trafficSituation.repository
 * @Description: �˹���¼��������������ʩ��ʵ����
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��10�� ����3:02:53
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.com.util.StringUtil;
import cy.its.trafficSituation.domain.model.TrafficManualWeather;
import cy.its.trafficSituation.domain.repository.IManualWeatherRepository;
import cy.its.trafficSituation.mybatis.client.TrafficManualWeatherMapper;

@Service
public class ManualWeatherRepository implements IManualWeatherRepository {

	@Autowired
	TrafficManualWeatherMapper trafficManualWeatherMapper;
	/*
	  * <p>Title: aggregateOfId</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @throws Exception
	  * @see cy.its.com.domain.IRepository#aggregateOfId(java.lang.String)
	  */

	@Override
	public TrafficManualWeather aggregateOfId(String id) throws Exception {
		return trafficManualWeatherMapper.selectByPrimaryKey(id);
	}

	/*
	  * <p>Title: save</p>
	  * <p>Description: </p>
	  * @param obj
	  * @return
	  * @see cy.its.com.domain.IRepository#save(java.lang.Object)
	  */

	@Override
	public String save(TrafficManualWeather obj) {
		obj.setBadWeatherId(StringUtil.generateUUID());
		trafficManualWeatherMapper.insertSelective(obj);
		return obj.getBadWeatherId();
	}

	/*
	  * <p>Title: delete</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see cy.its.com.domain.IRepository#delete(java.lang.String)
	  */

	@Override
	public int delete(String id) {
		return trafficManualWeatherMapper.deleteByPrimaryKey(id);
	}

	/*
	  * <p>Title: update</p>
	  * <p>Description: </p>
	  * @param obj
	  * @return
	  * @see cy.its.com.domain.IRepository#update(java.lang.Object)
	  */

	@Override
	public int update(TrafficManualWeather obj) {
		return trafficManualWeatherMapper.updateByPrimaryKey(obj);
	}

	/*
	  * <p>Title: selectAll</p>
	  * <p>Description: </p>
	  * @param map
	  * @return
	  * @see cy.its.trafficSituation.domain.repository.IManualWeatherRepository#selectAll(java.util.Map)
	  */

	@Override
	public List<TrafficManualWeather> selectAll(Map<String, Object> map) {
		return trafficManualWeatherMapper.selectAll(map);
	}

}
