package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class Login extends Utils {
	WebDriver driver;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css ="#username")
	private WebElement emailTextFie;

	private By emailText_Field=By.cssSelector("#username");
	private By password_Field=By.cssSelector("#password");
	private By termsOf_services_checkBox=By.xpath("//input[@type=\"checkbox\"]");
	private By login_Button=By.xpath("//button[@type=\"submit\"]");


	public void emailText_Field(String email) throws InterruptedException {

//		JavascriptExecutor executor=(JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].value='" + email + "';", emailTextFie);
		Thread.sleep(2000);
		driver.findElement(emailText_Field).sendKeys(email);
		Thread.sleep(2000);
	}
	public void password_Field(String password) {
		byElement_ToAppear(password_Field);
		driver.findElement(password_Field).sendKeys(password);
	}
	public void termsOf_services_checkBox() {
		byElement_ToAppear(termsOf_services_checkBox);
		driver.findElement(termsOf_services_checkBox).click();
	}
	public void login_Button() {
		byElement_ToAppear(login_Button);
		driver.findElement(login_Button).click();
	}

	public void login(String email, String password) throws InterruptedException {
		emailText_Field(email);
		Thread.sleep(2000);
		password_Field(password);
		Thread.sleep(2000);
		termsOf_services_checkBox();
		Thread.sleep(2000);
		login_Button();
	}

}
