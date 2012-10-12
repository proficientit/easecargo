package com.easecargo.user.service;

import com.easecargo.user.MyAccount;

public interface AccountService {
	public void saveAccount(MyAccount account) ;
	public void deleteAccount(MyAccount account) ;
	public MyAccount getAccountById(Integer accId) ;//useless method. just for testing
	public MyAccount getAccountForUser(Integer userId)  ;

}
