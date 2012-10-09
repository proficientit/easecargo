package com.easecargo.awb.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public AWB getAWB(Integer awbPrefix, Integer awbNum) {
		List<AWB> awbList = awbDao.selectAWBByNumber(awbPrefix, awbNum);
		//assuming awbNumber is unique
		if(awbList !=null && awbList.size()>0) {
			return awbList.get(0);	
		} else	return null;
		
	}
	@Override
	public void deleteAWBById(Integer awbId) {
		AWB awb = awbDao.selectAWBById(awbId);
		logger.info("fetched AWB via service "+awb.getAwbNumber());
		awbDao.deleteAWB(awb);		
	}	
	@Override
	public void deleteAWBByNumber(Integer awbPrefix, Integer awbNum) {
		AWB awb = getAWB(awbPrefix, awbNum);
		logger.info("fetched AWB via service "+awb.getAwbNumber());
		awbDao.deleteAWB(awb);		
	}
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
