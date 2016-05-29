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
    public void testSetUsername() throws Exception
    {
        assertTrue(user.setUsername("ArsenalBLAHBLAH123"));
        assertTrue(user.setUsername("Steven69Gerrad8"));
        assertTrue(user.setUsername("M3ssiIsASpicyLeprechaun"));
        assertFalse(user.setUsername("Sprowls_MakesFireM1XT4P3S"));
        assertFalse(user.setUsername("IdontKnow Class Diagrams"));
    }

    @Test
    public void testSetFirstName() throws Exception
    {

        assertTrue(user.setFirstName("Charlie"));
        assertTrue(user.getFirstName().equals("Charlie"));

        assertFalse(user.setFirstName("1Abece"));
        assertFalse(user.getFirstName().equals("1Abece"));

        assertFalse(user.setFirstName("AC!&c"));
        assertFalse(user.getFirstName().equals("AC!&c"));
    }
    
    @Test
    public void testSetLastName() throws Exception
    {
        user.setLastName("Charlie");
        assertTrue(user.getLastName().equals("Charlie"));

        user.setLastName("1Abece");
        assertFalse(user.getLastName().equals("1Abece"));

        user.setLastName("AC!&c");
        assertFalse(user.getLastName().equals("AC!&c"));
    }


}