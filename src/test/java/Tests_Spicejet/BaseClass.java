package Tests_Spicejet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class BaseClass {

    public static WebDriver driver;
    public Actions a;
//
//    @BeforeSuite
//    public void setUp() {
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        a = new Actions(driver);
//    }

    @Parameters("browser")

    @BeforeMethod
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com");

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        {
            if (ITestResult.FAILURE == result.getStatus()) {
                takeScreenshot(result.getName());
            }
            if (driver != null) {
                driver.quit();
            }
        }
    }


        public static String takeScreenshot (String testName){
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());

            File destFile = new File("Screenshots/" + testName + " _ " + timeStamp + ".png");
            try {
                FileUtils.copyFile(srcFile, new File(String.valueOf(destFile)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String path = "<img src = " + destFile.getAbsolutePath() + "width = 200px height = 200px/>";
            Reporter.log(path);
            return destFile.getAbsolutePath();
        }
    }
