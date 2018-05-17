package com.wys.chats.flock.service;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbFlockInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:00:46'.
*/
public interface TbFlockInfoService {

    /**
    * 新增
    */
    public int insert(TbFlockInfo tbFlockInfo);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbFlockInfo tbFlockInfo);

    /**
    * Load查询
    */
    public TbFlockInfo load(TbFlockInfo tbFlockInfo);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

}
