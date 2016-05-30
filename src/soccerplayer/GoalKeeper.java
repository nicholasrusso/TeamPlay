package soccerplayer;

import java.util.Random;

public class GoalKeeper implements SoccerPlayer
{
    String name = ""; 
    String team = "";
    int score = 0;

    public GoalKeeper(String name, String team){
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
        int save = random.nextInt(6);
        int cleanSheet = random.nextInt(1);
        int goalAgainst = random.nextInt(4);
        
        
        return 2*save + 3*cleanSheet - goalAgainst;
        
    }
    
    public String getPosition() {
		return "GK";
	}
    

}
