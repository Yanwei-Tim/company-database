package com.cy.cache.domain;

import java.io.Serializable;


/**
 * @author lilei
 * �û���ȫ����DAO
 * �����װ����
 */
public class CacheDao implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7109336144482926074L;
	

	private String code;

    private String name;
    
    private String parentCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	/** 
	* @Title: setProperty 
	* @Description: �����õ��ķ��� 
	* @param @param args    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public void setProperty(String...args){
		this.code = args[0];
		this.name = args[1];
		if(args.length==3){
			this.parentCode = args[2];
		}
	}
	
}
