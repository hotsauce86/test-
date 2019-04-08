import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class test1 {


    static int buttonintthing = 0;
    public int multiply(int a, int b){
        System.out.println("output: "+a*b);
        return a*b;
    }


    Robot rover = new Robot();
    public String direction = rover.Robot("LFFRFFLLFFLFFRF");





    public static int changeDate(dateandtime somedate1, dateandtime somedate2){

        //in case we have already passed the date
        if(somedate1.getYear()>somedate2.getYear() && somedate1.getMonth() > somedate2.getMonth() && somedate1.getDay() > somedate2.getDay()){
            somedate1.getDate();
            System.out.print("is greater than");
            somedate2.getDate();
            return somedate1.getDay();

        }
        //if it's the wrong month

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
        System.out.println("");

        System.out.print("binary to int :  ");
        BinaryToInt("0010001110");


        JFrame frame = new JFrame("Test1");

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            JLabel label = new JLabel("hello");
            JButton button = new JButton();
            button.setText("yes");
            JButton button2 = new JButton();
            button2.setText("no");

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.print("YES");
                    buttonintthing++;
                    System.out.println(" ," + buttonintthing);

                }
            });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("NO");
                buttonintthing--;
                System.out.println(" ," + buttonintthing);
            }
        });

            panel.add(label);
            panel.add(button);
            panel.add(button2);

        frame.add(panel);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.setVisible(true);

        //frame.pack();

    }




    
}
