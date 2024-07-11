package Tests_Spicejet;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchFlight extends BaseClass {
    @Test
    public static void OneWay() {
        driver.findElement(By.id("OneWayTrip")).click();

        driver.findElement(By.id("Origin")).sendKeys("Mumbai");
        driver.findElement(By.id("Destination")).sendKeys("Hyderabad");
        driver.findElement(By.id("Departure")).sendKeys("2024-07-19");
        driver.findElement(By.id("SearchFlights")).click();
    }

    //Add Assertions to validate Results for search
    @Test
    public static void RoundTrip() {
        driver.findElement(By.id("RoundTrip")).click();

       driver.findElement(By.id("Origin")).sendKeys("London");
        driver.findElement(By.id("Destination")).sendKeys("Singapore");
        driver.findElement(By.id("Departure")).sendKeys("2024-07-24");
        driver.findElement(By.id("Return Date")).sendKeys("2024-07-30");

        driver.findElement(By.id("SearchFlights")).click();


    }
}
