package com.wys.chats.flock.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbFlockRelevance;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:10:44'.
*/
@Component
public interface TbFlockRelevanceDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(@Param("tbFlockRelevance") TbFlockRelevance tbFlockRelevance);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update(@Param("tbFlockRelevance") TbFlockRelevance tbFlockRelevance);

    /**
    * Load查询
    */
    public TbFlockRelevance load(@Param("tbFlockRelevance") TbFlockRelevance tbFlockRelevance);

    public Object getFlockRelevanceByUserId(@Param("userId") int userId);

}
