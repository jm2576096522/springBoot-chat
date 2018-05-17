package com.wys.chats.resource.service;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbMessagePush;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:29:37'.
*/
public interface TbMessagePushService {

    /**
    * 新增
    */
    public int insert(TbMessagePush tbMessagePush);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbMessagePush tbMessagePush);

    /**
    * Load查询
    */
    public TbMessagePush load(TbMessagePush tbMessagePush);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

}
