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

    public String toString() {
        return ("Name: " + name + "\nTeam: " + team + 
            "\nPosition: " + this.getClass().getName() + "\nScore: " + score + "\n");        
    }
    
    public int getScore() {
        return score;
    }

    public int score() {
        int save = (int)(Math.random() * 6);
        int cleanSheet = (int)(Math.random() * 1);
        int goalAgainst = (int)(Math.random() * 4);
        
        int score = 0;
        
        score = 2*save + 3*cleanSheet - goalAgainst;
        
        return score;
    }

}