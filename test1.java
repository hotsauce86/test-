import java.util.*;

public class test1 {

    public int multiply(int a, int b){
        System.out.println("output: "+a*b);
        return a*b;
    }


    Robot rover = new Robot();
    public String direction = rover.Robot("LFFRFFLLFFLFFRF");





    public static int changeDate(dateandtime somedate1, dateandtime somedate2){
        if(somedate1.getDay() <= somedate2.getDay()){
            somedate1.setDay(somedate1.getDay()+1);
            return changeDate(somedate1, somedate2);
        }else {
            return somedate1.getDay();
        }
    }


    public static void main(String args[]){
        Robot boston = new Robot();
        String direction = boston.Robot("FFLFFRFF");

        System.out.println(direction);

        boston.robot(1,1);
        dateandtime billdate1 = new dateandtime(1,1,6);
        dateandtime billdate2 = new dateandtime(3,1,6);
        billdate1.setDay(1);





        billdate1.getDate();
        billdate2.getDate();


        changeDate(billdate1, billdate2);
        billdate1.getDate();


    }




    
}
