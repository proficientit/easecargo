package com.easecargo.awb.service;

import java.util.List;

import com.easecargo.awb.Customer;


public interface CustomerService {
	public void saveCustomer(Customer customer);
	public void deleteCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(Integer customerId);

	public List<Customer> getCustomersByNameAndUserId(String customerName,Integer userId)  ;
	public List<Customer> getCustomersByUserId(Integer userId)  ;
	public List<Customer> getCustomersByAccountAndUserId(String accountNumber,Integer userId) ;
	public List<Customer> getCustomersByAWBPrefixAndUserId(Integer awbPrefix,Integer userId) ;
	
}
