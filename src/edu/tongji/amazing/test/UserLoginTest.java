package edu.tongji.amazing.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.tongji.amazing.model.TestingResult;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.FileTools;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserLoginTest extends AbstractJUnit4SpringContextTests{
	
	@Resource(name="filetool")
	FileTools excel;
	/*
	 * 测试IsUserExist函数
	 */

	@Resource(name="carownerservice")
	private ICarOwnerService iCarOwnerService;
	public boolean UT_TC_001_001(String phone){
		if(iCarOwnerService.IsUserExist(phone)!=null){
			return true;	
		}
		return false;
	}
	@Test
	public void T1_IsUserExist_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			List<String[]> tests;
				tests = excel.readExcel("IsUserExist");
			for(int i=0;i<tests.size();i++){
				TestingResult result = excel.getTestingResult(tests.get(i)[0],String.valueOf(UT_TC_001_001(tests.get(i)[1])),tests.get(i)[2]);
				results.add(result);
			}
			excel.SoftwareTesingResult("IsUserExist", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 测试checkUser函数
	 */
	
	public boolean UT_TC_001_002(String phone,String password){
		if(iCarOwnerService.checkUser(phone,password)){
			return true;	
		}
		return false;
	}
	@Test
	public void T2_checkUser_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			List<String[]> tests;
				tests = excel.readExcel("checkUser");
			for(int i=0;i<tests.size();i++){
				TestingResult result = excel.getTestingResult(tests.get(i)[0],String.valueOf(UT_TC_001_002(tests.get(i)[1],tests.get(i)[2])),tests.get(i)[3]);
				results.add(result);
			}
			excel.SoftwareTesingResult("checkUser", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 测试LoginAndroid函数
	 */
	@Resource(name="actiontest")
	ActionTest action;
	public boolean UT_TC_001_003(String phone,String password){
		if(action.LoginAndroidTest(phone,password)!=null){
			return true;	
		}
		return false;
	}
	@Test
	public void T3_LoginAndroid_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			List<String[]> tests;
				tests = excel.readExcel("LoginAndroid");
			for(int i=0;i<tests.size();i++){
				TestingResult result = excel.getTestingResult(tests.get(i)[0],String.valueOf(UT_TC_001_002(tests.get(i)[1],tests.get(i)[2])),tests.get(i)[3]);
				results.add(result);
			}
			excel.SoftwareTesingResult("LoginAndroid", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
