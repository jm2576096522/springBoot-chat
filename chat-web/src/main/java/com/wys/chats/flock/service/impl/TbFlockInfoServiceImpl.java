package com.wys.chats.flock.service.impl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.PageDaoHelper;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbFlockInfo;
import com.wys.chats.flock.dao.TbFlockInfoDao;
import com.wys.chats.flock.service.TbFlockInfoService;
import com.wys.chats.util.JsonUtil;
import com.wys.chats.util.SysLog;

/**
* 
*
* Created by wangyanshu on '2018-05-18 00:00:46'.
*/
@Service
public class TbFlockInfoServiceImpl implements TbFlockInfoService {

	@Resource
	private TbFlockInfoDao tbFlockInfoDao;

	/**
    * 新增
    */
	@Override
	public int insert(TbFlockInfo tbFlockInfo) {
		try {
			if (tbFlockInfo == null) {
				return 0;
	        }
	        return tbFlockInfoDao.insert(tbFlockInfo);
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
			return tbFlockInfoDao.delete(id);
		} catch (Exception e) {
			SysLog.error("删除service:---"+e);
			return 0;
		}
	}

	/**
	* 更新
	*/
	@Override
	public int update(TbFlockInfo tbFlockInfo) {
		try {
			return tbFlockInfoDao.update(tbFlockInfo);
		} catch (Exception e) {
			SysLog.error("更新service:---"+e);
			return 0;
		}
	}

	/**
	* Load查询
	*/
	@Override
	public TbFlockInfo load(TbFlockInfo tbFlockInfo) {
		try {
			return tbFlockInfoDao.load(tbFlockInfo);
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
			return PageDaoHelper.search(tbFlockInfoDao, paramMap, request.getCurrPage(), request.getPageSize());
		} catch (Exception e) {
			SysLog.error("分页查询service:---"+e);
			return null;
		}
	}

}
