import java.util.Scanner;
import java.lang.Integer;
import java.util.ArrayList;

public abstract class Team {
   // RedMine ID: 512297

   protected String name = "";
   public ArrayList<SoccerPlayer> listOfPlayers = new ArrayList<SoccerPlayer>();

   public void addPlayer(SoccerPlayer sp) {
   }
   
   public void removePlayer(SoccerPlayer sp) {
   }

   public String getName() {
      return name;
   }

   public int getSize() {
      return listOfPlayers.size();
   }
}
