import TCMBPrices.*;
import org.openqa.selenium.chrome.ChromeDriver;

// KURLAR CSV file olarak alinacak
// Yapilan isin aynisini python'da da gelistir
// Pythonda ekstra olarak csv file grafigini cizdir
// https://www.websudoku.com/ zorluk durumunu secen, cozum olusturan, cozumu gonderen ve basarili sonucu gosteren uygulama
// Backtracking algoritmalarini oku

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ApplicationTCMBPrices appTCMBPrices = new ApplicationTCMBPrices();

//        bManager.tabAction(browser,TCMBPrices.TCMBConsts.yearPrevButtonIndex, TCMBPrices.TCMBConsts.yearNextButtonIndex,"2012");
//        bManager.selectYear(browser,"2012");

//        System.out.println("Yil secildi");
//        Thread.sleep(4000);
//        selectMonth(browser,"4","2012");
//        System.out.println("ay secildi");
//        Thread.sleep(4000);

//        //----------------------------------------------------------------------------------
//        ChromeDriver browser = new ChromeDriver();
//        browser.get("https://www.tcmb.gov.tr/");
//        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
//        Scanner scanner = new Scanner(System.in);

////        WebElement searchBox = browser.findElement(By.name("q"));
////        searchBox.sendKeys("Dependency of Inversion" + Keys.ENTER);
////        browser.executeScript("window.open('https://www.youtube.com')");
//
////        WebElement searched = browser.findElement(By.className("dURPMd"));
////        List<WebElement> filteredSearch = searched.findElements(By.className("MjjYud"));
//        // İlk 10 sonucun linklerini bul
//
//        try {
//
//            Thread.sleep(3000);
//
//            // Arama sonuçlarındaki linkler bulunuyor
////            List<WebElement> searchResults = browser.findElements(By.cssSelector(".tF2Cxc .yuRUbf a"));
//            System.out.println("GUNCEL DOVIZ KURLARI");
//            System.out.println("USD ALIS     = " +browser.findElement(By.id("usdBuying")).getText());
//            System.out.println("USD SATIS    = " +browser.findElement(By.id("usdSelling")).getText());
//            System.out.println("EURO ALIS    = " +browser.findElement(By.id("euroBuying")).getText());
//            System.out.println("EURO SATIS   = " +browser.findElement(By.id("euroSelling")).getText());
//            System.out.println("----------------------------------------------");
//
//            System.out.println("Gecmise yonelik doviz kurlarina gozatmak ister misiniz? [Y/n]");
//
//            // Kullanıcıdan bir satır okunuyor
////            String giris = scanner.nextLine();
//
////            if(!giris.toLowerCase().equals("y"))
////                return;
//            String gun = "12";
//            String ay = "3";
//            String yil = "2015";
//
//            String yearPrevButtonIndex = "6";
//            String yearNextButtonIndex = "7";
//
//            browser.get("https://www.tcmb.gov.tr/wps/wcm/connect/TR/TCMB+TR/Main+Menu/Istatistikler/Doviz+Kurlari/Gosterge+Niteligindeki+Merkez+Bankasi+Kurlarii/");
//            Thread.sleep(2000);
//
//            while(true) {
//                if(findYear(
//                        findMaxYear(
//                                findTabIndexYears(
//                                        browser, yearPrevButtonIndex
//                                )
//                        ),
//                        findMinYear(
//                                findTabIndexYears(
//                                        browser,
//                                        yearNextButtonIndex
//                                )
//                        ),
//                        yil)
//                )
//                    break;
//                changeTab(browser,yearPrevButtonIndex);
//            }
//
//            System.out.println(findMaxYear(findTabIndexYears(browser,yearPrevButtonIndex)));
//            System.out.println(findMinYear(findTabIndexYears(browser,yearNextButtonIndex)));
//            System.out.println("Yil araligi bulundu");
//            Thread.sleep(2000);
//            selectYear(browser,yil);
//            System.out.println("Yil secildi");
//            Thread.sleep(4000);
//            selectMonth(browser,ay,yil);
//            System.out.println("ay secildi");
//            Thread.sleep(4000);
////            selectDays(browser,);
//            Thread.sleep(5000);
//
//            //----------------------------------------------------------------------------------

//            System.out.println("prevDates" + prevDates);
//            System.out.println("nextDates" + nextDates);
//            Thread.sleep(2000);
//            browser.findElement(By.cssSelector("[data-w-tab=\"Tab 6\"]")).click();
//
//            prevDates = browser.findElement(By.cssSelector("[data-w-tab=\"Tab 6\"]")).getText();
//            nextDates = browser.findElement(By.cssSelector("[data-w-tab=\"Tab 7\"]")).getText();
//            System.out.println("prevDates" + prevDates);
//            System.out.println("nextDates" + nextDates);
//            Thread.sleep(2000);

//            while(true) {
//                System.out.println("Baslangic Tarihini yaziniz. FORMAT = 30.12.2023");
//                String[] startDate = scanner.nextLine().split("\\.");
//                if (startDate.length != 3) {
//                    System.out.println("Tarih Giris Kilavuzu=");
//                    return;
//                } else {
//                    gun = Integer.parseInt(startDate[0]);
//                    ay = Integer.parseInt(startDate[1]);
//                    yil = Integer.parseInt(startDate[2]);
//
//                    while (true) {
//                        if (gun >= 1  || gun <= 31){
//                            break;
//                        }
//                        System.out.println("Lutfen sadece 1 ile 31 arasinda bir gun degeri giriniz = ");
//                        gun = Integer.parseInt(scanner.nextLine());
//                    }
//                    while (true) {
//                        if (ay >= 1  || ay <= 31){
//                            break;
//                        }
//                        System.out.println("Lutfen sadece 1 ile 12 arasinda bir ay degeri giriniz = ");
//                        ay = Integer.parseInt(scanner.nextLine());
//                    }
//                    while (true) {
//                        if (yil >= 1  || yil <= 31){
//                            break;
//                        }
//                        System.out.println("Lutfen sadece 1996 ile 2024 arasinda bir yil degeri giriniz = ");
//                        yil = Integer.parseInt(scanner.nextLine());
//                    }
//                }
//
//                System.out.println("Araligi gun cinsinden sayi olarak giriniz.");
//                int days = Integer.parseInt(scanner.nextLine());
//                while (true) {
//                    if (days >= 1  || days <= 31){
//                        break;
//                    }
//                    System.out.println("Lutfen gun cinsinden sayilarla aralik degeri giriniz = ");
//                    days = Integer.parseInt(scanner.nextLine());
//                }
//
//                System.out.println(Arrays.toString(startDate));
//                System.out.println(days);
//
//
//                List<WebElement> we =browser.findElements(By.cssSelector(".block-tabs-bar .w-tab-menu a"));
//
//
//            }

//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            System.out.println("FINALLY");
//            browser.quit();
//        }
    }
}