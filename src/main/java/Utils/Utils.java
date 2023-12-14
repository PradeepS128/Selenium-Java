package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public WebDriver driver;

	public Utils(WebDriver driver) {
		this.driver = driver;
	}

	public void webElement_ToAppear(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10000));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void byElement_ToAppear(By by) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10000));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void allWebElement_ToAppear(List<WebElement> elements) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void elementToBeClickable(By by) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driverWait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public JavascriptExecutor javaScriptExecutor() {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		return executor;
	}

	public void moveToElement(By by) {
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(by)).perform();
	}

	public static String propertyFile(String url) throws IOException {

		FileInputStream inputStream = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\PropertyFile\\global.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties.getProperty(url);
	}

}
