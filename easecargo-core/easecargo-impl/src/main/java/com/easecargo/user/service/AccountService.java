package com.easecargo.user.service;

import com.easecargo.user.MyAccount;

public interface AccountService {
	public void saveAccount(MyAccount account) ;
	public void deleteAccount(MyAccount account) ;
	public MyAccount getAccountById(Integer accId) ;//useless method. just for testing
	/**
	 * get Unique account for user. user to account is one to one
	 * 
	 * @param userId
	 * @return
	 */
	public MyAccount getAccountForUser(Integer userId)  ;

}
