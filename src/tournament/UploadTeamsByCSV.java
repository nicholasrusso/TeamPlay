package tournament; 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import soccerplayer.Defender;
import soccerplayer.Forward;
import soccerplayer.GoalKeeper;
import soccerplayer.Midfielder;
import teams.Team;

public class UploadTeamsByCSV {
   public ArrayList<Team> upload() {
      // Relies on file named "TeamList.csv" 
      String csvFile = "TeamList.csv";

      String line = "";
      String csvSplitBy = ",";
      // Create a new professional team curTeam, start as null
      ArrayList<Team> ret = new ArrayList<Team>();
      Team curTeam = null;

      try {
         Scanner br = new Scanner(new File(csvFile));
         
         while (br.hasNextLine()) {
            line = br.nextLine();
            String[] curLine = line.split(csvSplitBy);
            String identifier = curLine[0];
            String name = curLine[1];

            if (identifier.equals("team")) {
               if (curTeam != null) {
                  // store previous team to ret
                  ret.add(curTeam);
               }
               curTeam = new Team(name);
            }
            else if (curTeam != null && identifier.equals("G")) {
               // new goalkeeper player
               GoalKeeper gk = new GoalKeeper(name, curTeam.getName());
               curTeam.addPlayer(gk);
            }
            else if (curTeam != null && identifier.equals("D")) {
               // new defender player
               Defender d = new Defender(name, curTeam.getName());
               curTeam.addPlayer(d);
            }
            else if (curTeam != null && identifier.equals("M")) {
               // new midfielder player
               Midfielder m = new Midfielder(name, curTeam.getName());
               curTeam.addPlayer(m);
            }
            else if (curTeam != null && identifier.equals("F")) {
               // new forward player
               Forward f = new Forward(name, curTeam.getName());
               curTeam.addPlayer(f);
            }
            else {
               System.out.println("Identifier: " + identifier);
               System.out.println("Identifier was not 'team', G, D, M or F");
            }
         }
         br.close();
      }
      catch (FileNotFoundException e) {
         System.out.println("File named ''TeamList.csv'' not found");
         //e.printStackTrace();
      }
      
      return ret;
   }
}
