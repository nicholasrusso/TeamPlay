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
import javax.swing.UIManager;;

public class UserInfoPanel extends JPanel {
	private JTextField usernameField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField teamsField;
	private JTextField winsField;
	private JTextField lossesField;

	/**
	 * Create the panel.
	 */
	public UserInfoPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUserInfo = new JLabel("User Information");
		GridBagConstraints gbc_lblUserInfo = new GridBagConstraints();
		gbc_lblUserInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblUserInfo.gridx = 1;
		gbc_lblUserInfo.gridy = 0;
		add(lblUserInfo, gbc_lblUserInfo);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 2;
		add(lblUsername, gbc_lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBackground(UIManager.getColor("window"));
		usernameField.setEditable(false);
		GridBagConstraints gbc_userNameField = new GridBagConstraints();
		gbc_userNameField.insets = new Insets(0, 0, 5, 0);
		gbc_userNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNameField.gridx = 1;
		gbc_userNameField.gridy = 2;
		add(usernameField, gbc_userNameField);
		usernameField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 3;
		add(lblFirstName, gbc_lblFirstName);
		
		firstNameField = new JTextField();
		firstNameField.setBackground(UIManager.getColor("window"));
		firstNameField.setEditable(false);
		GridBagConstraints gbc_firstName = new GridBagConstraints();
		gbc_firstName.insets = new Insets(0, 0, 5, 0);
		gbc_firstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstName.gridx = 1;
		gbc_firstName.gridy = 3;
		add(firstNameField, gbc_firstName);
		firstNameField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 4;
		add(lblLastName, gbc_lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setBackground(UIManager.getColor("window"));
		lastNameField.setEditable(false);
		GridBagConstraints gbc_lastNameField = new GridBagConstraints();
		gbc_lastNameField.insets = new Insets(0, 0, 5, 0);
		gbc_lastNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameField.gridx = 1;
		gbc_lastNameField.gridy = 4;
		add(lastNameField, gbc_lastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		GridBagConstraints gbc_lblEmailAddress = new GridBagConstraints();
		gbc_lblEmailAddress.anchor = GridBagConstraints.EAST;
		gbc_lblEmailAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailAddress.gridx = 0;
		gbc_lblEmailAddress.gridy = 5;
		add(lblEmailAddress, gbc_lblEmailAddress);
		
		emailField = new JTextField();
		emailField.setBackground(UIManager.getColor("window"));
		emailField.setEditable(false);
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 0);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 5;
		add(emailField, gbc_emailField);
		emailField.setColumns(10);
		
		JLabel lblTeams = new JLabel("Teams");
		GridBagConstraints gbc_lblTeams = new GridBagConstraints();
		gbc_lblTeams.anchor = GridBagConstraints.EAST;
		gbc_lblTeams.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeams.gridx = 0;
		gbc_lblTeams.gridy = 6;
		add(lblTeams, gbc_lblTeams);
		
		teamsField = new JTextField();
		teamsField.setBackground(UIManager.getColor("window"));
		teamsField.setEditable(false);
		GridBagConstraints gbc_teamsField = new GridBagConstraints();
		gbc_teamsField.insets = new Insets(0, 0, 5, 0);
		gbc_teamsField.fill = GridBagConstraints.HORIZONTAL;
		gbc_teamsField.gridx = 1;
		gbc_teamsField.gridy = 6;
		add(teamsField, gbc_teamsField);
		teamsField.setColumns(10);
		
		JLabel lblWins = new JLabel("Wins");
		GridBagConstraints gbc_lblWins = new GridBagConstraints();
		gbc_lblWins.anchor = GridBagConstraints.EAST;
		gbc_lblWins.insets = new Insets(0, 0, 5, 5);
		gbc_lblWins.gridx = 0;
		gbc_lblWins.gridy = 7;
		add(lblWins, gbc_lblWins);
		
		winsField = new JTextField();
		winsField.setBackground(UIManager.getColor("window"));
		winsField.setEditable(false);
		GridBagConstraints gbc_winsField = new GridBagConstraints();
		gbc_winsField.insets = new Insets(0, 0, 5, 0);
		gbc_winsField.fill = GridBagConstraints.HORIZONTAL;
		gbc_winsField.gridx = 1;
		gbc_winsField.gridy = 7;
		add(winsField, gbc_winsField);
		winsField.setColumns(10);
		
		JLabel lblLosses = new JLabel("Losses");
		GridBagConstraints gbc_lblLosses = new GridBagConstraints();
		gbc_lblLosses.anchor = GridBagConstraints.EAST;
		gbc_lblLosses.insets = new Insets(0, 0, 5, 5);
		gbc_lblLosses.gridx = 0;
		gbc_lblLosses.gridy = 8;
		add(lblLosses, gbc_lblLosses);
		
		lossesField = new JTextField();
		lossesField.setBackground(UIManager.getColor("window"));
		lossesField.setEditable(false);
		GridBagConstraints gbc_lossesField = new GridBagConstraints();
		gbc_lossesField.insets = new Insets(0, 0, 5, 0);
		gbc_lossesField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lossesField.gridx = 1;
		gbc_lossesField.gridy = 8;
		add(lossesField, gbc_lossesField);
		lossesField.setColumns(10);
		
		JButton backButton = new JButton("Back");
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 9;
		backButton.addActionListener(new backToSearchButtonListener());
		add(backButton, gbc_backButton);

	}
}

class backToSearchButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e) 
    {
    	Component component = (Component) e.getSource();
    	JFrame frame = (JFrame) SwingUtilities.getRoot(component);
    	            
    	frame.getContentPane().removeAll();
    	frame.getContentPane().add(new UserSearchPanel());
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();        
    }
}
