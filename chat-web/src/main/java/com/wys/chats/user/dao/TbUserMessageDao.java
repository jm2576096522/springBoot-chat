package com.wys.chats.user.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbUserMessage;
/**
* 
*
* Created by wangyanshu on '2018-05-17 23:28:41'.
*/
@Component
public interface TbUserMessageDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(@Param("tbUserMessage") TbUserMessage tbUserMessage);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update(@Param("tbUserMessage") TbUserMessage tbUserMessage);

    /**
    * Load查询
    */
    public TbUserMessage load(TbUserMessage tbUserMessage);


}
