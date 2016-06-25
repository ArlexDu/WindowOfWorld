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

import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.TestingResult;
import edu.tongji.amazing.service.IAdministratorService;
import edu.tongji.amazing.service.IBalanceService;
import edu.tongji.amazing.tool.FileTools;
import edu.tongji.amazing.tool.SendMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministorActionTest extends AbstractJUnit4SpringContextTests{
	
	@Resource(name="filetool")
	FileTools excel;
	/*
	 * 测试changeBalance函数
	 */
	@Resource(name="administratorservice")
	private IAdministratorService service;
	
	public boolean UT_TC_005_001(String phone,String status) throws Exception{
		if(service.changeUserStatus(phone, status)){
			return true;
		}
		return false;
	}
	
	@Test
	public void T1_changeUserStatus_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			List<String[]> tests;
				tests = excel.readExcel("changeUserStatus");
			for(int i=0;i<tests.size();i++){
				TestingResult result = excel.getTestingResult(tests.get(i)[0],String.valueOf(UT_TC_005_001(tests.get(i)[1],tests.get(i)[2])),tests.get(i)[3]);
				results.add(result);
			}
			excel.SoftwareTesingResult("changeUserStatus", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 测试SendUserExamineResult 函数
	 */
	@Resource(name = "sendmessage")
	private SendMessage sendmessage;
	public boolean UT_TC_005_002(String phone,String status,String userclass) throws Exception{
		if(sendmessage.SendUserExamineResult(phone, status, userclass)){
			return true;
		}
		return false;
	}
	@Test
	public void T2_SendUserExamineResult_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			List<String[]> tests;
				tests = excel.readExcel("SendUserExamineResult");
			for(int i=0;i<tests.size();i++){
				TestingResult result = excel.getTestingResult(tests.get(i)[0],String.valueOf(UT_TC_005_002(tests.get(i)[1],tests.get(i)[2],tests.get(i)[3])),tests.get(i)[4]);
				results.add(result);
			}
			excel.SoftwareTesingResult("SendUserExamineResult", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 测试examineUser函数
	 */
	@Resource(name="actiontest")
	ActionTest action;
	
	public boolean UT_TC_005_003(String phone,String status,String userclass) throws Exception{
		if(action.examineUser(phone, status, userclass)!=null){
			return true;
		}
		return false;
	}
	
	@Test
	public void T3_examineUser_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			List<String[]> tests;
				tests = excel.readExcel("examineUser");
			for(int i=0;i<tests.size();i++){
				TestingResult result = excel.getTestingResult(tests.get(i)[0],String.valueOf(UT_TC_005_002(tests.get(i)[1],tests.get(i)[2],tests.get(i)[3])),tests.get(i)[4]);
				results.add(result);
			}
			excel.SoftwareTesingResult("examineUser", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}