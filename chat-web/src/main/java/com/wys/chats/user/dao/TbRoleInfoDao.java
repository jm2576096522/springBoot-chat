package com.wys.chats.user.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbRoleInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:43:59'.
*/
@Component
public interface TbRoleInfoDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(@Param("tbRoleInfo") TbRoleInfo tbRoleInfo);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update(@Param("tbRoleInfo") TbRoleInfo tbRoleInfo);

    /**
    * Load查询
    */
    public TbRoleInfo load(@Param("tbRoleInfo") TbRoleInfo tbRoleInfo);


}
