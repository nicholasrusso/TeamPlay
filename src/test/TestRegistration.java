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
		// need to delete from database before testing if it exists
		boolean test = Registration.registerUser("Cgels","password", "Charlie", "Gels", "cgels@calpoly.edu");
		assertTrue(test);
//		test = Registration.registerUser("Cgels","password", "Charlie", "Gels", "cgels@calpoly.edu");
//		assertFalse(test);
	}
	
	@Test
	public void testUsernameExistsFalse()
	{
		boolean test = Registration.usernameExists("cgels");
		assertFalse(test);
	}
	
	@Test public void testUsernameExistsTrue()
	{
		boolean test = Registration.usernameExists("Cgels");
		assertTrue(test);
	}
}
