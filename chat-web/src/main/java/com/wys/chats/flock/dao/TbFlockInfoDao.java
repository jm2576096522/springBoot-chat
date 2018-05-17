package com.wys.chats.flock.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbFlockInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:00:46'.
*/
@Component
public interface TbFlockInfoDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(@Param("tbFlockInfo") TbFlockInfo tbFlockInfo);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update(@Param("tbFlockInfo") TbFlockInfo tbFlockInfo);

    /**
    * Load查询
    */
    public TbFlockInfo load(@Param("tbFlockInfo") TbFlockInfo tbFlockInfo);


}
