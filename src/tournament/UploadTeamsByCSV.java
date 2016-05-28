package tournament; 

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

import teams.ProfessionalTeam;

import soccerPlayer.*;

public class UploadTeamsByCSV {
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

            if (identifier.equals("team")) {
               if (curTeam != null) {
                  // store previous team to ret
                  ret.add(curTeam);
               }
               curTeam = new ProfessionalTeam(name);
            }
            else if (identifier.equals("G") && curTeam != null) {
               // new goalkeeper player
               GoalKeeper gk = new GoalKeeper(name, curTeam.getName());
               curTeam.addPlayer(gk);
            }
            else if (identifier.equals("D") && curTeam != null) {
               // new defender player
               Defender d = new Defender(name, curTeam.getName());
               curTeam.addPlayer(d);
            }
            else if (identifier.equals("M") && curTeam != null) {
               // new midfielder player
               Midfielder m = new Midfielder(name, curTeam.getName());
               curTeam.addPlayer(m);
            }
            else if (identifier.equals("F") && curTeam != null) {
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
