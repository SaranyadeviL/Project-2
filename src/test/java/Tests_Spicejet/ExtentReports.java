package Tests_Spicejet;

import Utilities.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

class ExtentReports {
    WebDriver driver;
    ExtentTest test;

    @BeforeMethod
    public void setup(){
        // setup web driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //initialize the Extent Reports
        ExtentManager.getInstance();
    }

    @Test
    public void validateHomePage() {
        test = ExtentManager.createTest("Validate Home Page");
        driver.get("https://www.spicejet.com");
        test.log(Status.INFO, "Navigated to Spicejet Home Page");
        String pageTitle = driver.getTitle();
        test.log(Status.INFO, "PageTitle:" + pageTitle);

        // Add assertion and log results
        if (pageTitle.contains("Spicejet")) {
            test.log(Status.PASS, "Home Page Validation Passed");
        } else {
            test.log(Status.FAIL, "Home Page Validation Failed");
        }
    }
    @AfterMethod
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
     // Flush Extent Reports
     ExtentManager.flush();
    }
}
