package E2E;

import org.testng.annotations.BeforeMethod;

import BaseClass.Baseclass;
import POM.Genarate_Report;
import POM.History;
import POM.Homepage;


public class __ObjectClasses extends Baseclass{

	public Homepage homepage;
	public History history;
	public Genarate_Report genarate_Report;

	@BeforeMethod
	public void pageObjects()
	{
		homepage=new Homepage(driver);
		history=new History(driver);
		genarate_Report=new Genarate_Report(driver);

}
}
