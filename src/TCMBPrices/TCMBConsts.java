package TCMBPrices;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TCMBConsts {
    public static String yearPrevButtonIndex = "6";
    public static String yearNextButtonIndex = "7";
    public String webSiteURL = "https://www.tcmb.gov.tr/wps/wcm/connect/TR/TCMB+TR/Main+Menu/Istatistikler/Doviz+Kurlari/Gosterge+Niteligindeki+Merkez+Bankasi+Kurlarii/";

    String maximumStopDate = "";
    String minimumStartDate = "1996-04-16";

    public List<OffDays> offDays = new ArrayList<>();

    public TCMBConsts(){
        LocalDate bugun = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        maximumStopDate = bugun.format(formatter);

//        for(int year = 1996; year<=LocalDate.now().getYear(); year++)
//        {
//            System.out.println("year = "+ year);
//
//            offDays.add(new OffDays("Yeni Yil Tatili", LocalDate.of(year,1,1)));
//            offDays.add(new OffDays("Ulusal Egemenlik ve Cocuk Bayrami",LocalDate.of(year,4,23)));
//            offDays.add(new OffDays("Isci Bayrami",LocalDate.of(year,5,1)));
//            offDays.add(new OffDays("Genclik ve Spor Bayrami",LocalDate.of(year,5,19)));
//            offDays.add(new OffDays("Sehitler Bayrami",LocalDate.of(year,7,15)));
//            offDays.add(new OffDays("Zafer Bayrami",LocalDate.of(year,8,30)));
//        }
    }

    public int getMaxYear(){
        LocalDate date = LocalDate.parse(maximumStopDate);
        return date.getYear();
    }
    public int getMaxMonth(){
        LocalDate date = LocalDate.parse(maximumStopDate);
        return date.getMonthValue();
    }
    public int getMaxDay(){
        LocalDate date = LocalDate.parse(maximumStopDate);
        return date.getDayOfMonth();
    }
    public int getMinYear(){
        LocalDate date = LocalDate.parse(minimumStartDate);
        return date.getYear();
    }
    public int getMinMonth(){
        LocalDate date = LocalDate.parse(minimumStartDate);
        return date.getMonthValue();
    }
    public int getMinDay(){
        LocalDate date = LocalDate.parse(minimumStartDate);
        return date.getDayOfMonth();
    }
}
