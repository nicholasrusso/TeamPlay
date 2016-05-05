package user;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by charliegels on 4/11/16.
 *
 * ProfileManger class is a utility class that contains information for the DB of all users.
 * These users are stored in memory so that users can edit their profile.
 *
 */
public class ProfileManager
{
    private static User newUser;
    private static HashMap<String, User> existingUsers;
    private static Scanner userInfoScanner;

    public ProfileManager()
    {
        existingUsers = new HashMap<>();
        userInfoScanner = new Scanner(System.in);
    }

    /**
     * Change the current user's username.
     * */
    public void editUsername(User u)
    {
        userNamePrompt(u);
    }

    /**
     * Change the current user's first name.
     * */
    public void editFirstName(User u)
    {
        firstNamePrompt(u);
    }

    /**
     * Change the current user's last name.
     * */
    public void editLastName(User u)
    {
        lastNamePrompt(u);
    }

    /**
     * Change the current user's email address.
     * */
    public void editEmail(User u)
    {
        emailPrompt(u);
    }

    /**
     * Creates a new user account and adds it to the list of users
     * @return true if user was created with valid information.
     * */
    public static void createUser()
    {
        newUser = new User();
        userNamePrompt(newUser);
        firstNamePrompt(newUser);
        lastNamePrompt(newUser);
        emailPrompt(newUser);
        if (newUser.isValidated())
        {
            //add to DB & add to Hash
            existingUsers.put(newUser.getUsername(), newUser);
        }
    }

    private static void userNamePrompt(User u)
    {
        String input = "";
        boolean first = true;
        while (!u.setUsername(input))
        {
            if (first) { System.out.println("Input desired username containing only alphanumeric characters."); }
            else { System.out.println("Invalid username -- Input a different desired username containing only alphanumeric characters."); }
            input = userInfoScanner.nextLine();
        }
    }

    private static void firstNamePrompt(User u)
    {
        String input = "";
        boolean first = true;
        while (!u.setFirstName(input))
        {
            if (first) { System.out.println("Input your first name containing only alphabetic characters."); }
            else { System.out.println("Invalid firstname -- Input a different first name containing only alphabetic characters."); }
            input = userInfoScanner.nextLine();
        }
    }

    private static void lastNamePrompt(User u)
    {
        String input = "";
        boolean first = true;
        while (!u.setLastName(input))
        {
            if (first) { System.out.println("Input your last name containing only alphabetic characters."); }
            else { System.out.println("Invalid last name -- Input a different last name containing only alphabetic characters."); }
            input = userInfoScanner.nextLine();
        }
    }

    private static void emailPrompt(User u)
    {
        String input = userInfoScanner.nextLine();
        boolean first = true;
        while (!u.setEmail(input))
        {
            if (first) { System.out.println("Input your .com/.net/.edu email. Example: user.team_play123@teamplay.com"); }
            else { System.out.println("Invalid email -- Input your .com/.net/.edu email. Example: user123@teamplay.com"); }
            input = userInfoScanner.nextLine();
        }
    }

    public HashMap<String, User> getUsers()
    {
        return existingUsers;
    }
}
