package com.wys.chats.user.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.core.Response;
import com.wys.chats.core.SystemCode;
import com.wys.chats.entity.TbUserMessage;
import com.wys.chats.interceptor.MyRequestHandler;
import com.wys.chats.user.service.TbUserMessageService;
import com.wys.chats.util.JsonUtil;
import com.wys.chats.util.SysLog;

/**
 * 
 *
 * Created by wangyanshu on '2018-05-17 23:28:41'.
 */
@Controller
@RequestMapping("/userMessage")
public class UserMessageController {

	@Resource
	private TbUserMessageService tbUserMessageService;

	/**
	 * 新增
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(@RequestBody TbUserMessage tbUserMessage){
		try {
			int result = tbUserMessageService.insert(tbUserMessage);
			return result  > 0 ? new Response(SystemCode.code_1000, result) : new Response(SystemCode.code_1001, null);
		} catch (Exception e) {
			SysLog.error("新增:---"+e);
			return new Response(SystemCode.code_1002, null);
		}
	}

	/**
	 * 发送消息
	 */
	@RequestMapping("/sendMessage")
	@ResponseBody
	public Object sendMessage(@RequestBody Request request,HttpServletRequest httpServletRequest){
		try {
			int result = tbUserMessageService.sendMessage(request, httpServletRequest);
			MyRequestHandler.handlerWebSocketPush(JsonUtil.getMapFromJsonObjStr(request.getData()));
			return result  > 0 ? new Response(SystemCode.code_1000, result) : new Response(SystemCode.code_1001, null);
		} catch (Exception e) {
			SysLog.error("新增:---"+e);
			return new Response(SystemCode.code_1002, null);
		}
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(int id){
		try {
			int result =  tbUserMessageService.delete(id);
			return result  > 0 ? new Response(SystemCode.code_1000, result) : new Response(SystemCode.code_1001, null);
		}catch (Exception e) {
			SysLog.error("删除:---"+e);
			return new Response(SystemCode.code_1002, null);
		}
	}

	/**
	 * 更新
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Object update(@RequestBody TbUserMessage tbUserMessage){
		try {
			int result = tbUserMessageService.update(tbUserMessage);
			return result  > 0 ? new Response(SystemCode.code_1000, result) : new Response(SystemCode.code_1001, null);
		} catch (Exception e) {
			SysLog.error("更新:---"+e);
			return new Response(SystemCode.code_1002, null);
		}
	}

	/**
	 * Load查询
	 */
	@RequestMapping("/load")
	@ResponseBody
	public Object load(@RequestBody TbUserMessage tbUserMessage){
		try {
			TbUserMessage result= tbUserMessageService.load(tbUserMessage);
			return  result  != null ? new Response(SystemCode.code_1000, result) : new Response(SystemCode.code_1001, null);
		} catch (Exception e) {
			SysLog.error("Load查询:---"+e);
			return new Response(SystemCode.code_1002, null);
		}
	}

	/**
	 * 分页查询
	 */
	@RequestMapping("/pageList")
	@ResponseBody
	public Object pageList(@RequestBody Request request) {
		try {
			PageBean pb = tbUserMessageService.pageList(request);
			return  pb  != null ? new Response(SystemCode.code_1000, pb) : new Response(SystemCode.code_1001, null);
		} catch (Exception e) {
			SysLog.error("分页查询:---"+e);
			return new Response(SystemCode.code_1002, null);
		}
	}

}
