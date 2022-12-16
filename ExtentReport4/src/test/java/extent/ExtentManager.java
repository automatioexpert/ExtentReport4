package extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		
		ExtentHtmlReporter htmlReportReporter = new ExtentHtmlReporter(fileName);
		htmlReportReporter.config().setTheme(Theme.STANDARD);
		htmlReportReporter.config().setDocumentTitle(fileName);
		htmlReportReporter.config().setEncoding("utf-8");
		htmlReportReporter.config().setReportName("utf-8");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReportReporter);
		
		extent.setSystemInfo("Automation Tester", "Mike Smith");
		extent.setSystemInfo("Organization", "Microsoft");
		extent.setSystemInfo("Build No", "ARM-9812");
		
		return extent;

	}
}
