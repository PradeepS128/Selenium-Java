package POM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.Utils;

public class Homepage extends Utils {
	WebDriver driver;

	public Homepage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

private By newChatButton=By.xpath("//img[@alt=\"AI Icon\"]");
private By newChatText=By.xpath("//span[.='New Chat']");
private By _3verticalDots=By.cssSelector(".options-button");
private By historyButton=By.xpath("//p[.='History']");
private By reportsButton=By.xpath("//p[.='Reports']");
private By resourcesButton=By.xpath("//button[.='Resources: 10']");
private By creativityButton=By.xpath("//button[.='Creativity: medium']");
private By logoutButton=By.xpath("//p[.='Logout']");
private By searchTextField=By.xpath("//input[@placeholder=\"Search...\"]");
private By searchEnterButton=By.xpath("//div[@class=\"relative w-full flex-1\"]//button");
private By searchResults=By.xpath("//div[@class=\"space-y-3 bg-white p-6\"]//p");


public String newChatButton() throws InterruptedException {
	byElement_ToAppear(newChatButton);
	moveToElement(newChatButton);
	Thread.sleep(5000);
	return driver.findElement(newChatText).getText();
}

public void _3verticalDots() {
	driver.findElement(_3verticalDots).click(); }


public String searchTextField(String key) throws IOException {
	String input = propertyFile(key);
	driver.findElement(searchTextField).sendKeys(input);
	driver.findElement(searchEnterButton).click();
	return input;
}

public String searchResults() {
	byElement_ToAppear(searchResults);
	return driver.findElement(searchResults).getText();
}

public WebElement logoutButton() {
	return driver.findElement(logoutButton); }

public WebElement historyButton() {
	return driver.findElement(historyButton);
}


}