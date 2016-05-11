package test;

import static org.junit.Assert.*;
import security.PasswordUtilities;

import org.junit.Test;

public class TestPasswordUtilities {

	@Test
	public void TestGetPasswordHashUnique() {
		String passHash1 = PasswordUtilities.getPasswordHash("");
		String passHash2 = PasswordUtilities.getPasswordHash("password");
		assertNotEquals(passHash1, passHash2);
	}
	
	@Test
	public void TestGetPasswordHashEmpty() {
		String passHash = PasswordUtilities.getPasswordHash("");
		String saltOnlyHash = "B8803B51D3A0A95E68F03309ECE0B242B2975454989402B5C88B74192CB0D7E683096252BE0CAD9B943191566DE3C7D07C58609434AEB04998B992132F6583A0";
		assertEquals(saltOnlyHash, passHash);
	}
}
