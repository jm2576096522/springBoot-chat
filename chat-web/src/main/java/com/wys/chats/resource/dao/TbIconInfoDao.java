package com.wys.chats.resource.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

import com.wys.chats.core.BaseDao;
import com.wys.chats.entity.TbIconInfo;
/**
* 
*
* Created by wangyanshu on '2018-05-18 00:26:13'.
*/
@Component
public interface TbIconInfoDao extends BaseDao{

    /**
    * 新增
    */
    public int insert(@Param("tbIconInfo") TbIconInfo tbIconInfo);

    /**
    * 删除
    */
    public int delete(@Param("id") int id);

    /**
    * 更新
    */
    public int update(@Param("tbIconInfo") TbIconInfo tbIconInfo);

    /**
    * Load查询
    */
    public TbIconInfo load(@Param("tbIconInfo") TbIconInfo tbIconInfo);


}
