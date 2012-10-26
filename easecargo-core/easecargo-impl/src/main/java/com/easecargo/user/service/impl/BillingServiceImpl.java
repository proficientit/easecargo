package com.easecargo.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.user.MyBilling;
import com.easecargo.user.dao.BillingDao;
import com.easecargo.user.service.BillingService;

@Service("BillingService")
public class BillingServiceImpl implements BillingService {
	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	@Autowired
	private BillingDao billingDao;
	public BillingServiceImpl() {
	}

	@Override
	@Transactional(readOnly = false)
	public void saveBilling(MyBilling acc) {
		billingDao.saveBilling(acc);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteBilling(MyBilling acc) {
		billingDao.deleteBilling(acc);
	}

	@Override
	public List<MyBilling> getBillingsByUserId(Integer userId) {
		return billingDao.selectBillingsByUserId(userId);
	}

}
