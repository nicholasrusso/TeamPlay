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
    private String ex = "Example";
    private Team tt = new Team(ex);
    private GoalKeeper gk = new GoalKeeper("Buffon", ex);
    private Defender d = new Defender("Pique", ex);
    private Midfielder m = new Midfielder("Ozil", ex);
    private Forward f = new Forward("Totti", ex);
    
    /* Integration Testing */
    
    @Test
    public void addPlayersToTeam() {
        tt.addPlayer(gk);
        tt.addPlayer(d);
        tt.addPlayer(m);
        tt.addPlayer(f);
        
        assertEquals(4, tt.getSize(), 0);
    }
    
    @Test
    public void convertToList() {
        tt.addPlayer(gk);
        tt.addPlayer(d);
        tt.addPlayer(m);
        tt.addPlayer(f);
        List<SoccerPlayer> teamAsArray = tt.getTeam();
        assertEquals(4, teamAsArray.size());
    }

    /* Unit Tests */
    
    @Test
    public void getNameWorks() {
        assertEquals("Example", tt.getName());
    }
    
    @Test
    public void getFormationWorks() {
        assertEquals("4-3-3", tt.getFormation());
    }
    
    @Test
    public void setFormationWorks() {
        tt.setFormation("4-4-2");
        assertEquals("4-4-2", tt.getFormation());
    }
    
    @Test
    public void setNameWorks() {
        tt.setName("Changed");
        assertEquals("Changed", tt.getName());
    }
}
