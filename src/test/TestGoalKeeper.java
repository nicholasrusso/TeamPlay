package test;

import static org.junit.Assert.*;
import org.junit.Test;

import soccerplayer.*;

/*
 * Test Type: Unit Test
 * Author: Spencer Sprowls
 */

public class TestGoalKeeper {


   @Test
   public void getPosition() {
      GoalKeeper gk = new GoalKeeper("Keylor Navas", "Real Madrid");

      assertEquals("GK", gk.getPosition());
   }

   @Test
   public void getName() {
      GoalKeeper gk = new GoalKeeper("Manuel Neur", "Bayern Munich");

      assertEquals("Bayern Munich", gk.getTeam());
   }

}
