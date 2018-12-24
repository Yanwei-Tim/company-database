package com.unitTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cy.its.device.service.PointLocationDomainI;

public class DeviceDomainTest {
	
	private PointLocationDomainI pointLocationDomainImpl;
	    
	/**
	* ���before���������еĲ��Է���֮ǰִ�У�����ִֻ��һ��
	* ������Junit��Ԫ����ʱһЩ��ʼ��������������������������
	* ������before���������ʼ��ApplicationContext��userService
	*/
	@Before
	public void before(){
		//ʹ��"spring.xml"��"spring-mybatis.xml"�����������ļ�����Spring������
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		//��Spring�����и���bean��idȡ������Ҫʹ�õ�userService����
		pointLocationDomainImpl = (PointLocationDomainI) ac.getBean("pointLocationDomainImpl");
	}
	
	@Test
	public void testAddUser(){
		pointLocationDomainImpl.deletePointLocation("1212");
	}
}
