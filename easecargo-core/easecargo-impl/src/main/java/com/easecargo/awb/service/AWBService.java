package com.easecargo.awb.service;

import java.util.List;

import com.easecargo.awb.AWB;
import com.easecargo.awb.dao.AWBDao;
import com.easecargo.awb.dao.CustomerDao;
public interface AWBService {
	public void setCustomerDao(CustomerDao dao);
	public void setAWBDao(AWBDao dao);
	public AWB getAWB(Integer id) ;
	public AWB getAWBByIdAndUserId(Integer awbId, Integer userId);
	public List<AWB> getAWBByUserId( Integer userId) ;	
	public AWB getAWBByNumberAndUserId(Integer awbPrefix, Integer awbNum, Integer userId);
	public void deleteAWBById(Integer awbId);
	public void deleteAWBByNumberAndUserId(Integer awbPrefix, Integer awbNum,Integer userId);
	public void saveAWB(AWB awb) ;
} 