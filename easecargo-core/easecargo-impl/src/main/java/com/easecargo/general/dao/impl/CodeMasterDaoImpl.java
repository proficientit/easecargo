package com.easecargo.general.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.general.CodesMaster;
import com.easecargo.general.dao.CodeMasterDao;

@Repository("CodeMasterDao")
@Transactional
public class CodeMasterDaoImpl implements CodeMasterDao {

	Logger logger = LoggerFactory.getLogger(CodeMasterDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public CodeMasterDaoImpl() {
	}

	@Override
	@Transactional(readOnly = false)
	public void saveCodesMaster(CodesMaster code) {
			sessionFactory.getCurrentSession().saveOrUpdate(code);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCodesMaster(CodesMaster code) {
		sessionFactory.getCurrentSession().delete(code);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CodesMaster> selectAll() {
		logger.info("get All CodesMaster");
		return (List<CodesMaster>) sessionFactory.getCurrentSession()
				.createQuery("from CodesMaster").list();	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CodesMaster> selectAllByType(String codeType) {
		codeType = codeType+"%";
		logger.info("select CodesMaster by Type");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from CodesMaster where codeType like :codeType");
		query.setParameter("codeType", codeType);
		return query.list();	
	}
	@Override
	@SuppressWarnings("unchecked")
	public CodesMaster selectCodesMasterByType(String codeType) {
		logger.info("select CodesMaster by Type");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from CodesMaster where codeType = :codeType");
		query.setParameter("codeType", codeType);
		List<CodesMaster> list = query.list();
		if(list!=null && list.size()>0)
			return list.get(0);
		else return null;
	}
}
