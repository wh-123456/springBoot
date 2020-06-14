package com.springboot.springb.modules.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.springb.modules.user.entity.User;
import com.springboot.springb.modules.user.service.Impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userImpl;
	
	/**
	 * 查询所有用户
	 */
	@RequestMapping("/getUserList")
	@ResponseBody
	public List<User> getUserList(){
		List<User> us=userImpl.getUserList();
		return us;
	}

	/*
	 * 分页查询
	 */
	@RequestMapping("/getUserListPage")
	@ResponseBody
	public PageInfo<User> getUserListPage(){
		PageHelper.startPage(0,3);
		List<User> us=userImpl.getUserListPage();
		return new PageInfo<User>(us);
	}
	
	/**
	 * 根据用户Id查询用户
	 */
	@RequestMapping("/getUserByWnum")
	@ResponseBody
	public User getUserByWnum(String wNum){
		return userImpl.getUserBywNum(wNum);
	}
	
	/**
	 * 增加用户
	 */
	@PostMapping("/insertUser")
	@ResponseBody
	public int insertUser(User u){
		return userImpl.inserUser(u);
	}
	
	/*
	 * 删除用户
	 */
	@PostMapping("/deleteUserBywNum")
	@ResponseBody
	public int deletetUser(String wNum){
		return userImpl.deleteUserBywNum(wNum);
	}
	
	/*
	 * 修改用户
	 */
	@PostMapping("/updateUser")
	@ResponseBody
	public int updateUser(User u){
		return userImpl.updateUser(u);
	}
	
}
