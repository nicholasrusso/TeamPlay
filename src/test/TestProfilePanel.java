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
    	User u = testSetup();
    	ProfilePanel test = new ProfilePanel(u);
    	String hash = PasswordUtilities.getPasswordHash("root");
    	assertTrue(hash.equals(test.getPassword()));
    }
	
	private static User testSetup()
	{
		User u = new User();
		
		u.setFirstName("root");
		u.setLastName("root");
		u.setUsername("root");
		u.setEmail("root@calpoly.edu");
		u.setPasswordHashFromPassword("root");
		return u;
	}
}
