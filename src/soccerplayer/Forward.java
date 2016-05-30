package soccerplayer;

import java.util.Random;

public class Forward implements SoccerPlayer
{
    String fname = "";
    String fteam = "";
    int fscore = 0;

    public Forward(String name, String team){
        this.fname = name;
        this.fteam = team;
        this.fscore = score();
    }

    public String getName() {
        return fname;
    }

    
    public String getTeam() {
        return fteam;
    }

    @Override
    public String toString() {
        return "Name: " + fname + "\nTeam: " + fteam + 
            "\nPosition: " + this.getClass().getName() + "\nScore: " + fscore + "\n";        
    }
    
    public int getScore() {
        return fscore;
    }

    public int score() {
       Random random = new Random();
        int goal = random.nextInt(3);
        int assist = random.nextInt(3);
        int shot = random.nextInt(7);
        int shotOnGoal = random.nextInt(5);
        int yellowCard = random.nextInt(2);
        int redCard = random.nextInt(1);
        int foulDrawn = random.nextInt(3);
        
        
        return 2*goal + assist + (shot - shotOnGoal) - 2*(yellowCard) - 4*(redCard) + 2*foulDrawn;
        
        
    }
    
    public String getPosition() {
        return "F";
    }
    

}
