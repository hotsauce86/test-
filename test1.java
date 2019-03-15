public class test1 {

    public int multiply(int a, int b){
        System.out.println("output: "+a*b);
        return a*b;
    }

    Robot rover = new Robot();
    public String direction = rover.Robot("LFFRFFLLFFLFFRF");

    public static void main(String args[]){
        Robot boston = new Robot();
        String direction = boston.Robot("FFLFFRRRFFF");

        System.out.println(direction);

        boston.robot(5,2);
    }
    
}
