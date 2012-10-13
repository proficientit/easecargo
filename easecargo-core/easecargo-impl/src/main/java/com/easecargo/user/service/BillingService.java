package com.easecargo.user.service;

import java.util.List;

import com.easecargo.user.MyBilling;

public interface BillingService {
	public void saveBilling(MyBilling acc) ;
	public void deleteBilling(MyBilling acc) ;
	/**
	 * get all billings for User
	 * 
	 * @param userId
	 * @return
	 */
	public List<MyBilling> getBillingsByUserId(Integer userId);
}
