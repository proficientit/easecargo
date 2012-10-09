package com.easecargo.awb.service;

import java.util.List;

import com.easecargo.awb.Customer;


public interface CustomerService {
	public void saveCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(Integer customerId);

	public List<Customer> getCustomerByName(String customerName)  ;

	public void deleteCustomer(Customer customer);
}
