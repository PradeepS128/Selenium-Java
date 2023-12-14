package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClass.Baseclass;
import Report.ExtentReport;

public class Get_Listener extends Baseclass implements ITestListener {

	ExtentReports report = ExtentReport.genarateReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> local = new ThreadLocal<>();
	static String apiResponse1;
	static String apiResponse2;

	@Override
	public void onTestStart(ITestResult result) {
//		test = report.createTest(result.getMethod().getMethodName());
		String description = result.getMethod().getDescription();
		test = report.createTest(description != null ? description : result.getMethod().getMethodName());

		local.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		local.get().log(Status.PASS, result.getMethod().getMethodName());

		// experimental
		local.get().log(Status.INFO, "<br>" + apiResponse1);
		local.get().log(Status.INFO, "<br>" + apiResponse2);

		String filepath = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		local.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		local.get().log(Status.FAIL, result.getMethod().getMethodName());

		String filepath = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		local.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		local.get().log(Status.SKIP, result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	// To display responses in an Extent Report
	public static void info_custom(String output1) {
		apiResponse1 = output1;
	}

	// To display responses in an Extent Report
	public static void info_custom1(String output2) {
		apiResponse2 = output2;
	}

}
