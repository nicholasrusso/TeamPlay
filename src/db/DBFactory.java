package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBFactory {

    public DBFactory() {
        
    }
    public static Connection getDBConnection() {
        Connection db = null;

        try {
          Class.forName("org.sqlite.JDBC");
          db = DriverManager.getConnection("jdbc:sqlite:data/test.db");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Opened database successfully");
        return db;
    }

}
