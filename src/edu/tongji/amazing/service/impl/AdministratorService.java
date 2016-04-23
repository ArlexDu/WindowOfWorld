package edu.tongji.amazing.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.impl.AdministratorDao;
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

}
