package sm.crm.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtReport {
	private ExtentReports ExtRe;
	public ExtentTest extTest;

	public ExtReport() {
		// TODO Auto-generated constructor stub
	}

	public void generateReport(String FileName) {
		try {
			ExtentSparkReporter spark = new ExtentSparkReporter(new File(FileName + ".html"));
			ExtRe = new ExtentReports();
			ExtRe.attachReporter(spark);
			System.out.println("Report initialized");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createTest(String testName) {
		extTest = ExtRe.createTest(testName);
	}

	public void flush() {
		try {
			ExtRe.flush();
			System.out.println("Report generated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
