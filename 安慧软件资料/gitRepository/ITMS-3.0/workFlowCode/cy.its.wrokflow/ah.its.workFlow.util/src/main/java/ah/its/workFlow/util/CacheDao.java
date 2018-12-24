package ah.its.workFlow.util;

import java.io.Serializable;

public class CacheDao implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7109336144482926074L;
	

	private String value;

    private String name;
    
    private String parentCode;
    
    private String spare;

	public String getSpare() {
		return spare;
	}

	public void setSpare(String spare) {
		this.spare = spare;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		this.value = args[0];
		this.name = args[1];
		if(args.length==3){
			this.parentCode = args[2];
		}
		if(args.length==4){
			this.parentCode = args[2];
			this.spare = args[3];
		}
	}
	
}
