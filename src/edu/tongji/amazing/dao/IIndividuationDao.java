package edu.tongji.amazing.dao;

public interface IIndividuationDao {
	
	//设置弹幕的快捷键
	public boolean setShortCut(String id,String key);
	
	//清空对应弹幕的key
	public boolean clearShortCut(String phone,String key);
	
    //查看当前快捷键是否有了设置
	public String CheckShortCut(String phone,String key);
	
	//改变当前的个性化图片的状态
	public boolean ChangeStatus(String id,String status);
}
