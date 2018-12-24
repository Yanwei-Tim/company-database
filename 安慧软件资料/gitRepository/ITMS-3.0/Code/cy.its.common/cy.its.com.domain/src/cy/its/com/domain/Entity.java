package cy.its.com.domain;

import cy.its.com.util.StringUtil;

public abstract class Entity<T> {
	
	public abstract T getIdentityId();

	protected void NotNull(String fieldValue, String fieldName)
			throws Exception {
		if (StringUtil.isNullOrEmpty(fieldValue)) {
			throw new Exception(fieldName + "����Ϊ��");
		}
	}

	protected void NotNull(Value fieldValue, String fieldName) throws Exception {
		if (fieldValue == null) {
			throw new Exception(fieldName + "����Ϊ��");
		}
		fieldValue.NotNull(fieldName);
	}
	
	
	protected void NotLessThanZero(Integer fieldValue, String fieldName) throws Exception {
		if (fieldValue == null) {
			throw new Exception(fieldName + "����Ϊ��");
		}
		
		if (fieldValue <= 0) {
			throw new Exception(fieldName + "����С��0");
		}
	}
	
	protected void NotLessThanZero(Double fieldValue, String fieldName) throws Exception {
		if (fieldValue == null) {
			throw new Exception(fieldName + "����Ϊ��");
		}
		
		if (fieldValue <= 0) {
			throw new Exception(fieldName + "����С��0");
		}
	}
	
	protected void NotLessThanZero(float fieldValue, String fieldName) throws Exception {
		if (Float.isNaN(fieldValue)) {
			throw new Exception(fieldName + "����Ϊ��");
		}
		
		if (fieldValue <= 0) {
			throw new Exception(fieldName + "����С��0");
		}
	}
	

	protected boolean stringIsEmpty(String str) {
		return StringUtil.isNullOrEmpty(str);
	}
	
	private EntityState entityState = EntityState.NONE;

	public EntityState getEntityState() {
		return entityState;
	}

	public void setEntityState(EntityState entityState) {
		this.entityState = entityState;
	}	
}

