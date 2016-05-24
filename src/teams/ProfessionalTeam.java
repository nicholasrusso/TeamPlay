package teams;

import java.util.Scanner;
import java.lang.Integer;
import java.util.ArrayList;
import soccerPlayer.*;

public class ProfessionalTeam extends Team {
   // RedMine ID: 512297
   //String league;

   public ProfessionalTeam() {
      this.name = "";
      //this.listOfPlayers = null;
   }

   public ProfessionalTeam(String name) {
      this.name = name;
      //this.listOfPlayers = null;
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
