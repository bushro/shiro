package com.smxy.wechat.service;

import com.smxy.wechat.pojo.WcUser;
import com.smxy.wechat.pojo.WcUserAll;

public interface WcUserService {
    WcUser selectByPrimaryKey(String userId);
    WcUserAll selectRoleByPrimaryKey(String userId);
}
