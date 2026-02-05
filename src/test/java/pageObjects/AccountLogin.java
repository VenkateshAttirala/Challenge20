package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountLogin {
	WebDriver driver;
	
	public AccountLogin(WebDriver driver) {
		this.driver=driver;
	}

	By buttonGuest_loc = By.cssSelector("#accountFrm_accountguest");
	By continue_loc = By.xpath("//button[@title='Continue']");
	
	public void clickGuestCheckout() {
		driver.findElement(buttonGuest_loc).click();
	}
	
	public void clickContinue() {
		driver.findElement(continue_loc).click();
	}
}
