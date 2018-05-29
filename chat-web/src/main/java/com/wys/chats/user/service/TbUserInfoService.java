package com.wys.chats.user.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wys.chats.core.BaseDao;
import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbUserInfo;

/**
 * 用户信息表
 *
 * Created by wangyanshu on '2018-05-16 22:50:01'.
 */
public interface TbUserInfoService{


	/**
	 * 新增
	 */
	public int insert(Request request);

	/**
	 * 删除
	 */
	public int delete(int id);

	/**
	 * 更新
	 */
	public int update(TbUserInfo tbUserInfo);

	/**
	 * Load查询
	 */
	public TbUserInfo load(Request request);

	/**
	 * 分页查询
	 */
	public PageBean pageList(Request request);


	public Map<String, Object> index(Request request, HttpServletRequest handlerServlet);

	public TbUserInfo login(TbUserInfo tbUserInfo, HttpServletRequest handlerServlet);

}
