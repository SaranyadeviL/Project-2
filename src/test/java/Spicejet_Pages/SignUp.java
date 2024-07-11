package Spicejet_Pages;

import Spicejet_Pages.OpenBrowser;
import Tests_Spicejet.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp extends BaseClass {
    @Test

    public static void ValidateSignUp() {
        driver.findElement(By.linkText("SignUp")).click();

        // fill the form
        driver.findElement(By.id("First Name")).sendKeys("Arjun");
        driver.findElement(By.id("Last Name")).sendKeys("Das");
        driver.findElement(By.id("Email")).sendKeys("arjundas56@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Arjun@12345");
        driver.findElement(By.id("Mobile_no")).sendKeys("9846214087");

        // Accept the terms and conditions checkbox

        driver.findElement(By.id("terms")).click();

        //Submit the form
        driver.findElement(By.xpath("//button[contains(text(), 'SIGN UP')]"));

        //add assertion to validate sign up success
        String successMessage = driver.findElement(By.id("successMessge")).getText();
        Assert.assertTrue(successMessage.contains("thank you for signing up"), "Sign-up failed");




        // To click Signup
        driver.findElement(By.id("Signup")).click();


    }
}


