package com.easecargo.awb.dao;

import java.util.List;

import com.easecargo.awb.AWB;


public interface AWBDao {
	public void saveAWB(AWB awb);
	public void deleteAWB(AWB awb);
	public AWB selectAWBById(Integer awbId);
	public List<AWB> getAllAWBs();


	public AWB selectAWBByNumberAndUserId(Integer awbPrefix, Integer awbNum,Integer userId);
	public AWB selectAWBByNumber(Integer awbPrefix, Integer awbNum);
	public AWB selectAWBByIdAndUserId(Integer awbId, Integer userId) ;
	public List<AWB> selectAllAWBByUserId( Integer userId) ;
	
	public List<AWB> searchAWB(String shipperName, String consigneeName,Integer awbPrefix, Integer awbNum, Integer userId) ;
	
}
