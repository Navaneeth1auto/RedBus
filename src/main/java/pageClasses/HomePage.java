package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helper.WaitClass;

public class HomePage {
	WebDriver driver;
	WaitClass wait;
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		wait=new WaitClass(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="src") 
	WebElement from_txtBox;
	
	@FindBy(how=How.XPATH, using="//input[@data-message='Please enter a source city']/following-sibling::ul/li") 
	List<WebElement> fromLocations_list;
	
	@FindBy(how=How.XPATH, using="//input[@data-message='Please enter a destination city']") 
	WebElement to_txtBox;
	
	@FindBy(how=How.XPATH, using="//input[@data-message='Please enter a destination city']/following-sibling::ul/li") 
	List<WebElement> toLocations_list;
	
	@FindBy(how=How.XPATH, using="//label[text()='Onward Date']") 
	WebElement calender_txtBox;
	
	@FindBy(how=How.ID, using="rb-calendar_onward_cal") 
	WebElement calender_visibilty;
	
	@FindBy(how=How.XPATH, using="//div[@id='rb-calendar_onward_cal']/descendant::td[@class='next']") 
	WebElement next_btn;
	
	public void enterFromCity(String fromCity, String location) {
		wait.elementToBeVisible(from_txtBox);
		from_txtBox.click();
		from_txtBox.clear();
		from_txtBox.sendKeys(fromCity);
		wait.listOfElementToBeVisible(fromLocations_list);
		try {
			driver.findElement(By.xpath("//input[@data-message='Please enter a source city']/following-sibling::ul/li[contains(text(),'"+location+"')]")).click();	
		} catch (Exception e) {
			System.out.println(e+"  : invalid location : "+location);
		}
		
	}
	
	public void enterToCity(String toCity, String location) {
		wait.elementToBeClickable(to_txtBox);
		to_txtBox.click();
		to_txtBox.clear();
		to_txtBox.sendKeys(toCity);
		wait.listOfElementToBeVisible(toLocations_list);
		try {
			driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']/following-sibling::ul/li[contains(text(),'"+location+"')]")).click();	
		} catch (Exception e) {
			System.out.println(e+"  : invalid location : "+location);
		}
	}
	
	public void selectDate(int day, String month, int year) {
		boolean value=true;
		String month_year;
		wait.elementToBeClickable(calender_txtBox);
		calender_txtBox.click();
		wait.elementToBeVisible(calender_visibilty);
		String dayStr=Integer.toString(day);
		String yearStr=Integer.toString(year);
		if(month.equalsIgnoreCase("september")) {
		month_year=month.substring(0, 4).concat(" ").concat(yearStr);
		}
		else {
			month_year=month.substring(0, 3).concat(" ").concat(yearStr);
		}
		System.out.println(month_year);
		while(value) {
		try {
			driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/descendant::td[@class='monthTitle' and contains(text(), '"+month_year+"')]"));
			driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/descendant::td[@class='monthTitle' and contains(text(), '2022')]/ancestor::tr/following-sibling::tr/td[text()='"+dayStr+"']")).click();
			value=false;
		} catch (Exception e) {
			wait.elementToBeClickable(next_btn);
			next_btn.click();
		}
		}
	}
}
