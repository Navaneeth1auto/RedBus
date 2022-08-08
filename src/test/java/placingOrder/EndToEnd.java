package placingOrder;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseFolder.BaseClass;
import pageClasses.HomePage;

public class EndToEnd extends BaseClass{
	HomePage home;
	@BeforeClass
	@Parameters("Browser")
	public void browserSetup(String browserName) {
		setupBrowser(browserName);
		openApplication();
	}
	
	@Test
	public void test1() {
		home=new HomePage(driver);
		home.enterFromCity("Bangalore", "Majestic");
		home.enterToCity("Hyderabad", "Gachibowli");
		home.selectDate(10, "Auguest", 2022);
	}
}
