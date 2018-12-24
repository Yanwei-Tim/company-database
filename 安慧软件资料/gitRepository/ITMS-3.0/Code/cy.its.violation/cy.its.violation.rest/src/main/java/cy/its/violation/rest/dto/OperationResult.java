package cy.its.violation.rest.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @title:OperationResult.java
 * @Package:cy.its.violation.rest.dto
 * @Description:TODO
 * @author:jinhb@cychina.cn
 * @date: 2015��9��24�� ����5:13:05
 * @version v1.0
 */
public class OperationResult {

	/**
	 * �������
	 */
	public int ResultCode = 0;

	/**
	 * ������Ϣ
	 */
	public String error;

	/**
	 * ��������
	 */
	public List<ViolationDto> Data = new ArrayList<ViolationDto>();

	public void Error(String msg) {
		error = msg;
		ResultCode = -1;
	}

	public void Success(List<ViolationDto> data) {
		Data = data;
	}
}
