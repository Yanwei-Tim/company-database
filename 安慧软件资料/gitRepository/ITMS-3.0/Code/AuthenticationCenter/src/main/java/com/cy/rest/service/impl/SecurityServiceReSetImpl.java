package com.cy.rest.service.impl;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cy.cache.domain.CacheDao;
import com.cy.cache.service.CacheServiceI;
import com.cy.rest.service.SecurityServiceReSetI;
import com.cy.security.domain.SecurityDao;
import com.cy.security.service.SecurityServiceI;
import com.cy.security.service.impl.SecurityServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cy.its.platform.common.utils.Log4jFactoryProxy;


/**
* @Title: SecurityServiceReSetImpl.java 
* @Package com.cy.rest.service.impl 
* @Description: ��Ҫ�����û������֤��ͳ��
* @author lil@cychina.cn
* @date 2015��12��7�� ����3:46:37 
* @version V1.0   
 */
@RestController
@RequestMapping("/authentication")
public class SecurityServiceReSetImpl implements SecurityServiceReSetI {
	/*
	 * ��־����
	 */
	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(SecurityServiceImpl.class);
	
	/**
     * ʹ��@Autowiredע���עuserMapper������
     * ����Ҫʹ��securityMapperʱ��Spring�ͻ��Զ�ע��securityMapper
     */
    @Autowired
    private SecurityServiceI securityServiceImpl;//ע��dao
    
    @Autowired
    private CacheServiceI cacheServiceImpl;
    
    private DateFormat format= new SimpleDateFormat("yyyyMMddHHmmss");  
    
    /*
     * JSON���߰�
     */
    private ObjectMapper  mapper  = new ObjectMapper();
    
    @RequestMapping("/getPwdByStaffCode") 
	public List<SecurityDao> getPwdByStaffCode(@RequestParam(value = "name") String name) {
		 return securityServiceImpl.getPwdByStaffCode(name.toUpperCase());
	}
    
