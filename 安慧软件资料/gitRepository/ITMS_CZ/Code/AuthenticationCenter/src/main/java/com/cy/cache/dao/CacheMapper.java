package com.cy.cache.dao;

import java.util.List;

import com.cy.cache.domain.CacheDao;

	
public interface CacheMapper {
     /**
      * ���ݽ�ɫ�����ȡ�����н�ɫ������Ȩ�޷���
      * @return List<SecurityDao>
      * 
      */
	  List<CacheDao> getServicesByRoleCode();
	  
	  
	  
     /**
      * ���ݽ�ɫ�����ȡ�����н�ɫ������Ȩ�޷���
      * @return List<SecurityDao>
      * 
      */
	  List<CacheDao> getServicesBykey(String serviceKey);
	  
 }