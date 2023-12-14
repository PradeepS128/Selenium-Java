package E2E;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Listeners.Get_Listener;
import Utils.Utils;

public class SmokeTesting_1_10 extends __ObjectClasses
{
	public String text;
	public String output;

	@Test(description = "Validate User's Presence on Home Page and \"New Chat\" button Displayed on Hover",priority = 1)
	public void TestScript01() throws IOException, InterruptedException
	{
		text = homepage.newChatButton();
		SoftAssert assert1=new SoftAssert(); // validation
//response will be added to the extent report
		System.out.println(text);

		assert1.assertEquals(text, "New Chat");
		String searchText = homepage.searchTextField("Question1");
		Thread.sleep(25000);
		output = homepage.searchResults();
		Get_Listener.info_custom(searchText); 	// To display responses in an Extent Report
		Get_Listener.info_custom1(output);
		assert1.assertAll();
	}

	@Test(description = "Verify Selection, Deletion, and Homepage Navigation for an Article from Dropdown List in History Page",priority = 2)
	public void TestScript02() throws InterruptedException, IOException {
		String searchText=Utils.propertyFile("Question1");  //input
		
		homepage._3verticalDots();
		homepage.historyButton().click();
		// Find the matching description and perform an action if present
		history.search_Results(searchText);
		history.deleteSearch_Results();
		history.deleteInAPopup();
		history.closeButton(); //close the history page
		Get_Listener.info_custom(searchText); 	// To display responses in an Extent Report
		Get_Listener.info_custom1(null);
	}

	@Test(description = "Generate Report for Selected Article and Return to Home Page",priority = 3)
	public void TestScript03() throws InterruptedException, IOException {
		String searchText=Utils.propertyFile("Question1");  //input

		homepage._3verticalDots();
		homepage.historyButton().click();
		history.verticaldotMainbutton();
		history.genarateReportButton();
		history.searchResultsByRadioButton(searchText); // Find the matching description and select the radio button
		history.highlightedGenarateButton(); 		// genarate the report
		genarate_Report.closeButton();
		history.closeButton();
		Get_Listener.info_custom(searchText); 	// To display responses in an Extent Report
		Get_Listener.info_custom1(null);
	}
	
	
	
	
	
	


	}

