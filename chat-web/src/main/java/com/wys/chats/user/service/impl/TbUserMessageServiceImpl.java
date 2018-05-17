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
import com.wys.chats.entity.TbUserMessage;
import com.wys.chats.user.dao.TbUserMessageDao;
import com.wys.chats.user.service.TbUserMessageService;
import com.wys.chats.util.JsonUtil;
import com.wys.chats.util.SysLog;

/**
* 
*
* Created by wangyanshu on '2018-05-17 23:28:41'.
*/
@Service
public class TbUserMessageServiceImpl implements TbUserMessageService {

	@Resource
	private TbUserMessageDao tbUserMessageDao;

	/**
    * 新增
    */
	@Override
	public int insert(TbUserMessage tbUserMessage) {
		try {
			if (tbUserMessage == null) {
				return 0;
	        }
	        return tbUserMessageDao.insert(tbUserMessage);
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
			return tbUserMessageDao.delete(id);
		} catch (Exception e) {
			SysLog.error("删除service:---"+e);
			return 0;
		}
	}

	/**
	* 更新
	*/
	@Override
	public int update(TbUserMessage tbUserMessage) {
		try {
			return tbUserMessageDao.update(tbUserMessage);
		} catch (Exception e) {
			SysLog.error("更新service:---"+e);
			return 0;
		}
	}

	/**
	* Load查询
	*/
	@Override
	public TbUserMessage load(TbUserMessage tbUserMessage) {
		try {
			SysLog.info(tbUserMessage);
			return tbUserMessageDao.load(tbUserMessage);
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
			return PageDaoHelper.search(tbUserMessageDao, paramMap, request.getCurrPage(), request.getPageSize());
		} catch (Exception e) {
			SysLog.error("分页查询service:---"+e);
			return null;
		}
	}

}
