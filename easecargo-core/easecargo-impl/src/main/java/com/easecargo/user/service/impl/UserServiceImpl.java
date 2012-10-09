package com.easecargo.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easecargo.user.User;
import com.easecargo.user.dao.UserDao;
import com.easecargo.user.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao dao) {
		this.userDao = dao;
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.selectAllUsers();
	}

	@Override
	public User getUserById(Integer userId) {
		return userDao.selectUserById(userId);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
	@Override
	public User getUserByName(String userName)  {
		List<User> userList =  userDao.selectUserByName(userName);
		//assuming userName is unique
		if(userList !=null && userList.size()>0) {
			return userList.get(0);	
		} else	return null;
				
	}
}
