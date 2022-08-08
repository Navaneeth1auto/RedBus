package pageClasses;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FKart_samsungHomePage {
	WebDriver driver;
	WebDriverWait wait;
	String parentWindow;
	public FKart_samsungHomePage(WebDriver driver) {
		this.driver = driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	private void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	private void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	private void switchToChildWindow(String parentWindow,WebElement element) {
		System.out.println("in child to :"+parentWindow);
		Set<String> childWindows=driver.getWindowHandles();
		Iterator<String> window=childWindows.iterator();
		while(window.hasNext()) {
			String child=window.next();
			System.out.println("in loop :"+child);
			if(!child.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(child);
				try {
					element.isDisplayed();
					break;
				} catch (Exception e) {
					System.out.println("next window... ");
					continue;
				}
			}
		}
	}
	
	private void switchToParentWindow(String parentWindow) {
		System.out.println(parentWindow);
		driver.switchTo().window(parentWindow);
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(@title,'SAMSUNG Galaxy F13')]")
	private WebElement samsung_galexy_f13;
	
	@FindBy(how=How.XPATH, using="//button[text()='ADD TO CART']")
	private WebElement addToCart_btn;
	
	public void clickOnSamsung() {
		waitForElementToBeClickable(samsung_galexy_f13);
		parentWindow=driver.getWindowHandle();
		samsung_galexy_f13.click();
	}
	
	public void clickOnAddToCartBtn() {
		switchToChildWindow(parentWindow, addToCart_btn);
		waitForElementToBeClickable(addToCart_btn);
		addToCart_btn.click();
		switchToParentWindow(parentWindow);
	}
}
