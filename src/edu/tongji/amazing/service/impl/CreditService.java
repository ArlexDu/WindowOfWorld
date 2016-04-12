package edu.tongji.amazing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.ICreditDao;
import edu.tongji.amazing.dao.impl.CreditDao;
import edu.tongji.amazing.model.Credit;
import edu.tongji.amazing.service.ICreditService;
@Service("creditservice")
public class CreditService implements ICreditService {
	
	@Resource(name = "creditdao")
	private CreditDao dao;

	@Override
	public boolean addCredit(Credit credit) {
		// TODO Auto-generated method stub
		return dao.Insert(credit);
	}

	@Override
	public List<Credit> getCreditList(String phone) {
		// TODO Auto-generated method stub
		return dao.QueryByPhone(phone);
	}

}
