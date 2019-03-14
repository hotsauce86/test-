public class test1 {

    public int multiply(int a, int b){
        System.out.println("output: "+a*b);
        return a*b;
    }

    Robot rover = new Robot();
    public String direction = rover.Robot("LFFRFFLLFFLFFRF");

    public static void main(String args[]){
        Robot boston = new Robot();
        String direction = boston.Robot("LFFRFFLLFFLFFRF");

        System.out.println(direction);
    }
    
}
