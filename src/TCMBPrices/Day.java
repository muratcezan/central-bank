package TCMBPrices;

public class Day  extends Date{
    public String _dayText = null;
    public boolean _offDay = false;
    public String _desc = null;

    public Day() {
    }

    public Day(int day, int month, int year) {
        super(day, month, year);
    }

    public Day(int day, int month, int year,String dayText, boolean offDay, String desc) {
        super(day, month, year);
        _dayText = dayText;
        _offDay = offDay;
        _desc = desc;
    }

    public void updateOffDay(){
        _offDay = true;
    }

    public void updateDesc(String desc){
        _desc = desc;
    }

//    Day(String date, String dayText, boolean offDay){
//        super();
//        _date = date;
//        _dayText = dayText;
//        _offDay = offDay;
//    }
//
//    Day(String date, String dayText, boolean offDay, String description){
//        _date = date;
//        _dayText = dayText;
//        _offDay = offDay;
//        _description = description;
//    }
}
