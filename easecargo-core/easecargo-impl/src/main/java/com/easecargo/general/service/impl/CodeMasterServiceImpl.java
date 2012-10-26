package com.easecargo.general.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.general.CodesMaster;
import com.easecargo.general.dao.CodeMasterDao;
import com.easecargo.general.service.CodeMasterService;


@Service("CodeMasterService")
public class CodeMasterServiceImpl implements CodeMasterService {
	Logger logger = LoggerFactory.getLogger(CodeMasterServiceImpl.class);
	@Autowired
	CodeMasterDao codeMasterDao;
	
	public CodeMasterServiceImpl() {
	}

	@Override
	@Transactional
	public void saveCodesMaster(CodesMaster code) {
		codeMasterDao.saveCodesMaster(code);
	}

	@Override
	@Transactional
	public void deleteCodesMaster(CodesMaster code) {
		codeMasterDao.deleteCodesMaster(code);
	}

	@Override
	public List<CodesMaster> getAll() {
		return codeMasterDao.selectAll();
	}

	@Override
	public List<CodesMaster> getAllByType(String codeType) {
		return codeMasterDao.selectAllByType(codeType);
	}
	public CodesMaster getCodesMasterByType(String codeType) {
		return codeMasterDao.selectCodesMasterByType(codeType);
	}

}
