package cy.its.trafficSituation.domain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.com.util.StringUtil;
import cy.its.trafficSituation.domain.model.TrafficDeviceFlow;
import cy.its.trafficSituation.domain.repository.ITrafficFlowRepository;
import cy.its.trafficSituation.domain.service.ITrafficFlowService;

@Service
public class TrafficFlowService implements ITrafficFlowService {

	@Autowired
	ITrafficFlowRepository trafficFlowRepository;
	
	@Override
	public List<TrafficDeviceFlow> countDeviceFlow(String deviceSysNbr, Date from, Date to) throws Exception {
		
		if(StringUtil.isNullOrEmpty(deviceSysNbr)){
			throw new Exception("ϵͳ��Ų���Ϊ��");
		}
		
		if(from == null){
			throw new Exception("ͳ�ƿ�ʼʱ�䲻��Ϊ��");
		}
		
		if(to == null){
			throw new Exception("ͳ�ƽ���ʱ�䲻��Ϊ��");
		}
		
		if(from.getTime() > from.getTime()){
			throw new Exception("ͳ�ƿ�ʼʱ�䲻�ܴ���ͳ�ƽ���ʱ��");
		}
		
		return trafficFlowRepository.countDeviceFlow(deviceSysNbr, from, to);
	}

}
