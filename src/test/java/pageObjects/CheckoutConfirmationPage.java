package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutConfirmationPage {
	
    WebDriver driver;
	
	public CheckoutConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}

	By productnameloc = By.cssSelector("td[class='align_left valign_top'] a");
	By totalpriceloc = By.xpath("//b[normalize-space()='Total:']/ancestor::td/following-sibling::td//span");
	
	By confirmOrderloc = By.id("checkout_btn");
	By orderSuccessloc = By.xpath("//h1[@class='heading1' and contains(normalize-space(),'Your Order Has Been Processed!')]");
	
	public void getProductName() {
		String productName = driver.findElement(productnameloc).getText();
		System.out.println(productName);
	}
	
	public void getTotalPrice() {
		String productPrice = driver.findElement(totalpriceloc).getText();
		System.out.println(productPrice);
	}
	
	public void clickConfirmOrder() {
		driver.findElement(confirmOrderloc).click();
	}
	
	public void getSuccessMsg() {
		String successMsg = driver.findElement(orderSuccessloc).getText();
		Assert.assertEquals(successMsg, "YOUR ORDER HAS BEEN PROCESSED!");
	}
}
