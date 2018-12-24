package com.cy.web.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import cy.its.common.duplex.service.WebscoketServiceI;

/**
* @Title: WebscoketServiceFactory.java 
* @Package com.cy.web.service.impl 
* @Description: ���񴴽��� 
* @author lil@cychina.cn
* @date 2015��10��19�� ����2:20:42 
* @version V1.0   
 */
public class WebscoketServiceFactory{
	
    private static HashMap<String, WebscoketServiceI>  mapService = new HashMap<>();//������ɵķ�����
    
    private volatile static WebscoketServiceFactory webscoketServiceFactory;  
    
    /**
     * ˽�еĹ�����
     */
    private WebscoketServiceFactory (){
    	
    }  
    
	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException  
	* @Title: getServiceBean 
	* @Description: MAP�д��ڷ������򷵻أ����
	* @param @param serviceKey
	* @param @param className
	* @param @return    �趨�ļ� 
	* @return WebscoketServiceI    �������� 
	* @throws 
	*/
	public WebscoketServiceI getServiceBean(String serviceKey,String  className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		if(mapService.get(serviceKey)== null){
    		Constructor c0=Class.forName(className).getDeclaredConstructor();   
            c0.setAccessible(true);   
            WebscoketServiceI wbsimpl=(WebscoketServiceI)c0.newInstance();
    		mapService.put(serviceKey, wbsimpl);
    		return wbsimpl;
		}else{
			return mapService.get(serviceKey);
		}
	}
    
    public static WebscoketServiceFactory getSingleWebscoketServiceFactory() {  
	    if (webscoketServiceFactory == null) {  
	        synchronized (WebscoketServiceFactory.class) {  
		        if (webscoketServiceFactory == null) {  
		        	webscoketServiceFactory = new WebscoketServiceFactory();  
		        }  
	        }  
	    }  
	    return webscoketServiceFactory;  
	}  

}
