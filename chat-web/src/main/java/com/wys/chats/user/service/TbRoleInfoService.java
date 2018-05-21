package com.wys.chats.user.service;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbRoleInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:43:59'.
*/
public interface TbRoleInfoService {

    /**
    * 新增
    */
    public int insert(TbRoleInfo tbRoleInfo);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbRoleInfo tbRoleInfo);

    /**
    * Load查询
    */
    public TbRoleInfo load(TbRoleInfo tbRoleInfo);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

}
