package teams;

import java.util.ArrayList;
import java.util.List;

import soccerplayer.SoccerPlayer;

public class Team {
   private String name = "";
   private String formation = "";
   public List<SoccerPlayer> listOfPlayers;

   // RedMine ID: 512297
   public Team(String name)
   {
      this.name = name;
      this.formation = "4-3-3";
      listOfPlayers = new ArrayList<>();
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
