package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import user.User;
/**
 * Test Type: Unit Test
 * Author: Charlie Gels
 */
public class TestEmail {

    

    @Test
    public void testSetEmailCom()
    {
        User user = new User();
        
        assertTrue(user.setEmail("gels.charles@gmail.com"));
        assertTrue(user.setEmail("nancy.neyman@arsenalsucks.com"));

    }
    
    @Test
    public void testSetEmailEdu()
    {
        User user = new User();
        
        assertTrue(user.setEmail("cgels@calpoly.edu"));

    }
    
    @Test
    public void testSetEmailGov()
    {
        User user = new User();

        assertFalse(user.setEmail("charlie@gmail.gov"));
    }
    
    @Test
    public void testSetEmailNet()
    {
        User user = new User();

        assertTrue(user.setEmail("c1v2g3@tacos.net"));
    }
}
