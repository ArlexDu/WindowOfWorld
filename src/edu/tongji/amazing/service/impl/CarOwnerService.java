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
	public boolean addUser(CarOwner user) {
		// TODO Auto-generated method stub
		return userdao.Insert(user);
	}

	@Override
	public boolean updateUser(CarOwner user) {
		// TODO Auto-generated method stub
		return userdao.Update(user);
	}

	@Override
	public CarOwner getUserbyPhone(String phone) {
		// TODO Auto-generated method stub
		return userdao.getUserbyPhone(phone);
	}

	@Override
	public boolean checkUser(String phone, String password) {
		// TODO Auto-generated method stub
		return userdao.checkUser(phone, password);
	}

	@Override
	public boolean checkUserExist(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeavatar(String phone, String path) {
		// TODO Auto-generated method stub
		return userdao.ChangeAvatar(phone, path);
	}
	
}
