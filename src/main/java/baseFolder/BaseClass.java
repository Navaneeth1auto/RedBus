package baseFolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
								//	@FindBy(how=How.XPATH, using="") WebElement
				
	public void setupBrowser(String browserName) {
		switch (browserName) {
		case "Firefox":{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		}

		case "Chrome":{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
		default:System.out.println("Browser name in correct");
		break;
		}
	}

	public void openApplication() {
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
	}
}
