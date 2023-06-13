package testcases;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base_objects.dashboard_objects;

public class dashboard {
	
	static WebDriver driver;
	
	@Test
	public static void search(login objectlogin,String email,String password) throws Exception {
		
		objectlogin = new login();
		login.navigation();
		
		login.login(email,password);
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		dashboard_objects.searchbox(driver).sendKeys("Software testing");

	}
}
