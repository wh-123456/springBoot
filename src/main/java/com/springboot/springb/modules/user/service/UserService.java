package com.springboot.springb.modules.user.service;

import java.util.List;

import com.springboot.springb.modules.user.entity.User;

public interface UserService {

	List<User> getUserList();
	List<User> getUserListPage();
	User getUserBywNum(String wNum);
	int inserUser(User u);
	int deleteUserBywNum(String wNum);
	int updateUser(User u);
}
