import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.BorderFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingUtilities;

import user.RegistrationPane;
import user.UserSearchPanel;

public class GUI {
    private JFrame frame;

    //FOR MAIN MENU
    private JPanel headerPanel, menuPanel, menuButtonPanel, profilePanel, settingsPanel, createTournamentPanel, tournamentPanel, rulesPanel;
    private JButton rulesButton, tournamentButton, createTournamentButton, editProfileButton, settingsButton, backButton;
    private JButton findFriendsButton;
    private JPanel findFriendsPanel;
    private JLabel backgroundLabel, title;
    private JLayeredPane lp;
    private Image img;    
    //END

    //FOR LOGIN
    private JPanel loginPanel;
    private JLayeredPane lp1;
    private JLabel usernameLabel, passwordLabel, statusLabel; 
    private JTextField jtfUsername;
    private JPasswordField jpfPassword;
    private JButton login, createAcct;
    private JProgressBar progressBar;
    //END   
    
    //FOR REGISTRATION
    private JPanel registrationPanel = new RegistrationPane();
    //END
    

    public void run() {        
        frame = new JFrame("Team Play");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lp1 = new JLayeredPane();
        loginPanel = new JPanel();
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        statusLabel = new JLabel(" ");
        jtfUsername = new JTextField(20);
        jpfPassword = new JPasswordField();
        login = new JButton("Login");
        createAcct = new JButton("Create Account");

        JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(usernameLabel);
        p3.add(passwordLabel);

        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(jtfUsername);
        p4.add(jpfPassword);

        JPanel p1 = new JPanel();
        p1.add(p3);
        p1.add(p4);

        JPanel p2 = new JPanel();
        p2.add(login);
        p2.add(createAcct);

        progressBar = new JProgressBar();

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(statusLabel, BorderLayout.NORTH);

        statusLabel.setForeground(Color.RED);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);        

        p1.setBounds(0,220,800,600);
        p5.setBounds(300,270,200,200);
        progressBar.setBounds(0, 545, 800, 15);
        lp1.add(p1, new Integer(1));
        lp1.add(p5, new Integer(2));
        lp1.add(progressBar, new Integer(3));
        frame.add(lp1);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      

        frame.setVisible(true);
        login.addActionListener(new progressListener());
        createAcct.addActionListener(new createAcctButtonListener());

    }

    public void createMenu() {       
        lp = new JLayeredPane();
        tournamentButton = new JButton("Join Tournament");
        tournamentButton.setBounds(170,290,440, 30);
        tournamentButton.setBackground(Color.black);
        tournamentButton.setFont(tournamentButton.getFont().deriveFont(Font.BOLD));
        tournamentButton.addActionListener(new tournamentButtonListener());

        createTournamentButton = new JButton("Create Tournament");
        createTournamentButton.setBounds(170,330,440, 30);
        createTournamentButton.setBackground(Color.black);
        createTournamentButton.setFont(createTournamentButton.getFont().deriveFont(Font.BOLD));
        //createTournamentButton.addActionListener(new tournamentButtonListener());

        editProfileButton = new JButton("Edit Profile");  
        editProfileButton.setBounds(170,370,440, 30);
        editProfileButton.setBackground(Color.black); 
        editProfileButton.setFont(editProfileButton.getFont().deriveFont(Font.BOLD));
        //editProfileButton.addActionListener(new tournamentButtonListener());

        rulesButton = new JButton("Rules");         
        rulesButton.setBounds(170,410,440, 30);
        rulesButton.setBackground(Color.black); 
        rulesButton.setFont(rulesButton.getFont().deriveFont(Font.BOLD));
        //rulesButton.addActionListener(new tournamentButtonListener());

        settingsButton = new JButton("Settings");
        settingsButton.setBounds(170,450,440, 30);
        settingsButton.setBackground(Color.black); 
        settingsButton.setFont(settingsButton.getFont().deriveFont(Font.BOLD));
        //settingsButton.addActionListener(new tournamentButtonListener());
        
        findFriendsButton = new JButton("Find Friends");
        findFriendsButton.setBounds(170,450,440, 30);
        findFriendsButton.setBackground(Color.black); 
        findFriendsButton.setFont(findFriendsButton.getFont().deriveFont(Font.BOLD));
        findFriendsButton.addActionListener(new findFriendsButtonListener());


        backgroundLabel = new JLabel();
        ImageIcon icon = new ImageIcon("C:/Users/Owner/Desktop/bgImage.jpg");
        backgroundLabel.setBounds(0,0,800,600);
        backgroundLabel.setIcon(icon);

        title = new JLabel("Team Play");
        title.setBounds(245, 50, 400, 200);
        title.setFont(new Font("TimesRoman", Font.PLAIN, 60));        

        lp.add(backgroundLabel, new Integer(1));
        lp.add(tournamentButton, new Integer(2));
        lp.add(createTournamentButton, new Integer(3));
        lp.add(editProfileButton, new Integer(4));
        lp.add(rulesButton, new Integer(5));
        lp.add(settingsButton, new Integer(6));
        lp.add(findFriendsButton, new Integer(7));
        lp.add(title, new Integer(8));

        frame.add(lp);        

        frame.revalidate();
        frame.repaint();
    }

    class tournamentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {            
            frame.getContentPane().removeAll();
            frame.getContentPane().add(joinTournamentPanel());
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
    }

    class progressListener implements ActionListener
    {
        public synchronized void updateBar() {
            Thread t = new Thread(){
                    public void run(){
                        int i = 0;
                        for(i = 0 ; i <= 100 ; i++){
                            int percent = i;
                            SwingUtilities.invokeLater(new Runnable() {
                                    public void run() {
                                        progressBar.setValue(percent);
                                        progressBar.setStringPainted(true);

                                    }
                                });

                            try {
                                Thread.sleep(25);
                            } catch (InterruptedException e) {}
                        }
                        if (i == 101) {
                            try {
                                Thread.sleep(500);
                                frame.getContentPane().removeAll();
                                createMenu();
                            }
                            catch(Exception e) {
                            }
                        }
                    }

                };
            t.start();       

        }
        public void actionPerformed(ActionEvent ae) 
        {            
            if ("root".equals(jpfPassword.getText())
            && "root".equals(jtfUsername.getText())) {
                updateBar();
            }
            else {
                statusLabel.setText("Invalid username or password");
            }

        }
    }
    
    class createAcctButtonListener implements ActionListener
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
    
    class findFriendsButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();            
            findFriendsPanel = new UserSearchPanel();

            backButton = new JButton("Back");
            backButton.addActionListener(new backButtonListener());
            findFriendsPanel.add(backButton);

            frame.getContentPane().add(findFriendsPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }

    class backButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            frame.getContentPane().removeAll();           
            frame.getContentPane().add(lp);
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
        new GUI().run();
    }
}