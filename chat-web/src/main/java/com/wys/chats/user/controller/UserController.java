package com.wys.chats.user.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.core.Response;
import com.wys.chats.core.SystemCode;
import com.wys.chats.entity.TbUserInfo;
import com.wys.chats.user.service.TbUserInfoService;

/**
 * 用户信息表
 *
 * Created by wangyanshu on '2018-05-16 22:50:01'.
 */
@Controller
@RequestMapping("/userInfo")
public class UserController {

	@Resource
	private TbUserInfoService tbUserInfoService;

	/**
	 * 新增
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(TbUserInfo tbUserInfo){
		int result = tbUserInfoService.insert(tbUserInfo);
		return result  > 0 ? new Response(SystemCode.code_1000, result) : new Response(SystemCode.code_1001, null);
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(@RequestBody TbUserInfo tbUserInfo){
		int result = tbUserInfoService.delete(tbUserInfo.getId());
		return result  > 0 ? new Response(SystemCode.code_1000, result) : new Response(SystemCode.code_1001, null);
	}

	/**
	 * 更新
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Object update(@RequestBody TbUserInfo tbUserInfo){
		int result = tbUserInfoService.update(tbUserInfo);
		return result  > 0 ? new Response(SystemCode.code_1000, result) : new Response(SystemCode.code_1001, null);
	}

	/**
	 * Load查询
	 */
	@RequestMapping("/load")
	@ResponseBody
	public Object load(@RequestBody Request request){
		TbUserInfo tbUserInfo = tbUserInfoService.load(request);
		return  tbUserInfo  != null ? new Response(SystemCode.code_1000, tbUserInfo) : new Response(SystemCode.code_1001, null);
	}

	/**
	 * 分页查询
	 */
	@RequestMapping("/pageList")
	@ResponseBody
	public Object pageList(@RequestBody Request request) {
		PageBean pb = tbUserInfoService.pageList(request);
		return  pb  != null ? new Response(SystemCode.code_1000, pb) : new Response(SystemCode.code_1001, null);
	}

}
