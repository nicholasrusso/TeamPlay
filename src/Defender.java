public class Defender implements SoccerPlayer
{
    String firstName = "";
    String lastName = "";
    String team = "";

    public Defender(String firstName, String lastName, String team){
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
        int yellowCard = 0;
        int redCard = 0;
        int foul = 0;
        
        return 0;        
    }

}