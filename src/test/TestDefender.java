package test;

import static org.junit.Assert.*;

import org.junit.Test;

import soccerplayer.*;

/*
 * Test Type: Unit Test
 * Author: Spencer Sprowls
 */

public class TestDefender {
   @Test
   public void getDPlayerName() {
      Defender d = new Defender("Mats Hummels", "Dortmund");

      assertEquals("Mats Hummels", d.getName());
   }

   @Test
   public void getDPlayerTeam() {
      Defender d = new Defender("Jerome Boatang", "Bayern Munich");

      assertEquals("Bayern Munich", d.getTeam());
   }

}



