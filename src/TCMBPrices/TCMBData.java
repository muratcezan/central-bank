package TCMBPrices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TCMBData extends Day{
    private double _euro;
    private double _dollar;

    public TCMBData(){}

    public TCMBData( TCMBData data){
        _euro = data._euro;
        _dollar = data._dollar;
        _dayText = data._dayText;
        _offDay = data._offDay;
        _desc = data._desc;
        _day = data._day;
        _month = data._month;
        _year = data._year;
    }

    public TCMBData(int day, int month, int year) {
        super(day, month, year);
    }

    public TCMBData(int day, int month, int year, String dayText, boolean offDay, String desc) {
        super(day, month, year, dayText, offDay, desc);
    }

    public void updateEuroValue(double euro) {
        _euro = euro;
    }

    public void updateDollarValue(double dollar) {
        _dollar = dollar;
    }

    public void updateDollarAndEuroValues(double dollar, double euro) {
        _dollar = dollar;
        _euro = euro;
    }

    public int getDay(){
        return _day;
    }

    public int getMonth(){
        return _month;
    }

    public int getYear(){
        return _year;
    }

    public String getDayText(){
        return _dayText;
    }

    public boolean getOffDay() { return _offDay; }

    public String getDesc() { return _desc; }

    public double getDollar() {
        return _dollar;
    }

    public double getEuro(){
        return _euro;
    }

    public String getDate(){
        LocalDate date = LocalDate.of(_year,_month,_day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}