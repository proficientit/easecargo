package com.easecargo.awb.service;

import java.util.List;

import com.easecargo.awb.AWB;
import com.easecargo.awb.dao.AWBDao;
import com.easecargo.awb.dao.CustomerDao;
public interface AWBService {
	public void setCustomerDao(CustomerDao dao);
	public void setAWBDao(AWBDao dao);
	public AWB getAWB(Integer id) ;
	public void deleteAWBById(Integer awbId);
	public void saveAWB(AWB awb) ;
	
	public AWB getAWBByIdAndUserId(Integer awbId, Integer userId);
	public List<AWB> getAllAWBByUserId( Integer userId) ;	
	public AWB getAWBByNumberAndUserId(Integer awbPrefix, Integer awbNum, Integer userId);
	public void deleteAWBByNumberAndUserId(Integer awbPrefix, Integer awbNum,Integer userId);
	/**
	 * userId is mandatory
	 * other params can be provided bsaed on availability
	 * all search on equals
	 * 
	 * @param shipperName
	 * @param consigneeName
	 * @param awbPrefix
	 * @param awbNum
	 * @param userId
	 * @return
	 */
	public List<AWB> searchAWB(String shipperName, String consigneeName,Integer awbPrefix, Integer awbNum, Integer userId) ;
} 