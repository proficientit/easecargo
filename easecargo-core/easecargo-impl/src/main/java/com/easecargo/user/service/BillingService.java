package com.easecargo.user.service;

import java.util.List;

import com.easecargo.user.MyBilling;

public interface BillingService {
	public void saveBilling(MyBilling acc) ;
	public void deleteBilling(MyBilling acc) ;
	public List<MyBilling> getBillingsByUserId(Integer userId);
}
