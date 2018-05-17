package com.wys.chats.user.controller;
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
import com.wys.chats.entity.TbRoleInfo;
import com.wys.chats.user.service.TbRoleInfoService;
import com.wys.chats.util.SysLog;

/**
* 
*
* Created by wangyanshu on '2018-05-18 00:43:59'.
*/
@Controller
@RequestMapping("/tbRoleInfo")
public class TbRoleInfoController {

    @Resource
    private TbRoleInfoService tbRoleInfoService;

    /**
    * 新增
    */
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(@RequestBody TbRoleInfo tbRoleInfo){
    	try {
    		int result = tbRoleInfoService.insert(tbRoleInfo);
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
	    	int result =  tbRoleInfoService.delete(id);
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
    public Object update(@RequestBody TbRoleInfo tbRoleInfo){
        try {
	        int result = tbRoleInfoService.update(tbRoleInfo);
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
    public Object load(@RequestBody TbRoleInfo tbRoleInfo){
        try {
	        TbRoleInfo result = tbRoleInfoService.load(tbRoleInfo);
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
	   		PageBean pb = tbRoleInfoService.pageList(request);
	   		return  pb  != null ? new Response(SystemCode.code_1000, pb) : new Response(SystemCode.code_1001, null);
    	} catch (Exception e) {
			SysLog.error("分页查询:---"+e);
			return new Response(SystemCode.code_1002, null);
		}
    }

}
