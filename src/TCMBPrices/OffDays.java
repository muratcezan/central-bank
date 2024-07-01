package TCMBPrices;

import java.time.LocalDate;

public class OffDays {
    private String _desc;
    private LocalDate _date;

    public OffDays(String desc, LocalDate date){
        _desc = desc;
        _date = date;
    }
    public OffDays(OffDays other) {
        _desc = other.getDesc();
        _date = other.getDate();
    }
    public OffDays copy() {
        return new OffDays(_desc, _date);
    }

    public String getDesc(){
        return _desc;
    }

    public LocalDate getDate(){
        return _date;
    }
}
