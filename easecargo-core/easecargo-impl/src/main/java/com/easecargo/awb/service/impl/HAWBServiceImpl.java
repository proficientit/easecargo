package com.easecargo.awb.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easecargo.awb.Customer;
import com.easecargo.awb.HAWB;
import com.easecargo.awb.dao.CustomerDao;
import com.easecargo.awb.dao.HAWBDao;
import com.easecargo.awb.service.HAWBService;

@Service("HAWBService")
public class HAWBServiceImpl implements HAWBService {
	Logger logger = LoggerFactory.getLogger(HAWBServiceImpl.class);
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private HAWBDao hawbDao;

	public void setCustomerDao(CustomerDao dao) {
		this.customerDao = dao;
	}

	public void setHAWBDao(HAWBDao dao) {
		this.hawbDao = dao;
	}
	@Override	
	public HAWB getHAWB(Integer id) {
		return hawbDao.selectHAWBById(id);
	}
	@Override
	public HAWB getHAWB(String hawbNum) {
		return hawbDao.selectHAWBByNumber(hawbNum);
		
	}
	@Override
	public void deleteHAWBById(Integer hawbId) {
		HAWB hawb = hawbDao.selectHAWBById(hawbId);
		logger.info("fetched HAWB via service "+hawb.getHawbNum());
		hawbDao.deleteHAWB(hawb);		
	}	
	@Override
	public void deleteHAWBByNumber(String hawbNum) {
		HAWB hawb = getHAWB(hawbNum);
		logger.info("fetched HAWB via service "+hawb.getHawbNum());
		hawbDao.deleteHAWB(hawb);		
	}
	@Override
	public void saveHAWB(HAWB hawb) {
		//right now customer doesnt have its own existence. hence deleting.
		//need to revisit once user management is done
		saveCustomer(hawb.getShipper());
		saveCustomer(hawb.getConsignee());
		hawbDao.saveHAWB(hawb);
		
	}
	
	private void saveCustomer(Customer customer) {
		if(customer != null)
			customerDao.saveCustomer(customer);
	}
}
