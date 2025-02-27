package shashankframeworkdesigns.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GetExtentReports {

	public static ExtentReports getreport() {
		
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter extreport = new ExtentSparkReporter(path);
		extreport.config().setReportName("Web automation results");
		extreport.config().setDocumentTitle("test results");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(extreport);
		report.setSystemInfo("Tester", "Shashank");
		return report;
		
		
	}

}
