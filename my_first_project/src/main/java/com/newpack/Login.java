package com.newpack;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	@FindBy(xpath = "//input[@id='UserId']")
	private WebElement userid;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//span[@class='caret']")
	private WebElement drpdown;

	@FindBy(xpath = "//a[@id='logout']")
	private WebElement logout;

	
	@FindBy(xpath = "//*[@class='cd-dropdown-trigger']")
	private WebElement nav;
	
	@FindBy(xpath="//*[@class=\"header-title parent\"][@data-childmenu='RED']")
	private WebElement Red;
	
	@FindBy(xpath = "//*[@class='header-title'][@data-childmenu='Tickets']")
	private WebElement tc;
	
	
	

	private WebDriver driver;
	private WebDriverWait wait;
	//Actions actions = new Actions(driver);
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	public void userid(String id) throws EncryptedDocumentException, IOException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(userid));
		userid.sendKeys(id);
	}

	public void password(String pass) throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}

	public void clickOnLogIn() {

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(loginbutton));
		loginbutton.click();

	}
	
	public void clickonnavigation() {
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		actions.moveToElement(nav).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		actions.moveToElement(Red).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		actions.moveToElement(tc).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		tc.click();
		
		
		
	}
	
	
	public void logout() {

			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(drpdown));
			drpdown.click();
			wait.until(ExpectedConditions.visibilityOf(logout));
			logout.click();

		}
	}

