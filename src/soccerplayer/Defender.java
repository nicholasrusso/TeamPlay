package soccerplayer;

import java.util.Random;

public class Defender implements SoccerPlayer
{
    String dname = "";
    String dteam = "";
    int dscore = 0;

    public Defender(String name, String team){
        this.dname = name;
        this.dteam = team;
        this.dscore = score();
    }

    public String getName() {
        return dname;
    }

    public String getTeam() {
        return dteam;
    }
   
    @Override
    public String toString() {
        return "Name: " + dname + "\nTeam: " + dteam + 
            "\nPosition: " + this.getClass().getName() + "\nScore: " + dscore + "\n";        
    }
    
    public int getScore() {
        return dscore;
    }

    public int score() {
       Random random = new Random(); 
       int goal = random.nextInt(2);
        int assist = random.nextInt(2);
        int yellowCard = random.nextInt(2);
        int redCard = random.nextInt(1);
        int foul = random.nextInt(5);
        
        return  4*goal + 2*assist - 2*yellowCard - 5*redCard - foul; 
        
               
    }

}
