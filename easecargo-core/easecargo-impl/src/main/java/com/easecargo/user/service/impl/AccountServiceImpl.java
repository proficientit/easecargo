package com.easecargo.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easecargo.user.MyAccount;
import com.easecargo.user.dao.AccountDao;
import com.easecargo.user.service.AccountService;

@Service("AccountService")
public class AccountServiceImpl implements AccountService{


	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	@Autowired
	private AccountDao accountDao;
	public AccountServiceImpl() {
	}
	public void setAccountDao(AccountDao dao) {
		this.accountDao = dao;
	}

	@Override
	public void saveAccount(MyAccount account) {
		accountDao.saveAccount(account);
	}

	@Override
	public void deleteAccount(MyAccount account) {
		accountDao.deleteAccount(account);
	}
	@Override	
	public MyAccount getAccountById(Integer accId) {
		return accountDao.selectAccountById(accId);
		
	}
	
	@Override
	public MyAccount getAccountForUser(Integer userId)  {
		return accountDao.selectAccountForUser(userId);
	}
}
