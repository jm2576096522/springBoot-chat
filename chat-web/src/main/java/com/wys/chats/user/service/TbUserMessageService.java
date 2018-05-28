package com.wys.chats.user.service;
import javax.servlet.http.HttpServletRequest;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbUserMessage;
/**
* 
*
* Created by wangyanshu on '2018-05-17 23:28:41'.
*/
public interface TbUserMessageService {

    /**
    * 新增
    */
    public int insert(TbUserMessage tbUserMessage);

    /**
    * 删除
    */
    public int delete(int id);

    /**
    * 更新
    */
    public int update(TbUserMessage tbUserMessage);

    /**
    * Load查询
    */
    public TbUserMessage load(TbUserMessage tbUserMessage);

    /**
    * 分页查询
    */
    public PageBean pageList(Request request);

    /**
     * 发送消息
     * @param request
     * @param httpServletRequest 
     * @return
     */
	public int sendMessage(Request request, HttpServletRequest httpServletRequest);

}
