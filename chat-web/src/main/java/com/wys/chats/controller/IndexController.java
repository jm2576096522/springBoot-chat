package com.wys.chats.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wys.chats.util.SysLog;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "forward:/login.html";
	}

	/**
	 * 生成验证码
	 */
	@RequestMapping(value = "/getVerify")
	public void getVerify(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
			response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expire", 0);
			/*RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
			randomValidateCode.getRandcode(request, response);// 输出验证码图片方法
*/			SysLog.error("获取验证码成功----- ");
		} catch (Exception e) {
			SysLog.error("获取验证码失败----- " + e);
		}
	}

	/**
	 * 校验验证码
	 */
	@RequestMapping(value = "/checkVerify", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public boolean checkVerify(@RequestBody Map<String, Object> requestMap, HttpSession session) {
		try {
			// 从session中获取随机数
			String inputStr = requestMap.get("inputStr").toString();
			String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
			if (random == null) {
				return false;
			}
			if (random.equals(inputStr)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			SysLog.error("验证码校验失败----- " + e);
			return false;
		}
	}
}