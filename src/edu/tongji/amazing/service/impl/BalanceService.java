package edu.tongji.amazing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.impl.BalanceDao;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.service.IBalanceService;
@Service("balanceservice")
public class BalanceService implements IBalanceService{

	@Resource(name = "balancedao")
	private BalanceDao dao;
	@Override
	public boolean changeBalance(Balance balance) {
		// TODO Auto-generated method stub
		if(balance == null){
			return false;
		}
		if(balance.getMoney().equals("")||balance.getPhone().equals("")||balance.getReason().equals("")){
			return false;
		}
		if(balance.getMoney()== null||balance.getPhone()== null||balance.getReason()== null){
			return false;
		}
		return dao.Insert(balance);
	}

	@Override
	public List<Balance> getOrderList(String phone) {
		// TODO Auto-generated method stub
		return dao.QueryBalanceByPhone(phone);
	}

}
