package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class DBFactory {
    private static final Logger log = Logger.getLogger("DBFactory");


    private DBFactory() {
        // Static class
    }
    
    public static Connection getDBConnection() {
        Connection db = null;

        try {
          Class.forName("org.sqlite.JDBC");
          db = DriverManager.getConnection("jdbc:sqlite:data/test.db");
        } catch ( Exception e ) {
          log.severe(e.toString());
        }
        log.info("Opened database successfully");
        return db;
    }

}
