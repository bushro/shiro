package com.smxy.wechat.dao;

import com.smxy.wechat.pojo.WcUserRoles;

public interface WcUserRolesMapper {
    int deleteByPrimaryKey(String userId);

    int insert(WcUserRoles record);

    int insertSelective(WcUserRoles record);

    WcUserRoles selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(WcUserRoles record);

    int updateByPrimaryKey(WcUserRoles record);
}