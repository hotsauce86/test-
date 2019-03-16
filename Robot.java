import java.awt.*;
import java.util.ArrayList;

public class Robot {

    public static String Robot(String directions){
        /*
            Robot

            we have a robot, it moves, and we track its path in the room

         */
        String results;
        String newDirections = directions;
        int xPosition = 0;
        int yPosition = 0;
        int XMax = 0;
        int YMax = 0;
        int XMin = 0;
        int YMin = 0;
        int pointDirection = 1;
        // 1-up, 2-left, 3-down, 4-right
        ArrayList<Integer> track = new ArrayList<Integer>();
        //staggered x and y input, followed by direction
        track.add(0);// x
        track.add(0);// y
        track.add(1);// direction
        //Next we loop through the String of directions one by one and change our values accordingly
        for (int i = 0; i < directions.length(); i++){

            //turn left
            if(newDirections.charAt(i) == 'L'){
                pointDirection++;
                //we must also keep our values between 1-4
                if(pointDirection == 5){
                    pointDirection = 1;
                }
            }

            //turn right
            if(newDirections.charAt(i) == 'R'){
                pointDirection--;
                //again, we must keep our values between 1-4
                if(pointDirection == 0){
                    pointDirection = 4;
                }
            }

            //turn around
            if(newDirections.charAt(i) == 'U'){
                switch (pointDirection){
                    case 1:
                        pointDirection = 3;
                        break;
                    case 2:
                        pointDirection =4;
                        break;
                    case 3:
                        pointDirection = 1;
                        break;
                    case 4:
                        pointDirection = 2;
                        break;
                }
            }

            //move forward
            if(newDirections.charAt(i) == 'F'){
                if(pointDirection == 1){
                    //move up
                    yPosition++;
                }
                if(pointDirection == 2){
                    //move left
                    xPosition--;
                }
                if(pointDirection == 3){
                    //move down
                    yPosition--;
                }
                if(pointDirection == 4){
                    //move left
                    xPosition++;
                }
            }

            //reverse
            if(newDirections.charAt(i) == 'R'){
                if(pointDirection == 1){
                    //move down
                    yPosition--;
                }
                if(pointDirection == 2){
                    //move right
                    xPosition++;
                }
                if(pointDirection == 3){
                    //move up
                    yPosition++;
                }
                if(pointDirection == 4){
                    //move right
                    xPosition--;
                }
            }

            if(xPosition > XMax){
                XMax = xPosition;
            }
            if(xPosition < XMin){
                XMin =  xPosition;
            }
            if(yPosition > YMax){
                YMax = yPosition;
            }
            if(yPosition < YMin){
                YMin = yPosition;
            }

            track.add(xPosition);
            track.add(yPosition);
            track.add(pointDirection);
        }
        //finding grid size to get center point
        //when we apply the track path
        int gridx = XMax-XMin;
        int gridy = YMax-YMin;
        int gridMax = 0;
        if(gridx>gridy){
            gridMax = gridx*2+1;
        }else{
            gridMax = gridy*2+1;
        }
        System.out.println(XMax + ", " +XMin + ", " + YMax +", " +YMin);
        System.out.println("max x: " + gridx + " max y: " + gridy);

        /*
            Slight problem

            currently this prints off rotation by 90 degrees
            this can be fixed but it's late and im tiiiiired

         */

        for(int j=gridMax; j>0; j--){
            for(int i=0; i<gridMax; i++){
                boolean isSeen = false;
                boolean last = false;
                boolean up = false;
                //the list numbers come in pairs of three, so we itterate...
                for(int k=0; k<track.size(); k= k+3){
                    if(i==track.get(k)+gridMax/2 && j==track.get(k+1)+gridMax/2){
                        isSeen=true;
                        //if the x and y are the same as a location on the track
                        //we set our output to draw that path
                        if(k==track.size()-3 && isSeen==true){
                            last=true;
                        }

                        if(track.get(k+2)==1 ||track.get(k+2)==3){
                            up = true;
                        }
                    }
                }
                if(last==true && isSeen==true){
                    System.out.print(4+" ");
                }
                else if(isSeen==true){
                    if(up == true){
                        System.out.print("| ");
                    }else{
                        System.out.print("- ");
                    }
                    //System.out.print(1+" ");
                }
                else if(i==gridMax/2 && j==gridMax/2){
                    System.out.print(4);
                }else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println("");
        }
        System.out.println();
        //Once we have finished reading the directions we can print out the results
        results = "[" + xPosition + "," + yPosition + "]";
        System.out.println(results);
        //and return them
        return results;
    }

    public static void robot(int x, int y){

        /*
            Rebot redux!

            we're going to change it up a bit and have the robot take the shortest path
            to it's destination with some fun polymorphism

            the robot will start at [0,0] and find it's path to [x,y]
         */

        int xPosition = 0;
        int yPosition = 0;
        int XMax = 0;
        int YMax = 0;
        int XMin = 0;
        int YMin = 0;
        int pointDirection = 1;

        ArrayList<Integer> track = new ArrayList<Integer>();
        //staggered x and y input, followed by direction
        track.add(0);// x
        track.add(0);// y
        track.add(1);// direction

        if(x > XMax){
            XMax = x;
        }
        if(x < XMin){
            XMin =  x;
        }
        if(y > YMax){
            YMax = y;
        }
        if(y < YMin){
            YMin = y;
        }

        int gridx = XMax-XMin;
        int gridy = YMax-YMin;
        int gridMax = 0;
        if(gridx>gridy){
            gridMax = gridx*2+1;
        }else{
            gridMax = gridy*2+1;
        }
        System.out.println(XMax + ", " +XMin + ", " + YMax +", " +YMin);
        System.out.println("max x: " + gridx + " max y: " + gridy);

        while(xPosition != x || yPosition != y){

            //we do an x move
            if(xPosition > x ){
                xPosition--;
                track.add(xPosition);// x
                track.add(yPosition);// y
                track.add(1);// direction
            }
            if(xPosition < x ){
                xPosition++;
                track.add(xPosition);// x
                track.add(yPosition);// y
                track.add(1);// direction
            }
            if(yPosition < y ){
                yPosition++;
                track.add(xPosition);// x
                track.add(yPosition);// y
                track.add(1);// direction
            }
            if(yPosition > y){
                yPosition--;
                track.add(xPosition);// x
                track.add(yPosition);// y
                track.add(1);// direction
            }
        }

        //the y
        for(int j = gridMax; j > 0; j--){
            //the x
            for(int i = 0; i < gridMax; i++){
                boolean isSeen = false;
                boolean last = false;
                boolean up = false;
                //the list numbers come in pairs of three, so we iterate...
                for(int k=0; k<track.size(); k= k+3){
                    if(i==track.get(k)+gridMax/2 && j==track.get(k+1)+gridMax/2){
                        isSeen=true;
                        //if the x and y are the same as a location on the track
                        //we set our output to draw that path
                        if(k==track.size()-3 && isSeen==true){
                            last=true;
                        }
                        if(track.get(k+2)==1 ||track.get(k+2)==3){
                            up = true;
                        }
                    }
                }
                if(last==true && isSeen==true){
                    System.out.print(4+" ");
                }
                else if(isSeen==true){
                    if(up==true){
                        System.out.print("| ");
                    }else{
                        System.out.print("-");
                    }
                    //System.out.print(1+" ");
                }
                else if(i==gridMax/2 && j==gridMax/2){
                    System.out.print(4);
                }else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println("");
        }

        System.out.println();
        //Once we have finished reading the directions we can print out the results
        String results = "[" + xPosition + "," + yPosition + "]";
        System.out.println(results);

    }


}
