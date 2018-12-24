package cy.its.sysCfg.rest.action.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import cy.its.com.constant.ConstValue;
import cy.its.platform.common.exception.ItmsAppException;
import cy.its.platform.common.utils.MD5Util;
import cy.its.sysCfg.rest.dto.DataGridResult;
import cy.its.sysCfg.rest.dto.Results;
import cy.its.sysCfg.rest.dto.UserDto;
import cy.its.syscfg.domain.criteria.UserCriteria;
import cy.its.syscfg.domain.model.duty.User;
import cy.its.syscfg.domain.model.duty.UserCount;
import cy.its.syscfg.domain.model.duty.UserResourceTree;
import cy.its.syscfg.domain.model.duty.UserSignature;
import cy.its.syscfg.domain.service.IDutyService;

@RestController
@RequestMapping("/sysCfg/userAction")
@Api(description="�û�����", value = "UserAction")
public class UserAction {

	@Autowired
	IDutyService dutyService;

	/**
	 * �����û���Ϣ����
	 */
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	@ApiOperation(value="save",notes="�����û���Ϣ����",httpMethod="POST")
	public Object save(@ModelAttribute(value = "userInfo") UserDto userDto) throws Exception {
		//��֤�û����Ƿ����
		UserCriteria criteria = new UserCriteria();
		criteria.loginName = userDto.getLoginName().toUpperCase();
		List<User> result = dutyService.findUsers(criteria);
		
		if(!result.isEmpty()){
			throw new ItmsAppException("�û����Ѿ����ڣ�");
		}
		
		//��֤��Ա����Ƿ����
		criteria = new UserCriteria();
		criteria.policeCode = userDto.getPoliceCode();
		result = dutyService.findUsers(criteria);
		if(!result.isEmpty()){
			throw new ItmsAppException("��Ա����Ѿ����ڣ�");
		}
		
		User user = userDto.convertToUser();
		user.name = userDto.getPoliceName();
		user.setLoginPassword(MD5Util.md5(ConstValue.DEFAULT_LOGIN_PASSWORD));
		dutyService.createUser(user);
		if(userDto.getRoleIds() != null && !"".equals(userDto.getRoleIds())){
			dutyService.addRolesToUser(user.getIdentityId(), userDto.getRoleIds().split(","));
		}
		return "success";
	}

	/**
	 * 
	  * updateUser �����û�
	  * @Title: updateUser
	  * @Description: TODO
	  * @param @param userDto
	  * @param @return
	  * @param @throws Exception    �趨�ļ�
	  * @return String    ��������
	  * @throws
	 */
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	@ApiOperation(value="updateUser",notes="�����û�",httpMethod="POST")
	public String updateUser(UserDto userDto) throws Exception {
		User user = dutyService.userOfId(userDto.getUserId());
		//��֤�û����Ƿ����
		if(!user.getLoginName().equals(userDto.getLoginName())){
			UserCriteria criteria = new UserCriteria();
			criteria.loginName = userDto.getLoginName().toUpperCase();
			List<User> result = dutyService.findUsers(criteria);
			if(!result.isEmpty()){
				throw new ItmsAppException("�û����Ѿ����ڣ�");
			}
		}
		if(!user.getPolice().getPoliceCode().equals(userDto.getPoliceCode())){
			//��֤��Ա����Ƿ����
			UserCriteria criteria = new UserCriteria();
			criteria.policeCode = userDto.getPoliceCode();
			List<User> result = dutyService.findUsers(criteria);
			if(!result.isEmpty()){
				throw new ItmsAppException("��Ա����Ѿ����ڣ�");
			}
		}
		user = userDto.convertToUser();
		//����user
		dutyService.updateUser(user);
		user = dutyService.userOfId(user.getUserId());
		//ɾ��ȫ���Ľ�ɫ
		if(user.roleIds != null && user.roleIds.size() > 0){
			dutyService.removeUserRoles(user.getUserId(), user.roleIds());
		}	
		//����µĽ�ɫ
		if(userDto.getRoleIds() != null && !"".equals(userDto.getRoleIds())){
		dutyService.addRolesToUser(user.getUserId(), userDto.getRoleIds().split(","));
		}
		return "success";
	}

	/**
	 * ɾ���û�
	 */
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	@ApiOperation(value="delete",notes="ɾ���û�",httpMethod="POST")
	public String delete(String ids) {
		String[] removeIds = ids.split(",");
		for(String id : removeIds){
			dutyService.deleteUser(id);
		}
		return "success";
	}

	@RequestMapping(value="/selectUser",method=RequestMethod.POST)
	@ApiOperation(value="findUser",notes="�����û�",httpMethod="POST")
	public DataGridResult<UserDto> findUser(@ModelAttribute(value = "userDto") UserDto userDto) throws Exception {

		// �����ѯ����
		UserCriteria userCriteria = new UserCriteria();
		// ���ò�ѯҳ��
		userCriteria.setPageNum(userDto.getPageNumber());
		// ����ÿҳ������¼��
		userCriteria.setPageSize(userDto.getPageSize());
		// �����Ƿ���Ҫͳ������: ��
		userCriteria.setNeedTotal(true); 
		// ��ȡ������UI�˵���������
		userCriteria.orgId = userDto.getOrgId();
		userCriteria.isOnline = userDto.getIsOnline();
		userCriteria.policeCode = userDto.getPoliceCode();
		userCriteria.name = userDto.getPoliceName();
		userCriteria.setOrderName(userDto.getOrderName());
		userCriteria.setOrderType(userDto.getOrderType());
		// ��ѯ�û���Ϣ�б�
		List<User> list = dutyService.findUsers(userCriteria);
		//��ѯ�û�������һ�ܵ�¼����
		List<String> userNameList = new ArrayList<String>();
		for(User u : list){
			userNameList.add(u.getLoginName());
		}
		
		// �Ѳ�ѯ���ת���ɲ�ѯ�б���
		List<UserDto> lstView = new ArrayList<UserDto>();
		for(User item : list){
			UserDto dto = new UserDto(item);
			lstView.add(dto);
		}
		// ����һ��������
		DataGridResult<UserDto> result = new DataGridResult<UserDto>();
		// ��������Ϊ��
		result.setError("");
		// ���ý������
		result.setResult(new Results<UserDto>(userCriteria.getTotal(), lstView));

		return result;
	}
	
