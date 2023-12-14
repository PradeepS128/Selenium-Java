package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class Genarate_Report extends Utils
{
public Genarate_Report(WebDriver driver) {
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

private By closeButton=By.xpath("//button[.='Close']");


public void closeButton() throws InterruptedException {
	byElement_ToAppear(closeButton);
	driver.findElement(closeButton).click();
	Thread.sleep(2000);	}
}
