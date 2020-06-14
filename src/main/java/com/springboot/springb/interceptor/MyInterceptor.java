package com.springboot.springb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
* 自定义拦截器，实现modelMap中不指定template，自动按照uri进行装配的功能
* 实现步骤：继承HandlerInterceptor ‐‐‐‐ 注册为组件 ‐‐‐‐ 重写postHandle方法 
* ‐‐‐‐ 配置类中注册addInterceptors
*/
@Component	//注册为spring组件
public class MyInterceptor implements HandlerInterceptor {
	private final static Logger LOGGER=LoggerFactory.getLogger(MyInterceptor.class);
	/**
	 * 拦截点之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.debug("Pre uri interceptor");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	/**
	 *拦截点执行 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOGGER.debug("Post uri interceptor");
		
		if(modelAndView==null || modelAndView.getViewName().startsWith("redirect")){
			return;
		}
		
		String uri=request.getServletPath();
		String template=(String) modelAndView.getModelMap().get("template");
		if(StringUtils.isBlank(template)/*template为空时*/){
			if(uri.startsWith("/")){
				uri=uri.substring(1);
			}
			//将uri存进template，传给index.html
			modelAndView.getModelMap().addAttribute("template", uri);
		
		}
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 拦截点之后执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.debug("After uri interceptor");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	

}
