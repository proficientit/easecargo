package com.easecargo.awb.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}
	@Override
	public List<Customer> getCustomerByName(String customerName)  {
		return customerDao.selectCustomerByName(customerName);
	}
}
