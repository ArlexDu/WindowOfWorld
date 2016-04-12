package edu.tongji.amazing.dao.impl;

import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.ICreditDao;
import edu.tongji.amazing.model.Credit;

@Repository("creditdao")
public class CreditDao extends GeneralDao<Credit> implements ICreditDao{

	public CreditDao() {
		super(Credit.class);
		// TODO Auto-generated constructor stub
	}

}
