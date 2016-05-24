package test;
import java.sql.*;
import java.sql.PreparedStatement;

public class SQLiteExample {
  public static void main(String args []) {
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
    
    // "Prepared" Statement
    try {
    		PreparedStatement pstmt = db.prepareStatement("SELECT count(*) FROM user WHERE firstname = ?");
    		pstmt.setString(1, "foo");
			ResultSet rs = pstmt.executeQuery();
						
			if (rs.getInt(1) == 0){
				System.out.println("Searching for 'foo' returned no values");				
			}
    } catch (SQLException e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
  }
}
