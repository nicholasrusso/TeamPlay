import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class MainMenu {
    private JFrame frame;
    private JPanel headerPanel, menuPanel, menuButtonPanel, profilePanel, settingsPanel, createTournamentPanel, tournamentPanel, rulesPanel;
    private JButton rulesButton, tournamentButton, createTournamentButton, editProfileButton, settingsButton, backButton; 

    public void createMenu() {
        frame = new JFrame();
        
        menuPanel = new JPanel();
        menuButtonPanel = new JPanel();
        headerPanel = new JPanel();

        frame.setTitle("TeamPlay");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(false);

        Dimension d = new Dimension(360,40);
        tournamentButton = new JButton("Join Tournament");
        tournamentButton.addActionListener(new tournamentButtonListener());
        tournamentButton.setPreferredSize(d);
        
        createTournamentButton = new JButton("Create Tournament");
        createTournamentButton.addActionListener(new createTournamentButtonListener());
        createTournamentButton.setPreferredSize(d);

        editProfileButton = new JButton("Edit Profile");
        editProfileButton.addActionListener(new editProfileButtonListener());
        editProfileButton.setPreferredSize(d);   
        
        rulesButton = new JButton("Rules");
        rulesButton.addActionListener(new rulesButtonListener());
        rulesButton.setPreferredSize(d);     
        
        settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new settingsButtonListener());
        settingsButton.setPreferredSize(d); 
        

               
        menuButtonPanel.add(tournamentButton);
        menuButtonPanel.add(createTournamentButton);
        menuButtonPanel.add(rulesButton);
        menuButtonPanel.add(editProfileButton);
        menuButtonPanel.add(settingsButton);
        menuButtonPanel.setPreferredSize(new Dimension(360, 600));        
        
        headerPanel.setPreferredSize(new Dimension(800, 200));
        
        menuPanel.add(headerPanel);
        menuPanel.add(menuButtonPanel);        
        
        
        menuPanel.setVisible(true);
        frame.getContentPane().add(menuPanel);
        //frame.pack();
        frame.setVisible(true);
    }

    class tournamentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();            
            tournamentPanel = new JPanel();
            tournamentPanel.add(new JLabel("Join Tournament Page"));

            backButton = new JButton("Back");
            backButton.addActionListener(new backButtonListener());
            tournamentPanel.add(backButton);

            frame.getContentPane().add(tournamentPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    
    class createTournamentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();            
            createTournamentPanel = new JPanel();
            createTournamentPanel.add(new JLabel("Create Tournament Page"));

            backButton = new JButton("Back");
            backButton.addActionListener(new backButtonListener());
            createTournamentPanel.add(backButton);

            frame.getContentPane().add(createTournamentPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }

    class editProfileButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();            
            profilePanel = new JPanel();
            profilePanel.add(new JLabel("Edit Profile Page"));

            backButton = new JButton("Back");
            backButton.addActionListener(new backButtonListener());
            profilePanel.add(backButton);

            frame.getContentPane().add(profilePanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    
    class settingsButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();            
            settingsPanel = new JPanel();
            settingsPanel.add(new JLabel("Settings Page"));

            backButton = new JButton("Back");
            backButton.addActionListener(new backButtonListener());
            settingsPanel.add(backButton);

            frame.getContentPane().add(settingsPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    
    class rulesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();            
            rulesPanel = new JPanel();
            rulesPanel.add(new JLabel("Rules Page"));

            backButton = new JButton("Back");
            backButton.addActionListener(new backButtonListener());
            rulesPanel.add(backButton);

            frame.getContentPane().add(rulesPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }


    class backButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();           
            frame.getContentPane().add(menuPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
        new MainMenu().createMenu();
    }

}