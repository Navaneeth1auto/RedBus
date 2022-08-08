package webDriverConcepts;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.FKart_samsungHomePage;

public class WindowHanding {
	
	public WebDriver driver;
	FKart_samsungHomePage samsung;
	@BeforeTest
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void openApplication() {
		driver.get("https://www.flipkart.com/samsung-mobile-store?otracker=nmenu_sub_Electronics_0_Samsung");
	}

	@Test
	public void verifyAddToCart() {
		samsung=new FKart_samsungHomePage(driver);
		samsung.clickOnSamsung();
		samsung.clickOnAddToCartBtn();
	}
	
	
	
}
