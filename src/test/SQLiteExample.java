package test;

import java.sql.*;
import java.util.logging.Logger;

public class SQLiteExample {
	
	private SQLiteExample() {
		// Static class
	}
    
    public static void main(String [] args ) {

    Logger log = Logger.getLogger("SQLiteExample");

    Connection db = null;

    try {
      Class.forName("org.sqlite.JDBC");
      db = DriverManager.getConnection("jdbc:sqlite:data/test.db");
    } catch ( Exception e ) {
      log.severe(e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Opened database successfully");

    // Simple select example
    try {
			Statement stmt = db.createStatement();
			String sql = "SELECT * FROM user WHERE firstname = 'Michael'";

			ResultSet rs = stmt.executeQuery(sql);
			while ( rs.next() ) {
				log.severe("Name: " 
                          + rs.getString("firstname") + " "
                          + rs.getString("lastname"));
			}
    } catch (SQLException e) {
      log.severe( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    
    // "Prepared" Statement
    try {
    		PreparedStatement pstmt = db.prepareStatement("SELECT count(*) FROM user WHERE firstname = ?");
    		pstmt.setString(1, "foo");
			ResultSet rs = pstmt.executeQuery();
						
			if (rs.getInt(1) == 0){
				log.info("Searching for 'foo' returned no values");				
			}
    } catch (SQLException e) {
      log.severe( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
  }
}
