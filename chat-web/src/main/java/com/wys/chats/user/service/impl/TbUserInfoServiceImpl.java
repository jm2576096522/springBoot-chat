package com.wys.chats.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.PageDaoHelper;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbUserInfo;
import com.wys.chats.flock.dao.TbFlockMessageDao;
import com.wys.chats.flock.dao.TbFlockRelevanceDao;
import com.wys.chats.user.dao.TbUserInfoDao;
import com.wys.chats.user.dao.TbUserMessageDao;
import com.wys.chats.user.dao.TbUserRelevanceDao;
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
	
	@Resource
	private TbUserRelevanceDao tbUserRelevanceDao;

	@Resource
	private TbUserMessageDao tbUserMessageDao;

	@Resource
	private TbFlockMessageDao tbFlockMessageDao;

	@Resource
	private TbFlockRelevanceDao tFlockRelevanceDao;



	@Override
	public Map<String, Object> index(Request request, HttpServletRequest handlerServlet) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		HttpSession session = handlerServlet.getSession();
		if (session != null && session.getAttribute("id") != null && !session.getAttribute("id").equals("")) {
			paramInfo.put("userId", session.getAttribute("id"));
			param.put("userRelevance", PageDaoHelper.search(tbUserRelevanceDao, paramInfo, request.getCurrPage(), request.getPageSize()));
			param.put("userMassgeCount", tbUserMessageDao.countUserMessageByUserId(session.getAttribute("id")));
			param.put("userMassgeCount", tbFlockMessageDao.countFlockMessageByFlockId(session.getAttribute("id"),tFlockRelevanceDao.getFlockRelevanceByUserId(session.getAttribute("id"))));
		}else{//测试
			paramInfo.put("userId", "1");
			param.put("userRelevance", PageDaoHelper.search(tbUserRelevanceDao, paramInfo, request.getCurrPage(), request.getPageSize()));
			param.put("userMassgeCount", tbUserMessageDao.countUserMessageByUserId("1"));
			param.put("flockMassgeCount", tbFlockMessageDao.countFlockMessageByFlockId("1",tFlockRelevanceDao.getFlockRelevanceByUserId("1")));
		}
		return param;
	}
	@Override
	public TbUserInfo login(TbUserInfo info, HttpServletRequest handlerServlet) {
		TbUserInfo tbUserInfo = tbUserInfoDao.login(info);
		if (tbUserInfo != null && tbUserInfo.getName() != null) {
			HttpSession session = handlerServlet.getSession();
			session.setAttribute("id", tbUserInfo.getId());
			session.setAttribute("name", tbUserInfo.getName());
			session.setAttribute("email", tbUserInfo.getEmail());
			return tbUserInfo;
		}
		return null;
	}


	/**
	 * 新增
	 */
	@Override
	public int insert(Request request) {
		try {
			if (request.getName() == null) {
				return 0;
			}
			return tbUserInfoDao.insert(request);
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

