package com.easecargo.user.service;

import java.util.List;

import com.easecargo.user.User;

public interface UserService {
	public void saveUser(User user) ;
	public List<User> getAllUsers() ;
	public User getUserById(Integer userId) ;
	public void deleteUser(User user) ;
	/**
	 * userName equals "userName"
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserByName(String userName)  ;
}
