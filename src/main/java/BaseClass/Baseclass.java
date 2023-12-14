package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import POM.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriver driver;
	public Login login;
	public Properties properties;

	public WebDriver getWebdriverAccess() throws IOException {
		FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//PropertyFile//global.properties");
		properties = new Properties();
		properties.load(inputStream);
		String browser = properties.getProperty("BROWSERNAME");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-notifications");

		if (browser.equalsIgnoreCase("chrome"))
				{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public String getScreenshot(String testcase, WebDriver driver) throws IOException {
		TakesScreenshot screenshot =(TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File(System.getProperty("user.dir")+"//Reports//" + testcase + ".png");
		FileUtils.copyFile(src, dst);
		return System.getProperty("user.dir")+"//Reports//" + testcase + ".png";
	}

	@BeforeMethod
	public void login3ECO() throws IOException, InterruptedException {
		driver = getWebdriverAccess();
		login=new Login(driver);
		driver.get(properties.getProperty("TEST_URL"));
		login.login(properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
