package com.wys.chats.resource.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbFileInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:23:05'.
*/
@Component
public interface TbFileInfoDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(@Param("tbFileInfo") TbFileInfo tbFileInfo);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update(@Param("tbFileInfo") TbFileInfo tbFileInfo);

    /**
    * Load查询
    */
    public TbFileInfo load(@Param("tbFileInfo") TbFileInfo tbFileInfo);


}
