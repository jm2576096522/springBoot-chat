package com.wys.chats.flock.service.impl;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.PageDaoHelper;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbFlockRelevance;
import com.wys.chats.flock.dao.TbFlockRelevanceDao;
import com.wys.chats.flock.service.TbFlockRelevanceService;
import com.wys.chats.util.JsonUtil;
import com.wys.chats.util.SysLog;

/**
* 
*
* Created by wangyanshu on '2018-05-18 00:10:44'.
*/
@Service
public class TbFlockRelevanceServiceImpl implements TbFlockRelevanceService {

	@Autowired
	private TbFlockRelevanceDao tbFlockRelevanceDao;

	/**
    * 新增
    */
	@Override
	public int insert(TbFlockRelevance tbFlockRelevance) {
		try {
			if (tbFlockRelevance == null) {
				return 0;
	        }
	        return  tbFlockRelevanceDao.insert(tbFlockRelevance);
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
			return  tbFlockRelevanceDao.delete(id);
		} catch (Exception e) {
			SysLog.error("删除service:---"+e);
			return 0;
		}
	}

	/**
	* 更新
	*/
	@Override
	public int update(TbFlockRelevance tbFlockRelevance) {
		try {
			return tbFlockRelevanceDao.update(tbFlockRelevance);
		} catch (Exception e) {
			SysLog.error("更新service:---"+e);
			return 0;
		}
	}

	/**
	* Load查询
	*/
	@Override
	public TbFlockRelevance load(TbFlockRelevance tbFlockRelevance) {
		try {
			return tbFlockRelevanceDao.load(tbFlockRelevance);
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
			return PageDaoHelper.search(tbFlockRelevanceDao, paramMap, request.getCurrPage(), request.getPageSize());
		} catch (Exception e) {
			SysLog.error("分页查询service:---"+e);
			return null;
		}
	}

}
