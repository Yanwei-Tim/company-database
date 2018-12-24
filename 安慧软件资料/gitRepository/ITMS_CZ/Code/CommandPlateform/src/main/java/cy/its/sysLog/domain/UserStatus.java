package cy.its.sysLog.domain;

import java.util.Date;

/**
* @Title: UserStatus.java 
* @Package cy.its.sysLog.domain 
* @Description: �û�״̬��¼ 
* @author lil@cychina.cn
* @date 2016��3��11�� ����3:46:38 
* @version V1.0   
 */
public class UserStatus {
    private String userId;

    private Long loginCount;

    private Date currentTime;

    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}