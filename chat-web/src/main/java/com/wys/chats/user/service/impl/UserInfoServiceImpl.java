package com.wys.chats.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wys.chats.entity.UserInfoModel;
import com.wys.chats.user.mapper.UserInfoMapper;
import com.wys.chats.user.service.UserInfoService;
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired  
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfoModel login(UserInfoModel userInfoModel) {
		return userInfoMapper.login(userInfoModel);
	}
}
