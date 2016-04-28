package edu.tongji.amazing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.impl.AdministratorDao;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdministratorService;
@Service("administratorservice")
public class AdministratorService implements IAdministratorService{

	@Resource
	private AdministratorDao dao;
	@Override
	public boolean addAdministrator(User user) {
		// TODO Auto-generated method stub
		return dao.Insert(user);
	}
	@Override
	public int getalladvertisements() throws Exception {
		// TODO Auto-generated method stub
		return dao.getalladvertisements();
	}
	@Override
	public int getallusers() throws Exception {
		// TODO Auto-generated method stub
		return dao.getallusers();
	}
	@Override
	public int unexamineUsers() throws Exception {
		// TODO Auto-generated method stub
		return dao.unexamineUsers();
	}
	@Override
	public int unexamineAdvertisements() throws Exception {
		// TODO Auto-generated method stub
		return dao.unexamineAdvertisement();
	}
	@Override
	public List<User> getShowUsers() throws Exception {
		// TODO Auto-generated method stub
		return dao.getShowUsers();
	}
	@Override
	public List<Advertisement> getShowAdvertisements() throws Exception {
		// TODO Auto-generated method stub
		return dao.getShowAdvertisement();
	}
	@Override
	public List<Balance> getShowBalance() throws Exception {
		// TODO Auto-generated method stub
		return dao.getShowBalance();
	}
	@Override
	public boolean login(String phone, String password) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(phone, password);
	}

}