	/* (non-Javadoc)
	 * @see com.cy.reset.service.SecurityServiceReSetI#validatelogin(java.lang.String) 
	 * ��֤�û���¼����֤ͨ������TOOKIN����֤ʧ�����µ�½
	 */
	@RequestMapping("/validatelogin") 
	public Map validatelogin(@RequestParam(value = "paramInfo") String paramInfo) {
		Map  map  =  new HashMap();
		Map  paramMap=null;
		try {
			paramMap = mapper.readValue(paramInfo, Map.class);
			List<SecurityDao> listdao  = securityServiceImpl.getPwdByStaffCode(paramMap.get("username").toString().toUpperCase());
			if(listdao.size() > 0){
				String pwd = paramMap.get("password").toString();
				SecurityDao   dao  = listdao.get(0);
				if(dao.getQueryValue2().equals(pwd)){
					//д�뻺��
					String  key= UUID.randomUUID().toString().replaceAll("-", "");//����Ψһ��
					Map object   = new  HashMap();
					object.put("date",format.format(new Date()));//����ʱ��
					//objMap.put("role",paramMap.get("role")==null?"":paramMap.get("role").toString());
					object.put("loginName",dao.getQueryValue1());//�û���¼��Ϣ
					object.put("userName",dao.getQueryValue5());//�û���¼��Ϣ
					object.put("orgCode",dao.getQueryValue3());//�û�����
					object.put("orgPrivCode",dao.getQueryValue4());//�û�����
					object.put("orgId",dao.getQueryValue6());//�û�����
					object.put("userId",dao.getQueryValue7());//�û�ID
					//���뻺��
					cacheServiceImpl.addMemeryCache("VU:"+key,JSONObject.toJSONString(object),10*60);//���뻺��
					//2�ɹ���־
					map.put("status","2");
					map.put("info",key);
					map.put("data",object);
				}else{
					map.put("status","0");
					map.put("info","��½�������");
				}
			}else{
				map.put("status","0");
				map.put("info","�����û������ڣ�");
			}
		} catch (JsonParseException e) {
			log.error(e);
		} catch (JsonMappingException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return map;
	}
	
	
	@RequestMapping("/getAllRoleByStaffCode") 
	public List<SecurityDao> getAllRoleByStaffCode(@RequestParam(value = "name") String name) {
		 return securityServiceImpl.getAllRoleByStaffCode(name.toUpperCase());
	}
	
	@Override
	@RequestMapping("/authorityService") 
	public Map authorityService(@RequestParam(value = "paramInfo") String paramInfo) {
		Map  map  =  new HashMap();
		Map  paramMap=null;
		try {
			paramMap = mapper.readValue(paramInfo,Map.class);
			String key = paramMap.get("sessionId")==null?"":paramMap.get("sessionId").toString();
			String role = paramMap.get("role")==null?"":paramMap.get("role").toString();
			String serviceName = paramMap.get("serviceName")==null?"":paramMap.get("serviceName").toString();
		    if(role != null){
				List<String> list2  = (List<String>) cacheServiceImpl.getMemeryCacheByKey(role);
				long count=list2.stream().filter(p->p.equals(serviceName)).count();//��ȡURL����
				if(count >0){
					//���Է���
					map.put("status", "2");
					map.put("info", "ͨ����֤��");
				}else{
					map.put("status","1");
					map.put("info", "�ý�ɫû�з��ʷ���Ȩ�ޣ�");
				}
		    }else{
		    	 map.put("status","1");
		    	 map.put("info", "���û�Ŀǰû��ɫ��Ϣ��");
		    }
		} catch (JsonParseException e) {
			log.error(e);
		} catch (JsonMappingException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return map;
	}


	/**
	 * @param string
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * ���ݿͻ��˴���� sesssionId,�ж���ǰ״̬�Ƿ���Ч
	 * @throws ParseException 
	 */
	private boolean validateStaffStatus(String sessionId) throws JsonParseException, JsonMappingException, IOException, ParseException {
		Object  obj  = cacheServiceImpl.getMemeryCacheByKey("VU:"+sessionId);
		if(obj != null ){
			return true;
		}else{
		    return  false;
		}
	}

	@Override
	@RequestMapping("/reFreshToken") 
	public Map reFreshToken(@RequestParam(value = "sessionId") String sessionId) {
	    Map map = new HashMap<>();
		if(sessionId == null){
			map.put("status", "0");
			map.put("info", "ˢ��ʧ�ܣ�");
		}else{
			Map objMap;
			try {
				if(cacheServiceImpl.getMemeryCacheByKey("VU:"+sessionId) == null){//token���������ˢ��
					map.put("status", "1");
					map.put("info", "��¼�ѹ��ڣ�");
				}else{
					cacheServiceImpl.freshExpoireKey("VU:"+sessionId,10*60);
					map.put("status", "2");
					map.put("info", "ˢ�³ɹ���");
				}
			} catch (Exception e) {
				log.error(e);
			}
		}
		return map;
	}
	
	/** 
	* @Title: loginOut 
	* @Description:�û��ǳ�����
	* @param @param token
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	@Override
	@RequestMapping("/loginOut") 
	public Map loginOut(@RequestParam(value = "sessionId") String sessionId) {
		Map map = new HashMap<>();
		if(sessionId == null){
			map.put("status", "1");
			map.put("info", "�Ѿ�ע�������账��");
		}else{
			cacheServiceImpl.deleteMemeryCache("VU:"+sessionId);
			map.put("status", "2");
			map.put("info", "ע���ɹ���");
		}
		return map;
	}

	/** 
	* @Title: onlineUsers 
	* @Description: ͳ�������û���
	* @param @param paramInfo
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	@Override
	@RequestMapping("/onlineUsers") 
	public Map onlineUsers() {
		Map map = new HashMap<>();
		int count  = cacheServiceImpl.getAllMemeryCacheKeys("VU:");
		map.put("status", "2");
		map.put("usersCount",count);
		map.put("info", "sucess��");
		return map;
	}
	
	@Override
	@RequestMapping("/validateFrom3") 
	public Map validateFrom3(@RequestParam(value = "paramInfo") String paramInfo) {
		Map  map  =  new HashMap();
		Map  paramMap=null;
		try {
			paramMap = mapper.readValue(paramInfo, Map.class);
			String token = paramMap.get("token").toString();
			String loginName = paramMap.get("loginName").toString();
			SecurityDao usermap  = securityServiceImpl.queryAppUserById(paramMap.get("loginName").toString().toUpperCase());
			String str = (String) cacheServiceImpl.getMemeryCacheByKey("VU:"+token);
			JSONObject obj = JSONObject.parseObject(str);
			
			if(usermap!=null && obj!=null){
				String objName = obj.get("loginName").toString();
				//�жϴ�redisȡ�����û���������ƽ̨��������ֵ�Ƿ�һ��
				if(objName.equalsIgnoreCase(loginName)){
					
					Map object   = new  HashMap();
					object.put("date",format.format(new Date()));//����ʱ��
					object.put("loginName",loginName);//�û���¼��
					object.put("userName",usermap.getQueryValue4());//�û���
					object.put("groupId",usermap.getQueryValue2());//�û�����
					object.put("userId",usermap.getQueryValue1());//�û�ID
					map.put("status","2");
					map.put("info",token);
					map.put("data",object);
				}
			}else{
				map.put("status","0");
				map.put("info","�����µ�¼");
			}
		} catch (JsonParseException e) {
			log.error(e);
		} catch (JsonMappingException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return map;
	}
}
