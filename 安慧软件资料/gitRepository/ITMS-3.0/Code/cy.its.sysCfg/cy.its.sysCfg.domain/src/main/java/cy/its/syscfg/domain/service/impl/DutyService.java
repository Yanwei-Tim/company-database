package cy.its.syscfg.domain.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.com.util.StringUtil;
import cy.its.syscfg.domain.criteria.OrgCriteria;
import cy.its.syscfg.domain.criteria.UserCriteria;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.model.duty.User;
import cy.its.syscfg.domain.model.duty.UserCount;
import cy.its.syscfg.domain.model.duty.UserResourceTree;
import cy.its.syscfg.domain.model.duty.UserSignature;
import cy.its.syscfg.domain.repository.duty.IOrgRepository;
import cy.its.syscfg.domain.repository.duty.IUserRepository;
import cy.its.syscfg.domain.repository.home.IDailyMenuRepository;
import cy.its.syscfg.domain.service.IDutyService;

/**
 * �������
 *
 */
@Service
public class DutyService implements IDutyService {

	@Autowired
	IOrgRepository orgRepository;

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IDailyMenuRepository dailyMenuRepository;

	/**
	 * �����»���
	 * 
	 * @param organization
	 *            �»�����ϸ
	 */
	public void createOrganization(Organization organization) {
		orgRepository.save(organization);
	}

	/**
	 * ��ѯָ���Ļ�����ϸ��Ϣ
	 * 
	 * @param orgId
	 * ����Ψһ��ʶID
	 * @return ������ϸ��Ϣ
	 * @throws Exception
	 */
	public Organization organizationOfId(String orgId) throws Exception {
		return orgRepository.aggregateOfId(orgId);
	}

	/**
	 * ��ȡָ���������µ��ӻ����б�
	 * 
	 * @param orgPrivilegeCode
	 *            ����Ȩ�޴���
	 * @return �ӻ����б�(��������)
	 * @throws Exception
	 */
	public List<Organization> findSonOrgsOfParent(String orgId) throws Exception {
		OrgCriteria criteria = new OrgCriteria();
		criteria.setNoPage();
		criteria.orgId = orgId;
		return orgRepository.findOrganizations(criteria);
	}

	/**
	 * ��ȡָ���������µ��ӻ����б� ע: �������ӻ����µ��ӻ���
	 * 
	 * @param orgId
	 *            ����������
	 * @return �ӻ����б�(����������)
	 * @throws Exception
	 */
	public List<Organization> findOrgsOfParent(String orgId) throws Exception {
		List<Organization> lst = findSonOrgsOfParent(orgId);
		Organization org = this.organizationOfId(orgId);
		return lst != null ? lst.stream().filter((c) -> 
			!c.orgPrivilegeCode.equals(org.orgPrivilegeCode) 
			&& c.orgPrivilegeCode.startsWith(org.orgPrivilegeCode)
			&& c.orgPrivilegeCode.length() == org.orgPrivilegeCode.length() + 2
			).collect(Collectors.toList())
				: null;
	}

	/**
	 * ��ѯ���������Ļ�����Ϣ�б�
	 * 
	 * @param orgCriteria
	 *            ��ѯ����
	 * @return ������Ϣ�б�
	 */
	public List<Organization> findOrganizations(OrgCriteria orgCriteria) {
		return orgRepository.findOrganizations(orgCriteria);
	}
	
	public List<Organization> findOrgOfParent(String parentOrgPrivilegeCode)
	{
		return orgRepository.findOrgOfParent(parentOrgPrivilegeCode);
	}

	/**
	 * ���»�����Ϣ
	 * 
	 * @param organization
	 *            ������Ϣ
	 * @throws Exception
	 */
	public void updateOrganiztion(Organization organization) throws Exception {
		if (StringUtil.isNullOrEmpty(organization.getIdentityId())) {
			throw new Exception("δָ��Ҫ�µĻ���Ψһ��ʶ");
		}
		orgRepository.update(organization);
	}

	/**
	 * ɾ��ָ���Ļ���
	 * 
	 * @param orgId
	 *            ����Ψһ��ʶID
	 * @throws Exception
	 */
	public void deleteOrganization(String orgId) throws Exception {
		Organization org = orgRepository.aggregateOfId(orgId);
		List<Organization> lstSonOrg = findSonOrgsOfParent(org.orgCode);
		if (lstSonOrg != null && lstSonOrg.size() != 0) {
			for (Organization sonOrg : lstSonOrg) {
				deleteOrgAndUsers(sonOrg);
			}
		}
		deleteOrgAndUsers(org);
	}

	/**
	 * �������û�
	 * 
	 * @param user
	 *            ���û���Ϣ
	 */
	public void createUser(User user) {
		userRepository.save(user);
	}

