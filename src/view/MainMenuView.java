package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import user.ProfilePanel;
import user.User;
import user.UserSearchPanel;

import tournament.CreateTournament;

public class MainMenuView extends JLayeredPane {
    private JPanel createTournamentPanel;
    private JPanel tournamentPanel;
    
    private JButton rulesButton;
    private JButton tournamentButton;
    private JButton createTournamentButton;
    private JButton editProfileButton;
    private JButton settingsButton;
    private JButton backButton;
    private JButton findFriendsButton;
    private JButton logoutButton;
    private JPanel findFriendsPanel;
    private JLabel backgroundLabel;
    private JLabel title;
    private JLayeredPane lp;
    private User user;

    public MainMenuView(User user) {
            this.user = user;
            lp = new JLayeredPane();

            tournamentButton = new JButton("Join Tournament");
            tournamentButton.setBounds(170,290,440, 30);
            tournamentButton.setBackground(Color.black);
            tournamentButton.setFont(tournamentButton.getFont().deriveFont(Font.BOLD));
            tournamentButton.addActionListener(new TournamentButtonListener());

            createTournamentButton = new JButton("Create Tournament");
            createTournamentButton.setBounds(170,330,440, 30);
            createTournamentButton.setBackground(Color.black);
            createTournamentButton.setFont(createTournamentButton.getFont().deriveFont(Font.BOLD));
            createTournamentButton.addActionListener(new CreateTournamentButtonListener());

            editProfileButton = new JButton("Edit Profile");  
            editProfileButton.setBounds(170,370,440, 30);
            editProfileButton.setBackground(Color.black); 
            editProfileButton.setFont(editProfileButton.getFont().deriveFont(Font.BOLD));
            editProfileButton.addActionListener(new EditProfileButtonListener());

            rulesButton = new JButton("Rules");         
            rulesButton.setBounds(170,410,440, 30);
            rulesButton.setBackground(Color.black); 
            rulesButton.setFont(rulesButton.getFont().deriveFont(Font.BOLD));
            

            settingsButton = new JButton("Settings");
            settingsButton.setBounds(170,450,440, 30);
            settingsButton.setBackground(Color.black); 
            settingsButton.setFont(settingsButton.getFont().deriveFont(Font.BOLD));
            
            
            findFriendsButton = new JButton("Find Friends");
            findFriendsButton.setBounds(170,450,440, 30);
            findFriendsButton.setBackground(Color.black); 
            findFriendsButton.setFont(findFriendsButton.getFont().deriveFont(Font.BOLD));
            findFriendsButton.addActionListener(new FindFriendsButtonListener());
            
            logoutButton = new JButton("Logout");
            logoutButton.setBounds(170,490,440, 30);
            logoutButton.setBackground(Color.black); 
            logoutButton.setFont(logoutButton.getFont().deriveFont(Font.BOLD));
            logoutButton.addActionListener(new LogoutButtonListener());



            backgroundLabel = new JLabel();
            ImageIcon icon = new ImageIcon("C:/Users/Owner/Desktop/bgImage.jpg");
            backgroundLabel.setBounds(0,0,800,600);
            backgroundLabel.setIcon(icon);

            title = new JLabel("Team Play");
            title.setBounds(245, 50, 400, 200);
            title.setFont(new Font("TimesRoman", Font.PLAIN, 60));        

            add(backgroundLabel, new Integer(1));
            add(tournamentButton, new Integer(2));
            add(createTournamentButton, new Integer(3));
            add(editProfileButton, new Integer(4));
            add(rulesButton, new Integer(5));
            add(settingsButton, new Integer(6));
            add(findFriendsButton, new Integer(7));
            add(logoutButton, new Integer(8));
            add(title, new Integer(9));
    }
    
    class FindFriendsButtonListener implements ActionListener
    {
       @Override
        public void actionPerformed(ActionEvent ae) 
        {
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            findFriendsPanel = new UserSearchPanel();

            frame.getContentPane().add(findFriendsPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }
    
    class LogoutButtonListener implements ActionListener
    {
       @Override
        public void actionPerformed(ActionEvent ae) 
        {
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            frame.getContentPane().add(new LoginMenuView());
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }


    class BackButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll(); 
            
            frame.getContentPane().removeAll();           
            frame.getContentPane().add(new MainMenuView(null));
            
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }

    public JPanel joinTournamentPanel() {
        tournamentPanel = new JPanel();
        tournamentPanel.add(new JLabel("Join Tournament Page"));

        backButton = new JButton("Back");
        backButton.addActionListener(new BackButtonListener());
        tournamentPanel.add(backButton);

        return tournamentPanel;
    }
   
    
    class TournamentButtonListener implements ActionListener
    {
       @Override
        public void actionPerformed(ActionEvent ae) 
        {       
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();
            frame.getContentPane().add(joinTournamentPanel());
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
    }
    
    public JPanel createTournamentPanel() {
        CreateTournament ct = new CreateTournament();
        createTournamentPanel = ct.createTournamentMenu();

        backButton = new JButton("Back");
        backButton.addActionListener(new BackButtonListener());
        createTournamentPanel.add(backButton);

        return createTournamentPanel;
    }
    
    class CreateTournamentButtonListener implements ActionListener
    {
       @Override
        public void actionPerformed(ActionEvent ae)
        {
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);
            
            frame.getContentPane().removeAll();
            CreateTournament ct = new CreateTournament();
            createTournamentPanel = ct.createTournamentMenu();
                        
            frame.getContentPane().add(createTournamentPanel());
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
    }

    class EditProfileButtonListener implements ActionListener
    {
       @Override
        public void actionPerformed(ActionEvent ae) 
        {       
            Component component = (Component) ae.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();
            frame.getContentPane().add(new ProfilePanel(user));
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
    }
    
}
