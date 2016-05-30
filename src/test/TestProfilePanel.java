package test;

import static org.junit.Assert.*;

import org.junit.Test;

import security.PasswordUtilities;
import user.ProfilePanel;
import user.User;

/**
 * Test Type: Integration Test
 * Author: Charlie Gels
 */
public class TestProfilePanel {
    public static User u = null;
    
    @Test
    public void getFirstName()
    {
        User u = testSetup();
        ProfilePanel test = new ProfilePanel(u);
        assertTrue(u.getFirstName().equals(test.getFirstName()));
    }
    
    @Test
    public void getLastName()
    {
        User u = testSetup();
        ProfilePanel test = new ProfilePanel(u);
        assertTrue(u.getLastName().equals(test.getLastName()));
    }
    
    @Test
    public void getUserName()
    {
        User u = testSetup();
        ProfilePanel test = new ProfilePanel(u);
        assertTrue(u.getUsername().equals(test.getUserName()));
    }
    
    @Test
    public void getEmailAddress()
    {
        User u = testSetup();
        ProfilePanel test = new ProfilePanel(u);
        assertTrue(u.getEmail().toString().equals(test.getEmailAddress()));
    }
    
    @Test
    public void getPassword()
    {
//      User u = testSetup();
//      ProfilePanel test = new ProfilePanel(u);
//      assertTrue("root".equals(test.getFirstName()));
    }
    
    private static User testSetup()
    {
        if (u == null)
        {
            u = new User();
        }
        
        u.setFirstName("root");
        u.setLastName("root");
        u.setUsername("root");
        u.setEmail("root@root.com");
        
        String password = "root";
        String hash = PasswordUtilities.getPasswordHash(password);
        u.setPasswordHashFromPassword("root");
        return u;
    }
}
