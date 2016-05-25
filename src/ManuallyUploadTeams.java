import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import soccerPlayer.Defender;
import soccerPlayer.Forward;
import soccerPlayer.GoalKeeper;
import soccerPlayer.Midfielder;
import teams.ProfessionalTeam;

public class ManuallyUploadTeams {
   public ArrayList<ProfessionalTeam> upload() {
      // Relies on file named "TeamList.csv" 
      String csvFile = "TeamList.csv";

      //Scanner br = null;
      String line = "";
      String csvSplitBy = ",";
      // Create a new professional team curTeam, start as null
      ArrayList<ProfessionalTeam> ret = new ArrayList<ProfessionalTeam>();
      ProfessionalTeam curTeam = null;

      try {
         System.out.println("Main block");
         Scanner br = new Scanner(new File(csvFile));
         //line = br.readLine();
         
         while (br.hasNextLine()) {
            line = br.nextLine();
            String[] curLine = line.split(csvSplitBy);
            String identifier = curLine[0];
            String name = curLine[1];
            
            /*
            for (int i = 0; i < curLine.length; i++) {
               System.out.println("Curline[i]: " + curLine[i]);
            }
            for (int i = 0; i < name.length; i++) {
               System.out.println("Name[i]: " + name[i]);
            }
            */

            //System.out.println("Identifier: " + identifier);

            if (identifier.equals("team")) {
               if (curTeam != null) {
                  // store previous team to ret
                  ret.add(curTeam);
               }
               curTeam = new ProfessionalTeam(name);
            }
            else if (identifier.equals("G")) {
               // new goalkeeper player
               GoalKeeper gk = new GoalKeeper(name, curTeam.getName());
               curTeam.addPlayer(gk);
            }
            else if (identifier.equals("D")) {
               // new defender player
               Defender d = new Defender(name, curTeam.getName());
               curTeam.addPlayer(d);
            }
            else if (identifier.equals("M")) {
               // new midfielder player
               Midfielder m = new Midfielder(name, curTeam.getName());
               curTeam.addPlayer(m);
            }
            else if (identifier.equals("F")) {
               // new forward player
               Forward f = new Forward(name, curTeam.getName());
               curTeam.addPlayer(f);
            }
            else {
               System.out.println("Identifier: " + identifier);
               System.out.println("Identifier was not 'team', G, D, M or F");
            }
            //line = br.readLine();
            //System.out.println("Line: " + line);
         }
         br.close();
      }
      catch (FileNotFoundException e) {
         System.out.println("File named ''TeamList.csv'' not found");
         e.printStackTrace();
   
      }
   
      /*finally {
         if (br != null) {
            try {
               br.close();
            }
         }
         return ret;
      }
      */
      return ret;
   }
}
