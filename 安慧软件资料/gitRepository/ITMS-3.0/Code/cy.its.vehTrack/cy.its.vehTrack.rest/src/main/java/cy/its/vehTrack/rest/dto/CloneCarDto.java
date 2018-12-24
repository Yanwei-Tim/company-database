
/**
 * date:2016/03/11
 * author:wangyunqi
 * name:���Ƴ�������ѯ����(���ô�����)
 */
package cy.its.vehTrack.rest.dto;

import java.lang.reflect.Field;

import com.wordnik.swagger.annotations.ApiParam;

import cy.its.com.dto.BaseDto;

public class CloneCarDto extends BaseDto {

	@ApiParam(name = "���ƺ���", value = "plate_nbr")
	private String plate_nbr;
	@ApiParam(name = "���ƿ�ʼʱ��")
	private String startTime;
	@ApiParam(name = "���ƽ���ʱ��")
	private String endTime;
	@ApiParam(name = "ȷ�ϱ�ʶ")
	private String clone_flag;
	 private String totalCount;
	// ��ǰ�û�Id
		private String currentUserId;
		//��ǰ�û���
		private String currentUserName;
		//��ǰ�û���¼��
		private String currentUserLoginName;
		// ��ǰ�û���������
		private String currentOrgId;
		//��ǰ�û�������������
		private String currentOrgCode;
		// ����Ȩ�޴���
		private String currentOrgPrivilegeCode;
		
		
		// ��ǰҳ��
		private int pageNumber;
		// ��ҳ��С
		private int pageSize;

	public String getPlate_nbr() {
		return plate_nbr;
	}

	public void setPlate_nbr(String plate_nbr) {
		this.plate_nbr = plate_nbr;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getClone_flag() {
		return clone_flag;
	}

	public void setClone_flag(String clone_flag) {
		this.clone_flag = clone_flag;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

	public String getCurrentUserLoginName() {
		return currentUserLoginName;
	}

	public void setCurrentUserLoginName(String currentUserLoginName) {
		this.currentUserLoginName = currentUserLoginName;
	}

	public String getCurrentOrgId() {
		return currentOrgId;
	}

	public void setCurrentOrgId(String currentOrgId) {
		this.currentOrgId = currentOrgId;
	}

	public String getCurrentOrgCode() {
		return currentOrgCode;
	}

	public void setCurrentOrgCode(String currentOrgCode) {
		this.currentOrgCode = currentOrgCode;
	}

	public String getCurrentOrgPrivilegeCode() {
		return currentOrgPrivilegeCode;
	}

	public void setCurrentOrgPrivilegeCode(String currentOrgPrivilegeCode) {
		this.currentOrgPrivilegeCode = currentOrgPrivilegeCode;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString(){
		StringBuilder params = new StringBuilder();
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields){
			try {
				params.append("&").append(field.getName()).append("=");
				Object value = field.get(this);
				if(value != null){
					params.append(value);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return params.substring(1);
	}
}
