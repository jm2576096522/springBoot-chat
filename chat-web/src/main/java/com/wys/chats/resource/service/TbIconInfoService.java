package com.wys.chats.resource.service;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbIconInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:26:13'.
*/
public interface TbIconInfoService {

    /**
    * 新增
    */
    public int insert(TbIconInfo tbIconInfo);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbIconInfo tbIconInfo);

    /**
    * Load查询
    */
    public TbIconInfo load(TbIconInfo tbIconInfo);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

}
