package test;

import static org.junit.Assert.*;

import org.junit.Test;

import user.Registration;

/**
 * Test Type: Integration Test
 * Author: Charlie Gels
 */
public class TestRegistration {
    
    @Test
    public void testRegisterUser()
    {
        boolean test = Registration.usernameExists("cgels");
        assertFalse(test);
        
        // need to delete from database before testing if it exists
        test = Registration.registerUser("Cgels","password", "Charlie", "Gels", "cgels@calpoly.edu");
        assertTrue(test);
        
        test = Registration.usernameExists("Cgels");
        assertTrue(test);
    }
}
