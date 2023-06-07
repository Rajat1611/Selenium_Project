package com.newpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketCreation {

	
	
	@FindBy(id="createTicket")
	private WebElement createticket;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public void createticket() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(createticket));
		createticket.click();
	}
	
	
	
}
