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
    
    public TournamentTest(String testName) 
    {
        super(testName);
    }

    /**
     * Test of connectClient method, of class SimulationStatusModel.
     */
    public void testGetPlayers() 
    {
        System.out.println("----Testing GetPlayers----");
        ArrayList<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
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
        Tournament tournament = new Tournament("Test Tournament", 10, players);
        
        assertEquals(players, tournament.getPlayers());
    }

    /**
     * Test of connectClient method, of class SimulationStatusModel.
     */
    public void testGetUsers() 
    {
        System.out.println("----Testing GetUsers----");
        ArrayList<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
        Tournament tournament = new Tournament("Test Tournament", 3, players);
        User user1 = new User();
        user1.setFirstName("Nick");
        user1.setLastName("Russo");
        user1.setUsername("nrusso");
        User user2 = new User();
        user2.setFirstName("rick");
        user2.setLastName("nusso");
        user2.setUsername("russo");
        User user3 = new User();
        user3.setFirstName("asdf");
        user3.setLastName("asdf");
        user3.setUsername("fdas");
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        tournament.addUser(user1);
        tournament.addUser(user2);
        tournament.addUser(user3);
        assertEquals(users, tournament.getUsers());
    }


    /**
     * Test of disconnectClient method, of class SimulationStatusModel.
     */
    public void testGetName() 
    {
        System.out.println("----Testing GetName----");
        ArrayList<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
        Tournament tournament = new Tournament("Test Tournament", 10, players);
        
        assertEquals("Test Tournament", tournament.getName());
    }

    /**
     * Test of setSimManagerStatus method, of class SimulationStatusModel.
     */
    public void testGetMaxUsers() 
    {
        System.out.println("----Testing GetMaxUsers----");
        ArrayList<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
        Tournament tournament = new Tournament("Test Tournament", 10, players);
        
        assertEquals(10, tournament.getMaxUsers());
    }

    /**
     * Test of setTime method, of class SimulationStatusModel.
     */
    public void testAddUser() 
    {
        System.out.println("----Testing AddUser----");
        ArrayList<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
        Tournament tournament = new Tournament("Test Tournament", 3, players);
        User user1 = new User();
        user1.setFirstName("Nick");
        user1.setLastName("Russo");
        user1.setUsername("nrusso");
        User user2 = new User();
        user2.setFirstName("rick");
        user2.setLastName("nusso");
        user2.setUsername("russo");
        User user3 = new User();
        user3.setFirstName("asdf");
        user3.setLastName("asdf");
        user3.setUsername("fdas");
        User user4 = new User();
        user4.setFirstName("no");
        user4.setLastName("nope");
        user4.setUsername("nah");
        System.out.println("----AddingUsers----");
        assertTrue(tournament.addUser(user1));
        assertTrue(tournament.addUser(user2));
        System.out.println("----Double Add----");
        assertFalse(tournament.addUser(user2));
        assertTrue(tournament.addUser(user3));
        System.out.println("----Over Limit----");
        assertFalse(tournament.addUser(user4));
    }

    /**
     * Test of setScriptStatus method, of class SimulationStatusModel.
     */
    public void testRemoveUser() 
    {
        System.out.println("----Testing RemoveUser----");
        ArrayList<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
        Tournament tournament = new Tournament("Test Tournament", 3, players);
        User user1 = new User();
        user1.setFirstName("Nick");
        user1.setLastName("Russo");
        user1.setUsername("nrusso");
        User user2 = new User();
        user2.setFirstName("rick");
        user2.setLastName("nusso");
        user2.setUsername("russo");
        User user3 = new User();
        user3.setFirstName("asdf");
        user3.setLastName("asdf");
        user3.setUsername("fdas");
        User user4 = new User();
        user4.setFirstName("no");
        user4.setLastName("nope");
        user4.setUsername("nah");
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        tournament.addUser(user1);
        tournament.addUser(user2);
        tournament.addUser(user3);
        System.out.println("----Testing GetUsers Before Remove----");
        assertEquals(users, tournament.getUsers());
        System.out.println("----Testing Remove Boolean----");
        assertTrue(tournament.removeUser(user3));
        System.out.println("----Testing ArrayList After Remove----");
        users.remove(user3);
        assertEquals(users, tournament.getUsers());
        System.out.println("----Testing Remove Not There----");
        assertFalse(tournament.removeUser(user4));

    }

    
}
