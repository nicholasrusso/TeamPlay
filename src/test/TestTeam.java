package test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;
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
    public void convertToList() {
        testTeam.addPlayer(gk);
        testTeam.addPlayer(d);
        testTeam.addPlayer(m);
        testTeam.addPlayer(f);
        List<SoccerPlayer> teamAsArray = testTeam.getTeam();
        assertEquals(4, teamAsArray.size());
    }

    /* Unit Tests */
    
    @Test
    public void getNameWorks() {
        assertEquals("Example", testTeam.getName());
    }
    
    @Test
    public void getFormationWorks() {
        assertEquals("4-3-3", testTeam.getFormation());
    }
    
    @Test
    public void setFormationWorks() {
        testTeam.setFormation("4-4-2");
        assertEquals("4-4-2", testTeam.getFormation());
    }
    
    @Test
    public void setNameWorks() {
        testTeam.setName("Changed");
        assertEquals("Changed", testTeam.getName());
    }
}
