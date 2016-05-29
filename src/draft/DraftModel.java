package draft;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import user.*;
import tournament.*;
import soccerPlayer.*;
import teams.Team;

import java.io.*;
import java.awt.*;
import javax.swing.*;


import java.awt.event.*;

public class DraftModel extends Observable{
    private Tournament tournament;
    private ArrayList<User> users;
    private ArrayList<SoccerPlayer> players;
    private User currentUser;
    private int userPosition;
    private SoccerPlayer[] currentPlayerSelection;
    private SoccerPlayer[] randomPlayers;
    private static int turnSeconds;
    private int draftRound;
    private boolean selection;
    private Timer clock;
    private static String time;
    private boolean save;
    private boolean draftOver;
    public DraftModel(Tournament tournament) 
    {
        this.userPosition = 0;
        this.draftRound = 0;
        this.tournament = tournament;
        this.users = tournament.getUsers();
        this.players = tournament.getPlayers();
        this.currentUser = users.get(userPosition);
        randomPlayers = new SoccerPlayer[3];
        turnSeconds = 10;
        selection = false;
        save = false;
        draftOver = false;
    }


    public User getCurrentUser()
    {
        return currentUser;
    }

    public void nextUser(int pos)
    {
            if (draftRound < 18)
            {
            	getCurrentUserTeam().addPlayer(currentPlayerSelection[2]);
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
            	save = false;
            	selection = false;
            	draftOver = true;
            }
            selection = false;
            currentPlayerSelection = null;
            clock.cancel();

            this.setChanged();
            this.notifyObservers();        
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
        currentUser.getTeam(tournament.getName()).addPlayer(randomPlayers[location]);
        tournament.removePlayer(randomPlayers[location]);
    }
    
    public void startTimer()
    {
    	clock = new Timer();
        clock.schedule(new TimerTask(){

            int second = 60;
            @Override
            public void run() {
                DraftModel.time = second-- + " seconds.";
                System.out.println(time);
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
    	System.out.println("updating");
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
    
    public String getTeamToString()
    {
    	String result = "";
    	Team team = getCurrentUserTeam();
    	if(team != null)
    	{
    		for (SoccerPlayer player : team.listOfPlayers)
    		{
    			result +=  player.getName() + "\n";
    		}
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

    



}
