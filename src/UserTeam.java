import java.util.Scanner;
import java.lang.Integer;

public class UserTeam extends Team {
   // RedMine ID: 512297
   int ownerID;
   int gameID;

   public void validatePositions() {
   }

   public void getStatistics() {
   }

   public void addPlayer(SoccerPlayer sp) {
      this.listOfPlayers.add(sp);
   }
   
   public void removePlayer(SoccerPlayer sp) {
      this.listOfPlayers.remove(sp);
   }

   public String getName() {
      return name;
   }

   public int getSize() {
      return listOfPlayers.size();
   }
}
