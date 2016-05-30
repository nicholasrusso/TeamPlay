package user;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import user.User;
import db.DBFactory;
>>>>>>> master
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBFactory;

public class UserSearch {
    private static final Logger log = Logger.getLogger("UserSearch");

    private String usernameQuery;
    

    public UserSearch(String username) {
        this.usernameQuery = username;
    }
    
    public void setQuery(String username) {
        this.usernameQuery = username;
    }
    
    /*
     *  Returns an arraylist of User's based on the user's username.
     */
    public List<User> getUsers() {
        String getUserSQL = "select username, firstname, lastname, passhash, "
                          + "email, lastlogin from main.User where username like "
                          + "'%' || ? || '%' order by username desc";
        Connection db = DBFactory.getDBConnection();
        
        log.fine("Find Friends Query String: " + this.usernameQuery);
        
        String qUsername;
        String qFirstName;
        String qLastName;
        String qEmailAddress;
        String qPassHash;
        
        List<User> users = new ArrayList<>();
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
                
                if (notEmpty(qUsername) && notEmpty(qFirstName) &&
                  notEmpty(qLastName) && notEmpty(qEmailAddress)) {
                    
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
            }
            pstmt.close();
            db.close();

        } catch (java.sql.SQLException e) {
            log.severe("UserQuery: Failed \n" + e.getMessage());
            log.severe(Arrays.toString(e.getStackTrace()));
            System.exit(1);
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
