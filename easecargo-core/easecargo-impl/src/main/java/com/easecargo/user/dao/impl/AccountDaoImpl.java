package com.easecargo.user.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.user.MyAccount;
import com.easecargo.user.dao.AccountDao;

@Repository("AccountDao")
@Transactional
public class AccountDaoImpl implements AccountDao{
	Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		logger.info("SessionFactory injecting");
		this.sessionFactory = sessionFactory;
	}
	

	public AccountDaoImpl() {
	}

	@Transactional(readOnly = false)
	@Override
	public void saveAccount(MyAccount acc) {
		logger.info("Saving account");
		sessionFactory.getCurrentSession().saveOrUpdate(acc);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteAccount(MyAccount acc) {
		logger.info("Deleting account");
		sessionFactory.getCurrentSession().delete(acc);
	}
	@Override
	public MyAccount selectAccountById(Integer accId) {
		logger.info("select Account by Id");
		return (MyAccount) sessionFactory.getCurrentSession().get(
				MyAccount.class, accId);
	}	
	@Override	
	public MyAccount selectAccountForUser(Integer userId) {
		logger.info("select account for User");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from MyAccount where user.userId = :userId");
		query.setParameter("userId", userId);
		@SuppressWarnings("unchecked")
		List<MyAccount> accountList = query.list();	
		//one to one mapping allows this
		if(accountList == null || accountList.size()==0)
			return null;
		else return accountList.get(0);
	}
}
