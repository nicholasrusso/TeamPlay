package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import user.RegistrationPane;

public class LoginMenuView extends JLayeredPane {
 
    private JPanel loginPanel;
    private JLabel usernameLabel, passwordLabel, statusLabel; 
    private JTextField jtfUsername;
    private JPasswordField jpfPassword;
    private JButton login, createAcct;
    private JProgressBar progressBar;


	public LoginMenuView() {
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
        p5.setBounds(300,290,200,200);
        progressBar.setBounds(0, 545, 800, 15);
        
        add(p1, new Integer(1));
        add(p5, new Integer(2));
        add(progressBar, new Integer(3));
        
        login.addActionListener(new progressListener());
        createAcct.addActionListener(new createAcctButtonListener());
        
	}
	
    class progressListener implements ActionListener
    {
        public synchronized void updateBar(ActionEvent ae) {
        	Component component = (Component) ae.getSource();
        	JFrame frame = (JFrame) SwingUtilities.getRoot(component);

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
                                frame.getContentPane().add(new MainMenuView());
                                frame.getContentPane().validate();
                                frame.getContentPane().repaint();
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
                updateBar(ae);
            }
            else {
                statusLabel.setText("Invalid username or password");
            }

        }
    }
    
    class createAcctButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
			Component component = (Component) e.getSource();
        	JFrame frame = (JFrame) SwingUtilities.getRoot(component);

            frame.getContentPane().removeAll();            
            JPanel registrationPanel = new RegistrationPane();

            frame.getContentPane().add(registrationPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
        }
    }


}