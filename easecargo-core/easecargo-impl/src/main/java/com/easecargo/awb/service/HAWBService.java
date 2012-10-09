package com.easecargo.awb.service;

import com.easecargo.awb.HAWB;
public interface HAWBService{
	public HAWB getHAWB(Integer id);	
	public HAWB getHAWB(String hawbNum) ;
	public void deleteHAWBById(Integer hawbId) ;
	public void deleteHAWBByNumber(String hawbNum);
	public void saveHAWB(HAWB hawb);
}
