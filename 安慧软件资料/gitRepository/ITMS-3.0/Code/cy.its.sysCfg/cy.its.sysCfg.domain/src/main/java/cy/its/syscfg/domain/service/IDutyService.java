package cy.its.syscfg.domain.service;

import java.util.List;
import java.util.Map;

import cy.its.syscfg.domain.criteria.OrgCriteria;
import cy.its.syscfg.domain.criteria.UserCriteria;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.model.duty.User;
import cy.its.syscfg.domain.model.duty.UserCount;
import cy.its.syscfg.domain.model.duty.UserResourceTree;
import cy.its.syscfg.domain.model.duty.UserSignature;

/**
 * @author STJ
 *
 */
/**
 * @author STJ
 *
 */
public interface IDutyService {

	/**
	 * �����»���
	 * 
	 * @param organization
	 *            �»�����ϸ
	 */
	public void createOrganization(Organization organization);

	/**
	 * ��ѯָ���Ļ�����ϸ��Ϣ
	 * 
	 * @param orgId
	 *            ����Ψһ��ʶID
	 * @return ������ϸ��Ϣ
	 * @throws Exception
	 */
	public Organization organizationOfId(String orgId) throws Exception;

	/**
	 * ��ȡָ���������µ��ӻ����б�
	 * ע: �����ӻ���
	 * @param orgId
	 *            ������ID
	 * @return �ӻ����б�(��������)
	 * @throws Exception 
	 */
	public List<Organization> findSonOrgsOfParent(String orgId) throws Exception;
	
	/**
	 * ��ȡָ���������µ��ӻ����б�
	 * ע: �������ӻ����µ��ӻ���
	 * @param orgId
	 *            ����������
	 * @return �ӻ����б�(����������)
	 * @throws Exception 
	 */
	public List<Organization> findOrgsOfParent(String orgId) throws Exception;
	

	/**
	 * ��ѯ���������Ļ�����Ϣ�б�
	 * ע: ����ҳ
	 * @param orgCriteria
	 *            ��ѯ����
	 * @return ������Ϣ�б�
	 */
	public List<Organization> findOrganizations(OrgCriteria orgCriteria);

	List<Organization> findOrgOfParent(String parentOrgPrivilegeCode);
	
	List<Organization> organizationsOfCode(String orgCode);
	
	/**
	 * ���»�����Ϣ
	 * 
	 * @param organization
	 *            ������Ϣ
	 * @throws Exception
	 */
	public void updateOrganiztion(Organization organization) throws Exception;

	/**
	 * ɾ��ָ���Ļ���
	 * 
	 * @param orgId
	 *            ����Ψһ��ʶID
	 * @throws Exception
	 */
	public void deleteOrganization(String orgId) throws Exception;

	/**
	 * �������û�
	 * 
	 * @param user
	 *            ���û���Ϣ
	 */
	public void createUser(User user);

	/**
	 * ɾ��ָ�����û�
	 * 
	 * @param userId
	 *            �û�Ψһ��ʶID
	 */
	public void deleteUser(String userId);

	/**
	 * �����û�
	 * 
	 * @param user
	 *            �û���Ϣ
	 */
	public void updateUser(User user);

	/**
	 * ��ѯָ�����û�
	 * 
	 * @param userId
	 *            �û�Ψһ��ʶID
	 * @return �û���Ϣ
	 * @throws Exception
	 */
	public User userOfId(String userId) throws Exception;

	/**
	 * ��ѯ�����������û���Ϣ�б�
	 * 
	 * @param userCriteria
	 *            ��ѯ����
	 * @return �û���Ϣ�б�
	 * @throws Exception
	 */
	public List<User> findUsers(UserCriteria userCriteria) throws Exception;

	/**
	 * Ϊָ���û���������ɫ
	 * 
	 * @param userId
	 *            �û�Ψһ��ʶID
	 * @param roleIds
	 *            �����ɫΨһ��ʶID
	 * @throws Exception
	 *             ָ���û�������
	 */
	public void addRolesToUser(String userId, String... roleIds)
			throws Exception;

	/**
	 * ɾ��ָ���û���ָ�������ɫ
	 * 
	 * @param userId
	 *            �û�Ψһ��ʶID
	 * @param roleIds
	 *            �����ɫΨһ��ʶID
	 */
	public void removeUserRoles(String userId, String... roleIds);

	/**
	 * �û���֤
	 * 
	 * @param loginName
	 *            ��¼��
	 * @param passWord
	 *            ��¼����
	 * @return ��֤ͨ����Ӧ���û���Ϣ
	 * @throws Exception
	 *             ��¼ʧ��: �������; ��¼ʧ��:�û�������!
	 */
	public User authorize(String loginName, String passWord) throws Exception;
	
	/**
	 * �������֪ͨ
	 */
	public void organizationChanged();

	/**
	  * updateLoginPasswordToDefault(������һ�仰�����������������)
	  * TODO(����������������������� �C ��ѡ)
	  * TODO(�����������������ִ������ �C ��ѡ)
	  * TODO(�����������������ʹ�÷��� �C ��ѡ)
	  * TODO(�����������������ע������ �C ��ѡ)
	  *
	  * @Title: updateLoginPasswordToDefault
	  * @Description: TODO
	  * @param     �趨�ļ�
	  * @return void    ��������
	  * @throws
	  */
	
	
	/**
	  * updateLoginPasswordToDefault ��������
	  * @Title: updateLoginPasswordToDefault
	  * @Description: TODO
	  * @param     �趨�ļ�
	  * @return void    ��������
	  * @throws
	 */
	public void updateLoginPassword(String userId, String password);
	
	/**
	  * 
	  * findUserResourceByUserId �����û�Id�����û���Դ���˵������ܵ㣩
	  * @Title: findUserResourceByUserId
	  * @Description: TODO
	  * @param @param userId
	  * @param @return    �趨�ļ�
	  * @return List<UserResourceTree>    ��������
	  * @throws
	 */
	public List<UserResourceTree> findUserResourceByUserId(String userId);
	
	/**
	 *  �����û�ID�ҵ��û�ǩ����Ϣ
	 * @param userId
	 * @return
	 */
	public List<UserSignature> findUserSigntureByUserId(String userId);

	/**
	 * �����û�ǩ����Ϣ
	 * @param sign
	 * @return
	 */
	public void createUserSignature(UserSignature sign);

	/**
	 * ɾ���û�ǩ����Ϣ
	 * @param userId
	 */
	public void removeUserSignatureByUserId(String userId);
	
	/**
	 * �����û����һ�ܵ�¼����
	 * @param userNameList
	 * @return
	 */
	public Map<String, Object[]> getUserLoingTimeInWeek(List<String> userNameList);
	
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
	 * ͳ�Ʊ��³��ù���ǰʮλ
	 * @return
	 */
	List<UserCount> countMenuCurrentMonthTop10();
	
	/**
	 * ͳ�Ʊ��µ�¼��������ǰʮλ
	 * @return
	 */
	List<UserCount> countOrgLoginCurrentMonthTop10();
	
	/**
	 * ͳ�Ʊ��µ�¼IP����ǰʮλ
	 * @return
	 */
	List<UserCount> countIpLoginCurrentMonthTop10();
	
	/**
	 * ����ͳ�Ʊ��µ�¼����
	 * @return
	 */
	List<UserCount> countLoginTimeByDay();
	
}