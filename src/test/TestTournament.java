package tournament;

import user.*;
import soccerplayer.*;
import junit.framework.TestCase;
import java.util.*;
/**
 *
 * @author nicholasrusso
 */
public class TournamentTest extends TestCase 
{
	private ArrayList<SoccerPlayer> players;
	private ArrayList<User> users;
	private Tournament tournament;
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	
    
    public TournamentTest(String testName) 
    {
        super(testName);
    }
    
    @Override
    protected void setUp() {
        players = new ArrayList<SoccerPlayer>();
        players.add(new Forward("Messi", "Barcelona"));
        players.add(new Forward("Saurez", "Barcelona"));
        players.add(new Forward("Neymar", "Barcelona"));
        players.add(new Midfielder("Xavi", "Barcelona"));
        players.add(new Midfielder("Iniesta", "Barcelona"));
        players.add(new Midfielder("Rakitic", "Barcelona"));
        players.add(new Midfielder("Busquets", "Barcelona"));
        players.add(new Defender("Pique", "Barcelona"));
        players.add(new Defender("Mascherano", "Barcelona"));
        players.add(new Defender("Dani Alves", "Barcelona"));
        players.add(new Defender("Jordi Alba", "Barcelona"));
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
        users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        tournament.addUser(user1);
        tournament.addUser(user2);
        tournament.addUser(user3);
    }


    /**
     * Test of getPlayers
     */
    public void testGetPlayers() 
    {
        assertEquals(players, tournament.getPlayers());
    }

    /**
     * Test of getUsers
     */
    public void testGetUsers() 
    {
        assertEquals(users, tournament.getUsers());
    }


    /**
     * Test of getName
     */
    public void testGetName() 
    {
        assertEquals("Test Tournament", tournament.getName());
    }

    /**
     * Test of getMaxUsers
     */
    public void testGetMaxUsers() 
    {
        assertEquals(3, tournament.getMaxUsers());
    }

    /**
     * Test of addUser General
     */
    public void testAddUser() 
    {   
    	tournament.removeUser(user1);
        assertTrue(tournament.addUser(user1));
    }
    
    /**
     * Test of addUser when there is a "double" add
     */
    public void testAddUserDoubleAdd() 
    {
    	assertFalse(tournament.addUser(user2));
    }
    /**
     * Test of addUser when the tournament is full
     */
    public void testAddUserOverLimit() 
    {
        assertFalse(tournament.addUser(user4));
    }

    /**
     * Test of removeUser when user exist
     */
    public void testRemoveUserDoesExist() 
    {
        assertTrue(tournament.removeUser(user3));
    }
    
    /**
     * Test of removeUser when user does not exist
     */
    public void testRemoveUserDoesNotExit() 
    {
        assertFalse(tournament.removeUser(user4));
    }

    
}
