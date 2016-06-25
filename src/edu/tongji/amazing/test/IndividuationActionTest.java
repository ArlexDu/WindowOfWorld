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

import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.TestingResult;
import edu.tongji.amazing.service.IBalanceService;
import edu.tongji.amazing.tool.FileTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IndividuationActionTest extends AbstractJUnit4SpringContextTests{
	
	@Resource(name="filetool")
	FileTools excel;
	/*
	 * 测试changeBalance函数
	 */
	@Resource(name = "balanceservice")
	private IBalanceService service;
	
	public boolean UT_TC_003_001_001(Balance balance){
		if(service.changeBalance(balance)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_003_001_002_001(Balance balance){
		if(service.changeBalance(balance)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_003_001_002_002(Balance balance){
		if(service.changeBalance(balance)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_003_001_002_003(Balance balance){
		if(service.changeBalance(balance)){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_003_001_003(Balance balance){
		if(service.changeBalance(balance)){
			return true;
		}
		return false;
	}
	
	@Test
	public void T1_changeBalance_Test(){
		Balance balance = new Balance();
		balance.setMoney("");
		balance.setPhone("15021799675");
		balance.setReason("充值");
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1 = excel.getTestingResult("UT_TC_003_001_001",String.valueOf(UT_TC_003_001_001(null)),"false");
		results.add(result1);
		TestingResult result2_1 = excel.getTestingResult("UT_TC_003_001_002_001",String.valueOf(UT_TC_003_001_002_001(balance)),"false");
		results.add(result2_1);
		balance.setMoney("100");
		balance.setPhone("");
		balance.setReason("充值");
		TestingResult result2_2 = excel.getTestingResult("UT_TC_003_001_002_002",String.valueOf(UT_TC_003_001_002_002(balance)),"false");
		results.add(result2_2);
		balance.setMoney("100");
		balance.setPhone("15021799675");
		balance.setReason("");
		TestingResult result2_3 = excel.getTestingResult("UT_TC_003_001_002_003",String.valueOf(UT_TC_003_001_002_003(balance)),"false");
		results.add(result2_3);
		balance.setMoney("100");
		balance.setPhone("15021799675");
		balance.setReason("充值");
		TestingResult result3 = excel.getTestingResult("UT_TC_003_001_003",String.valueOf(UT_TC_003_001_003(balance)),"true");
		results.add(result3);
		excel.SoftwareTesingResult("changeBalance", results);
	}
	
	/*
	 * 测试Changebill函数
	 */
	@Resource(name="actiontest")
	ActionTest action;
	public boolean UT_TC_003_002_001_001() throws Exception{
		if(action.Changebill("100", "", "充值")!=null){
			return true;
		}
		return false;
	}
	public boolean UT_TC_003_002_001_002() throws Exception{
		if(action.Changebill("", "15021799675", "充值")!=null){
			return true;
		}
		return false;
	}
	public boolean UT_TC_003_002_001_003() throws Exception{
		if(action.Changebill("100", "15021799675", "")!=null){
			return true;
		}
		return false;
	}
	public boolean UT_TC_003_002_002() throws Exception{
		if(action.Changebill("100", "15012349675", "充值")!=null){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_003_002_003_001() throws Exception{
		if(action.Changebill("100", "150abcd9675", "充值")!=null){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_003_002_003_002() throws Exception{
		if(action.Changebill("100sdf", "15021799675", "充值")!=null){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_003_002_004() throws Exception{
		if(action.Changebill("100", "15096759675", "充值")!=null){
			return true;
		}
		return false;
	}
	
	@Test
	public void T2_Changebill_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1_1 = excel.getTestingResult("UT_TC_003_001_001",String.valueOf(UT_TC_003_002_001_001()),"false");
			results.add(result1_1);
			TestingResult result1_2 = excel.getTestingResult("UT_TC_003_001_002",String.valueOf(UT_TC_003_002_001_002()),"false");
			results.add(result1_2);
			TestingResult result1_3 = excel.getTestingResult("UT_TC_003_001_003",String.valueOf(UT_TC_003_002_001_003()),"false");
			results.add(result1_3);
			TestingResult result2 = excel.getTestingResult("UT_TC_003_002",String.valueOf(UT_TC_003_002_002()),"false");
			results.add(result2);
			TestingResult result3_1 = excel.getTestingResult("UT_TC_003_003_001",String.valueOf(UT_TC_003_002_003_001()),"false");
			results.add(result3_1);
			TestingResult result3_2 = excel.getTestingResult("UT_TC_003_003_002",String.valueOf(UT_TC_003_002_003_002()),"false");
			results.add(result3_2);
			TestingResult result3_3 = excel.getTestingResult("UT_TC_003_003_003",String.valueOf(UT_TC_003_002_004()),"true");
			results.add(result3_3);
			excel.SoftwareTesingResult("Changebill", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}