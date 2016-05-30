package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import user.RegistrationPane;

public class GUI {
    private JFrame frame;
    
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
        frame.add(new MainMenuView());
        frame.revalidate();
        frame.repaint();
    }
    

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
        new GUI().run();
    }
}