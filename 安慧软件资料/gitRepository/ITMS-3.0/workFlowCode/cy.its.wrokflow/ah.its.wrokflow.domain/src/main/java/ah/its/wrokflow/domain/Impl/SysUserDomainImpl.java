package ah.its.wrokflow.domain.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ah.its.wrokflow.domain.SysUserDomainI;
import ah.its.wrokflow.domain.util.ReturnResultUtil;
import ah.its.wrokflow.repository.SysUserRepositoryI;
import ah.its.wrokflow.repository.dao.SysUser;

/**
* @Title: SysUserDomainImpl.java 
* @Package ah.its.wrokflow.domain.Impl 
* @Description: �û���������������
* @author lil@cychina.cn
* @date 2016��4��5�� ����6:43:17 
* @version V1.0   
 */
@Service
public class SysUserDomainImpl implements SysUserDomainI {

	
	@Autowired
	private SysUserRepositoryI sysUserRepositoryImpl;//�û������ӿ�
	
	@Override
	public Map queryUserShipById(String userId,String  pwd) {
		
		Map  map = new HashMap();
		
		SysUser   suser  = sysUserRepositoryImpl.queryUserShipById(userId);
		if(suser == null){
			map.put("status", "0");
			map.put("info", "��Ч�û���");
		}else{
			if(pwd.equals(suser.getPwd())){
				map.put("status", "1");
				map.put("info", "��¼�ɹ���");
				map.put("user",suser);
			}else{
				map.put("status", "0");
				map.put("info", "�������");
			}
		}
		return map;
	}

	@Override
	public Map queryUsers(SysUser user) {
		// TODO Auto-generated method stub
		Map  map = new HashMap();
		List<SysUser> list = this.sysUserRepositoryImpl.queryUsers(user);
		if (list !=null && list.size()>0){
			map.put("users", list);
		}
		return map;
	}

	@Override
	public List queryUsersByGroupId(String groupId) {
		if(groupId==null||groupId.equals("")){
			return null;
		}
		List<SysUser> list = sysUserRepositoryImpl.queryUsersByGroupId(groupId);
		return list;
	}

	@Override
	public List queryUsersWithGroupinfo(SysUser user) {
		List<SysUser> list = sysUserRepositoryImpl.queryUsersWithGroupinfo(user);
		return list;
	}

}
