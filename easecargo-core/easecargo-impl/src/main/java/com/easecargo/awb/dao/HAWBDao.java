package com.easecargo.awb.dao;

import java.util.List;

import com.easecargo.awb.HAWB;


public interface HAWBDao  {
	public void saveHAWB(HAWB hawb) ;
	public void deleteHAWB(HAWB hawb);
	public List<HAWB> getAllHAWBs() ;
	public HAWB selectHAWBById(Integer hawbId) ;
	public HAWB selectHAWBByNumberAndUserId(String hawbNum, Integer userId) ;
	public HAWB selectHAWBByAWBPrefixAndNumberAndUserID(Integer awbPrefix, Integer awbNumber, Integer userId);
	
}
