package test;

import static org.junit.Assert.*;

import org.junit.Test;
import teams.*;
import soccerplayer.*;

/*
 * Test Type: Unit Test
 * Author: Chauncey Neyman
 */

public class TestTeam {
    private Team testTeam = new Team("Example");
    private GoalKeeper gk = new GoalKeeper("Buffon", "Example");
    private Defender d = new Defender("Pique", "Example");
    private Midfielder m = new Midfielder("Ozil", "Example");
    private Forward f = new Forward("Totti", "Example");
    
    /* Integration Testing */
    
    @Test
    public void addPlayersToTeam() {
        testTeam.addPlayer(gk);
        testTeam.addPlayer(d);
        testTeam.addPlayer(m);
        testTeam.addPlayer(f);
        
        assertEquals(4, testTeam.getSize(), 0);
    }
    
    @Test
    public void addDefenderToTeam() {
        fail("Not yet implemented");
    }

    /* Unit Tests */
    
    @Test
    public void getNameWorks() {
        fail("Not yet implemented");
    }
    
    @Test
    public void addPlayerWorks() {
        fail("Not yet implemented");
    }
    
    @Test
    public void removePlayerWorks() {
        fail("Not yet implemented");
    }
    
    @Test
    public void getSizeWorks() {
        fail("Not yet implemented");
    }
}
