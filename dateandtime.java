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
        if(month >12){
            setYear(getYear()+1);
            this.month=1;
        }
    }

    public void setDay(int day) {


        if(day>30){
            this.day = 1;
            setMonth(getMonth()+1);
        }else{
            this.day = day;
        }

        System.out.println("chaning day: "+day);

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


