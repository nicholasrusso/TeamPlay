package view;

import java.util.Arrays;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI {
    private JFrame frame;
    private static final Logger log = Logger.getLogger("GUI");

    
    public void run() {        
        frame = new JFrame("Team Play");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new LoginMenuView());

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      

        frame.setVisible(true);

    }
    
    public void createMenu() {       
        frame.add(new MainMenuView(null));
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1) {
            log.severe(Arrays.toString(e1.getStackTrace()));
        }
        new GUI().run();
    }
}