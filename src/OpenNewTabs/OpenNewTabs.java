package OpenNewTabs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OpenNewTabs {
    public  OpenNewTabs(){
        ChromeDriver browser = new ChromeDriver();
        browser.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));

        WebElement searchBox = browser.findElement(By.name("q"));
        searchBox.sendKeys("Dependency of Inversion" + Keys.ENTER);

        // İlk 10 sonucun linklerini bul
        try {
            Thread.sleep(5000);
            List<WebElement> searchResults = browser.findElements(By.cssSelector(".tF2Cxc .yuRUbf a"));

            for (int i = 0; i < Math.min(10, searchResults.size()); i++) {
                String link = searchResults.get(i).getAttribute("href");
                System.out.println((i + 1) + ": " + link);
                browser.executeScript("window.open('"+ link +"')");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("FINALLY");
//            browser.quit();
        }
    }
}
