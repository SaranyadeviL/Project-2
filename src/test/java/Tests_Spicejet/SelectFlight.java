package Tests_Spicejet;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SelectFlight extends BaseClass {
    @Test

    public void selectFlight(){

        //Assuming flight search has been done
        driver.findElement(By.xpath("//button[text()='Select']")).click();
        driver.findElement(By.id("ProceedToBooking")).click();



    }
}
