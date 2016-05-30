package tournament;

import java.util.*;
import soccerplayer.*;
import user.*;
/**
 * Tournament Class.
 */
public class Tournament {
    private String name;
    private int maxUsers;
    private ArrayList<SoccerPlayer> players;
    private ArrayList<User> users;
    /**
     * Constructor
     * @param name - String, Tournament name
     * @param maxUsers - int, max number of users allowed in tournament
     * @param players - List, List of soccer players to be used for pool.
     */
    public Tournament(String name, int maxUsers, List<SoccerPlayer> players)
    {
        this.name = name;
        this.maxUsers = maxUsers;
        this.players = (ArrayList<SoccerPlayer>) players;
        this.users = new ArrayList<>();
        Collections.shuffle(players);
    }

    /**
     * Accessor for players list
     */
    public List<SoccerPlayer> getPlayers()
    {
        return players;
    }
    /**
     * Accessor for users list
     */
    public List<User> getUsers()
    {
        return users;
    }
    /**
     * Accessor for tournament name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor for max number of players
     */
    public int getMaxUsers()
    {
        return maxUsers;
    }

    /**
     * Adds a user to the tournament
     * @param user, User the user to be added
     * @return boolean, true if successful false other wise.
     */
    public boolean addUser(User user)
    {
        if (users.contains(user) || (users.size() == maxUsers))
        {
            return false;
        }
        else
        {
            return users.add(user);
        }
        
    }
    /**
     * Removes a user from the tournament
     * @param user, User the user to be removed
     * @return boolean, true if successful false other wise.
     */
    public boolean removeUser(User user)
    {
        if (!users.contains(user))
        {
            return false;
        }
        else
        {
            return users.remove(user);
        }
    }
    
    /**
     * Remove player from available players
     */
    public void removePlayer(SoccerPlayer player)
    {
        players.remove(player);
    }
    
    public SoccerPlayer[] randomPlayers()
    {
        
        SoccerPlayer[] threePlayers = new SoccerPlayer[3];
        Collections.shuffle(players);
        threePlayers[0] = players.get(0);
        threePlayers[1] = players.get(1);
        threePlayers[2] = players.get(2);
        return threePlayers;
    }

}
