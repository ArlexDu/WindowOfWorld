package edu.tongji.amazing.dao.impl;

import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IBalanceDao;
import edu.tongji.amazing.model.Balance;
@Repository("balancedao")
public class BalanceDao extends GeneralDao<Balance> implements IBalanceDao{

	public BalanceDao() {
		super(Balance.class);
		// TODO Auto-generated constructor stub
	}

}
