package soccerplayer;

import java.util.Random;

public class Midfielder implements SoccerPlayer
{
    String mname = "";
    String mteam = "";
    int mscore = 0;

    public Midfielder(String name, String team){
        this.mname = name;
        this.mteam = team;
        this.mscore = score();
    }

    public String getName() {
        return mname;
    }   

    public String getTeam() {
        return mteam;
    }

    @Override
    public String toString() {
        return "Name: " + mname + "\nTeam: " + mteam + 
            "\nPosition: " + this.getClass().getName() + "\nScore: " + mscore + "\n";        
    }
    
    public int getScore() {
        return mscore;
    }

    public int score() {
       Random random = new Random();
        int goal = random.nextInt(3);
        int assist = random.nextInt(3);
        int shot = random.nextInt(6);
        int shotOnGoal = random.nextInt(4);
        int yellowCard = random.nextInt(2);
        int redCard = random.nextInt(1);
        
        return goal + 3*assist + (shot - shotOnGoal) - 2*yellowCard - 3*redCard;
               
    }
    
    public String getPosition() {
		return "M";
	}
   
    

}
