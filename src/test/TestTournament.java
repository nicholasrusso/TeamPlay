package test;

import user.*;
import soccerplayer.*;
import tournament.Tournament;
import junit.framework.TestCase;
import java.util.*;
/**
 * Test for Tournament Class
 * @author Nicholas Russo
 */
public class TestTournament extends TestCase 
{
    private ArrayList<SoccerPlayer> list;
    private ArrayList<User> userList;
    private Tournament tourn;
    private User users1;
    private User users2;
    private User users3;
    private User users4;
    private static final String BARCA = "Barcelona";
    
    
    public TestTournament(String testName) 
    {
        super(testName);
    }
    
    @Override
    protected void setUp() {
        list = new ArrayList<>();
        list.add(new Forward("Messi", BARCA));
        list.add(new Forward("Saurez", BARCA));
        list.add(new Forward("Neymar", BARCA));
        list.add(new Midfielder("Xavi", BARCA));
        list.add(new Midfielder("Iniesta", BARCA));
        list.add(new Midfielder("Rakitic", BARCA));
        list.add(new Midfielder("Busquets", BARCA));
        list.add(new Defender("Pique", BARCA));
        list.add(new Defender("Mascherano", BARCA));
        list.add(new Defender("Dani Alves", BARCA));
        list.add(new Defender("Jordi Alba", BARCA));
        tourn = new Tournament("Test Tournament", 3, list);
        users1 = new User();
        users1.setFirstName("Nick");
        users1.setLastName("Russo");
        users1.setUsername("nrusso");
        users2 = new User();
        users2.setFirstName("rick");
        users2.setLastName("nusso");
        users2.setUsername("russo");
        users3 = new User();
        users3.setFirstName("asdf");
        users3.setLastName("asdf");
        users3.setUsername("fdas");
        users4 = new User();
        users4.setFirstName("no");
        users4.setLastName("nope");
        users4.setUsername("nah");
        userList = new ArrayList<>();
        userList.add(users1);
        userList.add(users2);
        userList.add(users3);
        tourn.addUser(users1);
        tourn.addUser(users2);
        tourn.addUser(users3);
    }


    /**
     * Test of getPlayers
     * @author Nicholas Russo
     */
    public void testGetPlayers() 
    {
        assertEquals(list, tourn.getPlayers());
    }

    /**
     * Test of getUsers
     * @author Nicholas Russo
     */
    public void testGetUsers() 
    {
        assertEquals(userList, tourn.getUsers());
    }


    /**
     * Test of getName
     * @author Nicholas Russo
     */
    public void testGetName() 
    {
        assertEquals("Test Tournament", tourn.getName());
    }

    /**
     * Test of getMaxUser
     * @author Nicholas Russo
     */
    public void testGetMaxUsers() 
    {
        assertEquals(3, tourn.getMaxUsers());
    }

    /**
     * Test of addUser General
     * @author Nicholas Russo
     */
    public void testAddUser() 
    {   
        tourn.removeUser(users1);
        assertTrue(tourn.addUser(users1));
    }
    
    /**
     * Test of addUser when there is a "double" add
     * @author Nicholas Russo
     */
    public void testAddUserDoubleAdd() 
    {
        assertFalse(tourn.addUser(users2));
    }
    /**
     * Test of addUser when the tournament is full
     * @author Nicholas Russo
     */
    public void testAddUserOverLimit() 
    {
        assertFalse(tourn.addUser(users4));
    }

    /**
     * Test of removeUser when user exist
     * @author Nicholas Russo
     */
    public void testRemoveUserDoesExist() 
    {
        assertTrue(tourn.removeUser(users3));
    }
    
    /**
     * Test of removeUser when user does not exist
     *  @author Nicholas Russo
     */
    public void testRemoveUserDoesNotExit() 
    {
        assertFalse(tourn.removeUser(users4));
    }

    
}
