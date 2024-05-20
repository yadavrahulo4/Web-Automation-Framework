package sm.crm.utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Utility {
	
	private WebDriver driver;
	private ExtentTest exTest;
	private FileReader fileReader;

	public void getBrowser(BrowserType bt) {
		try {
			switch (bt) {
			case Chrome :
				driver = new ChromeDriver();
				break;
			case Edge :
				driver = new EdgeDriver();
				break;
			case Firefox :
				driver = new FirefoxDriver();
				break;
			default:
				exTest.log(Status.WARNING, "Invalid Browser Type");
				break;
			}
			if (driver!=null) {
				exTest.log(Status.INFO, bt+" Browser launched sucessfully!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			exTest.log(Status.FAIL,"unable to launch "+ bt+" Browser!");
		}
	}
	public void getURL() {
		// TODO Auto-generated method stub
		try {
			driver.get(fileReader.getProperty("url"));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
		
	public void closeResources() {
		// TODO Auto-generated method stub
		

	}
	
	public static void main(String[] args) {
		new Utility().getBrowser(BrowserType.Opera);
	}
	

}
