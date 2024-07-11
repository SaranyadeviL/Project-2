package Utilities;

import Tests_Spicejet.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Tests_Spicejet.BaseClass.driver;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started:" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed:" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed:" + result.getName());
        takeScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped:" + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite Started:" + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite Finished:" + context.getName());
    }

    public void takeScreenshot(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = BaseClass.driver;


        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String click = result.getName() + "_" + timestamp + ".png";
        try {
            FileUtils.copyFile(srcFile, new File("C:\\Users\\HP\\IdeaProjects\\Project-2\\src\\test\\Screenshot//" + click));
            System.out.println("Screenshot taken:" + click);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}