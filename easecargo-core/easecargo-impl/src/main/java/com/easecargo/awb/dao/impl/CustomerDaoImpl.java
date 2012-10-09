package com.easecargo.awb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.easecargo.awb.Customer;
import com.easecargo.awb.dao.CustomerDao;


@Repository("CustomerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		logger.info("SessionFactory injecting");
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = false)
	@Override
	public void saveCustomer(Customer customer) {
		logger.info("Saving Customer");
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteCustomer(Customer customer) {
		logger.info("Deleting Customer");
		sessionFactory.getCurrentSession().delete(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> selectAllCustomers() {
		logger.info("get All customers");
		return (List<Customer>) sessionFactory.getCurrentSession()
				.createQuery("from Customer").list();
	}
	@Override
	public Customer selectCustomerById(Integer customerId) {
		logger.info("select Customer by Id");
		return (Customer) sessionFactory.getCurrentSession().get(
				Customer.class, customerId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> selectCustomerByName(String customerName) {
		logger.info("select Customer by Name");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from Customer where customerName = :customerName");
		query.setParameter("customerName", customerName);
		return query.list();
	}	
	
}
