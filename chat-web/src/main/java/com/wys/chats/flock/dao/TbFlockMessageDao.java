package com.wys.chats.flock.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbFlockMessage;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:05:06'.
*/
@Component
public interface TbFlockMessageDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(TbFlockMessage tbFlockMessage);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update( TbFlockMessage tbFlockMessage);

    /**
    * Load查询
    */
    public TbFlockMessage load(TbFlockMessage tbFlockMessage);

    /**
     * 根据用户id和群统计群未读消息数
     */
    public int countFlockMessageByFlockId(@Param("userId") Object userId,@Param("flockId") Object flockId);
}
