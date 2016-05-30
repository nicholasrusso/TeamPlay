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
    public void TestGetInstanceLength() {
        Properties props = AppSettings.getInstance(); 
        assertTrue(props.keySet().size() > 0);
    }
    
    @Test
    public void TestGetInstanceIsSingleton() {
        Properties props1 = AppSettings.getInstance();
        Properties props2 = AppSettings.getInstance(); 
        assertTrue(props1 == props2);
    }

}
