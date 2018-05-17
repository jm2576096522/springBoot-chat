package com.wys.chats.resource.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbMessagePush;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:29:37'.
*/
@Component
public interface TbMessagePushDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(@Param("tbMessagePush") TbMessagePush tbMessagePush);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update(@Param("tbMessagePush") TbMessagePush tbMessagePush);

    /**
    * Load查询
    */
    public TbMessagePush load(@Param("tbMessagePush") TbMessagePush tbMessagePush);


}
