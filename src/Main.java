import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.lang.InstantiationException;
import java.lang.IllegalAccessException;

import java.util.Properties;
import org.junit.Assert;
import org.junit.Test;
import security.AppSettings;
import email.EmailUtilities;


public class Main {

    public static void main(String[] args) {
        GoalKeeper gk = new GoalKeeper("manuel neur", "bayern");
        Defender d = new Defender("mats hummel", "dortmund");
        Midfielder mf = new Midfielder("mesut ozil", "arsenal");
        Forward f = new Forward("mario gomez", "fiorentina");

        ArrayList<SoccerPlayer> list = new ArrayList<SoccerPlayer>();
        list.add(gk);
        list.add(d);
        list.add(mf);
        list.add(f);   
        
        int score = 0;
        
               
        for (SoccerPlayer sp : list) {            
            System.out.println(sp.toString());
            System.out.println("Correct Score: " + sp.getScore());
            System.out.println();
            score += sp.getScore();            
        }

        System.out.println("Total Score: " + score);
        //run();
        email();

    }

    public static void email() {
       Properties props = AppSettings.getInstance();
       String to = props.getProperty("spencer.sprowls@gmail.com");
       String subject = ("suhhhh this is the subject fam");
       String content = ("I got a bad ass bitch named Brooklyn");

       boolean b = EmailUtilities.sendEmail(to, subject, content);
       Assert.assertTrue(b);
    }
  

    public static void run() {
        Connection db = null;

        try {
            Class.forName("org.sqlite.JDBC");
            db = DriverManager.getConnection("jdbc:sqlite:/data/test.db");
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

}
