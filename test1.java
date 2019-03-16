import java.util.*;

public class test1 {

    public int multiply(int a, int b){
        System.out.println("output: "+a*b);
        return a*b;
    }

    Robot rover = new Robot();
    public String direction = rover.Robot("LFFRFFLLFFLFFRF");
    public static dateandtime billdate2 = new dateandtime();
    public static void main(String args[]){
        Robot boston = new Robot();
        String direction = boston.Robot("FFLFFRFF");

        System.out.println(direction);

        boston.robot(1,1);


        dateandtime billdate = new dateandtime();

        billdate.setDate(1,1,1999);
        billdate2.setDate(1,1,1999);

        checkBilling(billdate);
        billdate.getDate();




    }

    public static  void checkBilling(dateandtime billdate){
        if(billdate.getDay() == billdate2.getDay()){
            billdate.setDay(billdate.getDay()+1);
        }
    }
    
}
