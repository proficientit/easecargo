package com.easecargo.user.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.user.User;
import com.easecargo.user.dao.UserDao;

@Repository("UserDao")
@Transactional
public class UserDaoImpl implements UserDao {
	Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl() {
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		logger.info("SessionFactory injecting");
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional(readOnly = false)
	@Override
	public void saveUser(User user) {
		logger.info("Saving User");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteUser(User user) {
		logger.info("Deleting User");
		sessionFactory.getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUsers() {
		logger.info("get All users");
		return (List<User>) sessionFactory.getCurrentSession()
				.createQuery("from User").list();
	}
	@Override
	public User selectUserById(Integer userId) {
		logger.info("select User by Id");
		return (User) sessionFactory.getCurrentSession().get(
				User.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectUserByName(String userName) {
		logger.info("select User by Name");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from User where userName = :userName");
		query.setParameter("userName", userName);
		return query.list();
	}	
	

}
