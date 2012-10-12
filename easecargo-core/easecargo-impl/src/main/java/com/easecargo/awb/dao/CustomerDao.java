package com.easecargo.awb.dao;

import java.util.List;

import com.easecargo.awb.Customer;


public interface CustomerDao {
	public void saveCustomer(Customer customer);
	public void deleteCustomer(Customer customer);

	public List<Customer> selectAllCustomers();

	public Customer selectCustomerById(Integer userId);

	public List<Customer> selectCustomersByNameAndUserId(String customerName,Integer userId) ;
	public List<Customer> selectCustomersByUserId(Integer userId);
	public List<Customer> selectCustomersByAccountAndUserId(String accountNumber,Integer userId);
	public List<Customer> selectCustomersByAWBPrefixAndUserId(Integer awbPrefix,Integer userId) ;
}
