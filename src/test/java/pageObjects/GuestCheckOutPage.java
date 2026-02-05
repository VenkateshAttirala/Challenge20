package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GuestCheckOutPage {
    WebDriver driver;
	
	public GuestCheckOutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By txtFirstNameloc = By.id("guestFrm_firstname");
	By txtLastNameloc = By.id("guestFrm_lastname");
	By txtEmailloc = By.id("guestFrm_email");

	By txtaddress1 = By.id("guestFrm_address_1");
	By txtCityloc = By.id("guestFrm_city");
	By drpdwRegion = By.id("guestFrm_zone_id");
	By txtZipCode = By.id("guestFrm_postcode");
	By drpdwCountry = By.xpath("//select[@id='guestFrm_country_id']");
	
	By btnContinue = By.xpath("//button[@title='Continue']");
	
	public void enterFirstName(String firstName) {
		driver.findElement(txtFirstNameloc).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(txtLastNameloc).sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		driver.findElement(txtEmailloc).sendKeys(email);
	}
	
	public void enterAddress(String address) {
		driver.findElement(txtaddress1).sendKeys(address);
	}
	
	public void enterCity(String city) {
		driver.findElement(txtCityloc).sendKeys(city);
	}
	
	
	public void selectRegion(String regionPlace) {
		WebElement Region = driver.findElement(drpdwRegion);
		Select select = new Select(Region);
		
		select.selectByVisibleText(regionPlace);
	}
	
	public void enterZipCode(String zipcode) {
		driver.findElement(txtZipCode).sendKeys(zipcode);
	}
	
	public void enterCountry(String country) {
		WebElement Country = driver.findElement(drpdwCountry);
		
        Select select = new Select(Country);		
		select.selectByVisibleText(country);
	}
	
	public void clickContinue() {
		driver.findElement(btnContinue).click();
	}
	
}
