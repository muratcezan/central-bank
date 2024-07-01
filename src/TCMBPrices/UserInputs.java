package TCMBPrices;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import TCMBPrices.TCMBConsts;
import com.google.common.io.ByteStreams;
import net.bytebuddy.asm.Advice;

public class UserInputs {
    // Start and Stop Dates
    Date startDate;
    Date stopDate;
    // User Input Object
    Scanner scanner = new Scanner(System.in);

    // TCMBData List
    public List<TCMBData> tcmbDataList = new ArrayList<>();

    // Constructures
    public UserInputs(){}
    public UserInputs(TCMBConsts consts){
        boolean isComplete = false;

        while (!isComplete) {
            System.out.println("Lutfen Baslangic Tarihini Giriniz");
            System.out.println("---------------------------------");
            LocalDate localStartDate = getDateFromUser(consts);
            System.out.println("Lutfen Bitis Tarihini Giriniz");
            System.out.println("---------------------------------");
            LocalDate localStopDate = getDateFromUser(consts);
            if(!localStartDate.isBefore(localStopDate)) {
                boolean iSTrueInput = false;
                while (!iSTrueInput) {
                    System.out.println("[!] Baslangic Tarihi, Bitis Tarihinden Buyuk Olamaz!");
                    System.out.println("[!] Tekrar Tarihleri Girmek Istiyor musunuz?[Y/n]");
                    String isContinue = scanner.next();
                    if (isContinue.equals("n") || isContinue.equals("N"))
                        System.exit(0);
                    else if (isContinue.equals("y") || isContinue.equals("Y")) {
                        iSTrueInput=true;
                    }
                    else{
                        System.out.println("[!] Hatali Giris Yaptiniz!");
                    }
                }
                continue;
            }

            isComplete =true;
            startDate = new Date(localStartDate);
            stopDate = new Date(localStopDate);
            createDays();
        }
    }
    public UserInputs(int startDay, int startMonth, int startYear,
                      int stopDay, int stopMonth, int stopYear){
        startDate = new Date(startDay,startMonth,startYear);
        stopDate = new Date(stopDay,stopMonth,stopYear);
        createDays();
    }

    // return LocalDate object
    public LocalDate parseStringToLocalDate(String localDateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(localDateString, formatter);
    }

    // return LocalDate as String
    public String parseLocaldateToString(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(formatter);
    }

    public void createDays(){
        LocalDate startLocalDate = LocalDate.of(startDate._year, startDate._month, startDate._day);
        LocalDate stopLocalDate = LocalDate.of(stopDate._year, stopDate._month, stopDate._day);

        LocalDate nowDate = startLocalDate;
        while (!nowDate.isAfter(stopLocalDate)) {
            DayOfWeek dayOfWeek = nowDate.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY
                    && dayOfWeek != DayOfWeek.SUNDAY) {
                System.out.println(nowDate + " (" + dayOfWeek + ")");
                tcmbDataList.add(new TCMBData(
                        nowDate.getDayOfMonth(),
                        nowDate.getMonthValue(),
                        nowDate.getYear()));
            }
            nowDate = nowDate.plus(1, ChronoUnit.DAYS);
        }
    }

    public int getDataFromUser(int maxValue, int minValue, String inputText, String errorText){
        int number = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(inputText);
            try {
                number = scanner.nextInt();
                if (number >= minValue && number <= maxValue) {
                    valid = true; // Geçerli bir tamsayı alındı, döngüden çık
                } else {
                    System.out.println(errorText);
                }
            } catch (InputMismatchException e) {
                System.out.println("Geçersiz giriş. Lütfen bir tamsayı girin.");
                scanner.next(); // Geçersiz girdiyi temizle
            }
        }
        return number;
    }

    public LocalDate getDateFromUser(TCMBConsts consts){
        LocalDate localDateReturn = null;
        boolean getDateBoolean = false;
        while(!getDateBoolean) {
            int userInputYear = getDataFromUser(
                    consts.getMaxYear(),
                    consts.getMinYear(),
                    "Lutfen yil degerini giriniz: ",
                    "Hatali yil degeri");

            int userInputMonth = getDataFromUser(
                    12,
                    1,
                    "Lutfen ay degerini giriniz: ",
                    "Hatali ay degeri");

            int userInputDay = getDataFromUser(
                    31,
                    1,
                    "Lutfen gun degerini giriniz: ",
                    "Hatali gun degeri");

            String inputDateStr = String.format("%04d-%02d-%02d", userInputYear, userInputMonth, userInputDay);

            System.out.println("inputDateStr = " + inputDateStr);

            // Tarih formatını tanımla
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Geçersiz tarihi kontrol et
            try {
                // Tarih bileşenlerini kullanarak tarih oluştur
                LocalDate date = LocalDate.of(userInputYear, userInputMonth, userInputDay);
                System.out.println("Geçerli tarih: " + date);
                localDateReturn = date;
                getDateBoolean = true;
            } catch (DateTimeException e) {
                System.out.println(inputDateStr + " geçersiz bir tarihtir.");
            }
        }

        System.out.println("localDateReturn =" + localDateReturn );
        return localDateReturn;
    }

}
