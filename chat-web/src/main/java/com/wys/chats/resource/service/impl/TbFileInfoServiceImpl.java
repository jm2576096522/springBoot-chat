package com.wys.chats.resource.service.impl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.PageDaoHelper;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbFileInfo;
import com.wys.chats.resource.dao.TbFileInfoDao;
import com.wys.chats.resource.service.TbFileInfoService;
import com.wys.chats.util.JsonUtil;
import com.wys.chats.util.SysLog;

/**
* 
*
* Created by wangyanshu on '2018-05-18 00:23:05'.
*/
@Service
public class TbFileInfoServiceImpl implements TbFileInfoService {

	@Resource
	private TbFileInfoDao tbFileInfoDao;

	/**
    * 新增
    */
	@Override
	public int insert(TbFileInfo tbFileInfo) {
		try {
			if (tbFileInfo == null) {
				return 0;
	        }
	        return tbFileInfoDao.insert(tbFileInfo);
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
			return tbFileInfoDao.delete(id);
		} catch (Exception e) {
			SysLog.error("删除service:---"+e);
			return 0;
		}
	}

	/**
	* 更新
	*/
	@Override
	public int update(TbFileInfo tbFileInfo) {
		try {
			return tbFileInfoDao.update(tbFileInfo);
		} catch (Exception e) {
			SysLog.error("更新service:---"+e);
			return 0;
		}
	}

	/**
	* Load查询
	*/
	@Override
	public TbFileInfo load(TbFileInfo tbFileInfo) {
		try {
			return tbFileInfoDao.load(tbFileInfo);
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
			return PageDaoHelper.search(tbFileInfoDao, paramMap, request.getCurrPage(), request.getPageSize());
		} catch (Exception e) {
			SysLog.error("分页查询service:---"+e);
			return null;
		}
	}

}
