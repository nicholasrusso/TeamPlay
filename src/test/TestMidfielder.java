package test;

import orrg.junit.Assert.*;
import soccerplayer.*;
import org.junit.Test;


/*
 * Type of Test: Integration Test
 * Author: Spencer Sprowls
 */

public class TestMidfield {
   
   @Test
   public void testScore() {
      Midfielder m = new Midfielder("Mesut Ozil", "Arsenal");

      int score = m.getScore();
      assertTrue(m.toString().contains(m.getScore()+""));

   }

}


