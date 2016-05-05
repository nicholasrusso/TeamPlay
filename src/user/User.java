package user;

/**
 * @author charliegels
 * @version 1.0
 *
 * Created by charliegels on 4/11/16.
 *
 * This class serves as the user's profile created during registration and used to log in to the game application.
 * This class is used by the ProfileManger to create and edit user profiles
 */
public class User
{
    private String firstName;
    private String lastName;
    private String userName;
    private Email email;
    private boolean allValidated;
    //TODO
//    private String passwordHash;
//    private ArrayList<ProfessionalTeam> userTeams;
    /***
     * Default constructor for user. User fields must be validated.
     * User instance should not be used unless allValidated is true.
     * */
    public User()
    {
        firstName = "";
        lastName = "";
        userName = "";
        email = new Email();
        allValidated = false;
    }

    /**
     * Validates userName for being alphanumeric characters.
     * @param userName desired username.
     * @return true if valid alphanumeric userName, otherwise false.
     * */
    public boolean setUsername(String userName)
    {
        if (userName.matches("^[A-Za-z0-9]+")) {
            this.userName = userName;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Accessor for user name.
     * @return username
     * */
    public String getUsername()
    {
        return userName;
    }

    /**
     * Validates firstName for being alphanumeric characters.
     * @param name desired username.
     * @return true if valid alphanumeric userName, otherwise false.
     * */
    public boolean setFirstName(String name)
    {
        if (name.matches("^[A-Za-z]+")) {
            firstName = name;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Accessor for first name.
     * @return first name of user
     * */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Validates userName for being alphanumeric characters.
     * @param name desired username.
     * @return true if valid alphanumeric last name, otherwise false.
     * */
    public boolean setLastName(String name)
    {
        if (name.matches("^[A-Za-z]+")) {
            lastName = name;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Accessor for user's last name.
     * @return user's last name
     * */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Validates userName for being alphanumeric characters.
     * @param address desired username.
     * @return true if valid email address, otherwise false.
     * */
    public boolean setEmail(String address)
    {
        return email.setAddress(address);
    }

    /**
     * Accessor for user's email address name.
     * @return user's email address
     * */
    public Email getEmail()
    {
        return email;
    }

    /***
     * Accessor for the validaiton status of this user.
     * @return true if all fields are valid, else false.
     * */
    public boolean isValidated() {
        return setEmail(email.toString()) && setFirstName(firstName) && setLastName(lastName) && setUsername(userName);
    }


    /***
     * String representation of this user.
     * @return user string
     */
    @Override
    public String toString()
    {
        return new StringBuilder().append("User Name  : ").append(userName)
                        .append("\nFirst Name : ").append(firstName)
                        .append("\nLast Name  : ").append(lastName)
                        .append("\nEmail      : ").append(email.toString()).toString();
    }
}

