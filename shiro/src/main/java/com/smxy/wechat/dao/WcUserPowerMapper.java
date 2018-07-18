package com.smxy.wechat.dao;

import com.smxy.wechat.pojo.WcUserPower;

public interface WcUserPowerMapper {
    int deleteByPrimaryKey(String userRole);

    int insert(WcUserPower record);

    int insertSelective(WcUserPower record);

    WcUserPower selectByPrimaryKey(String userRole);

    int updateByPrimaryKeySelective(WcUserPower record);

    int updateByPrimaryKey(WcUserPower record);
}