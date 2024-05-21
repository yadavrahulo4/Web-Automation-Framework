package sm.crm.test;

import org.testng.annotations.Test;

import sm.crm.pages.LoginPage;

/**
 * TestScenario: LoginFunctionality
 */
public class LoginFunctioality extends BaseTest {
	
	/**TestScenario: LoginFunctionality
	 * 
	 * TestCase : Login with valid credentials
	 * 
	 * (TestID : tc001)
	 */
	@Test
	public  void tc_001() {
		// TODO Auto-generated method stub
		LoginPage lp=new LoginPage(utl);
		lp.validlogin();	
	}
	
	

}
