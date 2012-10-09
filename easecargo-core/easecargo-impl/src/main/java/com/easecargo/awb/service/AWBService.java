package com.easecargo.awb.service;

import com.easecargo.awb.AWB;
import com.easecargo.awb.dao.AWBDao;
import com.easecargo.awb.dao.CustomerDao;
public interface AWBService {
	public void setCustomerDao(CustomerDao dao);
	public void setAWBDao(AWBDao dao);
	public AWB getAWB(Integer id) ;
	public AWB getAWB(Integer awbPrefix, Integer awbNum);
	public void deleteAWBById(Integer awbId);
	public void deleteAWBByNumber(Integer awbPrefix, Integer awbNum);
	public void saveAWB(AWB awb) ;
} 