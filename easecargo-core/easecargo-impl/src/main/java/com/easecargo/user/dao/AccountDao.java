package com.easecargo.user.dao;

import com.easecargo.user.MyAccount;

public interface AccountDao {
	public void saveAccount(MyAccount acc);
	public void deleteAccount(MyAccount acc);
	public MyAccount selectAccountForUser(Integer userId);
	public MyAccount selectAccountById(Integer accId) ;	
}
