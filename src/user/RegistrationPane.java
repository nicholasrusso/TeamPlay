package user;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import user.Registration;
import view.LoginMenuView;
import view.MainMenuView;;

public class RegistrationPane extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;

    /**
     * Create the panel.
     */
    public RegistrationPane() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblRegistration = new JLabel("Registration");
        GridBagConstraints gbc_lblRegistration = new GridBagConstraints();
        gbc_lblRegistration.gridwidth = 3;
        gbc_lblRegistration.insets = new Insets(0, 0, 5, 0);
        gbc_lblRegistration.gridx = 0;
        gbc_lblRegistration.gridy = 0;
        add(lblRegistration, gbc_lblRegistration);
        
        JLabel lblUsername = new JLabel("UserName");
        GridBagConstraints gbc_lblUsername = new GridBagConstraints();
        gbc_lblUsername.anchor = GridBagConstraints.EAST;
        gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsername.gridx = 0;
        gbc_lblUsername.gridy = 2;
        add(lblUsername, gbc_lblUsername);
        
        usernameField = new JTextField();
        GridBagConstraints gbc_userNameField = new GridBagConstraints();
        gbc_userNameField.gridwidth = 2;
        gbc_userNameField.insets = new Insets(0, 0, 5, 0);
        gbc_userNameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_userNameField.gridx = 1;
        gbc_userNameField.gridy = 2;
        add(usernameField, gbc_userNameField);
        usernameField.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.anchor = GridBagConstraints.EAST;
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 0;
        gbc_lblPassword.gridy = 3;
        add(lblPassword, gbc_lblPassword);
        
        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.gridwidth = 2;
        gbc_passwordField.insets = new Insets(0, 0, 5, 0);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 1;
        gbc_passwordField.gridy = 3;
        add(passwordField, gbc_passwordField);
        
        JLabel lblFirstName = new JLabel("First Name");
        GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
        gbc_lblFirstName.anchor = GridBagConstraints.EAST;
        gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
        gbc_lblFirstName.gridx = 0;
        gbc_lblFirstName.gridy = 4;
        add(lblFirstName, gbc_lblFirstName);
        
        firstNameField = new JTextField();
        GridBagConstraints gbc_firstName = new GridBagConstraints();
        gbc_firstName.gridwidth = 2;
        gbc_firstName.insets = new Insets(0, 0, 5, 0);
        gbc_firstName.fill = GridBagConstraints.HORIZONTAL;
        gbc_firstName.gridx = 1;
        gbc_firstName.gridy = 4;
        add(firstNameField, gbc_firstName);
        firstNameField.setColumns(10);
        
        JLabel lblLastName = new JLabel("Last Name");
        GridBagConstraints gbc_lblLastName = new GridBagConstraints();
        gbc_lblLastName.anchor = GridBagConstraints.EAST;
        gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
        gbc_lblLastName.gridx = 0;
        gbc_lblLastName.gridy = 5;
        add(lblLastName, gbc_lblLastName);
        
        lastNameField = new JTextField();
        GridBagConstraints gbc_lastNameField = new GridBagConstraints();
        gbc_lastNameField.gridwidth = 2;
        gbc_lastNameField.insets = new Insets(0, 0, 5, 0);
        gbc_lastNameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_lastNameField.gridx = 1;
        gbc_lastNameField.gridy = 5;
        add(lastNameField, gbc_lastNameField);
        lastNameField.setColumns(10);
        
        JLabel lblEmailAddress = new JLabel("Email Address");
        GridBagConstraints gbc_lblEmailAddress = new GridBagConstraints();
        gbc_lblEmailAddress.anchor = GridBagConstraints.EAST;
        gbc_lblEmailAddress.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmailAddress.gridx = 0;
        gbc_lblEmailAddress.gridy = 6;
        add(lblEmailAddress, gbc_lblEmailAddress);
        
        emailField = new JTextField();
        GridBagConstraints gbc_emailField = new GridBagConstraints();
        gbc_emailField.gridwidth = 2;
        gbc_emailField.insets = new Insets(0, 0, 5, 0);
        gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
        gbc_emailField.gridx = 1;
        gbc_emailField.gridy = 6;
        add(emailField, gbc_emailField);
        emailField.setColumns(10);
        
        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new registerButtonListener());
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new backToLoginMenuListener());
        GridBagConstraints gbc_backButton = new GridBagConstraints();
        gbc_backButton.insets = new Insets(0, 0, 5, 5);
        gbc_backButton.gridx = 1;
        gbc_backButton.gridy = 7;
        add(backButton, gbc_backButton);
        
        GridBagConstraints gbc_btnRegister = new GridBagConstraints();
        gbc_btnRegister.insets = new Insets(0, 0, 5, 0);
        gbc_btnRegister.gridx = 2;
        gbc_btnRegister.gridy = 7;
        add(btnRegister, gbc_btnRegister);

    }
    
    class registerButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) 
        {
            if(Registration.usernameExists(usernameField.getText())) {
                Component component = (Component) ae.getSource();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(component);
                JOptionPane.showMessageDialog(null, "Please select a different username!");
                System.out.println("Warning: Username already used");
            } else {
                boolean result = Registration.registerUser(usernameField.getText(),
                                                           passwordField.getPassword().toString(),
                                                           firstNameField.getText(),
                                                           lastNameField.getText(),
                                                           emailField.getText());
            }
        }
    }
    
    class backToLoginMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            Component component = (Component) e.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                        
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new LoginMenuView());
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();        
        }
    }

}
