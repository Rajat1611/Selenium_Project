package com.newpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageNavigation {

	
	@FindBy(xpath = "//*[@class='cd-dropdown-trigger']")
	private WebElement nav;
	
	@FindBy(xpath = "//li[@class='has-children RED_menu']")
	private WebElement Red;
	
	@FindBy(xpath = "//*[@id=\\\"accordiontest\\\"]/ul/li[3]/ul/li[1]/li[1]/a\")")
	private WebElement tc;
	
	
	private WebDriver driver;
	Actions actions= new Actions(driver);
	
	public void clickonnavigation() {
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		actions.moveToElement(nav).perform();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		actions.moveToElement(Red).perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		
	}
	
//	WebElement dropdown = driver.findElement(By.xpath("//a[@class='cd-dropdown-trigger']"));
//	Actions action = new Actions(driver);
//	action.moveToElement(dropdown).perform();
//	//Thread.sleep(2500);
//	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//	WebElement Red = driver.findElement(By.xpath("//li[@class='has-children RED_menu ']"));
//	Actions action1 = new Actions(driver);
//	action.moveToElement(Red).perform();
//	Thread.sleep(2500);
//	WebElement ticket = driver.findElement(By.xpath("//*[@id=\"accordiontest\"]/ul/li[3]/ul/li[1]/li[1]/a"));
//	ticket.click();
//	//Thread.sleep();
//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	
}
