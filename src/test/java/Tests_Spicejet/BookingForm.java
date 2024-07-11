package Tests_Spicejet;

import org.openqa.selenium.By;

public class BookingForm extends BaseClass{
    public static void FillForm(){

        // Assume flight has been selected and navigated to booking page

        //Fill all passenger details
        driver.findElement(By.id("Name")).sendKeys("John Peter");
        driver.findElement(By.id("Age")).sendKeys("34");
       driver.findElement(By.id("Gender")).sendKeys("MAle");

        // Fill Details of payment

        driver.findElement(By.id("CardNumber")).sendKeys("7569 2871 3580 4036");
        driver.findElement(By.id("ExpiryDate")).sendKeys("10/27");
        driver.findElement(By.id("cvv")).sendKeys("519");

        // Click on Book Button

        driver.findElement(By.id("Book")).click();


    }

}
