package com.wys.chats.flock.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import com.wys.chats.core.PageBean;
import com.wys.chats.core.Request;
import com.wys.chats.core.Response;
import com.wys.chats.core.SystemCode;
import com.wys.chats.entity.TbFlockMessage;
import com.wys.chats.flock.service.TbFlockMessageService;
import com.wys.chats.util.SysLog;

/**
* 
*
* Created by wangyanshu on '2018-05-18 00:05:06'.
*/
@Controller
@RequestMapping("/tbFlockMessage")
public class TbFlockMessageController {

    @Resource
    private TbFlockMessageService tbFlockMessageService;

    /**
    * 新增
    */
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(@RequestBody TbFlockMessage tbFlockMessage){
    	try {
    		int result = tbFlockMessageService.insert(tbFlockMessage);
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
	    	int result =  tbFlockMessageService.delete(id);
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
    public Object update(@RequestBody TbFlockMessage tbFlockMessage){
        try {
	        int result = tbFlockMessageService.update(tbFlockMessage);
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
    public Object load(@RequestBody TbFlockMessage tbFlockMessage){
        try {
	        TbFlockMessage result = tbFlockMessageService.load(tbFlockMessage);
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
	   		PageBean pb = tbFlockMessageService.pageList(request);
	   		return  pb  != null ? new Response(SystemCode.code_1000, pb) : new Response(SystemCode.code_1001, null);
    	} catch (Exception e) {
			SysLog.error("分页查询:---"+e);
			return new Response(SystemCode.code_1002, null);
		}
    }

}
