package com.wys.chats.flock.service;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbFlockMessage;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:05:06'.
*/
public interface TbFlockMessageService {

    /**
    * 新增
    */
    public int insert(TbFlockMessage tbFlockMessage);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbFlockMessage tbFlockMessage);

    /**
    * Load查询
    */
    public TbFlockMessage load(TbFlockMessage tbFlockMessage);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

}
