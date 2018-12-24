/**
 * @Title: ServerStatusSingleReceiver.java
 * @Package cy.its.common.duplex.rabbitMq.receive
 * @Description: TODO(����Ҫ��д��;)
 * @author Administrator Administrator@cychina.cn
 * @date 2015��12��28�� ����4:04:43
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.common.duplex.rabbitMq.receive;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cy.its.common.duplex.mapData.ServerStatusMapData;
import cy.its.common.duplex.rabbitMq.IMqReceiver;
import cy.its.common.duplex.rabbitMq.IWebscoketReceiver;

/**
  * @ClassName: ServerStatusSingleReceiver
  * @Description: ����������״̬������
  * @author Administrator Administrator@cychina.cn
  * @date 2015��12��28�� ����4:04:43
  *
  */

public class ServerStatusSingleReceiver implements IMqReceiver{

	
	/**
	 * ��ʱ����ע����Ϣ
	 */
    private  List<IWebscoketReceiver> list = new ArrayList<IWebscoketReceiver>();
    /**
     * ������෢����Ϣ
     */
    @Override
	public Boolean receive(String routingKey,String message) {
    	boolean status = true;
    	JSONObject  jsonObject  = JSONObject.parseObject(message);
    	//���»���
    	ServerStatusMapData.updateServerStatus(jsonObject);
		for(IWebscoketReceiver webscoketReceiver:list){	
		    try{
		    	status=webscoketReceiver.receive(jsonObject);
		    }catch(Exception e){
		    	continue;
		    }
			
		}		
		return status;
	}

	
	/**
	 * ע��һ��������
	 */
	@Override
	public boolean addReciveObject(IWebscoketReceiver webscoketReceiver) {
		synchronized(this){
			list.add(webscoketReceiver);
		}
		return true;
	}

}
