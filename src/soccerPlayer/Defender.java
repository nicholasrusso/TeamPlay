package soccerplayer;

import java.util.Random;

public class Defender implements SoccerPlayer
{
    String name = "";
    String team = "";
    int score = 0;

    public Defender(String name, String team){
        this.name = name;
        this.team = team;
        this.score = score();
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
   
    @Override
    public String toString() {
        return "Name: " + name + "\nTeam: " + team + 
            "\nPosition: " + this.getClass().getName() + "\nScore: " + score + "\n";        
    }
    
    public int getScore() {
        return score;
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
