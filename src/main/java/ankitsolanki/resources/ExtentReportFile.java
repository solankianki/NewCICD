package ankitsolanki.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportFile {
	
	public static ExtentReports getReportObject()
	{
		ExtentSparkReporter sparker = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\index.html");
		sparker.config().setReportName("Automation");
		sparker.config().setDocumentTitle("Test Results");
		ExtentReports report = new ExtentReports();
		report.attachReporter(sparker);
		report.setSystemInfo("TestReport", "Ankit Solanki");
		return report;
	}

}
