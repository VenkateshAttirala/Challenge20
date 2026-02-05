package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

public class HomePage extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By makeUp_loc = By.xpath("//section[@id='categorymenu']//a[contains(normalize-space(),'Makeup')]");
	
	
	public void validateHomePageLoad() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(webDriver ->((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

		System.out.println("Page Loaded Successfully!");

	}
	
	public void clickMakeUp() {
		wait.until(ExpectedConditions.elementToBeClickable(makeUp_loc)).click();
	}

}
