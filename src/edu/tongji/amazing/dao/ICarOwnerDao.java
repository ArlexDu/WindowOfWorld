package edu.tongji.amazing.dao;


import edu.tongji.amazing.model.CarOwner;
/*
 * 车主类的操作
 */
public interface ICarOwnerDao {

	// 检查用户
	public CarOwner checkUser(CarOwner user);

	// 挂失用户
	public boolean RvokeAccount(long identity);

	// 恢复用户身份
	public boolean ResumeAccount(long identity);

	// 根据身份证查找用户
	public CarOwner getUserbyIndentity(long identity);
	
	public void Disconnect();
}
