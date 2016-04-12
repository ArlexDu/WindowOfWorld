package edu.tongji.amazing.dao;

import java.util.List;

/*
 * 关于一些共同操作的泛型类
 */
public interface IGeneralDao<T> {

	// 显示所有当前类，例如显示当前用户的所有的个性化show
	List<T> QueryByPhone(String Phone);

	// 通过id获得对象的具体信息
	T QueryById(String id);

	// 新添加一项数据
	boolean Insert(T t);

	// 通过id删除数据
	boolean DeleteViaId(String id);

	//通过identity删除数据
	boolean DeleteViaPhone(String Phone);
	// 更新数据
	boolean Update(T t);
}
