package test;

import static org.junit.Assert.*;

import org.junit.Test;

import soccerplayer.*;

/*
 * Author: Spencer Sprowls
 *
 * */

public class TestDefender {

   /*
    * Test Type: Unit Test
    * 
   @Test
   public void getDPlayerName() {
      Defender d = new Defender("Mats Hummels", "Dortmund");

      assertEquals("Mats Hummels", d.getName());
   }

   /*
    * Test Type: Unit Test
    */

   @Test
   public void getDPlayerTeam() {
      Defender d = new Defender("Jerome Boatang", "Bayern Munich");

      assertEquals("Bayern Munich", d.getTeam());
   }

   /*
    * Test Type: Integration Test
    */
   @Test
      public void getScore() {
         Defender d = new Defender("Per Mertesacker", "Arsenal");

         int score = d.getScore();
         assertTrue(d.toString().contains(d.getScore()+""));
      }

}



