package com.wys.chats.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.PageDaoHelper;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbUserInfo;
import com.wys.chats.flock.dao.TbFlockMessageDao;
import com.wys.chats.flock.dao.TbFlockRelevanceDao;
import com.wys.chats.user.dao.TbUserInfoDao;
import com.wys.chats.user.dao.TbUserMessageDao;
import com.wys.chats.user.service.TbUserInfoService;
import com.wys.chats.util.JsonUtil;
import com.wys.chats.util.SysLog;

/**
 * 用户信息表
 * 未做参数的校验
 * Created by wangyanshu on '2018-05-16 22:50:01'.
 */
@Service
public class TbUserInfoServiceImpl implements TbUserInfoService {

	@Resource
	private TbUserInfoDao tbUserInfoDao;
	
	@Autowired
	private TbUserMessageDao tbUserMessageDao;
	
	@Autowired
	private TbFlockMessageDao tbFlockMessageDao;
	
	@Autowired
	private TbFlockRelevanceDao tbFlockRelevanceDaoDao;

	
	@Override
	public Map<String, Object> login(TbUserInfo tbUserInfo) {
		Map<String, Object> reslutMap = new HashMap<String, Object>();
		Map<String, Object> reslutCount = new HashMap<String, Object>();
		try {
			TbUserInfo userInfo = tbUserInfoDao.login(tbUserInfo);
			int userId = userInfo.getId();
			if (userInfo.getName() != null && !userInfo.getName().trim().equals("")) {
				reslutCount.put("userMessage", tbUserMessageDao.countUserMessageByUserId(userInfo));
				String flockId = String.valueOf(tbFlockRelevanceDaoDao.getFlockRelevanceByUserId(userId));
				reslutCount.put("flockMessage",tbFlockMessageDao.countFlockMessageByFlockId(userId, flockId));
			}
			reslutMap.put("count", reslutCount);
			return reslutMap;
		} catch (Exception e) {
			SysLog.error("Load查询service:---"+e);
			return null;
		}
	}
	
	
	/**
	 * 新增
	 */
	@Override
	public int insert(TbUserInfo tbUserInfo) {
		try {
			if (tbUserInfo == null) {
				return 0;
			}
			return tbUserInfoDao.insert(tbUserInfo);
		} catch (Exception e) {
			SysLog.error("新增service:---"+e);
			return 0;
		}
	}

	/**
	 * 删除
	 */
	@Override
	public int delete(int id) {
		try {
			return tbUserInfoDao.delete(id);
		} catch (Exception e) {
			SysLog.error("删除service:---"+e);
			return 0;
		}
	}

	/**
	 * 更新
	 */
	@Override
	public int update(TbUserInfo tbUserInfo) {
		try {
			return tbUserInfoDao.update(tbUserInfo);
		} catch (Exception e) {
			SysLog.error("更新service:---"+e);
			return 0;
		}
	}

	/**
	 * Load查询
	 */
	@Override
	public TbUserInfo load(Request request) {
		try {
			return tbUserInfoDao.load(request);
		} catch (Exception e) {
			SysLog.error("Load查询service:---"+e);
			return null;
		}
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageBean pageList(Request request) {
		Map<String, Object> paramMap = null;
		try {
			if(request.getData() != null && !request.getData().trim().equals("")){
				paramMap = JsonUtil.getMapFromJsonObjStr(request.getData());
			}else{
				paramMap = new HashMap<String, Object> ();
			}
			paramMap.put("id", request.getId());
			return PageDaoHelper.search(tbUserInfoDao, paramMap, request.getCurrPage(), request.getPageSize());
		} catch (Exception e) {
			SysLog.error("分页查询service:---"+e);
			return null;
		}

	}

}

