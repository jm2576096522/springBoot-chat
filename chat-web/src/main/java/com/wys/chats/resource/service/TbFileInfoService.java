package com.wys.chats.resource.service;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbFileInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:23:05'.
*/
public interface TbFileInfoService {

    /**
    * 新增
    */
    public int insert(TbFileInfo tbFileInfo);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbFileInfo tbFileInfo);

    /**
    * Load查询
    */
    public TbFileInfo load(TbFileInfo tbFileInfo);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

}
