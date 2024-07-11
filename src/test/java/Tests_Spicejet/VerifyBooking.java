package Tests_Spicejet;

import Spicejet_Pages.OpenBrowser;
import org.openqa.selenium.By;

public class VerifyBooking {
    public static void Verify() {
        OpenBrowser.openBrowser("chrome");

        //Assume booking has been done

        // Checking confirmation Message
        String ConfirmMsg = OpenBrowser.driver.findElement(By.id("ConfirmationMessage")).getText();
        if(ConfirmMsg.contains("Booking confirmed")) {
            System.out.println("Booking Successful!");

        } else {
            System.out.println("Booking failed");
        }
        OpenBrowser.closeBrowser();

    }
}
