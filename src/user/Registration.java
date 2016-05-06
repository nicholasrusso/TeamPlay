package user;

import db.DBFactory;

import java.sql.*;

public class Registration {

	public Registration() {
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
			e.printStackTrace();
			System.exit(0);
		}
		return nameExists;
	}
	
	public static boolean registerUser(String username, String password, String firstname, 
			String lastname, String email){
				
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPasswordHash(password);
		newUser.setFirstName(firstname);
		newUser.setLastName(lastname);
		newUser.setEmail(email);
		
		if(newUser.isValidated()) {
			newUser.save();
		}
		return true;
	}
}
