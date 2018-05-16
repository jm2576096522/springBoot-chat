package com.wys.chats.core;


import java.util.List;
import java.util.Map;



/**
 * 数据操作接口
 * @author WangYS
 *
 */
public interface BaseDao
{
    /**
     * 根据条件查询所有数据集
     */
    List<BaseBean> listAll(Map<String, Object> map);
    
    /**
     * 根据条件分页查询数据集
     */
    List<BaseBean> list(Map<String, Object> map);
    
    /**
     * 根据条件统计数据记录数
     */
    int count(Map<String, Object> map);
    
    /**
     * 添加数据记录
     */
    int add(BaseBean myBean);
    
    /**
     * 更新数据
     */
    int update(BaseBean myBean);
    
    /**
     * 
     * 根据ID删除记录
     */
    int deleteById(String id);
    
    /**
     * 根据ID获取单个记录信息
     */
    BaseBean getById(String id);
}
