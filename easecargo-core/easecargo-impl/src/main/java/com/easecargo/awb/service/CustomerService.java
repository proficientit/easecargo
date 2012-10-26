package com.easecargo.awb.service;

import java.util.List;

import com.easecargo.awb.Customer;


public interface CustomerService {
	public void saveCustomer(Customer customer);
	public void deleteCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(Integer customerId);

	/**
	 * Name like "name%"
	 * 
	 * @param customerName
	 * @param userId
	 * @return
	 */
	public List<Customer> getCustomersByNameAndUserId(String customerName,Integer userId)  ;
	public List<Customer> getCustomersByUserId(Integer userId)  ;
	/**
	 * account number like "accountNumber%"
	 * 
	 * @param accountNumber
	 * @param userId
	 * @return
	 */
	public List<Customer> getCustomersByAccountAndUserId(String accountNumber,Integer userId) ;
	/**
	 * awbPrefix equals "awbPrefix"
	 * 
	 * @param awbPrefix
	 * @param userId
	 * @return
	 */
	public List<Customer> getCustomersByAWBPrefixAndUserId(Integer awbPrefix,Integer userId) ;
	/**
	 * customerType like "customerType"
	 * 
	 * @param customerType
	 * @param userId
	 * @return
	 */
	public List<Customer> getCustomersByTypeAndUserId(String customerType, Integer userId);
	
}
