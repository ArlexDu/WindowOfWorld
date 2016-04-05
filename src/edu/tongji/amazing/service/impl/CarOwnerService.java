package edu.tongji.amazing.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.ICarOwnerDao;
import edu.tongji.amazing.dao.impl.CarOwnerDao;
import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.ICarOwnerService;

@Service("carownerservice")
public class CarOwnerService implements ICarOwnerService{

	@Resource
	private CarOwnerDao userdao;


	@Override
	public void addUser(CarOwner user) {
		// TODO Auto-generated method stub
		userdao.Insert(user);
	}

	@Override
	public void updateUser(CarOwner user) {
		// TODO Auto-generated method stub
		userdao.Update(user);
	}

	@Override
	public boolean RvokeAccount(long identity) {
		// TODO Auto-generated method stub
		return userdao.RvokeAccount(identity);
	}

	@Override
	public boolean ResumeAccount(long identity) {
		// TODO Auto-generated method stub
		return userdao.ResumeAccount(identity);
	}

	@Override
	public CarOwner getUserbyIndentity(String identity) {
		// TODO Auto-generated method stub
		return userdao.getUserbyIndentity(identity);
	}

	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		return userdao.checkUser(username, password);
	}

}
