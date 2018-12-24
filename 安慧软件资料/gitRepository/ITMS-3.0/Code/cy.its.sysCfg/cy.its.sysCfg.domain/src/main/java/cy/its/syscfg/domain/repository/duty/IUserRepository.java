package cy.its.syscfg.domain.repository.duty;

import java.util.List;
import java.util.Map;

import cy.its.com.domain.IRepository;
import cy.its.syscfg.domain.criteria.UserCriteria;
import cy.its.syscfg.domain.model.duty.User;
import cy.its.syscfg.domain.model.duty.UserCount;
import cy.its.syscfg.domain.model.duty.UserResourceTree;
import cy.its.syscfg.domain.model.duty.UserSignature;

public interface IUserRepository extends IRepository<User> {
	void removeUserRoles(String userId);
	void removeUserRolesByRoleId(String rodleId);
	void addUserRoles(String userId, String...roleIds);
	void removeUserRoles(String userId, String...roleIds);
	List<User> findUsers(UserCriteria criteria) throws Exception;
	int countUsers(UserCriteria criteria);
	/**
	  * updateLoginPasswordToDefault ��������
	  * TODO(����������������������� �C ��ѡ)
	  * TODO(�����������������ִ������ �C ��ѡ)
	  * TODO(�����������������ʹ�÷��� �C ��ѡ)
	  * TODO(�����������������ע������ �C ��ѡ)
	  *
	  * @Title: updateLoginPasswordToDefault
	  * @Description: TODO
	  * @param @param userId
	  * @param @param password    �趨�ļ�
	  * @return void    ��������
	  * @throws
	 */
	void updateLoginPassword(String userId, String password);
	
	/**
	  * findUserResourceByUserId �����û�Id�������û���ӵ�е���Դ���˵������ܵ㣩
	  *
	  * @Title: findUserResourceByUserId
	  * @Description: TODO
	  * @param @param userId
	  * @param @return    �趨�ļ�
	  * @return List<UserResourceTree>    ��������
	  * @throws
	 */
	List<UserResourceTree> findUserResourceByUserId(String userId);
	
	/**
	 * �����û�ID�����û�ǩ��
	 * @param userId
	 * @return
	 */
	List<UserSignature> findUserSignatureByUserId(String userId);
	
	/**
	 * �����û�ǩ����Ϣ
	 * @param sign
	 * @return
	 */
	void saveUserSignature(UserSignature sign);
	
	/**
	 * ɾ���û�ǩ��
	 * @param userId
	 */
	void removeUserSignature(String userId);
	
	/**
	 * �����û����һ�ܵ�¼����
	 * @param userNameList
	 * @return
	 */
	Map<String, Object[]> getUserLoingTimeInWeek(List<String> userNameList);
	
	/**
	 * ��ѯ�û���ǰ�·���ʵʱ������ǰʱ��Ϊֹ�ܹ��ĵ�½����
	 * @param userId
	 * @return
	 */
	int loginCountCurMonthOfUser(String userId);
	
	/**
	 * ��ѯָ���û���ע�������ܵĵ�½����
	 * @param userId
	 * @return
	 */
	int loginTotalOfUser(String userId);
	/**
	 * ����ͳ�Ʊ��µ�¼����
	 * @return
	 */
	List<UserCount> countLoginTimeByDay();
	
	/**
	 * ͳ�Ʊ��µ�¼IPǰʮ��
	 * @return
	 */
	List<UserCount> countIpLoginCurrentMonthTop10();
	
	/**
	 * ͳ�Ƶ��»�����¼����ǰʮ��
	 * @return
	 */
	List<UserCount> countOrgLoginCurrentMonthTop10();
	
	/**
	 * ͳ�Ƶ��²˵�ʹ�ô���ǰʮ��
	 * @return
	 */
	List<UserCount> countMenuCurrentMonthTop10();
}
