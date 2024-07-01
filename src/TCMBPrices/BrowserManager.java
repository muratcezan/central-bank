package TCMBPrices;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class BrowserManager {
    public BrowserManager(){
        System.out.println("TCMBPrices.BrowserManager Initialized");
    }

    public static void tabAction(ChromeDriver browser, String yearPrevButtonIndex, String yearNextButtonIndex, int yil) {
        while (!findYear(
                findMaxYear(findTabIndexYears(browser, yearPrevButtonIndex)),
                findMinYear(findTabIndexYears(browser, yearNextButtonIndex)),
                yil)) {

            changeTab(browser, yearPrevButtonIndex);
        }
    }

    public static String findTabIndexYears(ChromeDriver browser, String tabIndex) {
        return (browser.findElement(By.cssSelector("[data-w-tab=\"Tab " + tabIndex + "\"]")).getText());
    }

    public static boolean findYear(String firstYear, String secondYear, int currentYear) {
        if(firstYear == null)
            return false;
        if(secondYear == null)
            return false;

        System.out.println("Integer.parseInt(firstYear) = " + Integer.parseInt(firstYear));
        System.out.println("Integer.parseInt(secondYear) = " + Integer.parseInt(secondYear));

        for(int i = Integer.parseInt(firstYear); i < Integer.parseInt(secondYear); i++)
        {
            System.out.println(i);
            if(i == currentYear)
                return true;
        }
        return false;
    }

    public static String findMaxYear(String scaleYears) {
        if(scaleYears.isEmpty())
            return null;

        String[] years = scaleYears.split(" - ");
        System.out.println("String[] years = " + Arrays.toString(years));
        System.out.println("years[0] = " + years[0]);
        return years[0];
    }

    public static String findMinYear(String scaleYears) {
        if(scaleYears.isEmpty())
            return null;

        String[] years = scaleYears.split(" - ");
        return years[1];
    }

    public static void changeTab(ChromeDriver browser, String tabIndex) {
        browser.findElement(By.cssSelector("[data-w-tab=\"Tab " + tabIndex + "\"]")).click();
    }

    public static boolean selectYear(ChromeDriver browser, int year){
        boolean isFind = false;
            try {
                browser.findElement(By.cssSelector("[data-year=\"" + year + "\"]")).click();
                isFind = true;
            }
            catch (NoSuchElementException e)
            {
                System.out.println("Year Couldn't find");
            }
            return isFind;
    }

    public static void selectMonth(ChromeDriver browser, int month, int year){
        month = month - 1;
        browser.findElement(By.cssSelector("[data-month='"+month+"'][data-year='"+year+"']")).click();
    }

    public static List<WebElement> selectDays(ChromeDriver browser, List<String> selectedDays){
        List<WebElement> selectDays = browser.findElements(By.cssSelector("[data-handler=\"selectDay\"]"));
        List<WebElement> selectedAvailableDays = null;
        for(WebElement availableDays : selectDays)
        {
            System.out.println("------");
            for(String selectDay : selectedDays)
            {
                if(selectDay.equals( availableDays.getText()))
                {
                    selectedAvailableDays.add(availableDays);
                    break;
                }
            }
        }
        return selectedAvailableDays;
    }

    public static void showData(ChromeDriver browser, TCMBData tcmbDay) {
        browser.findElement(By.xpath("//div[@data-w-tab='Tab "+tcmbDay.getYear()+"']//input")).click();
    }

    public static boolean chooseDay(ChromeDriver browser, int tcmbDay) {
        List<WebElement> pageDays = browser.findElements(By.cssSelector("a.ui-state-default"));

        for (WebElement day : pageDays){
            if(day.getText().equals(String.valueOf(tcmbDay))){
                day.click();
                return true;
            }
        }
        return false;
    }

    public static void printValues(ChromeDriver browser){
        try {
            WebElement table = browser.findElement(By.xpath("//table[@class='kurlarTablo']"));
            List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (int i = 2; i<5; i ++) {
                    System.out.println(cells.get(i).getText());
                }
            }
        }catch (NoSuchElementException e)  {
            WebElement we = browser.findElement(By.id("data"));
            System.out.println(we.getText());
        }

        browser.findElement(By.id("back")).click();
    }

    public static boolean checkOffDays(TCMBData tcmbDay,TCMBConsts constValues)
    {
        for(OffDays day : constValues.offDays){
            System.out.println("day.getDate() = " + day.getDate());

            LocalDate ld = LocalDate.of(
                    tcmbDay.getYear(),
                    tcmbDay.getMonth(),
                    tcmbDay.getDay());
            System.out.println("ld = " + ld);

            if(day.getDate().equals(ld))
                return true;
        }
        return false;
    }
}
