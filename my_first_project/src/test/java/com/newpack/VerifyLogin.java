package com.newpack;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Objects;
import com.newpack.Login.*;
import com.newpack.TicketCreation.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLogin extends TicketCreation  {

	Login loginpage;
	TicketCreation headers;
	WebDriverWait wait;

	public WebDriver driver;
	
	@AfterClass
	
	public void deleteObject()
	{
		loginpage = null;
		headers = null;
	}

	@BeforeTest
	public void presetup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rajat.parmar\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://spectrumdbperformance.specindia.com/");

	}

	@Test(priority = 0)
	public void testA_Valid_Credentials() throws EncryptedDocumentException, IOException, InterruptedException

	{
		System.out.println("TestCase-1");
		loginpage = new Login(driver);
		
		String id = "amisha.shah";
		String password = "Amisha@12345";
		loginpage.userid(id);
		loginpage.password(password);
		loginpage.clickOnLogIn();
		Thread.sleep(1000);
		
		id = "amisha.shah";
		password = "Amisha@123656";
		loginpage.userid(id);
		loginpage.password(password);
		loginpage.clickOnLogIn();
		Thread.sleep(2000);
		
		id = "amisha.shah";
		password = "Amisha@123";
		loginpage.userid(id);
		loginpage.password(password);
		loginpage.clickOnLogIn();
		
		Thread.sleep(3000);
		String actualUlr = driver.getCurrentUrl();
		System.out.println("ActualUrl: " + actualUlr);
		String expectedUrl = "https://spectrumdbperformance.specindia.com/MyDesk/Dashboard";
		System.out.println("ExpectedUrl: " + expectedUrl);

		Thread.sleep(7000);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualUlr, expectedUrl);
		softAssert.assertAll();
		
		loginpage.logout();
		invalid();
	
}
	@Test(priority = 1)
	public void invalid() throws EncryptedDocumentException, IOException, InterruptedException

	{
		System.out.println("TestCase-1");
		loginpage = new Login(driver);
		String id = "amisha.shah";
		String password = "Amisha@123dfdf";
		loginpage.userid(id);
		loginpage.password(password);

		loginpage.clickOnLogIn();
		Thread.sleep(3000);
		String actualUlr = driver.getCurrentUrl();
		System.out.println("ActualUrl: " + actualUlr);
		String expectedUrl = "https://spectrumdbperformance.specindia.com/MyDesk/Dashboard";
		System.out.println("ExpectedUrl: " + expectedUrl);

		Thread.sleep(7000);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualUlr, expectedUrl);
		softAssert.assertAll();

	
}


	@Test(priority = 1)
	public void navigate() {

		loginpage.clickonnavigation();

	}
}
//	
//		@Test(priority = 2)
//		public void createticket()
//		{
//			wait= new WebDriverWait(driver, 10);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("createTicket")));
//			//headers = new TicketCreation(driver);
//			headers.createticket();
//			if(Objects.isNull(headers))
//			{
//				System.out.println("Null");
//			}
//			else {System.out.println("Not Null");}
//		
//		}
//	
//}

//	
//	@Test(priority = 1)
//	public void logout() throws EncryptedDocumentException, IOException, InterruptedException
//
//	{
//
//		loginpage.logout();
//		Thread.sleep(3000);
//		String actualUlr = driver.getCurrentUrl();
//		System.out.println("ActualUrl: " + actualUlr);
//		String expectedUrl = "https://spectrumdbperformance.specindia.com/";
//		System.out.println("ExpectedUrl: " + expectedUrl);
//
//		Thread.sleep(7000);
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(actualUlr, expectedUrl);
//		softAssert.assertAll();
//
//	}
////	
//	@AfterClass
//	public void afterClass() {
//
//		System.out.println("after class");
//		driver.close();
