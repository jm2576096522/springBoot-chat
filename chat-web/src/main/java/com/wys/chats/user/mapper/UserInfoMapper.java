package com.wys.chats.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wys.chats.entity.UserInfoModel;

@Mapper
public interface UserInfoMapper{
	
	UserInfoModel login(UserInfoModel userInfoModel);
	
}

