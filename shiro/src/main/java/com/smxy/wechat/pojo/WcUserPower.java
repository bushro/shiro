package com.smxy.wechat.pojo;

import java.io.Serializable;

/**
 * 
 * @Description :权限表
 * @author Bush罗
 * @date 2018年7月12日
 *
 */
public class WcUserPower implements Serializable {
    private String userRole;

    private String userPower;

    private static final long serialVersionUID = 1L;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getUserPower() {
        return userPower;
    }

    public void setUserPower(String userPower) {
        this.userPower = userPower == null ? null : userPower.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WcUserPower other = (WcUserPower) that;
        return (this.getUserRole() == null ? other.getUserRole() == null : this.getUserRole().equals(other.getUserRole()))
            && (this.getUserPower() == null ? other.getUserPower() == null : this.getUserPower().equals(other.getUserPower()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserRole() == null) ? 0 : getUserRole().hashCode());
        result = prime * result + ((getUserPower() == null) ? 0 : getUserPower().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userRole=").append(userRole);
        sb.append(", userPower=").append(userPower);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}