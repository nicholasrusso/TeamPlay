package test;

/*
 * Test Type: Unit Test
 * Author: Michael Haskell
 */

import static org.junit.Assert.*;
import security.AppSettings;
import java.util.Properties;

import org.junit.Test;

public class TestAppSettings {

    @Test
    public void testGetInstanceLength() {
        Properties props = AppSettings.getInstance(); 
        assertFalse(props.keySet().isEmpty());
    }
    
    @Test
    public void testGetInstanceIsSingleton() {
        Properties props1 = AppSettings.getInstance();
        Properties props2 = AppSettings.getInstance(); 
        assertTrue(props1 == props2);
    }

}
