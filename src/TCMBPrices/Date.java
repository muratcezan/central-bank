package TCMBPrices;

import java.time.LocalDate;

public class Date {
    public int _day = 0;
    public int _month = 0;
    public int _year = 0;

    public Date(int day, int month, int year)  {
        _day = day;
        _month = month;
        _year = year;
    }

    public Date(LocalDate date){
        _day = date.getDayOfMonth();
        _month = date.getMonthValue();
        _year = date.getYear();
    }

    public Date() {
    }
}
