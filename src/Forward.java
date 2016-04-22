public class Forward implements SoccerPlayer
{
    String firstName = "";
    String lastName = "";
    String team = "";

    public Forward(String firstName, String lastName, String team){
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTeam() {
        return team;
    }

    public String print() {
        return ("Name: " + firstName + " " + lastName + "\nTeam: " + team + 
            "\nPosition: " + this.getClass().getName() + "\nScore: " + score() + "\n");        
    }

    public int score() {
        int goal = 0;
        int assist = 0;
        int shot = 0;
        int shotOnGoal = 0;
        int yellowCard = 0;
        int redCard = 0;
        int foulDrawn = 0;
        return 0;
    }

}