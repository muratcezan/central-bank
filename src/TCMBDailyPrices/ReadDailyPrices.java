package TCMBDailyPrices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ReadDailyPrices {
    ReadDailyPrices() throws InterruptedException {
        ChromeDriver browser = new ChromeDriver();
        browser.get("https://www.tcmb.gov.tr/");
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));

        Thread.sleep(3000);

        // Arama sonuçlarındaki linkler bulunuyor
        List<WebElement> searchResults = browser.findElements(By.cssSelector(".tF2Cxc .yuRUbf a"));
        System.out.println("GUNCEL DOVIZ KURLARI");
        System.out.println("USD ALIS     = " +browser.findElement(By.id("usdBuying")).getText());
        System.out.println("USD SATIS    = " +browser.findElement(By.id("usdSelling")).getText());
        System.out.println("EURO ALIS    = " +browser.findElement(By.id("euroBuying")).getText());
        System.out.println("EURO SATIS   = " +browser.findElement(By.id("euroSelling")).getText());
        System.out.println("----------------------------------------------");
    }
}
