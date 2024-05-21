package sm.crm.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOR {
	protected LoginOR(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "user_name")
	protected WebElement userNameTB;
	
	@FindBy(name = "user_password")
	protected WebElement passwordTB;
	
	@FindBy(name = "Login")
	protected WebElement LoginBT;
}
