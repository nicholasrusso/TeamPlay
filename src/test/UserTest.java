package test;

import junit.framework.TestCase;
import user.User;

/**
 * Created by charliegels on 4/11/16.
 */
public class UserTest extends TestCase
{
    User user = new User();

    public void testSetUsername() throws Exception
    {
        assertTrue(user.setUsername("ArsenalBLAHBLAH123"));
        assertTrue(user.setUsername("Steven69Gerrad8"));
        assertTrue(user.setUsername("M3ssiIsASpicyLeprechaun"));
        assertFalse(user.setUsername("Sprowls_MakesFireM1XT4P3S"));
        assertFalse(user.setUsername("IdontKnow Class Diagrams"));
    }

    public void testSetFirstName() throws Exception
    {

        assertTrue(user.setFirstName("Charlie"));
        assertTrue(user.getFirstName().equals("Charlie"));

        assertFalse(user.setFirstName("1Abece"));
        assertFalse(user.getFirstName().equals("1Abece"));

        assertFalse(user.setFirstName("AC!&c"));
        assertFalse(user.getFirstName().equals("AC!&c"));
    }

    public void testSetLastName() throws Exception
    {
        user.setLastName("Charlie");
        assertTrue(user.getLastName().equals("Charlie"));

        user.setLastName("1Abece");
        assertFalse(user.getLastName().equals("1Abece"));

        user.setLastName("AC!&c");
        assertFalse(user.getLastName().equals("AC!&c"));
    }

    public void testSetEmail() throws Exception
    {
        assertTrue(user.setEmail("cgels@calpoly.edu"));
        assertTrue(user.setEmail("gels.charles@gmail.com"));
        assertTrue(user.setEmail("nancy.neyman@arsenalsucks.com"));
        assertFalse(user.setEmail("charlie@gmail.gov"));
        assertTrue(user.setEmail("c1v2g3@tacos.net"));
    }

}