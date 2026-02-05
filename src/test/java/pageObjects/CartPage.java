package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By productName_loc = By.xpath("//td[@class='align_left']/a[text()='Tropiques Minerale Loose Bronzer']");
	By quantity_loc = By.xpath("//table[contains(@class,'table')]//input[starts-with(@id,'cart_quantity')]");
	By colour_loc = By.xpath("//td[@class='align_left']/div/small[text()='Color Natural Ambre']");
	By price_loc = By.xpath("//span[@class='bold totalamout']"); 
	By checkout_loc = By.id("cart_checkout2");
	
	public void productNameValidation() {
		String productName = driver.findElement(productName_loc).getText();
		Assert.assertEquals(productName, "Tropiques Minerale Loose Bronzer");
	}
	
	public void quantityValidation() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(quantity_loc));
		String quantity = driver.findElement(quantity_loc).getAttribute("value");
		Assert.assertEquals(quantity, "2");
		
	}
	
	public void productColourValidation() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(colour_loc));
		String prod_Colour = driver.findElement(colour_loc).getText();
		Assert.assertEquals(prod_Colour, "Color Natural Ambre");
	}
	public void priceValidation() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(price_loc));
		String prod_price = driver.findElement(price_loc).getText();
		Assert.assertEquals(prod_price, "$79.00");
	}

	public void clickContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkout_loc));
		driver.findElement(checkout_loc).click();
	}
}
