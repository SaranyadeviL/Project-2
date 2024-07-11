package Spicejet_Pages;

import Tests_Spicejet.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Booking extends BaseClass {
        @Test
        public static void SelectFlight() {


            // Assume flight search has been done

            driver.findElement(By.xpath("//button[text()='Select']")).click();
            driver.findElement(By.id("ProceedToBooking")).click();



        }
    }


