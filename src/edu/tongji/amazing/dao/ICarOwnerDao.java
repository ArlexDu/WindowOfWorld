package edu.tongji.amazing.dao;


import edu.tongji.amazing.model.CarOwner;
/*
 * 车主类的操作
 */
public interface ICarOwnerDao {

	// 检查用户
	public boolean checkUser(String phone,String password);

//	根据手机号查找用户
	public CarOwner getUserbyPhone(String phone);
	
	//更改头像
	public boolean ChangeAvatar(String phone , String path);
	
}
