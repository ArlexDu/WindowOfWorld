package edu.tongji.amazing.service;


import edu.tongji.amazing.model.CarOwner;

public interface ICarOwnerService {
	// 检查用户
	public CarOwner checkUser(CarOwner user);

	// 增加用户
	public void addUser(CarOwner user);

	// 更新用户信息
	public void updateUser(CarOwner user);

	// 挂失用户
	public boolean RvokeAccount(long identity);

	// 恢复用户身份
	public boolean ResumeAccount(long identity);

	// 根据身份证查找用户
	public CarOwner getUserbyIndentity(long identity);
}
