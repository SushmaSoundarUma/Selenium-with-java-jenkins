package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports report;
	public ExtentTest test;

	String reportName;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		reportName = "TestNG_ExtentReport"+timeStamp+".html";

		String filepath = System.getProperty("user.dir") + "/Reports/";
		sparkReporter = new ExtentSparkReporter(filepath + reportName);// specify location of the report

		sparkReporter.config().setDocumentTitle("Be Cognizant "); // Title of report
		sparkReporter.config().setReportName("News Around Cognizant"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Application", "Be Cognizant");
		report.setSystemInfo("Module", "News Around Cognizant");
		report.setSystemInfo("Sub Module", "News Page");
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("User Name", System.getProperty("user.name"));
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		report.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		report.setSystemInfo("Groups", includedGroups.toString());
			
	}}

	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	
		test.assignCategory(result.getMethod().getGroups());
		

	}

	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		test.assignCategory(result.getMethod().getGroups());
	 
	}

		
	

	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
		test.assignCategory(result.getMethod().getGroups());
		
	}

	public void onFinish(ITestContext testContext) {
		report.flush();

		
	}
}
