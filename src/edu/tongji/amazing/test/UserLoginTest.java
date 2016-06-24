package edu.tongji.amazing.test;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.tongji.amazing.action.ActionTest;
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
	public boolean UT_TC_001_001_001(){
		if(iCarOwnerService.IsUserExist("")!=null){
			return true;	
		}
		return false;
	}
	public boolean UT_TC_001_001_002(){
		if(iCarOwnerService.IsUserExist("150abcd9675")!=null){
			return true;	
		}
		return false;
	}
	public boolean UT_TC_001_001_003(){
		if(iCarOwnerService.IsUserExist("15021799675")!=null){
			return true;	
		}
		return false;
	}
	@Test
	public void T1_IsUserExist_Test(){
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1 = excel.getTestingResult("UT_TC_001_001_001",String.valueOf(UT_TC_001_001_001()),"false");
		results.add(result1);
		TestingResult result2 = excel.getTestingResult("UT_TC_001_001_002",String.valueOf(UT_TC_001_001_002()),"false");
		results.add(result2);
		TestingResult result3 = excel.getTestingResult("UT_TC_001_001_003",String.valueOf(UT_TC_001_001_003()),"true");
		results.add(result3);
		excel.SoftwareTesingResult("IsUserExist", results);
	}
	
	/*
	 * 测试checkUser函数
	 */
	
	public boolean UT_TC_001_002_001(){
		if(iCarOwnerService.checkUser("150217799675","941225")){
			return true;	
		}
		return false;
	}
	
	public boolean UT_TC_001_002_002(){
		if(iCarOwnerService.checkUser("150217799675","dsy941225")){
			return true;	
		}
		return false;
	}
	@Test
	public void T2_checkUser_Test(){
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1 = excel.getTestingResult("UT_TC_001_002_001",String.valueOf(UT_TC_001_002_001()),"false");
		results.add(result1);
		TestingResult result2 = excel.getTestingResult("UT_TC_001_002_002",String.valueOf(UT_TC_001_002_002()),"true");
		results.add(result2);
		excel.SoftwareTesingResult("checkUser", results);
	}
	
	/*
	 * 测试LoginAndroid函数
	 */
	@Resource(name="actiontest")
	ActionTest action;
	public boolean UT_TC_001_003_001_001(){
		if(action.LoginAndroidTest("","28850169")!=null){
			return true;	
		}
		return false;
	}
	public boolean UT_TC_001_003_001_002(){
		if(action.LoginAndroidTest("15021799675","")!=null){
			return true;	
		}
		return false;
	}
	public boolean UT_TC_001_003_002(){
		if(action.LoginAndroidTest("15012349675","2885")!=null){
			return true;	
		}
		return false;
	}
	
	public boolean UT_TC_001_003_003(){
		if(action.LoginAndroidTest("150abcd9675","28850169")!=null){
			return true;	
		}
		return false;
	}
	
	public boolean UT_TC_001_003_004(){
		if(action.LoginAndroidTest("15021799675","dsy941225")!=null){
			return true;	
		}
		return false;
	}
	@Test
	public void T3_LoginAndroid(){
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1_1 = excel.getTestingResult("UT_TC_001_003_001_001",String.valueOf(UT_TC_001_003_001_001()),"false");
		results.add(result1_1);
		TestingResult result1_2 = excel.getTestingResult("UT_TC_001_003_001_002",String.valueOf(UT_TC_001_003_001_002()),"false");
		results.add(result1_2);
		TestingResult result2 = excel.getTestingResult("UT_TC_001_003_002",String.valueOf(UT_TC_001_003_002()),"false");
		results.add(result2);
		TestingResult result3 = excel.getTestingResult("UT_TC_001_003_003",String.valueOf(UT_TC_001_003_003()),"false");
		results.add(result3);
		TestingResult result4 = excel.getTestingResult("UT_TC_001_003_004",String.valueOf(UT_TC_001_003_004()),"true");
		results.add(result4);
		excel.SoftwareTesingResult("checkUser", results);
	}
}
