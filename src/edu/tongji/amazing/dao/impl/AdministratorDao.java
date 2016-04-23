package edu.tongji.amazing.dao.impl;

import org.springframework.stereotype.Repository;

import edu.tongji.amazing.model.User;
@Repository("administratordao")
public class AdministratorDao extends GeneralDao<User>{

	public AdministratorDao() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}

}
