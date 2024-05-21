package sm.crm.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Utility {

	private WebDriver driver;
	private ExtentTest exTest;
	private FileReader fileReader;
	public Utility(ExtentTest exTest) {
		// TODO Auto-generated constructor stub
		this.exTest =exTest;
	}

	public void getBrowser(BrowserType bt) {
		try {
			switch (bt) {
			case Chrome:
				driver = new ChromeDriver();
				break;
			case Edge:
				driver = new EdgeDriver();
				break;
			case Firefox:
				driver = new FirefoxDriver();
				break;
			default:
				exTest.log(Status.WARNING, "Invalid Browser Type");
				break;
			}
			if (driver != null) {
				exTest.log(Status.INFO, bt + " Browser launched sucessfully!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			exTest.log(Status.FAIL, "unable to launch " + bt + " Browser!");
		}
	}

	public void getURL() {
		// TODO Auto-generated method stub
		try {
			String url = FileReader.get("url");
			driver.get(url);

			if (validateURL(url))
				exTest.log(Status.INFO, "url<" + url + ">  hitted  sucessfully");
			else
				exTest.log(Status.FAIL, "while hitting url<" + url + "> problem occured.. ");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private boolean validateURL(String url) {
		// TODO Auto-generated method stub
		try {
			if (url.equalsIgnoreCase(driver.getCurrentUrl()))
				;
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void closeResources() {
		// TODO Auto-generated method stub

	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	public void sendkey(WebElement we, String text, String elementName) {
		// TODO Auto-generated method stub
		try {
			we.sendKeys(text);
			exTest.log(Status.INFO, MarkupHelper.createLabel("typed <"+text+"> Sucessfully on "+elementName , ExtentColor.BLUE));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}public void click(WebElement we ,String elementName) {
		// TODO Auto-generated method stub
		try {
			we.click();
			exTest.log(Status.INFO, MarkupHelper.createLabel("clicked Sucessfully on"+elementName , ExtentColor.BLUE));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
