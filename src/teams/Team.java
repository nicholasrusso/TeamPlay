package teams;

import soccerplayer.SoccerPlayer;
import java.util.ArrayList;
import java.util.List;

public class Team {
   private String name = "";
   private String formation = "";
   public ArrayList<SoccerPlayer> listOfPlayers;

   // RedMine ID: 512297
   public Team(String name)
   {
      this.name = name;
      this.formation = "4-3-3";
      listOfPlayers = new ArrayList<SoccerPlayer>();
   }
   
   public void addPlayer(SoccerPlayer sp) {
      listOfPlayers.add(sp);
   }
   
   public void removePlayer(SoccerPlayer sp) {
      listOfPlayers.remove(sp);
   }

   public String getName() {
      return name;
   }

   public int getSize() {
      return listOfPlayers.size();
   }
   
   public List<SoccerPlayer> getTeam()
   {
      return listOfPlayers;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setFormation(String formation)
   {
      this.formation = formation;
   }
   
   public String getFormation()
   {
      return formation;
   }
}
