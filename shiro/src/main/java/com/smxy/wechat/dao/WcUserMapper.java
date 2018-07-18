package com.smxy.wechat.dao;

import java.util.List;

import com.smxy.wechat.pojo.WcUser;
import com.smxy.wechat.pojo.WcUserAll;

public interface WcUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(WcUser record);

    int insertSelective(WcUser record);

    WcUser selectByPrimaryKey(String userId);
    
    WcUserAll selectRoleByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(WcUser record);

    int updateByPrimaryKey(WcUser record);
    
    List<WcUser> findAllWcUser();
}