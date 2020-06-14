package com.springboot.springb.modules.user.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.springb.modules.user.dao.UserDao;
import com.springboot.springb.modules.user.entity.User;
import com.springboot.springb.modules.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;
	
	@Override
	public List<User> getUserList() {
		List<User>us=userdao.getUserList();
		return us;
	}

	@Override
	public User getUserBywNum(String wNum) {
		
		return userdao.getUserBywNum(wNum);
	}

	@Override
	public int inserUser(User u) {
		
		return userdao.inserUser(u);
	}

	@Override
	public int deleteUserBywNum(String wNum) {
		
		return userdao.deleteUserBywNum(wNum);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int updateUser(User u) {
		int num;
		try {
			num = userdao.updateUser(u);
			int i=1/0;
			u.setuName("464");
			userdao.updateUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;//抛出异常
		}
		return num;
	}

	@Override
	public List<User> getUserListPage() {
		return userdao.getUserListPage();
	}

}
