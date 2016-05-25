package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
import db.DBFactory;
=======
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Logger;
>>>>>>> master

public class UserInfo {
	private static final Logger log = Logger.getLogger("UserInfo");


	public UserInfo() {
		// Static class
	}
	
	public static boolean usernameExists(String username) {
		boolean nameExists = true;
		String nameExistsSQL = "select count(username) from user where username = ?";
		Connection db = DBFactory.getDBConnection();
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = db.prepareStatement(nameExistsSQL);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs != null && rs.getInt(1) == 0){
				nameExists = false;	
			}
			pstmt.close();
			db.close();
		} catch (SQLException e) {
			log.severe(Arrays.toString(e.getStackTrace()));
			System.exit(1);
		}
		return nameExists;
	}
	
	public static boolean registerUser(String username, String password, String firstname, 
			String lastname, String email){
				
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPasswordHashFromPassword(password);
		newUser.setFirstName(firstname);
		newUser.setLastName(lastname);
		newUser.setEmail(email);
		
		if(newUser.isValidated()) {
			newUser.save();
		}
		return true;
	}
	
}
