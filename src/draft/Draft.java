package draft;

import java.util.*;
public class Draft {
    private Tournament tournament;
    private ArrayList users;
    public Draft(Tournament tournament) 
    {
        this.tournament = tournament;
        this.users = tournament.getUsers();
    }

    public Player randomPlayer(ArrayList<Player> array)
    {
        int max = 3;
        int min = 0;
        int position = random.nextInt(max - min + 1) + min;
        return array.get(position);
    }

    public void run(Reader reader) 
    {
        Scanner scanner = new Scanner(reader);
        boolean intime = true;
        Team currentTeam = null;
        //Loops 18 times, giving each player 18 opportunties to draft.
        for (int opportunities = 0; opportunities < 18; opportunities++)
        {
            //Loops through all the players in the tournament.
            for (User user : users) 
            {
                System.out.println("Current Player: " + user.getName());
                System.out.println("Are you ready?(Yes/No)");     

                String line = scanner.nextLine();
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
                
            }
        }
    }
}
