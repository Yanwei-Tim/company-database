package cy.its.syscfg.domain.model.permission;

import cy.its.com.domain.Entity;

public class MenuFunction extends Entity<String> {

	/**
	 * ϵͳ���ܱ���
	 */
	private String functionCode;

	/**
	 * �˵�����
	 */
	public String menuCode;

	/**
	 * ϵͳ��������
	 */
	private String functionName;

	/**
	 * 0��δ���ã�1������
	 */
	private String functionFlag;

	/**
	 * ������ٸ���Ȩ�ޡ����磺ɾ������������ѯ������ɾ�����ܣ���ѯ�����Զ�ѡ�С�
	 */
	public String functionDependency;

	@Override
	public String getIdentityId() {
		return functionCode;
	}

	public MenuFunction(String functionCode, String functionName,
			String functionFlag) throws Exception {		
		this.setFunctionCode(functionCode);
		this.setFunctionName(functionName);
		this.setFunctionFlag(functionFlag);		
	}
	
	
	public MenuFunction(String functionCode, String functionName,
			String functionFlag, String menuCode) throws Exception {		
		this(functionCode, functionName, functionFlag);
		this.menuCode = menuCode;		
	}

	public void setFunctionCode(String functionCode) throws Exception {
		NotNull(functionCode, "ϵͳ���ܱ���");
		this.functionCode = functionCode;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionName(String functionName) throws Exception {
		NotNull(functionName, "ϵͳ��������");
		this.functionName = functionName;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionFlag(String functionFlag) throws Exception {
		NotNull(functionFlag, "���ñ��");
		this.functionFlag = functionFlag;
	}

	public String getFunctionFlag() {
		return functionFlag;
	}
}
