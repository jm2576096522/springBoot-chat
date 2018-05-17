package com.wys.chats.flock.service;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbFlockRelevance;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:10:44'.
*/
public interface TbFlockRelevanceService {

    /**
    * 新增
    */
    public int insert(TbFlockRelevance tbFlockRelevance);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbFlockRelevance tbFlockRelevance);

    /**
    * Load查询
    */
    public TbFlockRelevance load(TbFlockRelevance tbFlockRelevance);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

}
