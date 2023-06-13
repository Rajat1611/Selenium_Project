package testcases;

import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_objects.login_objects;

public class login {

	static WebDriver driver = new ChromeDriver();;
	public static WebDriverWait wait;

	@BeforeTest
	public static void navigation() throws InterruptedException {
		//driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		// System.setProperty("web0driver.http.factory", "jdk-http-client");
		driver.manage().window().maximize();
		driver.get("https://www.coursera.org/");
	
	}
	
	@Test()
	@Parameters({"email","password"})
	public static void login( String email, String password) throws InterruptedException {
		
		//Thread.sleep(5000);
		login_objects.findPopup(driver);
		login_objects.Email(driver).sendKeys(email);
		login_objects.password(driver).sendKeys(password);
		login_objects.login(driver).click();
		login_objects.profile(driver).click();
		
		
	}
}
