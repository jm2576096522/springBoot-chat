package com.wys.chats.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/hello", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object helloworld(@RequestBody Request request) {
		System.out.println(request.getData());
		return new Response(SystemCode.code_1000, request.getData());
	}
}