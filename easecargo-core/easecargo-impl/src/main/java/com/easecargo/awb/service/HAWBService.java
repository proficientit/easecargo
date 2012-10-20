package com.easecargo.awb.service;

import com.easecargo.awb.HAWB;
public interface HAWBService{
	public HAWB getHAWB(Integer id);	
	public void deleteHAWBById(Integer hawbId) ;
	public void saveHAWB(HAWB hawb);
	public HAWB getHAWBByAWBPrefixAndNumberAndUserID(Integer awbPrefix, Integer awbNumber, Integer userId);
	public HAWB getHAWBByNumberAndUserId(String hawbNum, Integer userId) ;
	public void deleteHAWBByNumberAndUserId(String hawbNum,Integer userId);
	public void deleteHAWBByAWBPrefixAndNumberAndUserID(Integer awbPrefix, Integer awbNumber,Integer userId);
	
}
