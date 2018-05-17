package com.wys.chats.user.service;
import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbUserGroupInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:14:00'.
*/
public interface TbUserGroupInfoService {

    /**
    * 新增
    */
    public int insert(TbUserGroupInfo tbUserGroupInfo);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbUserGroupInfo tbUserGroupInfo);

    /**
    * Load查询
    */
    public TbUserGroupInfo load(TbUserGroupInfo tbUserGroupInfo);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

}
