package sm.crm.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.Status;

import sm.crm.utility.BrowserType;
import sm.crm.utility.ExtReport;
import sm.crm.utility.Utility;

public class BaseTest {

	private ExtReport rep;
	private String testMethName;
	protected Utility utl;

	@BeforeSuite
	public void init() {
		// TODO Auto-generated method stub
		rep = new ExtReport();
		rep.generateReport("test");
		rep.createTest("TC_0");

		utl = new Utility(rep.extTest);

	}

	@BeforeMethod
	public void bTest(Method met) {
		testMethName = met.getName();
		System.out.println(testMethName);
		rep.createTest(testMethName);

		utl.getBrowser(BrowserType.Chrome);

	}

	@AfterMethod
	public void aTest(ITestResult iresult) {
		if (iresult.isSuccess()) {
			rep.extTest.log(Status.PASS, testMethName + " passed Sucessfully!");
		} else
			rep.extTest.log(Status.FAIL, testMethName + " Failed !!");
	}

	@AfterSuite
	public void destory() {
		// TODO Auto-generated method stub
		rep.flush();

		utl.closeResources();
	}

}
