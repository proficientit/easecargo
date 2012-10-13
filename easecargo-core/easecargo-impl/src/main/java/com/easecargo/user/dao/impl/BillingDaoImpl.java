package com.easecargo.user.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.user.MyBilling;
import com.easecargo.user.dao.BillingDao;

@Repository("BillingDao")
@Transactional
public class BillingDaoImpl implements BillingDao{
	Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		logger.info("SessionFactory injecting");
		this.sessionFactory = sessionFactory;
	}
	

	public BillingDaoImpl() {
	}

	@Transactional(readOnly = false)
	@Override
	public void saveBilling(MyBilling acc) {
		logger.info("Saving account");
		sessionFactory.getCurrentSession().saveOrUpdate(acc);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteBilling(MyBilling acc) {
		logger.info("Deleting MyBilling");
		sessionFactory.getCurrentSession().delete(acc);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MyBilling> selectBillingsByUserId(Integer userId) {
		logger.info("select billings for User");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from MyBilling where user.userId = :userId");
		query.setParameter("userId", userId);
		return query.list();			
	}
}