package user;

/**
 * Created by charliegels on 4/11/16.
 */
public class Email
{
    private String address;

    /**
     * Validates email address string to make sure it has a plausible address.
     * @param address - string containing desired email address.
     * @return true if valid email address and stored, else false
     * */
    public boolean setAddress(String address)
    {
        if (address.matches("^[A-Za-z0-9_\\.]+@[a-zA-Z]+[/.com|/.edu|./net]+"))
        {
            this.address = address;
            return true;
        }
        else
        {
            return false;
        }
    }

    /***
     * Email address string representation.
     * @return email address
     */
    public String toString()
    {
        return address;
    }

    /***
     * Send an email from this email address to a given recipient.
     * @param recipient - email address to which this email message will be sent.
     * @param message - message to send to the recipient
     * @return true if successful email is sent, otherwise false;
     */
    public boolean sendEmailTo(Email recipient, String message)
    {
        return false;
    }
}
