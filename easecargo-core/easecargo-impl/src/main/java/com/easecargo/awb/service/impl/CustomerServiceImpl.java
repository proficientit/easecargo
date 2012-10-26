package com.easecargo.awb.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.awb.Customer;
import com.easecargo.awb.dao.CustomerDao;
import com.easecargo.awb.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao dao) {
		this.customerDao = dao;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.selectAllCustomers();
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		return customerDao.selectCustomerById(customerId);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}
	@Override
	public List<Customer> getCustomersByNameAndUserId(String customerName,Integer userId)  {
		return customerDao.selectCustomersByNameAndUserId(customerName,userId);
	}
	
	@Override
	public List<Customer> getCustomersByUserId(Integer userId)  {
		return customerDao.selectCustomersByUserId(userId);
		
	}
	@Override
	public List<Customer> getCustomersByAccountAndUserId(String accountNumber,Integer userId)  {
		return customerDao.selectCustomersByAccountAndUserId(accountNumber,userId);
	}
	@Override
	public List<Customer> getCustomersByAWBPrefixAndUserId(Integer awbPrefix,Integer userId) {
		return customerDao.selectCustomersByAWBPrefixAndUserId(awbPrefix, userId);
	}
	@Override
	public List<Customer> getCustomersByTypeAndUserId(String customerType, Integer userId) {
		return customerDao.selectCustomersByTypeAndUserId(customerType, userId);
	}
	
}
