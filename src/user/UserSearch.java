package user;

import java.util.ArrayList;
import user.User;
import db.DBFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserSearch {
	private String usernameQuery;

	public UserSearch(String username) {
		this.usernameQuery = username;
	}
	
	public void setQuery(String username) {
		this.usernameQuery = username;
	}
	
	// Find users that contain given username string.
	public ArrayList<User> getUsers() {
		String getUserSQL = "select username, firstname, lastname, passhash, "
				          + "email, lastlogin from main.User where username like "
				          + "'%' || ? || '%' order by username desc";
		Connection db = DBFactory.getDBConnection();
		
		System.out.println("Find Friends Query String: " + this.usernameQuery);
		
		String qUsername;
		String qFirstName;
		String qLastName;
		String qEmailAddress;
		String qPassHash;
		Long qLastLogin;
		
		ArrayList<User> users = new ArrayList<User>();
		User tempUser;
    	
		try {
			PreparedStatement pstmt = db.prepareStatement(getUserSQL);
			pstmt.setString(1, this.usernameQuery);			
			ResultSet rs = pstmt.executeQuery(); 
		    
		    while (rs.next()) {
	    		qUsername = rs.getString("username");
	    		qFirstName = rs.getString("firstname");
	    		qLastName = rs.getString("lastname");
	    		qEmailAddress = rs.getString("email");
	    		qPassHash = rs.getString("passhash");
	    		qLastLogin = rs.getLong("lastlogin");
	    		
	    		if (notEmpty(qUsername) && notEmpty(qFirstName) &&
	    		  notEmpty(qLastName) && notEmpty(qEmailAddress) && 
	    		  notEmpty(qPassHash) && notEmpty(qLastLogin)) {
	    			
	    			tempUser = new User();
	    			tempUser.setUsername(qUsername);
	    			tempUser.setEmail(qEmailAddress);
	    			tempUser.setFirstName(qFirstName);
	    			tempUser.setLastName(qFirstName);
	    			tempUser.setPasswordHash(qPassHash);
	    			
	    			users.add(tempUser);
	    				    			
	    		}
	    		qUsername = null;
	    		qFirstName = null;
	    		qLastName = null;
	    		qEmailAddress = null;
	    		qPassHash = null;
	    		qLastLogin = null;
		    }
		    pstmt.close();
		    db.close();

		} catch (java.sql.SQLException e) {
			e.printStackTrace();
			System.out.println("UserQuery: Failed \n" + e.getMessage());
			System.exit(0);
		}
		
		return users;
	}
	
	private boolean notEmpty(Object obj) {
		
		if (obj != null && !obj.toString().isEmpty()) {
			return true;
		}
		
		return false;
	}
}
