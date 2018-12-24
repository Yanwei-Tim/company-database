/**
 *name :Σ�ռ�ʻ��������
 *author:wangyunqi
 *date:2016/03/14
 * 
 */
package cy.its.vehTrack.repository.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;

import cy.its.vehTrack.domain.repository.IDangerCarResponsitory;
import cy.its.vehTrack.repository.bigData.Config;
import cy.its.vehTrack.repository.bigData.util.RESTUtil;

@Repository
public class DangerCarResponsitory implements IDangerCarResponsitory {

	/**
	 * Σ�ռ�ʻ����TOPN
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public String findDangerCarTopN(String query) throws Exception {
		// TODO Auto-generated method stub
		//return this.getDataFromBigData("danger_car_topn_service", query);
		String id=RESTUtil.load(Config.getProperties("danger_car_topn_service"), query);
		return id;
	}

	/**
	 * Σ�ռ�ʻ�����������
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public String findDangerCarWholeAnylsis(String query) throws Exception {
		// TODO Auto-generated method stub
		//return this.getDataFromBigData("danger_car_whole_service", query);
		String id=RESTUtil.load(Config.getProperties("danger_car_whole_service"), query);
		return id;
	}

	/**
	 * Σ�ռ�ʻ�����������
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> findDangerCarSimpleAnylsis(String query) throws Exception {
		// TODO Auto-generated method stub
		return this.getDataFromBigData("danger_car_simple_service", query);
	}

	/**
	 * Σ�ռ�ʻ�����������
	 * @param dangerDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public String findDangerCarMulitAnylsis(String query) throws Exception {
		// TODO Auto-generated method stub
		//return this.getDataFromBigData("danger_car_mulit_service", query);
		String id=RESTUtil.load(Config.getProperties("danger_car_mulit_service"), query);
		return id;
	}

	
	/**
	 * ���ô�����ƽ̨�Ľӿ�
	 * @param key
	 * @param query
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Map<String, Object> getDataFromBigData(String key,String query) throws FileNotFoundException, IOException, Exception{
		
		String result = RESTUtil.load(Config.getProperties(key), query);
		return JsonToMap(result);
		
	}
	public static Map<String, Object> JsonToMap(String result){
		JSONObject obj = JSONObject.parseObject(result);
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("result", obj);
		return map;
	}
	
}
