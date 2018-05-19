package com.wys.chats.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wys.chats.util.SysLog;

/**
 * 拦截器
 * @author WangYS 2018年5月19日上午12:35:55
 *
 */
public class MyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		HttpSession session = request.getSession();
		SysLog.info("前置拦截请求：---"+request.getRequestURL());
		String id = String.valueOf(session.getAttribute("id"));
		SysLog.info("id：---"+id);
		String role = String.valueOf(session.getAttribute("role"));
		SysLog.info("role：---"+role);
		if (id != null && !id.trim().equals("") && !id.trim().equals("null")) {
			if(role != null &&  !role.trim().equals("") &&  !role.trim().equals("null")){
				
			}	
			return true;// 只有返回true才会继续向下执行，返回false取消当前请求
		}else{
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}

}