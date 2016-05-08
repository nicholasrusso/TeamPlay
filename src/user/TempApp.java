package src.user;

import javax.swing.*;

/**
 * Temporary class to act as a application class.
 *
 * Created by charliegels on 4/13/16.
 */
public class TempApp
{
    public static void main(String args[])
    {
        JPanel p = new ProfilePanel(null);
        JFrame f = new JFrame("Test");
        f.add(p);
        f.setVisible(true);
        f.pack();
    }
}
