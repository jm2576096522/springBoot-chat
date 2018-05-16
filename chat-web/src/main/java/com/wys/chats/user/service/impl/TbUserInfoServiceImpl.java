package com.wys.chats.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.PageDaoHelper;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbUserInfo;
import com.wys.chats.user.mapper.TbUserInfoDao;
import com.wys.chats.user.service.TbUserInfoService;

/**
 * 用户信息表
 *
 * Created by wangyanshu on '2018-05-16 22:50:01'.
 */
@Service
public class TbUserInfoServiceImpl implements TbUserInfoService {

	@Resource
	private TbUserInfoDao tbUserInfoDao;

	/**
	 * 新增
	 */
	@Override
	public int insert(TbUserInfo tbUserInfo) {
		if (tbUserInfo == null) {
			return 0;
		}
		return tbUserInfoDao.insert(tbUserInfo);
	}

	/**
	 * 删除
	 */
	@Override
	public int delete(int id) {
		int ret = tbUserInfoDao.delete(id);
		return ret;
	}

	/**
	 * 更新
	 */
	@Override
	public int update(TbUserInfo tbUserInfo) {
		int ret = tbUserInfoDao.update(tbUserInfo);
		return ret;
	}

	/**
	 * Load查询
	 */
	@Override
	public TbUserInfo load(Request request) {
		return tbUserInfoDao.load(request);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageBean pageList(Request request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		PageBean pb = PageDaoHelper.search(tbUserInfoDao, paramMap, request.getCurrPage(), request.getPageSize());
		System.out.println(pb.getResult().get(0));
		return pb;

	}
	
}

