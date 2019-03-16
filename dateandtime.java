public class dateandtime {

    private static int day = 0;
    private static int month = 0;
    private static int year = 0;


    public static void setYear(int year) {
        dateandtime.year = year;
    }

    public static void setDay(int day) {
        dateandtime.day = day;
    }

    public static void setMonth(int month) {
        dateandtime.month = month;
    }

    public static int getYear() {
        return year;
    }

    public static int getDay() {
        return day;
    }

    public static int getMonth() {
        return month;
    }

    public void setDate(int day, int month, int year ){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void getDate(){
        System.out.println("Day:" + day + " Month: " + month  + " Year: " + year);
    }
}

