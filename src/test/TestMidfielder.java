package test;

import static org.junit.Assert.*;
import soccerplayer.*;
import org.junit.Test;


/*
 * Type of Test: Integration Test
 * Author: Spencer Sprowls
 */

public class TestMidfielder {
   
   @Test
   public void testScore() {
      Midfielder m = new Midfielder("Mesut Ozil", "Arsenal");

      
      assertTrue(m.toString().contains(m.getScore()+""));

   }

}