	/**
	 * @throws NoSuchAlgorithmException 
	 * 
	  * updateLoginPasswordToDefault  �����û�����
	  * @Title: updateLoginPasswordToDefault
	  * @Description: TODO
	  * @param @param userId
	  * @param @return    �趨�ļ�
	  * @return String    ��������
	  * @throws
	 */
	@RequestMapping(value="/updateLoginPasswordToDefault",method=RequestMethod.POST)
	@ApiOperation(value="updateLoginPasswordToDefault",notes="�����û�����",httpMethod="POST")
	public String updateLoginPasswordToDefault(String userId) throws NoSuchAlgorithmException{
		dutyService.updateLoginPassword(userId,MD5Util.md5(ConstValue.DEFAULT_LOGIN_PASSWORD));
		return "success";
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
	@RequestMapping(value="/findUserResource",method=RequestMethod.POST)
	@ApiOperation(value="findUserResourceById",notes="�����û�Id�����û���Դ���˵������ܵ㣩",httpMethod="POST")
	public List<UserResourceTree> findUserResourceById(String userId){
		return dutyService.findUserResourceByUserId(userId);
	}
	
	/**
	 * �����û�Id�����û���Ϣ
	 * @param currentUserId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/findUserById",method=RequestMethod.POST)
	@ApiOperation(value="findUserById",notes="�����û�Id�����û�������Ϣ",httpMethod="POST")
	public User findUserById(@ApiParam(name="currentUserId",required=true)String currentUserId) throws Exception{
		User user = dutyService.userOfId(currentUserId);
		return user;
	}
	
	@RequestMapping(value="/updatePassword",method=RequestMethod.POST)
	@ApiOperation(value="updatePassword",notes="�޸��û�����",httpMethod="POST")
	public String updatePassword(@ApiParam(name="password",required=true)String password,@ApiParam(name="currentUserId",required=true)String currentUserId) throws NoSuchAlgorithmException{
		dutyService.updateLoginPassword(currentUserId,MD5Util.md5(password));
		return "success";
	}
	
	@RequestMapping(value="/findUserSign",method=RequestMethod.POST)
	@ApiOperation(value="findUserSign",notes="��õ�ǰ�û����û�ǩ����Ϣ",httpMethod="POST")
	public List<UserSignature> findUserSign(@ApiParam(name="currentUserId",required=true)String currentUserId){
		return dutyService.findUserSigntureByUserId(currentUserId);
	}
	
	@RequestMapping(value="/saveUserSign",method=RequestMethod.POST)
	@ApiOperation(value="saveUserSign",notes="�����û�ǩ����Ϣ",httpMethod="POST")
	public String saveUserSign(@ApiParam(name="currentUserId",required=true)String currentUserId,
			@ApiParam(name="imageUrl",required=true)String imageUrl){
		//ɾ��ԭ�е�ǩ����Ϣ
		dutyService.removeUserSignatureByUserId(currentUserId);
		//����µ�ǩ����Ϣ
		UserSignature sign = new UserSignature();
		sign.setUserId(currentUserId);
		sign.setSignatureIndex(1);
		sign.setSignatureImage(imageUrl);
		dutyService.createUserSignature(sign);
		return "success";
	}
	
	@RequestMapping(value="/removeUserSign",method=RequestMethod.POST)
	@ApiOperation(value="removeUserSign",notes="ɾ���û�ǩ����Ϣ",httpMethod="POST")
	public String removeUserSign(@ApiParam(name="currentUserId",required=true)String currentUserId){
		//ɾ��ԭ�е�ǩ����Ϣ
		dutyService.removeUserSignatureByUserId(currentUserId);
		return "success";
	}
	
	@RequestMapping(value="/countMenuCurrentMonthTop10")
	public List<UserCount> countMenuCurrentMonthTop10(){
		return dutyService.countMenuCurrentMonthTop10();
	}
	
	@RequestMapping(value="/countOrgLoginCurrentMonthTop10")
	public List<UserCount> countOrgLoginCurrentMonthTop10(){
		return dutyService.countOrgLoginCurrentMonthTop10();
	}
	
	@RequestMapping(value="/countIpLoginCurrentMonthTop10")
	public Map<String,Object> countIpLoginCurrentMonthTop10(){
		List<UserCount> countList = dutyService.countIpLoginCurrentMonthTop10();
		Map<String,Object> result = new HashMap<String,Object>();
		Map<String,Object> dataResult = new HashMap<String,Object>();
		result.put("error", "");
		result.put("result", dataResult);
		dataResult.put("total", 0);
		dataResult.put("rows", countList);
		return result;
	}
	
	@RequestMapping(value="/countLoginTimeByDay")
	public List<UserCount> countLoginTimeByDay(){
		return dutyService.countLoginTimeByDay();
	}
	
}