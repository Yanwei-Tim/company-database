package cy.its.sysLog.domain;

import java.util.Date;

/**
* @Title: UserLogin.java 
* @Package cy.its.sysLog.domain 
* @Description: �û���¼��־ 
* @author lil@cychina.cn
* @date 2016��3��11�� ����3:46:23 
* @version V1.0   
 */
public class UserLogin {
    private String userId;

    private String userIp;

    private Date loginTime;

    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}