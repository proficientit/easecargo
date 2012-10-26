package com.easecargo.general.service;

import java.util.List;

import com.easecargo.general.CodesMaster;

public interface CodeMasterService {

	public void saveCodesMaster(CodesMaster code);
	public void deleteCodesMaster(CodesMaster code);
	public List<CodesMaster> getAll();
	/**
	 * codeType like "codeType"
	 * 
	 * @param codeType
	 * @return
	 */
	public List<CodesMaster> getAllByType(String codeType);
	public CodesMaster getCodesMasterByType(String codeType);
	
}
