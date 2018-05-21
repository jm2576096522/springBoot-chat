package com.wys.chats.user.service;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbUserRelevance;
/**
* 
*
* Created by wangyanshu on '2018-05-17 23:41:55'.
*/
public interface TbUserRelevanceService {

    /**
    * 新增
    */
    public int insert(TbUserRelevance tbUserRelevance);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbUserRelevance tbUserRelevance);

    /**
    * Load查询
    */
    public TbUserRelevance load(TbUserRelevance tbUserRelevance);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

}
