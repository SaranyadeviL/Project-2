package Tests_Spicejet;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ValidatePage extends  BaseClass{
    @Test
    public static void ValidateFields() {


        // validate Check-in
        driver.findElement(By.id("Check-in")).isDisplayed();

        // Validate Flight Status
        driver.findElement(By.id("FlightStatus")).isDisplayed();

        //Validate Manage Booking
        driver.findElement(By.id("ManageBooking")).isDisplayed();

    }
}
