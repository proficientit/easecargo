package com.easecargo.awb.dao;

import java.util.List;

import com.easecargo.awb.AWB;


public interface AWBDao {
	public void saveAWB(AWB awb);
	public void deleteAWB(AWB awb);

	public List<AWB> getAllAWBs();

	public AWB selectAWBById(Integer awbId);

	public List<AWB> selectAWBByNumber(Integer awbPrefix, Integer awbNum);
}
