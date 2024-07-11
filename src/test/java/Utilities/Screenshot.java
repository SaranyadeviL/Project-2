package Utilities;

import Tests_Spicejet.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class Screenshot extends BaseClass {
    ExtentTest test;

    @Test
    public void validateHomePage(){
        test = ExtentManager.createTest("Validate Home Page");
        String pageTitle = driver.getTitle();
        test.log(Status.INFO, "PageTitle:" +pageTitle);

        //Add assertions and log results
        if (pageTitle.contains("Spicejet")) {
            test.log(Status.PASS, "Home Page Validation Passed");
        } else {
            test.log(Status.FAIL,"Home Page Validation Failed");

            takeScreenshot("ValidateHomePage");
        }

    }

}
