package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports genarateReport() {
		String path = System.getProperty("user.dir")+"//src//main//java//Report//NabuAI_AutomationResults.html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);

		sparkReporter.config().setDocumentTitle("NABU-AI");
		sparkReporter.config().setReportName("AUTOMATION RESULTS");
		sparkReporter.config().setTheme(Theme.DARK);


		ExtentReports reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		reports.setSystemInfo("Reporter: ", "Pradeep Kumar Meti");
		reports.setSystemInfo("OS: ", System.getProperty("os.name"));
		reports.setSystemInfo("Browser: ", "Google Chrome");
		reports.setSystemInfo("Environment: ","Local");
		reports.setSystemInfo("Web-Automation: ", "Selenium with Java");

		return reports;
	}
}
