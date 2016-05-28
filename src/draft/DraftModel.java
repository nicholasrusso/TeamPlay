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
    private SoccerPlayer[] randomPlayers;
    private static int turnSeconds;
    private int draftRound;
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
    }


    public User getCurrentUser()
    {
        return currentUser;
    }

    public void nextUser()
    {
            if (draftRound < 18)
            {
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
        
    }

    public void addPlayer(int location)
    {
        currentUser.getTeam(tournament.getName()).addPlayer(randomPlayers[location]);
        tournament.removePlayer(randomPlayers[location]);
    }
    
    public void turnTimer()
    {
        new Timer().schedule(new TimerTask()
        {

            int second = 60;
            @Override
            public void run() 
            {
                turnSeconds--;
                setChanged();
                notifyObservers();
            }   
        }, 0, 1000);
        
    }
    
    public int getTurnSeconds()
    {
        return turnSeconds;
    }



    public SoccerPlayer[] getThreeRandomSoccerPlayers()
    {
        randomPlayers[0] = tournament.randomPlayer();
        randomPlayers[1] = tournament.randomPlayer();
        randomPlayers[2] = tournament.randomPlayer();
        return randomPlayers;
    }

    public Team getCurrentUserTeam()
    {
        return currentUser.getTeam(tournament.getName());
    }


    public void run(Reader reader) 
    {
        System.out.println("Are you ready?(Yes/No)");   
        Scanner scanner = new Scanner(reader);
        boolean intime = true;
        //Team currentTeam = null;
        //Loops 18 times, giving each user 18 opportunties to draft.
        for (int opportunities = 0; opportunities < 18; opportunities++)
        {
            //Loops through all the user in the tournament.
            //for (User user : users) 
            //{
                System.out.println("Current User: Tim");
                System.out.println("Are you ready?(Yes/No)");     

                //String line = scanner.nextLine();
//                JFrame f = new JFrame();
//                final JDialog dialog = new JDialog(f, "Test", true);
//                Timer timer = new Timer(2000, new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        dialog.setVisible(false);
//                        dialog.dispose();
//                    }
//                });
//                timer.setRepeats(false);
//                timer.start();

                //dialog.setVisible(true); // if modal, application will pause here

                System.out.println("Dialog closed");
                //needs threading for timer.
                //needs random player presentation
                //needs user selection
                //needs auto pick
                // final long start = System.nanoTime();
                // while (!line.equalsIgnoreCase("Yes"))
                // {
                //     final long currentTime = (start - System.nanoTime())/1000000000;
                //     if (current % 1 == 0) 
                //     {
                //        System.out.println(5 - currentTime);
                //     }
                //     if (current <= 0)
                //     {
                //         intime = false;
                //         break;
                //     }
                    
                // }

                //currentTeam = user.getTournamentTeam(tournament.getName());
                
            //}
        }
    }

    public static void main(String[] args) 
    {
        Draft draft = new Draft(new Tournament("Test", 5, null));
        draft.run(new InputStreamReader(System.in));
    }



}
