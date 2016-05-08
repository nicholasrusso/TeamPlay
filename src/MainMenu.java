import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import user.RegistrationPane;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;

public class MainMenu {
    private JFrame frame;
    private JPanel headerPanel, menuPanel, menuButtonPanel, profilePanel, settingsPanel, createTournamentPanel, tournamentPanel, rulesPanel, registrationPanel;
    private JButton rulesButton, tournamentButton, createTournamentButton, editProfileButton, settingsButton, registerButton, backButton; 
    private JLabel logoLabel, background;
    private Image img;

    public void createMenu() {

        frame = new JFrame();
        menuPanel = new JPanel();
        menuButtonPanel = new JPanel();
        headerPanel = new JPanel();

        //try {
        //    
        //    BufferedImage myPicture = ImageIO.read(new File("C:/Users/Owner/Desktop/logo.png"));
        //    logoLabel = new JLabel(new ImageIcon(myPicture));
        //    headerPanel.setLayout(null);
        //    headerPanel.add(logoLabel);

        //    logoLabel.setBounds(20, 20, 220, 160);
        //}
        //catch (Exception e) {
        //}

        frame.setTitle("TeamPlay");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(false);                  

        Dimension d = new Dimension(420,30);
        tournamentButton = new JButton("Join Tournament");
        tournamentButton.addActionListener(new tournamentButtonListener());
        tournamentButton.setPreferredSize(d);
        tournamentButton.setBorder(BorderFactory.createLineBorder(Color.black));
        tournamentButton.setFont(tournamentButton.getFont().deriveFont(Font.BOLD));

        createTournamentButton = new JButton("Create Tournament");
        createTournamentButton.addActionListener(new createTournamentButtonListener());
        createTournamentButton.setPreferredSize(d);
        createTournamentButton.setBorder(BorderFactory.createLineBorder(Color.black));
        createTournamentButton.setFont(createTournamentButton.getFont().deriveFont(Font.BOLD));

        editProfileButton = new JButton("Edit Profile");
        editProfileButton.addActionListener(new editProfileButtonListener());
        editProfileButton.setPreferredSize(d);
        editProfileButton.setBorder(BorderFactory.createLineBorder(Color.black));
        editProfileButton.setFont(editProfileButton.getFont().deriveFont(Font.BOLD));

        rulesButton = new JButton("Rules");
        rulesButton.addActionListener(new rulesButtonListener());
        rulesButton.setPreferredSize(d);     
        rulesButton.setBorder(BorderFactory.createLineBorder(Color.black));
        rulesButton.setFont(rulesButton.getFont().deriveFont(Font.BOLD));

        settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new settingsButtonListener());
        settingsButton.setPreferredSize(d); 
        
        registerButton = new JButton("Register");
        registerButton.addActionListener(new registerButtonListener());
        registerButton.setPreferredSize(d); 
       
               
        menuButtonPanel.add(registerButton);

        menuButtonPanel.add(tournamentButton);
        menuButtonPanel.add(createTournamentButton);
        menuButtonPanel.add(rulesButton);
        menuButtonPanel.add(editProfileButton);
        menuButtonPanel.add(settingsButton);

        menuButtonPanel.setPreferredSize(new Dimension(420, 600));        
        headerPanel.setPreferredSize(new Dimension(800, 260));

        menuPanel.add(headerPanel);
        menuPanel.add(menuButtonPanel);        
        menuButtonPanel.repaint();
        menuPanel.setVisible(true);

        frame.getContentPane().add(menuPanel);   

        frame.setVisible(true);
    }

    class tournamentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();       
            

            frame.getContentPane().add(joinTournamentPanel());
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
    class registerButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();            
            registrationPanel = new RegistrationPane();

            backButton = new JButton("Back");
            backButton.addActionListener(new backButtonListener());
            registrationPanel.add(backButton);

            frame.getContentPane().add(registrationPanel);
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

    public JPanel joinTournamentPanel() {

        tournamentPanel = new JPanel();
        tournamentPanel.add(new JLabel("Join Tournament Page"));

        backButton = new JButton("Back");
        backButton.addActionListener(new backButtonListener());
        tournamentPanel.add(backButton);

        return tournamentPanel;
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
