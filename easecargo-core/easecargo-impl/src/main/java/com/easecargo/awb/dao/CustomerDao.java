package com.easecargo.awb.dao;

import java.util.List;

import com.easecargo.awb.Customer;


public interface CustomerDao {
	public void saveCustomer(Customer customer);

	public List<Customer> selectAllCustomers();

	public Customer selectCustomerById(Integer userId);

	public List<Customer> selectCustomersByNameAndUserId(String customerName,Integer userId) ;
	public List<Customer> selectCustomersByUser(Integer userId);
	public void deleteCustomer(Customer customer);
}
