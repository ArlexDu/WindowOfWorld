package edu.tongji.amazing.dao;

import java.util.List;

import edu.tongji.amazing.model.User;

/*
 * 关于一些共同操作的泛型类
 */
public interface IGeneralDao<T> {

	// 显示所有当前类，例如显示当前用户的所有的个性化show
	public List<T> QueryByPhone(String Phone);

	// 通过id获得对象的具体信息
	public T QueryById(String id);

	// 新添加一项数据
	public boolean Insert(T t);

	// 通过id删除数据
	public boolean DeleteViaId(String id);

	//通过identity删除数据
	public boolean DeleteViaPhone(String Phone);
	// 更新数据
	public boolean Update(T t);
	
	//得到当前的数量
	public int GetNumbers(String phone);
	
	//得到最近的一条记录
	public T GetLast(String phone); 
	
	public User IsUserExist(String phone);
	
	//得到最近的一条记录
	public String GetUsernameByPhone(String phone) throws Exception; 
	
}
