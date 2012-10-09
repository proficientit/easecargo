package com.easecargo.user.dao;

import java.util.List;

import com.easecargo.user.User;

public interface UserDao {
	public void saveUser(User user) ;
	public void deleteUser(User user) ;
	public List<User> selectAllUsers() ;
	public User selectUserById(Integer userId) ;
	public List<User> selectUserByName(String userName);
	
}
