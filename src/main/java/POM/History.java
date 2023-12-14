package POM;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class History extends Utils{

	public History(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	private By searchResults=By.cssSelector(".group");
	private By searchResultText=By.xpath("//p[@class=\"text-sm\"]");
	private By _3verticaldots=By.cssSelector(".dropdown");
	private By delete=By.xpath("//span[.='Delete']");
	private By deleteInApopup=By.xpath("//button[.='Delete']");
	private By close=By.xpath("//button[.='Close']");
	private By _3verticaldotMainbutton=By.cssSelector(".shadow-btn-shadow svg");
	private By genarateReportButton=By.xpath("//p[.='Generate Report']");
	
//	private By contentRadio_Button=By.xp
//	private By resourcesRadio_Button=By.xp
	
	
	private By searchResultsByradioButton=By.xpath("//div[@class=\"hover:bg-list-gradient flex w-full items-center rounded-lg p-3 px-5 s-Rx_0BvvLQc3a\"]");
	private By radioButton=By.xpath("//input[@type=\"checkbox\"]");
	// This tag is not working thats Why I used xpath
	private By highlightedGenarateButton=By.xpath("/html/body/div/div[1]/section/section/div/div[3]/button[1]");

	public void search_Results(String searchText) throws InterruptedException {
		Thread.sleep(4000);
		List<WebElement> search_Results = driver.findElements(searchResults);
		byElement_ToAppear(searchResultText);
		search_Results.stream().filter(a->a.findElement(searchResultText).getText().equalsIgnoreCase(searchText)).
		findFirst().
		ifPresent(matchingDescription->
		{
			byElement_ToAppear(_3verticaldots);
			List<WebElement> dotButtons=driver.findElements(_3verticaldots);
			int index=search_Results.indexOf(matchingDescription);
			dotButtons.get(index).click();
			});
		Thread.sleep(4000);	}

	public void deleteSearch_Results() throws InterruptedException {
		try {
			driver.findElement(delete).click();
		} catch (Exception e) {
			driver.findElement(delete).click();
	}}
	
	public void deleteInAPopup() throws InterruptedException {
		try {
			driver.findElement(deleteInApopup).click();
		} catch (Exception e) {
			driver.findElement(deleteInApopup).click();
			Thread.sleep(2000);
	}
	}
	
	public void closeButton() throws InterruptedException {
		driver.findElement(close).click();
		Thread.sleep(2000);}
	
	public void verticaldotMainbutton() {
		driver.findElement(_3verticaldotMainbutton).click();	}
	
	public void genarateReportButton() {
		driver.findElement(genarateReportButton).click();	}
	
	public void searchResultsByRadioButton(String input) throws InterruptedException {
		List<WebElement> searchResults_ = driver.findElements(searchResultsByradioButton);
		searchResults_.stream().filter(a-> a.findElement(searchResultText).getText().equalsIgnoreCase(input)).findFirst().
		ifPresent(matchingDescription->{
			List<WebElement> radioButtons=driver.findElements(radioButton);
			int index=searchResults_.indexOf(matchingDescription);
			radioButtons.get(index).click();		
		});		
		Thread.sleep(3000);
	}
	
	public void highlightedGenarateButton() throws InterruptedException {
		byElement_ToAppear(highlightedGenarateButton);
		try {
			driver.findElement(highlightedGenarateButton).click();
		} catch (Exception e) {
			driver.findElement(highlightedGenarateButton).click();
		}		
		Thread.sleep(3000);
	}

}

