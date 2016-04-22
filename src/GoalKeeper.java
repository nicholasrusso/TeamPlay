public class GoalKeeper implements SoccerPlayer
{
    String firstName = "";
    String lastName = "";
    String team = "";

    public GoalKeeper(String firstName, String lastName, String team){
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
        int save = 0;
        int cleanSheet = 0;
        int goalAgainst = 0;
        
        return 0;
    }

}