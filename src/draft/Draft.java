package draft;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import user.*;
import tournament.*;
import soccerPlayer.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Draft {
    private Tournament tournament;
    private ArrayList<User> users;
    public Draft(Tournament tournament) 
    {
        this.tournament = tournament;
        this.users = tournament.getUsers();
    }

    public SoccerPlayer randomPlayer(ArrayList<SoccerPlayer> array)
    {
        Random random = new Random();
        int max = 3;
        int min = 0;
        int position = random.nextInt(max - min + 1) + min;
        return array.get(position);
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
                JFrame f = new JFrame();
                final JDialog dialog = new JDialog(f, "Test", true);
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();

                dialog.setVisible(true); // if modal, application will pause here

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
