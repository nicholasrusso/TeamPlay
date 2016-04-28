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

    public String toString() {
        return ("Name: " + name + "\nTeam: " + team + 
            "\nPosition: " + this.getClass().getName() + "\nScore: " + score + "\n");        
    }
    
    public int getScore() {
        return score;
    }

    public int score() {
        int goal = (int)(Math.random() * 2);
        int assist = (int)(Math.random() * 2);
        int yellowCard = (int)(Math.random() * 2);
        int redCard = (int)(Math.random() * 1);
        int foul = (int)(Math.random() * 5);
        
        int score = 4*goal + 2*assist - 2*yellowCard - 5*redCard - foul; 
        
        return score;        
    }

}