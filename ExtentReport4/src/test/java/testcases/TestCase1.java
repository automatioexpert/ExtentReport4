package testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCase1 {

//Below are 3 important classes used for extent report
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setUpReport() {
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("OLM Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Steve Smith");
		extent.setSystemInfo("Organisation", "Google");
		extent.setSystemInfo("Build No", "ARM-9812");
		// extent.setSystemInfo("Automation Tester", "Steve Smith");

	}

	// Required for flushing the report
	@AfterTest
	public void endReport() {
		extent.flush();
	}

	/*
	 * PASS , FAIL , SKIP
	 * 
	 * Based on pass,fail, skip we can log report in extent report
	 * 
	 */

	@Test
	public void doUserReg() {
		test = extent.createTest("doUserReg Test");
		System.out.println("Executing doUserReg Test");
		Assert.fail("User registration failed");
	}

	@Test
	public void doLogin() {
		test = extent.createTest("Login Test");
		System.out.println("Executing Login Test");
	}

	@Test
	public void isSkip() {
		test = extent.createTest("Skip Test");
		throw new SkipException("Skipping this test");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

		} else if (result.getStatus() == ITestResult.SKIP) {

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			// Markup m= MarkupHelper.createLabel(text, ExtentColor.GREEN);

		}

	}

}
