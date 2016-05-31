package test;

import static org.junit.Assert.*;
import org.junit.Test;

import soccerplayer.*;

/*
 * Test Type: Unit Test
 * Author Spencer Sprowls
 */

public class TestForward {

   @Test
   public void getName() {
      Forward f = new Forward("Mario Balotelli", "AC Milan");

      assertEquals("Mario Balotelli", f.getName());
   }

}


