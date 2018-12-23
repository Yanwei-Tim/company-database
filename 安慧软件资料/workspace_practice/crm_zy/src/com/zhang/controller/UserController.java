package com.zhang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhang.entity.PageBean;
import com.zhang.entity.User;
import com.zhang.service.UserService;
import com.zhang.util.ResponseUtil;
import com.zhang.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * �û�Controller��
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * �û���¼
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) throws Exception {
		User resultUser = userService.login(user);
		if (resultUser == null) {
			request.setAttribute("user", user); // ����ҳ��չʾ����ĵ�¼��Ϣ��������Ϣ
			request.setAttribute("errorMsg", "�û������������");// ��ʾ������Ϣ
			return "login";// ��¼ʧ�ܣ����ص�¼ҳ��
		} else {
			// ��¼�ɹ������¼��Ϣ��session����
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", resultUser);
			return "redirect:/main.jsp";// �ض�����ҳ
		}
	}

	/**
	 * ��ҳ��������ѯ�û��б�
	 * @param page easyui��ҳ����Ĳ���(��ǰҳ)
	 * @param rows easyui��ҳ����Ĳ���(�У�����)
	 * @param s_user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, User s_user, HttpServletResponse response)
			throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", StringUtil.formatLike(s_user.getUserName())); //Ϊ��mybatis��ģ����ѯ���ֶ�ǰ�����%...%
//		map.put("userName", s_user.getUserName());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<User> userList = userService.find(map);
		Long total = userService.getTotal(map);
		JSONObject result = new JSONObject(); //����json����
		JSONArray jsonArray = JSONArray.fromObject(userList);//��listת��json����
		result.put("rows", jsonArray);//���� ������easyui��ǰ̨����row���ա�
		result.put("total", total);//�ܼ�¼��
		ResponseUtil.write(response, result);//д��ǰ̨����
		return "page/userManage";
	}
	
	/**
	 * ��ӻ��޸��û�ʱ�ı���
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(User user,HttpServletResponse response) throws Exception{
		int resultTotal=0; // �����ļ�¼����
		if(user.getId()==null){ //�����ȡ����id����˵�������
			resultTotal = userService.add(user); //����
		} else{
			resultTotal = userService.update(user);//����
		}
		JSONObject result = new JSONObject(); //����json����
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ɾ���û�
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		String[] idsStr=ids.split(","); //������һ��ɾ���������ݣ����id����
		for(int i=0;i<idsStr.length;i++){
			userService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ��ȡ�ͻ�������Ϣ �����������õ�
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/customerManagerComboList")
	public String customerManagerComboList(HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("roleName", "�ͻ�����");
		List<User> userList=userService.find(map);
		JSONArray row=JSONArray.fromObject(userList);
		ResponseUtil.write(response, row);
		return null;
	}
	
	/**
	 * �޸�����
	 * @param id
	 * @param newPassword
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(Integer id,String newPassword,HttpServletResponse response)throws Exception{
		User user = new User();
		user.setId(id);
		user.setPassword(newPassword);
		int resultTotal=userService.update(user);
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * �û�ע��
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate(); //���session������
		return "redirect:/login.jsp";//�ض��򵽵�¼ҳ��
	}
}
