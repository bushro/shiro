package com.smxy.wechat.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smxy.wechat.dao.WcUserMapper;
import com.smxy.wechat.pojo.WcUser;
import com.smxy.wechat.pojo.WcUserAll;
import com.smxy.wechat.service.WcUserService;

@Service
public class WcUserServiceImpl implements WcUserService{
	@Autowired
	WcUserMapper wcUserMapper;
	@Override
	public WcUser selectByPrimaryKey(String userId) {
		// TODO Auto-generated method stub
		return wcUserMapper.selectByPrimaryKey(userId);
	}
	@Override
	public WcUserAll selectRoleByPrimaryKey(String userId) {
		// TODO Auto-generated method stub
		return wcUserMapper.selectRoleByPrimaryKey(userId);
	}

}
