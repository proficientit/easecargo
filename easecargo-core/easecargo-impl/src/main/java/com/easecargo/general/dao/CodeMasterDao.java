package com.easecargo.general.dao;

import java.util.List;

import com.easecargo.general.CodesMaster;

public interface CodeMasterDao {

	public void saveCodesMaster(CodesMaster code);
	public void deleteCodesMaster(CodesMaster code);
	public List<CodesMaster> selectAll();
	public List<CodesMaster> selectAllByType(String codeType);
	public CodesMaster selectCodesMasterByType(String codeType) ;
}
