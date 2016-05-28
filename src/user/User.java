package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import security.AppSettings;
import db.DBFactory;
import security.PasswordUtilities;

/**
 * @author charliegels
 * @version 1.0
 *
 * Created by charliegels on 4/11/16.
 *
 * This class serves as the user's profile created during registration and used to log in to the game application.
 * This class is used by the ProfileManger to create and edit user profiles
 */
public class User
{
	private static Properties props = AppSettings.getInstance();
	private static final Logger LOGGER = Logger.getLogger("User");

	
    private String firstName;
    private String lastName;
    private String userName;
    private Email email;
    private boolean allValidated;
    private String passwordHash;

    /***
     * Default constructor for user. User fields must be validated.
     * User instance should not be used unless allValidated is true.
     * */
    public User()
    {
        firstName = "";
        lastName = "";
        userName = "";
        email = new Email();
        allValidated = false;
        passwordHash= props.getProperty("emptyString");
    }

    /**
     * Validates userName for being alphanumeric characters.
     * @param userName desired username.
     * @return true if valid alphanumeric userName, otherwise false.
     * */
    public boolean setUsername(String userName)
    {
        if (userName.matches("^[A-Za-z0-9]+")) {
            this.userName = userName;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Accessor for user name.
     * @return username
     * */
    public String getUsername()
    {
        return userName;
    }

    /**
     * Validates firstName for being alphanumeric characters.
     * @param name desired username.
     * @return true if valid alphanumeric userName, otherwise false.
     * */
    public boolean setFirstName(String name)
    {
        if (name.matches("^[A-Za-z]+")) {
            firstName = name;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Accessor for first name.
     * @return first name of user
     * */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Validates userName for being alphanumeric characters.
     * @param name desired username.
     * @return true if valid alphanumeric last name, otherwise false.
     * */
    public boolean setLastName(String name)
    {
        if (name.matches("^[A-Za-z]+")) {
            lastName = name;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Accessor for user's last name.
     * @return user's last name
     * */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Validates userName for being alphanumeric characters.
     * @param address desired username.
     * @return true if valid email address, otherwise false.
     * */
    public boolean setEmail(String address)
    {
        return email.setAddress(address);
    }

    /**
     * Accessor for user's email address name.
     * @return user's email address
     * */
    public Email getEmail()
    {
        return email;
    }

    /**
     * @param set password hash as given string.
     * */
    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }
    
    /**
     * @param set password hash based on salt and password.
     * */
    public void setPasswordHashFromPassword(String password)
    {
        this.passwordHash = PasswordUtilities.getPasswordHash(password);
    }
    
    /**
     * Accessor for user's password hash.
     * @return user's password hash as a string.
     * */
    public String getPasswordHash()
    {
        return passwordHash;
    } 
    
    public boolean passwordValid()
    {
        return passwordHash != null;
    }


    /***
     * Accessor for the validaiton status of this user.
     * @return true if all fields are valid, else false.
     * */
    public boolean isValidated() {
    	allValidated = true;
    	allValidated &= setEmail(email.toString());
    	allValidated &= setFirstName(firstName);
    	allValidated &= setLastName(lastName);
    	allValidated &= setUsername(userName);
    	allValidated &= passwordValid();
    	return allValidated;
    }


    /***
     * String representation of this user.
     * @return user string
     */
    @Override
    public String toString()
    {
        return new StringBuilder().append("User Name  : ").append(userName)
                        .append("\nFirst Name : ").append(firstName)
                        .append("\nLast Name  : ").append(lastName)
                        .append("\nEmail      : ").append(email.toString()).toString();
    }
    
    public void save() {
    	String insertUserSQL = "insert into main.User (username, firstname, lastname, passhash, email, lastlogin) values (?,?,?,?,?,?)";
		Connection db = DBFactory.getDBConnection();
		
		try {
			PreparedStatement pstmt = db.prepareStatement(insertUserSQL);
			pstmt.setString(1, this.userName);
			pstmt.setString(2, this.firstName);
			pstmt.setString(3, this.lastName);
			pstmt.setString(4, this.passwordHash);
			pstmt.setString(5, this.email.toString());
			pstmt.setLong(6, System.currentTimeMillis() / 1000L);

			pstmt.executeUpdate();
			pstmt.close();
		    db.close();

		} catch (SQLException e) {
			LOGGER.warning(e.toString());
			LOGGER.warning("Unable to save user to database.");
		}
    }
    
    public void update() {
    	String updateUserSQL = "update main.User set username = ?, firstname = ?, lastname = ?, passhash = ?, email = ?, lastlogin = ? where username = ?";
    	Connection db = DBFactory.getDBConnection();
    	
    	try {
    		PreparedStatement pstmt = db.prepareStatement(updateUserSQL);
    		//set update values
			pstmt.setString(1, this.userName);
			pstmt.setString(2, this.firstName);
			pstmt.setString(3, this.lastName);
			pstmt.setString(4, this.passwordHash);
			pstmt.setString(5, this.email.toString());
			pstmt.setLong(6, System.currentTimeMillis() / 1000L);
			//set where condition
			pstmt.setString(7, this.userName);
			
			pstmt.executeUpdate();
			pstmt.close();
			db.close();
    	}
    	catch (SQLException e) {
    		LOGGER.warning(e.toString());
    	}
    }
    
}

