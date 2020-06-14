package com.springboot.springb.modules.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.springb.modules.user.entity.User;
import com.springboot.springb.modules.user.service.Impl.UserServiceImpl;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserServiceImpl userImpl;
	/*
	 * 测试过滤器
	 */
	@RequestMapping("/filter")
	@ResponseBody
	public String testFilter(HttpServletRequest request,
			@RequestParam(value="key"/*链接上的参数名*/,defaultValue="123"/*未赋值时默认值*/,required=false)String value1,
			@RequestParam(value="key2"/*链接上的参数名*/,defaultValue="123"/*未赋值时默认值*/,required=false)String value3){
		String value2=request.getParameter("key");
		String value4=request.getParameter("key2");
		return "过滤器过滤后的特朗普1="+value1+",特朗普2="+value2+",过滤后的手风琴1="+value3+",手风琴2="+value4;
	}
	/**
	 * 页面跳转
	 * 跳转至html页面
	 */
	@RequestMapping("/center")
	public String hello(ModelMap m){
		User u=userImpl.getUserBywNum("16110201");
		m.addAttribute("user", u);//传递参数用于center页面获取
		//m.addAttribute("template","test/center" );//index页面获取拼接的页面路径
		return "index";
	}

}
