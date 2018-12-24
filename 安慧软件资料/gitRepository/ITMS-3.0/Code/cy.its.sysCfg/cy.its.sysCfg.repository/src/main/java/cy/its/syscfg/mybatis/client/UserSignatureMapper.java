package cy.its.syscfg.mybatis.client;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cy.its.syscfg.domain.model.duty.UserSignature;

public interface UserSignatureMapper {
	
	/**
	 * �����û�ID�����û�ǩ��
	 * @param userId
	 * @return
	 */
	List<UserSignature> findSignatureByUserId(@Param("userId") String userId);

	/**
	 * �����û�ǩ����Ϣ��¼
	 * @param sign
	 * @return
	 */
	void saveUserSignature(UserSignature sign);
	
	/**
	 * ɾ���û��µ�����ǩ��
	 */
	void removeUserSignature(@Param("userId") String userId);

}
