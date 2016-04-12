package edu.tongji.amazing.service;

import java.util.List;

import edu.tongji.amazing.model.Balance;

public interface IBalanceService {

	public boolean changeBalance(Balance balance);
	
	public List<Balance> getOrderList(String phone);
}
