package sm.crm.pages;

import sm.crm.or.LoginOR;
import sm.crm.utility.FileReader;
import sm.crm.utility.Utility;

public class LoginPage extends LoginOR {

	private Utility utl;

	public LoginPage(Utility utl) {
		super(utl.getDriver());
		this.utl = utl;
	}
	/**To try log into crm-Application using given credentials
	 * @param userName
	 * @param password
	 */
	public void login(String userName,String password) {
		// TODO Auto-generated method stub
		utl.getURL();
		utl.sendkey(userNameTB,userName,"user-Name Text-Box");
		utl.sendkey(passwordTB, password,"password Text-Box");
		utl.click(LoginBT," Login Button.");

	}

	/**
	 * sends Valid credentials & clicks login  Button
	 */
	public void validlogin() {
		// TODO Auto-generated method stub
		login(FileReader.get("username"),FileReader.get("password"));
	}
	

}
