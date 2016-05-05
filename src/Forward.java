public class Forward implements SoccerPlayer
{
    String name = "";
    String team = "";
    int score = 0;

    public Forward(String name, String team){
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
        int shot = (int)(Math.random() * 7);
        int shotOnGoal = (int)(Math.random() * 5);
        int yellowCard = (int)(Math.random() * 2);
        int redCard = (int)(Math.random() * 1);
        int foulDrawn = (int)(Math.random() * 3);
        
        int score = 0;
        score = 2*goal + assist + (shot - shotOnGoal) - 2*(yellowCard) - 4*(redCard) + 2*foulDrawn;
        
        return score;
    }

}