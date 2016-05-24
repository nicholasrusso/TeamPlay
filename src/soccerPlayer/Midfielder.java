package soccerPlayer;

public class Midfielder implements SoccerPlayer
{
    String name = "";
    String team = "";
    int score = 0;

    public Midfielder(String name, String team){
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

    public String toString() {
        return ("Name: " + name + "\nTeam: " + team + 
            "\nPosition: " + this.getClass().getName() + "\nScore: " + score + "\n");        
    }
    
    public int getScore() {
        return score;
    }

    public int score() {
        int goal = (int)(Math.random() * 3);
        int assist = (int)(Math.random() * 3);
        int shot = (int)(Math.random() * 6);
        int shotOnGoal = (int)(Math.random() * 4);
        int yellowCard = (int)(Math.random() * 2);
        int redCard = (int)(Math.random() * 1);
        
        int score = goal + 3*assist + (shot - shotOnGoal) - 2*yellowCard - 3*redCard;
        return score;        
    }

}