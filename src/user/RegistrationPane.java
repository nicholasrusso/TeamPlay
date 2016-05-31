package user;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;


import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import view.LoginMenuView;;

public class RegistrationPane extends JPanel {
	
	private static final Logger log = Logger.getLogger("RegistrationPane");

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
		GridBagConstraints gbcLblRegistration = new GridBagConstraints();
		gbcLblRegistration.gridwidth = 3;
		gbcLblRegistration.insets = new Insets(0, 0, 5, 0);
		gbcLblRegistration.gridx = 0;
		gbcLblRegistration.gridy = 0;
		add(lblRegistration, gbcLblRegistration);
		
		JLabel lblUsername = new JLabel("UserName");
		GridBagConstraints gbcLblUsername = new GridBagConstraints();
		gbcLblUsername.anchor = GridBagConstraints.EAST;
		gbcLblUsername.insets = new Insets(0, 0, 5, 5);
		gbcLblUsername.gridx = 0;
		gbcLblUsername.gridy = 2;
		add(lblUsername, gbcLblUsername);
		
		usernameField = new JTextField();
		GridBagConstraints gbcUserNameField = new GridBagConstraints();
		gbcUserNameField.gridwidth = 2;
		gbcUserNameField.insets = new Insets(0, 0, 5, 0);
		gbcUserNameField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserNameField.gridx = 1;
		gbcUserNameField.gridy = 2;
		add(usernameField, gbcUserNameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbcLblPassword = new GridBagConstraints();
		gbcLblPassword.anchor = GridBagConstraints.EAST;
		gbcLblPassword.insets = new Insets(0, 0, 5, 5);
		gbcLblPassword.gridx = 0;
		gbcLblPassword.gridy = 3;
		add(lblPassword, gbcLblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbcPasswordField = new GridBagConstraints();
		gbcPasswordField.gridwidth = 2;
		gbcPasswordField.insets = new Insets(0, 0, 5, 0);
		gbcPasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbcPasswordField.gridx = 1;
		gbcPasswordField.gridy = 3;
		add(passwordField, gbcPasswordField);
		
		JLabel lblFirstName = new JLabel("First Name");
		GridBagConstraints gbcLblFirstName = new GridBagConstraints();
		gbcLblFirstName.anchor = GridBagConstraints.EAST;
		gbcLblFirstName.insets = new Insets(0, 0, 5, 5);
		gbcLblFirstName.gridx = 0;
		gbcLblFirstName.gridy = 4;
		add(lblFirstName, gbcLblFirstName);
		
		firstNameField = new JTextField();
		GridBagConstraints gbcFirstName = new GridBagConstraints();
		gbcFirstName.gridwidth = 2;
		gbcFirstName.insets = new Insets(0, 0, 5, 0);
		gbcFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbcFirstName.gridx = 1;
		gbcFirstName.gridy = 4;
		add(firstNameField, gbcFirstName);
		firstNameField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbcLblLastName = new GridBagConstraints();
		gbcLblLastName.anchor = GridBagConstraints.EAST;
		gbcLblLastName.insets = new Insets(0, 0, 5, 5);
		gbcLblLastName.gridx = 0;
		gbcLblLastName.gridy = 5;
		add(lblLastName, gbcLblLastName);
		
		lastNameField = new JTextField();
		GridBagConstraints gbcLastNameField = new GridBagConstraints();
		gbcLastNameField.gridwidth = 2;
		gbcLastNameField.insets = new Insets(0, 0, 5, 0);
		gbcLastNameField.fill = GridBagConstraints.HORIZONTAL;
		gbcLastNameField.gridx = 1;
		gbcLastNameField.gridy = 5;
		add(lastNameField, gbcLastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		GridBagConstraints gbcLblEmailAddress = new GridBagConstraints();
		gbcLblEmailAddress.anchor = GridBagConstraints.EAST;
		gbcLblEmailAddress.insets = new Insets(0, 0, 5, 5);
		gbcLblEmailAddress.gridx = 0;
		gbcLblEmailAddress.gridy = 6;
		add(lblEmailAddress, gbcLblEmailAddress);
		
		emailField = new JTextField();
		GridBagConstraints gbcEmailField = new GridBagConstraints();
		gbcEmailField.gridwidth = 2;
		gbcEmailField.insets = new Insets(0, 0, 5, 0);
		gbcEmailField.fill = GridBagConstraints.HORIZONTAL;
		gbcEmailField.gridx = 1;
		gbcEmailField.gridy = 6;
		add(emailField, gbcEmailField);
		emailField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new RegisterButtonListener());
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new BackToLoginMenuListener());
		GridBagConstraints gbcBackButton = new GridBagConstraints();
		gbcBackButton.insets = new Insets(0, 0, 5, 5);
		gbcBackButton.gridx = 1;
		gbcBackButton.gridy = 7;
		add(backButton, gbcBackButton);
		
		GridBagConstraints gbcBtnRegister = new GridBagConstraints();
		gbcBtnRegister.insets = new Insets(0, 0, 5, 0);
		gbcBtnRegister.gridx = 2;
		gbcBtnRegister.gridy = 7;
		add(btnRegister, gbcBtnRegister);

	}
	
    class RegisterButtonListener implements ActionListener
    {
    	@Override
        public void actionPerformed(ActionEvent ae) 
        {
        	if(Registration.usernameExists(usernameField.getText())) {

        		JOptionPane.showMessageDialog(null, "Please select a different username!");
        		log.warning("Warning: Username already used");
        	} else {
        		Registration.registerUser(usernameField.getText(),
        				passwordField.getText(),
        				firstNameField.getText(),
        				lastNameField.getText(),
        				emailField.getText());
        	}
        }
    }
    
    class BackToLoginMenuListener implements ActionListener
    {
    	@Override
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
