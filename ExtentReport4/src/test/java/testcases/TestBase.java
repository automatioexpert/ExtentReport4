package testcases;

import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extent.ExtentManager;

public class TestBase {
	//public static ExtentReports extent;
	
	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	public static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	

	@BeforeSuite
	public void setUp() {
		
	System.out.println("setUp started");

		
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("setUp completed");

	}

}
