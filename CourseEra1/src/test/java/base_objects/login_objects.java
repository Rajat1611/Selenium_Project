package base_objects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class login_objects {

	WebDriverWait wait;

	public static WebElement findPopup(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		By popupLocator = By.xpath("//*[text()='Thanks for visiting!']");
		// wait.until(ExpectedConditions.presenceOfElementLocated(popupLocator));
		List<WebElement> popupElements = driver.findElements(By.xpath("//*[text()='Thanks for visiting!']"));

		try {

			if (popupElements.size() > 0 && popupElements.get(0).isDisplayed()) {
				Thread.sleep(1000);
				System.out.println("Thanks madi gayu");
				driver.findElement(By.xpath("//*[@id='rendered-content']/div/div[1]/div/div[2]/div[2]/div/button[1]"))
						.click();
				System.out.println("Thanks madi par click karyu");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
				Thread.sleep(1000);

				return null;

			}
		} catch (NoSuchElementException e) {
			System.out.println("Popup not found");

		}
		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
		// Thread.sleep(1000);

		// driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();

		return null;
	}

	public static WebElement loginNavigation(WebDriver driver) throws InterruptedException {

		Thread.sleep(5000);
		WebElement frame1 = driver.findElement(By.xpath("/html/body/iframe"));
		driver.switchTo().frame(frame1);
		WebElement navigation = driver.findElement(By.xpath("//a[normalize-space()='Log In']"));
		return navigation;
	}

	public static WebElement Email(WebDriver driver) throws InterruptedException {

		String name = "Helly";

		WebElement email = driver.findElement(By.xpath("//div[@class='css-hygizn']//input[@id='email']"));
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		return email;

	}

	public static WebElement password(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement pwd = driver.findElement(By.id("password"));
		return pwd;
	}

	public static WebElement login(WebDriver driver) {

		WebElement loginbtn = driver.findElement(By.cssSelector("button[type='submit']"));
		return loginbtn;
	}

	public static WebElement profile(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[14]/div[2]/iframe")));
		// driver.switchTo().defaultContent();
		System.out.println("Frame ma gayu");

		WebElement profile1 = driver.findElement(By.xpath("//*[@id='right-nav-dropdown-btn']/div/div[2]/div/p"));
		// wait.until(ExpectedConditions.presenceOfElementLocated(profile1));
		wait.until(ExpectedConditions.visibilityOf(profile1));
		System.out.println("Frame ma madyu");

		return profile1;
	}

}
