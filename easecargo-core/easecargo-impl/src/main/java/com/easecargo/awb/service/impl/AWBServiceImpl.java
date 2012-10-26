package com.easecargo.awb.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.awb.*;
import com.easecargo.awb.dao.*;
import com.easecargo.awb.service.AWBService;

@Service("AWBService")
public class AWBServiceImpl implements AWBService {
	Logger logger = LoggerFactory.getLogger(AWBServiceImpl.class);
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private AWBDao awbDao;

	public void setCustomerDao(CustomerDao dao) {
		this.customerDao = dao;
	}

	@Override
	public void setAWBDao(AWBDao dao) {
		this.awbDao = dao;
	}
	@Override	
	public AWB getAWB(Integer id) {
		return awbDao.selectAWBById(id);
	}
	@Override
	public List<AWB> getAllAWBByUserId( Integer userId) {
		return awbDao.selectAllAWBByUserId(userId);
	}
	
	@Override	
	public AWB getAWBByIdAndUserId(Integer awbId, Integer userId) {
		return awbDao.selectAWBByIdAndUserId(awbId, userId);
	}
	@Override
	public AWB getAWBByNumberAndUserId(Integer awbPrefix, Integer awbNum, Integer userId) {
		return awbDao.selectAWBByNumberAndUserId(awbPrefix, awbNum, userId);

	}
	@Override
	@Transactional(readOnly = false)
	public void deleteAWBById(Integer awbId) {
		AWB awb = awbDao.selectAWBById(awbId);
		logger.info("fetched AWB via service "+awb.getAwbNumber());
		awbDao.deleteAWB(awb);		
	}	
	@Transactional(readOnly = false)
	@Override
	public void deleteAWBByNumberAndUserId(Integer awbPrefix, Integer awbNum, Integer userId) {
		AWB awb = getAWBByNumberAndUserId(awbPrefix, awbNum, userId);
		logger.info("fetched AWB via service "+awb.getAwbNumber());
		awbDao.deleteAWB(awb);		
	}
	@Override
	public List<AWB> searchAWB(String shipperName, String consigneeName,Integer awbPrefix, Integer awbNum, Integer userId){
		return awbDao.searchAWB(shipperName, consigneeName, awbPrefix, awbNum, userId);
	}
	
	
	@Transactional(readOnly = false)
	@Override
	public void saveAWB(AWB awb) {
		//right now customer doesnt have its own existence. hence deleting.
		//need to revisit once user management is done
		saveCustomer(awb.getAgent());
		saveCustomer(awb.getShipper());
		saveCustomer(awb.getConsignee());
		saveCustomer(awb.getOtherParty());
		awbDao.saveAWB(awb);
		
	}
	
	private void saveCustomer(Customer customer) {
		if(customer != null)
			customerDao.saveCustomer(customer);
	}
	
}
