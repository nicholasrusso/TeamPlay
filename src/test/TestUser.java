package test;

import static org.junit.Assert.*;

import org.junit.Test;

import user.User;

/**
 * Test Type: Unit Test
 * Author: Charlie Gels
 */
public class TestUser
{
    User user = new User();
    
    @Test
    public void testSetUsername()
    {
        assertTrue(user.setUsername("ArsenalBLAHBLAH123"));
        assertTrue(user.setUsername("Steven69Gerrad8"));
        assertTrue(user.setUsername("M3ssiIsASpicyLeprechaun"));
        assertFalse(user.setUsername("Sprowls_MakesFireM1XT4P3S"));
        assertFalse(user.setUsername("IdontKnow Class Diagrams"));
    }

    @Test
    public void testSetFirstName()
    {
    	String a = "Charlie";
        assertTrue(user.setFirstName(a));
        assertTrue(user.getFirstName().equals(a));

        String b = "1Abece";
        assertFalse(user.setFirstName(b));
        assertFalse(user.getFirstName().equals(b));

        String c = "AC!&c";
        assertFalse(user.setFirstName(c));
        assertFalse(user.getFirstName().equals(c));
    }
    
    @Test
    public void testSetLastName()
    {
    	String a = "Charlie";
        user.setLastName(a);
        assertTrue(user.getLastName().equals(a));

        String b = "1Abece";
        user.setLastName(b);
        assertFalse(user.getLastName().equals(b));

        String c = "AC!&c";
        user.setLastName(c);
        assertFalse(user.getLastName().equals(c));
    }


}