package com.wys.chats.user.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbUserGroupInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:14:00'.
*/
@Component
public interface TbUserGroupInfoDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(@Param("tbUserGroupInfo") TbUserGroupInfo tbUserGroupInfo);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update(@Param("tbUserGroupInfo") TbUserGroupInfo tbUserGroupInfo);

    /**
    * Load查询
    */
    public TbUserGroupInfo load(@Param("tbUserGroupInfo") TbUserGroupInfo tbUserGroupInfo);


}
