import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class scoreboardThing {

}

class LeaderBoard{
    private List<Scores> Scoreboard =  new ArrayList<>();
    private List<Scores> Sortedboard =  new ArrayList<>();
    public Double add_score(Integer player_id, Integer score) {
        Scores NewScore = new Scores(player_id, score);
        Scoreboard.add(NewScore);
        int GameCounter = 0;
        int ScoreSum = 0;
        double Ave;
        reset_add(player_id);
        for(int i =0; i < Scoreboard.size(); i++){
            if(Scoreboard.get(i).GetPlayerID() == player_id){
                GameCounter++;
                ScoreSum += Scoreboard.get(i).GetScore();
            }
        }
        Ave = (double) ScoreSum/GameCounter;
        System.out.println(Ave);
        return Ave;
    }
    public List<Integer> top(Integer max) {
        // the returned list
        List<Integer> tops = new ArrayList<Integer>();
        //
        List<Scores> temptop2 =new ArrayList<>();
        Sortedboard =  Scoreboard.stream().sorted(Comparator.comparing(Scores::GetPlayerID).reversed()).collect(Collectors.toList());
        //add the top player
        int LastID = Sortedboard.get(0).GetPlayerID();
        int GameCounter = 0;
        int ScoreSum = 0;
        double Ave;

        // temptop.add(LastID);

        for(int i =0; i< Sortedboard.size(); i++) {
            System.out.print("tops >> player and score: " + Sortedboard.get(i).GetPlayerID() + ", " +Sortedboard.get(i).GetScore());
            if(LastID == Sortedboard.get(i).GetPlayerID()){
                GameCounter++;
                ScoreSum += Sortedboard.get(i).GetScore();
            }
            if(LastID != Sortedboard.get(i).GetPlayerID()){
                if(Sortedboard.get(i).GetScore() == 0){
                    Ave = (double) ScoreSum / GameCounter;
                    Scores newScore = new Scores(LastID, Ave);
                    System.out.println("     added: " + LastID + ", " + Ave + " WHEN VALUE IS ZERO");
                    temptop2.add(newScore);
                    GameCounter = 0;
                    ScoreSum = 0;
                    Ave = 0.0;
                    LastID = Sortedboard.get(i).GetPlayerID();
                    System.out.println("----");
                    Ave = 0.0;
                    //Scores newScore2 = new Scores(Sortedboard.get(i).GetPlayerID(), 0.0);
                    // System.out.println("     added: " + LastID + ", " + Ave);
                    GameCounter=1;
                    ScoreSum = 0;
                }
                else {
                    Ave = (double) ScoreSum / GameCounter;
                    Scores newScore = new Scores(LastID, Ave);
                    System.out.println("     added: " + LastID + ", " + Ave);
                    temptop2.add(newScore);
                    GameCounter = 0;
                    ScoreSum = 0;
                    Ave = 0;
                    LastID = Sortedboard.get(i).GetPlayerID();
                }
            }
            if (i== Sortedboard.size()-1){
                ScoreSum = Sortedboard.get(i).GetScore();
                GameCounter++;
                Ave = (double) ScoreSum/GameCounter;
                Scores newScore = new Scores(LastID, Ave);
                System.out.println( "     added: " + LastID + ", " + Ave);
                temptop2.add(newScore);

            }

            System.out.println();
        }

        temptop2 = temptop2.stream().sorted(Comparator.comparing(Scores::GetScoreDouble).reversed()).collect(Collectors.toList());
            /*
            for(int i =0; i< Sortedboard.size(); i++){
                if(LastID != Sortedboard.get(i).GetPlayerID()){
                    LastID = Sortedboard.get(i).GetPlayerID();
                    temptop.add(LastID);
                }
            }
            */
        System.out.println("temptopsize = "  + temptop2.size());
        for(int i =0; i < max; i++){
            System.out.println(" FIANL : " + temptop2.get(i).GetPlayerID() + ", " + temptop2.get(i).GetScoreDouble());
            // System.out.println(temptop.get(i).);
            tops.add(temptop2.get(i).GetPlayerID());
        }



        return tops;
    }

    public void reset(Integer player_id) {
        Iterator<Scores> IteratePlayer = Scoreboard.iterator();
        while(IteratePlayer.hasNext()){
            Object o = IteratePlayer.next();
            if(((Scores) o).GetPlayerID() == player_id){
                IteratePlayer.remove();
            }
        }
        Scores AddEmptyScore = new Scores(player_id, 0);
        Scoreboard.add(AddEmptyScore);
    }

    public void reset_add(Integer player_id) {
        Iterator<Scores> IteratePlayer = Scoreboard.iterator();
        while(IteratePlayer.hasNext()){
            Object o = IteratePlayer.next();
            if(((Scores) o).GetPlayerID() == player_id){
                if(((Scores) o).GetScore() == 0) {
                    IteratePlayer.remove();
                }
            }
        }
    }

    public int GamesPlayed(int player_id){
        int GamesPlayed = 0;

        for(int i = 0; i < Scoreboard.size(); i ++){
            if(Scoreboard.get(i).GetPlayerID() == player_id){
                GamesPlayed++;
            }
        }
        return GamesPlayed;
    }



}
class Scores { //implements Comparable<Scores>
    private int PlayerID;
    private int PlayerScore;
    private double PlayerScoreDouble;
    //this is always the setter
    Scores(int PlayerID, int PlayerScore){
        this.PlayerID = PlayerID;
        this.PlayerScore  = PlayerScore;
    }

    Scores(int PlayerID, double PlayerScoreDouble){
        this.PlayerID = PlayerID;
        this.PlayerScoreDouble  = PlayerScoreDouble;
    }
    //getters
    public int GetPlayerID(){
        return PlayerID;
    }
    public int GetScore() {
        return PlayerScore;
    }

    public double GetScoreDouble() {
        return PlayerScoreDouble;
    }


}
// Test code here
class Solution {
    public static void main(String[] args) {

        int answer = JOptionPane.showConfirmDialog(null, "are you as is constricted??", "checking", JOptionPane.YES_NO_OPTION);

        if(answer == JOptionPane.YES_OPTION){
            System.out.println("yes was selected" + answer);
        }
        else if(answer == JOptionPane.NO_OPTION){
            System.out.println("no was selected" + answer);
        }

        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.add_score(1, 50);
        System.out.println(leaderBoard.add_score(2, 80) == 80);
        System.out.println(leaderBoard.add_score(2, 70) == 75);
        System.out.println(leaderBoard.add_score(2, 60) == 70);
        System.out.println(leaderBoard.add_score(3, 90) == 90);
        System.out.println(leaderBoard.add_score(3, 85) == 87.5);

        System.out.println();

        System.out.println(leaderBoard.top(3).equals(Arrays.asList(3, 2, 1)));
        System.out.println(leaderBoard.top(2).equals(Arrays.asList(3, 2)));

        leaderBoard.reset(3);

        System.out.println(leaderBoard.top(3).equals(Arrays.asList(2, 1, 3)));

        System.out.println(leaderBoard.add_score(67, 900) == 900);
        System.out.println(leaderBoard.top(2).equals(Arrays.asList(67, 2)));


        System.out.println(leaderBoard.GamesPlayed(2));

    }
}