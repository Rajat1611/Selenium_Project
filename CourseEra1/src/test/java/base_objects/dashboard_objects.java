package base_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboard_objects {
	
	public static WebElement searchbox(WebDriver driver) {
		WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));
		return searchbox;
	}

}
