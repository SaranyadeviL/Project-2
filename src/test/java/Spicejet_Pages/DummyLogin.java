package Spicejet_Pages;

import Tests_Spicejet.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DummyLogin extends BaseClass {
    @Test
    public static void login() {

        driver.findElement(By.id("Login")).click();

        //Switch to login
        driver.switchTo().frame("LoginIFrame");
        driver.findElement(By.id("Email")).sendKeys("Arun@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Password@123345");
        driver.findElement(By.id("Submit")).click();

        //assertions to add validate login success


    }
}
