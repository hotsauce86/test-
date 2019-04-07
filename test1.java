import java.util.*;

public class test1 {

    public int multiply(int a, int b){
        System.out.println("output: "+a*b);
        return a*b;
    }


    Robot rover = new Robot();
    public String direction = rover.Robot("LFFRFFLLFFLFFRF");





    public static int changeDate(dateandtime somedate1, dateandtime somedate2){
        if(somedate1.getMonth() < somedate2.getMonth()){
            somedate1.setMonth(somedate1.getMonth()+1);
        }
        if((somedate1.getDay() < somedate2.getDay()) && (somedate1.getMonth() == somedate2.getMonth())){
            somedate1.setDay(somedate1.getDay()+1);
            return changeDate(somedate1, somedate2);
        }else {
            return somedate1.getDay();
        }
    }

    public int SmalledtPos(int[] A) {
        // write your code in Java SE 8

        int smallestpos =1;

        for(int i =0; i < A.length; i ++){
            if(A[i]==smallestpos){
                smallestpos++;
                i=0;
            }
        }

        return smallestpos;
    }


    public static int BinaryToInt(String binary){


        //int foo = Integer.parseInt("1001", 2);
        int foo = Integer.parseInt(binary, 2);
        System.out.println(foo);

        return foo;
    }


    public static void main(String args[]){
        Robot boston = new Robot();
        String direction = boston.Robot("FFLFFRFF");

        System.out.println(direction);

        boston.robot(1,1);
        dateandtime billdate1 = new dateandtime(1,1,6);
        dateandtime billdate2 = new dateandtime(30,1,6);
        billdate1.setDay(1);

        billdate1.getDate();
        billdate2.getDate();

        changeDate(billdate1, billdate2);
        billdate1.getDate();
        BinaryToInt("0010001110");

    }




    
}
