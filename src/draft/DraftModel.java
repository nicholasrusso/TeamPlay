package draft;

import java.util.ArrayList;
import java.util.Observable;

import java.util.Timer;
import java.util.TimerTask;

import user.*;
import tournament.*;
import soccerplayer.*;
import teams.Team;

public class DraftModel extends Observable{
    private Tournament tournament;
    private ArrayList<User> users;
    private User currentUser;
    private int userPosition;
    private SoccerPlayer[] currentPlayerSelection;
    private SoccerPlayer[] randomPlayers;
    private static int turnSeconds;
    private int draftRound;
    private boolean selection;
    private Timer clock;
    private String time;
    private boolean draftOver;
    
    public DraftModel(Tournament tournament) 
    {
        this.userPosition = 0;
        this.draftRound = 0;
        this.tournament = tournament;
        this.users = (ArrayList<User>) tournament.getUsers();
        this.currentUser = users.get(userPosition);
        randomPlayers = new SoccerPlayer[3];
        turnSeconds = 10;
        selection = false;
        draftOver = false;
        //dummy data
        
        for (User u : users)
        {
        	u.generateDummyPlayerUsages(tournament.getPlayers());
        }
    }


    public User getCurrentUser()
    {
        return currentUser;
    }

    public void nextUser(int pos)
    {
            if (draftRound < (18 * tournament.getUsers().size()))
            {
            	addPlayer(pos);
                if (userPosition < users.size() - 1)
                {
                    currentUser = users.get(++userPosition);
                }
                else
                {
                    userPosition = 0;
                    currentUser = users.get(userPosition);
                }
                
                draftRound++;
                
            }
            else
            {
            	selection = false;
            	draftOver = true;
            }
            selection = false;
            currentPlayerSelection = null;
            clock.cancel();

            this.setChanged();
            this.notifyObservers();        
    }
    
    public int getLoopIterations()
    {
    	return draftRound;
    }
    
    public boolean getSelection()
    {
    	return selection;
    }
    public boolean isOver()
    {
    	return draftOver;
    }

    public void addPlayer(int location)
    {
    	currentUser.incrementPlayerUsage(currentPlayerSelection[location]);
    	getCurrentUserTeam().addPlayer(currentPlayerSelection[location]);
        tournament.removePlayer(currentPlayerSelection[location]);
    }
    
    public void startTimer()
    {
    	clock = new Timer();
        clock.schedule(new TimerTask(){

            int second = 60;
            @Override
            public void run() {
            	DraftModel.this.time = second-- + " seconds.";
                DraftModel.this.setChanged();
                DraftModel.this.notifyObservers();
            }   
        },0, 1000);
        
    }
    
    public int getTurnSeconds()
    {
        return turnSeconds;
    }
    
    public String getTime(){
    	return time;
    }
    public SoccerPlayer[] getCurrentPlayerSelection()
    {
        return currentPlayerSelection;
    }

    public Team getCurrentUserTeam()
    {
        return currentUser.getTeam(tournament.getName());
    }
    public String getCurrentUserTeamName()
    {
    	if (hasTeam())
    		return getCurrentUserTeam().getName();
    	return "";
    }
    public String getCurrentUserTeamFormation()
    {
    	if (hasTeam())
    		return getCurrentUserTeam().getFormation();
    	return "4-3-3";
    }
    public String getCurrentUserTeamSize()
    {
    	if (hasTeam())
    		return getCurrentUserTeam().getSize() + "";
    	return "0";
    }
    
    public void startDraft()
    {
    	selection = true; 
    	currentPlayerSelection = tournament.randomPlayers();
    	setChanged();
    	notifyObservers();
    	
    }
    
    public void canelClock()
    {
    	clock.cancel();
    }
    
    public boolean hasTeam()
    {
    	return getCurrentUserTeam() != null;
    }
    
    public void addNewTeam(String name)
    {
    	currentUser.setTeam(tournament.getName(), new Team(name));
    	setChanged();
    	notifyObservers();
    }
    
    public String getCurrentUserName()
    {
    	return currentUser.getFirstName() + " " + currentUser.getLastName();
    }
    
    public String getTeamToString(String type)
    {
    	String result = "";
    	ArrayList<SoccerPlayer> forwards = new ArrayList<>();
    	ArrayList<SoccerPlayer> mids = new ArrayList<>();
    	ArrayList<SoccerPlayer> defenders = new ArrayList<>();
    	ArrayList<SoccerPlayer> keeps = new ArrayList<>();
    	ArrayList<SoccerPlayer> returnList;
    	Team team = getCurrentUserTeam();
    	if(team != null)
    	{
    		for (SoccerPlayer player : team.getTeam())
    		{
    			
    			if (player instanceof Forward)
    			{
    				forwards.add(player);
    			}
    			else if (player instanceof Midfielder)
    			{
    				mids.add(player);
    			}
    			else if  (player instanceof Defender)
    			{
    				defenders.add(player);
    			}
    			else
    			{
    				keeps.add(player);
    			}
    		}
    	}
    	
    	if (type.equals("forws"))
    	{
    		returnList = forwards;
    	}
    	else if (type.equals("mids"))
    	{
    		returnList = mids;
    	}
    	else if (type.equals("defs"))
    	{
    		returnList = defenders;
    	}
    	else
    	{
    		returnList = keeps;
    	}
    	
    	for (SoccerPlayer player: returnList)
    	{
    		result += player.getName() + " " + player.getPosition() + "\n";
    	}
    	return result;
    }
    
    public void setTeamName(String name)
    {
    	getCurrentUserTeam().setName(name);
    }
    
    public void setTeamFormation(String formation)
    {
    	getCurrentUserTeam().setFormation(formation);
    }
    
    public String getTeamStats()
    {
    	String result = "";
    	int index = 0;
    	int length = getCurrentUserTeam().getTeam().size();
    	int mid = length/2;
    	for (SoccerPlayer player: getCurrentUserTeam().getTeam())
    	{
    		result += player.getName() + " " + currentUser.getPlayerUsage(player).toString() + "\n";
    		if (index == mid)
    			result += "\n";
    		index++;
    	}
		return result;
    }

    



}
