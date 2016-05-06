import java.util.Scanner;
import java.lang.Integer;
import java.util.ArrayList;

public class ProfessionalTeam extends Team {
   // RedMine ID: 512297
   //String league;

   public ProfessionalTeam() {
      this.name = "";
   }

   public ProfessionalTeam(String name) {
      this.name = name;
   }

   public void addPlayer(SoccerPlayer sp) {
      this.listOfPlayers.add(sp);
   }

   public void removePlayer(SoccerPlayer sp) {
      this.listOfPlayers.remove(sp);
   }

   public String getName() {
      return this.name;
   }
}
