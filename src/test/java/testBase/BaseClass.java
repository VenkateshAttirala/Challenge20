package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {

	protected WebDriver driver ; //the reason to use protected is if we use static ONE variable shared across ALL objects and ALL threads of that classbut if we use protected Each test class instance gets its OWN driver
	public Logger logger; //Log4j
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		
		logger = LogManager.getLogger(this.getClass());
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
        	driver = new FirefoxDriver();
        }
		
		driver.manage().window().maximize();
		driver.get("https://automationteststore.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	public void takeScreenshot(String testName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String projectPath = System.getProperty("user.dir");
            String folderPath = projectPath + File.separator + "Screenshots";
            File folder = new File(folderPath);
            if (!folder.exists()) folder.mkdirs();

            File destFile = new File(folder, testName + "_" + timestamp + ".png");
            FileUtils.copyFile(srcFile, destFile);

            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        //Capture screenshot only if test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result.getMethod().getMethodName());
        }
    }
    
    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
}
