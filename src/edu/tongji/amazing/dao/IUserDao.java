package edu.tongji.amazing.dao;

import org.springframework.stereotype.Repository;

import edu.tongji.amazing.model.User;

public interface IUserDao {

	// 检查用户
	public User checkUser(User user);

	// 增加用户
	public boolean addUser(User user);

	// 更新用户信息
	public boolean updateUser(User user);

	// 挂失用户
	public boolean RvokeAccount(long identity);

	// 恢复用户身份
	public boolean ResumeAccount(long identity);

	// 根据身份证查找用户
	public User getUserbyIndentity(long identity);
	
	public void Disconnect();
}
