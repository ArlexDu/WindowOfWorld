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
	public void ChangeAvatar(String phone , String path);
	
	//设备号和用户对应
	public void setproductId(String phone , String channelid);
	
	//通过用户手机获得设备号
	public String getProduct(String phone);
}
