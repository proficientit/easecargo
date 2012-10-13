package com.easecargo.user.dao;

import java.util.List;

import com.easecargo.user.MyBilling;

public interface BillingDao {
	public void saveBilling(MyBilling acc) ;
	public void deleteBilling(MyBilling acc) ;
	public List<MyBilling> selectBillingsByUserId(Integer userId);

}
