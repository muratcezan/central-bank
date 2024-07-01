package TCMBPrices;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class ApplicationTCMBPrices {
    public ApplicationTCMBPrices() throws InterruptedException {
        // create BrowserManager object
        BrowserManager bManager = new BrowserManager();

        // create TCMBConsts object
        TCMBConsts constValues = new TCMBConsts();

        // create UserInputs object
//        UserInputs userInputs = new UserInputs(constValues);
        UserInputs userInputs = new UserInputs(21,11,2003,6,5,2024);

        // create ChromeDriver object
        ChromeDriver browser = new ChromeDriver();

        // enter the site
        browser.get(constValues.webSiteURL);

        // TODO: privDay tarafi incelenecek!
        TCMBData privDay = new TCMBData();

        for(TCMBData tcmbDay : userInputs.tcmbDataList){
            System.out.println("Checking off days");
            if(bManager.checkOffDays(tcmbDay,constValues))
                continue;

            System.out.println(tcmbDay.getDate());

            if(privDay.getMonth() == 0 || !(privDay.getMonth() == tcmbDay.getMonth())){
                boolean isFound = false;
                while(!isFound) {
                    bManager.tabAction(browser, TCMBConsts.yearPrevButtonIndex, TCMBConsts.yearNextButtonIndex, tcmbDay.getYear());
                    System.out.println("tcmbDay.getYear() = "+tcmbDay.getYear());
                    isFound = bManager.selectYear(browser, tcmbDay.getYear());
                    Thread.sleep(4000);
                }
                System.out.println("Yil secildi");

                bManager.selectMonth(browser,tcmbDay.getMonth(),tcmbDay.getYear());
                System.out.println("ay secildi");
                Thread.sleep(4000);
            }

            if (!bManager.chooseDay(browser,tcmbDay.getDay())){
                System.out.println("Tatil Gunu! " + tcmbDay.getDay());
                tcmbDay.updateOffDay();
                tcmbDay.updateDesc("Free Day");
                continue;
            }
            System.out.println("gun secildi");
            Thread.sleep(3000);

            bManager.showData(browser,tcmbDay);
            System.out.println("veriler gosterildi");
            Thread.sleep(3000);

            bManager.printValues(browser);
            Thread.sleep(3000);

            ExcelManager excelManager = new ExcelManager();
            String firstname = excelManager.readExcel("Sheet1",1,0);
            System.out.println("Isim = " + firstname);
            String lastname = excelManager.readExcel("Sheet1",1,1);
            System.out.println("Isim = " + lastname);

            privDay = new TCMBData(tcmbDay);
        }
    }
}
