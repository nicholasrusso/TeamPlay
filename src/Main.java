import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.lang.InstantiationException;
import java.lang.IllegalAccessException;

public class Main {

    public static void main(String[] args) {
       ManuallyUploadTeams mut = new ManuallyUploadTeams();
       ArrayList<ProfessionalTeam> teams = mut.upload();
       System.out.println("Size " + teams.size());
       for (int i = 0; i < teams.size(); i++) {
          System.out.println("Size of team: " + teams.get(i).getSize());
          for (int j = 0; j < teams.get(i).getSize(); j++) {
             /*
             System.out.println("Player " + teams.get(i).get(j).getLastName());
             System.out.println("on team " + teams.get(i).get(j).getTeam);
             */
          }
       }

        GoalKeeper gk = new GoalKeeper("manuel neur", "bayern");
        Defender d = new Defender("mats hummel", "dortmund");
        Midfielder mf = new Midfielder("mesut ozil", "arsenal");
        Forward f = new Forward("mario gomez", "fiorentina");

        ArrayList<SoccerPlayer> list = new ArrayList<SoccerPlayer>();
        list.add(gk);
        list.add(d);
        list.add(mf);
        list.add(f);

        for (SoccerPlayer sp : list) {
            //System.out.println(sp.print());
            System.out.println(sp.getName());
            System.out.println(sp.getTeam());
        }

        System.out.println("Total Score: " + calculate(list));
        //run();
    }

    public static int calculate(ArrayList<SoccerPlayer> list) {
        int score = 0;

        return score;        
    }

    /*
    public static void run() {
        Connection db = null;

        try {
            Class.forName("org.sqlite.JDBC");
            db = DriverManager.getConnection("jdbc:sqlite:data/test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        // Simple select example
        try {
            Statement stmt = db.createStatement();
            String sql = ("SELECT * FROM user WHERE firstname = 'Michael'");

            ResultSet rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                System.out.println("Name: " 
                    + rs.getString("firstname") + " "
                    + rs.getString("lastname"));
            }
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    */

}
