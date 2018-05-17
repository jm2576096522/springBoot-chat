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
import com.wys.chats.entity.TbFlockInfo;
import com.wys.chats.flock.service.TbFlockInfoService;
import com.wys.chats.util.SysLog;

/**
* 
*
* Created by wangyanshu on '2018-05-18 00:00:46'.
*/
@Controller
@RequestMapping("/tbFlockInfo")
public class TbFlockInfoController {

    @Resource
    private TbFlockInfoService tbFlockInfoService;

    /**
    * 新增
    */
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(@RequestBody TbFlockInfo tbFlockInfo){
    	try {
    		int result = tbFlockInfoService.insert(tbFlockInfo);
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
	    	int result =  tbFlockInfoService.delete(id);
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
    public Object update(@RequestBody TbFlockInfo tbFlockInfo){
        try {
	        int result = tbFlockInfoService.update(tbFlockInfo);
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
    public Object load(@RequestBody TbFlockInfo tbFlockInfo){
        try {
	        TbFlockInfo result = tbFlockInfoService.load(tbFlockInfo);
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
	   		PageBean pb = tbFlockInfoService.pageList(request);
	   		return  pb  != null ? new Response(SystemCode.code_1000, pb) : new Response(SystemCode.code_1001, null);
    	} catch (Exception e) {
			SysLog.error("分页查询:---"+e);
			return new Response(SystemCode.code_1002, null);
		}
    }

}
