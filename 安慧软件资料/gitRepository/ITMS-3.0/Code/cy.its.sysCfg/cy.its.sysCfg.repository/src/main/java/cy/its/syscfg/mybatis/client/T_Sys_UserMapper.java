package cy.its.syscfg.mybatis.client;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import cy.its.syscfg.domain.model.duty.UserCount;
import cy.its.syscfg.mybatis.model.LoginTime;
import cy.its.syscfg.mybatis.model.T_Sys_User;
import cy.its.syscfg.mybatis.model.UserResource;

public interface T_Sys_UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(T_Sys_User record);

    int insertSelective(T_Sys_User record);

    T_Sys_User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(T_Sys_User record);

    int updateByPrimaryKey(T_Sys_User record);

	/**
	  * updateLoginPasswordToDefault �޸�����sql
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
	void updateLoginPassword(@Param("userId") String userId, @Param("password") String password);
	
	/**
	 * 
	  * selectUserResource �����û�ID�����û����õ�ϵͳ��Դ���˵������ܵ㣩
	  * @Title: selectUserResource
	  * @Description: TODO
	  * @param @param userId
	  * @param @return    �趨�ļ�
	  * @return List<UserResource>    ��������
	  * @throws
	 */
	List<UserResource> selectUserResource(@Param("userId") String userId);

	/**
	 * ͳ�������û����һ�ܵ�¼����
	 * @param userNameList
	 * @return
	 */
	List<LoginTime> countUserLoginTimeInWeek(@Param("userNameList") List<String> userNameList);

	int countLoginTimesInCurMonth(@Param("userId") String userId);

	int countLoginTotal(@Param("userId") String userId);

	List<UserCount> countMenuCurrentMonthTop10();

	List<UserCount> countOrgLoginCurrentMonthTop10();

	List<UserCount> countIpLoginCurrentMonthTop10();

	List<UserCount> countLoginTimeByDay();

}