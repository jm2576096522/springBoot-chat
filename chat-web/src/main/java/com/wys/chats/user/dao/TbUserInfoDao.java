package com.wys.chats.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.wys.chats.core.BaseDao;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbUserInfo;

/**
 * 用户信息表
 *
 * Created by wangyanshu on '2018-05-16 22:50:01'.
 */
@Component
public interface TbUserInfoDao extends BaseDao{

	/**
	 * 新增
	 */
	public int insert(Request request);

	/**
	 * 删除
	 */
	public int delete(@Param("id") int id);

	/**
	 * 更新
	 */
	public int update( TbUserInfo tbUserInfo);

	/**
	 * Load查询
	 */
	public TbUserInfo load(Request request);

	public TbUserInfo login(TbUserInfo tbUserInfo);


}

