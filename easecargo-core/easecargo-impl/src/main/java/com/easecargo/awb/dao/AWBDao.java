package com.easecargo.awb.dao;

import java.util.List;

import com.easecargo.awb.AWB;


public interface AWBDao {
	public void saveAWB(AWB awb);
	public void deleteAWB(AWB awb);

	public List<AWB> getAllAWBs();

	public AWB selectAWBById(Integer awbId);
	public AWB selectAWBByNumberAndUserId(Integer awbPrefix, Integer awbNum,Integer userId);
	public AWB selectAWBByNumber(Integer awbPrefix, Integer awbNum);
	public AWB selectAWBByIdAndUserId(Integer awbId, Integer userId) ;
	public List<AWB> selectAWBByUserId( Integer userId) ;
	
}
