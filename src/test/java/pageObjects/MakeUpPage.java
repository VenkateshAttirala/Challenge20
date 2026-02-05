package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MakeUpPage {
	WebDriver driver;
    String productPrice;
	
	public MakeUpPage(WebDriver driver) {
		this.driver=driver;
	}

	By tmlr_loc = By.xpath("//a[text()='Tropiques Minerale Loose Bronzer']");
	By productName_loc = By.className("bgnone");
	By productPrice_loc = By.className("productfilneprice");
	By productColour_loc = By.id("option318");
	By productQuantity_loc = By.id("product_quantity");
	By addToCart_loc = By.xpath(" //a[normalize-space() = 'Add to Cart']"); //text() methods takes only direct text , if we we dont mention it teakes all text and compares
	
	public void clickTMLRProduct() {
		driver.findElement(tmlr_loc).click();
	}
	
	public void pdpDisplayed() {
		WebElement productNameVerification = driver.findElement(productName_loc);
		
		if(productNameVerification.isDisplayed()) {
			System.out.println("PDP loaded Succssfully");
		}
	}
	
	public String getProductPrice() {
		String productPrice = driver.findElement(productPrice_loc).getText();
		return productPrice;
	}
	
	public void prodctColourChange() {
		WebElement productColour= driver.findElement(productColour_loc);
		
		Select colour = new Select(productColour);
		colour.selectByValue("652");
	}
	public void updateQuantity(String quantity) {
		WebElement productQuantity = driver.findElement(productQuantity_loc);
		productQuantity.clear();
		productQuantity.sendKeys(quantity);
	}
	
	public void addToCart() {
		WebElement addToCart = driver.findElement(addToCart_loc);
		addToCart.click();
	}
	
}
