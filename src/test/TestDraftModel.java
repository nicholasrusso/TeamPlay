package test;

import user.*;
import soccerplayer.*;
import tournament.Tournament;
import junit.framework.TestCase;
import java.util.*;

import draft.DraftModel;
/**
 *
 * @author Nicholas Russo
 */
public class TestDraftModel extends TestCase 
{
    private ArrayList<SoccerPlayer> players;
    private ArrayList<User> users;
    private Tournament tournament;
    private DraftModel model;
    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private static final String TEAM = "Barcelona";
    
    
    public TestDraftModel(String testName) 
    {
        super(testName);
    }
    
    @Override
    protected void setUp() {
        players = new ArrayList<>();
        players.add(new Forward("Messi", TEAM));
        players.add(new Forward("Saurez", TEAM));
        players.add(new Forward("Neymar", TEAM));
        players.add(new Midfielder("Xavi", TEAM));
        players.add(new Midfielder("Iniesta", TEAM));
        players.add(new Midfielder("Rakitic", TEAM));
        players.add(new Midfielder("Busquets", TEAM));
        players.add(new Defender("Pique", TEAM));
        players.add(new Defender("Mascherano", TEAM));
        players.add(new Defender("Dani Alves", TEAM));
        players.add(new Defender("Jordi Alba", TEAM));
        tournament = new Tournament("Test Tournament", 3, players);
        user1 = new User();
        user1.setFirstName("Nick");
        user1.setLastName("Russo");
        user1.setUsername("nrusso");
        user2 = new User();
        user2.setFirstName("rick");
        user2.setLastName("nusso");
        user2.setUsername("russo");
        user3 = new User();
        user3.setFirstName("asdf");
        user3.setLastName("asdf");
        user3.setUsername("fdas");
        user4 = new User();
        user4.setFirstName("no");
        user4.setLastName("nope");
        user4.setUsername("nah");
        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        tournament.addUser(user1);
        tournament.addUser(user2);
        tournament.addUser(user3);
        model = new DraftModel(tournament);
        
    }


    /**
     * Test of getLoopIterates
     * @author Nicholas Russo
     */
    public void testGetLoopIterates() 
    {
        model.startDraft();
        model.addNewTeam("test");
        model.startTimer();
        model.nextUser(0);
        assertEquals(1, model.getLoopIterations());
    }
}