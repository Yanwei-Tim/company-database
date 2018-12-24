package cy.its.sysLog.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cy.its.platform.common.utils.SqlHelper;
import cy.its.sysLog.client.UserStatusMapper;
import cy.its.sysLog.domain.UserStatus;
import cy.its.sysLog.service.UserStatusLogI;

/**
* @Title: UserStatusLogImpl.java 
* @Package cy.its.sysLog.service.impl 
* @Description:�����õ��µ�¼����
* @author lil@cychina.cn
* @date 2016��3��11�� ����4:45:15 
* @version V1.0   
 */
@Service
public class UserStatusLogImpl implements UserStatusLogI{
	
	@Autowired
	private UserStatusMapper userStatusMapper;//ע�����ݿ������
	

	@Override
	public int updateUserStatus(UserStatus record) {
		//���Ȼ�ȡ�û���¼�����������¼����Ϊ0��ֱ������
		String  info= userStatusMapper.selectById(record.getUserId());
		if(StringUtils.isEmpty(info)){
			//�����ڼ�¼����һ����¼
			record.setLoginCount((long) 1);
			record.setRemark("����¼��");
			record.setCurrentTime(new Date());
			return userStatusMapper.insert(record);
		}else{
			int count = Integer.valueOf(info.split(":")[0]).intValue();//����
		    String ldate = info.split(":")[1];//ʱ��
		    Date lastDate;
			try {
				lastDate = new SimpleDateFormat("yyyy-MM-dd").parse(ldate);
				if(lastDate.getMonth() == new Date().getMonth()){//�����ۼ�
					record.setLoginCount((long) (count+1));
					record.setCurrentTime(new Date());
					return userStatusMapper.updateByUserId(record);
			    }else{
					//���µ�һ�ε�¼
					record.setLoginCount((long) (1));
					record.setCurrentTime(new Date());
					return userStatusMapper.updateByUserId(record);
			    }
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("��¼��¼����������ת���������⣡");
				e.printStackTrace();
			}
		}
		return 0;
	}
	
}
