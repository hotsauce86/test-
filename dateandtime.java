public class dateandtime {

    private int day;
    private int month;
    private int year;

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public dateandtime(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void getDate(){
        System.out.println(day+" :"+month+" :"+year);
    }
}