	/**
	 * ɾ��ָ�����û�
	 * 
	 * @param userId
	 *            �û�Ψһ��ʶID
	 */
	public void deleteUser(String userId) {
		userRepository.removeUserRoles(userId);
		userRepository.delete(userId);
		dailyMenuRepository.deleteByUserPermmission();
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 *            �û���Ϣ
	 */
	public void updateUser(User user) {
		userRepository.update(user);
	}

	/**
	 * ��ѯָ�����û�
	 * 
	 * @param userId
	 *            �û�Ψһ��ʶID
	 * @return �û���Ϣ
	 * @throws Exception
	 */
	public User userOfId(String userId) throws Exception {
		return userRepository.aggregateOfId(userId);
	}

	/**
	 * ��ѯָ�������µ������û�
	 * 
	 * @param orgCode
	 *            ��������
	 * @return �û���Ϣ�б�
	 * @throws Exception
	 */
	public List<User> findUsers(UserCriteria userCriteria) throws Exception {
		return userRepository.findUsers(userCriteria);
	}

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
	public void addRolesToUser(String userId, String... roleIds) throws Exception {
		User user = userRepository.aggregateOfId(userId);
		if (user == null) {
			throw new Exception("�û�������");
		}
		user.assignRoles(roleIds);
		// userRepository.removeUserRoles(userId);
		userRepository.addUserRoles(userId, roleIds);
	}

	/**
	 * ɾ��ָ���û���ָ�������ɫ
	 * 
	 * @param userId
	 *            �û�Ψһ��ʶID
	 * @param roleIds
	 *            �����ɫΨһ��ʶID
	 */
	public void removeUserRoles(String userId, String... roleIds) {
		userRepository.removeUserRoles(userId, roleIds);
		dailyMenuRepository.deleteByUserPermmission();
	}

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
	public User authorize(String loginName, String passWord) throws Exception {
		UserCriteria criteria = new UserCriteria();
		criteria.loginName = loginName;
		List<User> users = userRepository.findUsers(criteria);
		if (users != null && users.size() == 1) {
			if (users.get(0).authorize(loginName, passWord)) {
				userRepository.update(users.get(0));
				return users.get(0);
			}
			throw new Exception("��¼ʧ��:�������!");
		}
		throw new Exception("��¼ʧ��:�û�������!");
	}

	/**
	 * ɾ��ָ�����������µ������û�
	 * 
	 * @param org
	 * @throws Exception
	 */
	private void deleteOrgAndUsers(Organization org) throws Exception {
		UserCriteria criteria = new UserCriteria();
		criteria.orgId = org.getIdentityId();

		List<User> users = findUsers(criteria);
		for (User user : users) {
			deleteUser(user.getUserId());
		}
		orgRepository.delete(org.getIdentityId());
		dailyMenuRepository.deleteByUserPermmission();
	}

	/**
	 * �������֪ͨ
	 */
	public void organizationChanged() {
		orgRepository.organizationChanged();
	}

	/**
	 * ��������
	 */
	@Override
	public void updateLoginPassword(String userId,String password) {
		userRepository.updateLoginPassword(userId,password);
	}
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
	@Override
	public List<UserResourceTree> findUserResourceByUserId(String userId){
		return userRepository.findUserResourceByUserId(userId);
	}

	@Override
	public List<UserSignature> findUserSigntureByUserId(String userId) {
		return userRepository.findUserSignatureByUserId(userId);
	}

	@Override
	public void createUserSignature(UserSignature sign) {
		//�����µ�ǩ�¼�¼
		userRepository.saveUserSignature(sign);
	}
	
	@Override
	public void removeUserSignatureByUserId(String userId){
		//ɾ��ԭ�е�ǩ���ļ�
		
		//ɾ��ԭ�е�ǩ�¼�¼
		userRepository.removeUserSignature(userId);
	}

	@Override
	public Map<String, Object[]> getUserLoingTimeInWeek(List<String> userNameList) {
		return userRepository.getUserLoingTimeInWeek(userNameList);
	}

	@Override
	public int loginCountCurMonthOfUser(String userId) {
		return userRepository.loginCountCurMonthOfUser(userId);
	}

	@Override
	public int loginTotalOfUser(String userId) {
		return userRepository.loginTotalOfUser(userId);
	}

	@Override
	public List<Organization> organizationsOfCode(String orgCode) {
		return orgRepository.organizationsOfCode(orgCode);
	}

	@Override
	public List<UserCount> countMenuCurrentMonthTop10() {
		return userRepository.countMenuCurrentMonthTop10();
	}

	@Override
	public List<UserCount> countOrgLoginCurrentMonthTop10() {
		return userRepository.countOrgLoginCurrentMonthTop10();
	}

	@Override
	public List<UserCount> countIpLoginCurrentMonthTop10() {
		return userRepository.countIpLoginCurrentMonthTop10();
	}

	@Override
	public List<UserCount> countLoginTimeByDay() {
		return userRepository.countLoginTimeByDay();
	}
}
