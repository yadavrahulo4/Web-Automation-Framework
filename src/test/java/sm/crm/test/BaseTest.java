package sm.crm.test;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.Status;

import sm.crm.utility.BrowserType;
import sm.crm.utility.ExtReport;
import sm.crm.utility.Utility;

public class BaseTest {

	private ExtReport rep;
	String testMethName;
	private Utility utl;

	@BeforeSuite
	private void init() {
		// TODO Auto-generated method stub
		rep = new ExtReport();
		rep.generateReport("test");
		rep.createTest("TC_0");

		utl = new Utility();

	}

	@BeforeMethod
	public void bTest(TestResult result) {
		testMethName = result.getName();
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
	private void destory() {
		// TODO Auto-generated method stub
		rep.flush();

		utl.closeResources();
	}

}
