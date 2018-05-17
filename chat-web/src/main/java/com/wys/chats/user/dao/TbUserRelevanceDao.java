package com.wys.chats.user.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbUserRelevance;
/**
* 
*
* Created by wangyanshu on '2018-05-17 23:41:55'.
*/
@Component
public interface TbUserRelevanceDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(@Param("tbUserRelevance") TbUserRelevance tbUserRelevance);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update(@Param("tbUserRelevance") TbUserRelevance tbUserRelevance);

    /**
    * Load查询
    */
    public TbUserRelevance load(@Param("tbUserRelevance") TbUserRelevance tbUserRelevance);


}
