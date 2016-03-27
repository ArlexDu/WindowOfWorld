package edu.tongji.amazing.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.IUserDao;
import edu.tongji.amazing.dao.impl.UserDao;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IUserService;

@Service("userservice")
public class UserService implements IUserService{

	@Resource
	private IUserDao userdao;

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return userdao.checkUser(user);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userdao.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userdao.updateUser(user);
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
	public User getUserbyIndentity(long identity) {
		// TODO Auto-generated method stub
		return userdao.getUserbyIndentity(identity);
	}

}
