package com.easecargo.awb.dao;

import java.util.List;

import com.easecargo.awb.Customer;


public interface CustomerDao {
	public void saveCustomer(Customer customer);

	public List<Customer> selectAllCustomers();

	public Customer selectCustomerById(Integer userId);

	public List<Customer> selectCustomerByName(String customerName) ;
	
	public void deleteCustomer(Customer customer);
}
