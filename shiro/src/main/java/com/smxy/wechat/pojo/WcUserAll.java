package com.smxy.wechat.pojo;

/**
 * 
 * @Description :用于多表查询
 * @author Bush罗
 * @date 2018年7月12日
 *
 */
public class WcUserAll {
    private String userId;

    private String userPassword;

    private String userActive;
    
    private WcUserRoles wcUserRoles;

	public WcUserAll(String userId, String userPassword, String userActive) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userActive = userActive;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserActive() {
		return userActive;
	}

	public void setUserActive(String userActive) {
		this.userActive = userActive;
	}

	public WcUserRoles getWcUserRoles() {
		return wcUserRoles;
	}

	public void setWcUserRoles(WcUserRoles wcUserRoles) {
		this.wcUserRoles = wcUserRoles;
	}

	public WcUserAll() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	@Override
	public String toString() {
		return "WcUserAll [userId=" + userId + ", userPassword=" + userPassword
				+ ", userActive=" + userActive + ", wcUserRoles=" + wcUserRoles
				+ "]";
	}
    
    
}
