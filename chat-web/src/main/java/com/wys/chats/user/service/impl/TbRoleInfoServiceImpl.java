package com.wys.chats.user.service.impl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.PageDaoHelper;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbRoleInfo;
import com.wys.chats.user.dao.TbRoleInfoDao;
import com.wys.chats.user.service.TbRoleInfoService;
import com.wys.chats.util.JsonUtil;
import com.wys.chats.util.SysLog;

/**
* 
*
* Created by wangyanshu on '2018-05-18 00:43:59'.
*/
@Service
public class TbRoleInfoServiceImpl implements TbRoleInfoService {

	@Resource
	private TbRoleInfoDao tbRoleInfoDao;

	/**
    * 新增
    */
	@Override
	public int insert(TbRoleInfo tbRoleInfo) {
		try {
			if (tbRoleInfo == null) {
				return 0;
	        }
	        return tbRoleInfoDao.insert(tbRoleInfo);
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
			return tbRoleInfoDao.delete(id);
		} catch (Exception e) {
			SysLog.error("删除service:---"+e);
			return 0;
		}
	}

	/**
	* 更新
	*/
	@Override
	public int update(TbRoleInfo tbRoleInfo) {
		try {
			return tbRoleInfoDao.update(tbRoleInfo);
		} catch (Exception e) {
			SysLog.error("更新service:---"+e);
			return 0;
		}
	}

	/**
	* Load查询
	*/
	@Override
	public TbRoleInfo load(TbRoleInfo tbRoleInfo) {
		try {
			return tbRoleInfoDao.load(tbRoleInfo);
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
			}
			return PageDaoHelper.search(tbRoleInfoDao, paramMap, request.getCurrPage(), request.getPageSize());
		} catch (Exception e) {
			SysLog.error("分页查询service:---"+e);
			return null;
		}
	}

}
