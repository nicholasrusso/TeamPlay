package user;

/**
 * Temporary class to act as a application class.
 *
 * Created by charliegels on 4/13/16.
 */
public class TempApp
{
    public static void main(String args[])
    {
        ProfileManager pf = new ProfileManager();
        pf.createUser();

        User u = pf.getUsers().get("2leet");
        System.out.println(u.toString());

        pf.editEmail(u);

        pf.editFirstName(u);

        pf.editLastName(u);

        pf.editUsername(u);

        System.out.println(u.toString());
    }
}
