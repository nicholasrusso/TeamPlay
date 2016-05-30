package user;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
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
		
		Color windowColor = UIManager.getColor("window");
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUserInfo = new JLabel("User Information");
		GridBagConstraints gbcLblUserInfo = new GridBagConstraints();
		gbcLblUserInfo.insets = new Insets(0, 0, 5, 0);
		gbcLblUserInfo.gridx = 1;
		gbcLblUserInfo.gridy = 0;
		add(lblUserInfo, gbcLblUserInfo);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbcLblUsername = new GridBagConstraints();
		gbcLblUsername.anchor = GridBagConstraints.EAST;
		gbcLblUsername.insets = new Insets(0, 0, 5, 5);
		gbcLblUsername.gridx = 0;
		gbcLblUsername.gridy = 2;
		add(lblUsername, gbcLblUsername);
		
		usernameField = new JTextField();
		usernameField.setBackground(windowColor);
		usernameField.setEditable(false);
		GridBagConstraints gbcUserNameField = new GridBagConstraints();
		gbcUserNameField.insets = new Insets(0, 0, 5, 0);
		gbcUserNameField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserNameField.gridx = 1;
		gbcUserNameField.gridy = 2;
		add(usernameField, gbcUserNameField);
		usernameField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		GridBagConstraints gbcLblFirstName = new GridBagConstraints();
		gbcLblFirstName.anchor = GridBagConstraints.EAST;
		gbcLblFirstName.insets = new Insets(0, 0, 5, 5);
		gbcLblFirstName.gridx = 0;
		gbcLblFirstName.gridy = 3;
		add(lblFirstName, gbcLblFirstName);
		
		firstNameField = new JTextField();
		firstNameField.setBackground(windowColor);
		firstNameField.setEditable(false);
		GridBagConstraints gbcFirstNameRO = new GridBagConstraints();
		gbcFirstNameRO.insets = new Insets(0, 0, 5, 0);
		gbcFirstNameRO.fill = GridBagConstraints.HORIZONTAL;
		gbcFirstNameRO.gridx = 1;
		gbcFirstNameRO.gridy = 3;
		add(firstNameField, gbcFirstNameRO);
		firstNameField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbcLblLastNameRO = new GridBagConstraints();
		gbcLblLastNameRO.anchor = GridBagConstraints.EAST;
		gbcLblLastNameRO.insets = new Insets(0, 0, 5, 5);
		gbcLblLastNameRO.gridx = 0;
		gbcLblLastNameRO.gridy = 4;
		add(lblLastName, gbcLblLastNameRO);
		
		lastNameField = new JTextField();
		lastNameField.setBackground(windowColor);
		lastNameField.setEditable(false);
		GridBagConstraints gbcLastNameFieldRO = new GridBagConstraints();
		gbcLastNameFieldRO.insets = new Insets(0, 0, 5, 0);
		gbcLastNameFieldRO.fill = GridBagConstraints.HORIZONTAL;
		gbcLastNameFieldRO.gridx = 1;
		gbcLastNameFieldRO.gridy = 4;
		add(lastNameField, gbcLastNameFieldRO);
		lastNameField.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		GridBagConstraints gbcLblEmailAddressRO = new GridBagConstraints();
		gbcLblEmailAddressRO.anchor = GridBagConstraints.EAST;
		gbcLblEmailAddressRO.insets = new Insets(0, 0, 5, 5);
		gbcLblEmailAddressRO.gridx = 0;
		gbcLblEmailAddressRO.gridy = 5;
		add(lblEmailAddress, gbcLblEmailAddressRO);
		
		emailField = new JTextField();
		emailField.setBackground(windowColor);
		emailField.setEditable(false);
		GridBagConstraints gbcEmailFieldRO = new GridBagConstraints();
		gbcEmailFieldRO.insets = new Insets(0, 0, 5, 0);
		gbcEmailFieldRO.fill = GridBagConstraints.HORIZONTAL;
		gbcEmailFieldRO.gridx = 1;
		gbcEmailFieldRO.gridy = 5;
		add(emailField, gbcEmailFieldRO);
		emailField.setColumns(10);
		
		JLabel lblTeams = new JLabel("Teams");
		GridBagConstraints gbcLblTeamsRO = new GridBagConstraints();
		gbcLblTeamsRO.anchor = GridBagConstraints.EAST;
		gbcLblTeamsRO.insets = new Insets(0, 0, 5, 5);
		gbcLblTeamsRO.gridx = 0;
		gbcLblTeamsRO.gridy = 6;
		add(lblTeams, gbcLblTeamsRO);
		
		teamsField = new JTextField();
		teamsField.setBackground(windowColor);
		teamsField.setEditable(false);
		GridBagConstraints gbcTeamsFieldRO = new GridBagConstraints();
		gbcTeamsFieldRO.insets = new Insets(0, 0, 5, 0);
		gbcTeamsFieldRO.fill = GridBagConstraints.HORIZONTAL;
		gbcTeamsFieldRO.gridx = 1;
		gbcTeamsFieldRO.gridy = 6;
		add(teamsField, gbcTeamsFieldRO);
		teamsField.setColumns(10);
		
		JLabel lblWins = new JLabel("Wins");
		GridBagConstraints gbcLblWinsRO = new GridBagConstraints();
		gbcLblWinsRO.anchor = GridBagConstraints.EAST;
		gbcLblWinsRO.insets = new Insets(0, 0, 5, 5);
		gbcLblWinsRO.gridx = 0;
		gbcLblWinsRO.gridy = 7;
		add(lblWins, gbcLblWinsRO);
		
		winsField = new JTextField();
		winsField.setBackground(windowColor);
		winsField.setEditable(false);
		GridBagConstraints gbcWinsFieldRO = new GridBagConstraints();
		gbcWinsFieldRO.insets = new Insets(0, 0, 5, 0);
		gbcWinsFieldRO.fill = GridBagConstraints.HORIZONTAL;
		gbcWinsFieldRO.gridx = 1;
		gbcWinsFieldRO.gridy = 7;
		add(winsField, gbcWinsFieldRO);
		winsField.setColumns(10);
		
		JLabel lblLosses = new JLabel("Losses");
		GridBagConstraints gbcLblLossesRO = new GridBagConstraints();
		gbcLblLossesRO.anchor = GridBagConstraints.EAST;
		gbcLblLossesRO.insets = new Insets(0, 0, 5, 5);
		gbcLblLossesRO.gridx = 0;
		gbcLblLossesRO.gridy = 8;
		add(lblLosses, gbcLblLossesRO);
		
		lossesField = new JTextField();
		lossesField.setBackground(windowColor);
		lossesField.setEditable(false);
		GridBagConstraints gbcLossesFieldRO = new GridBagConstraints();
		gbcLossesFieldRO.insets = new Insets(0, 0, 5, 0);
		gbcLossesFieldRO.fill = GridBagConstraints.HORIZONTAL;
		gbcLossesFieldRO.gridx = 1;
		gbcLossesFieldRO.gridy = 8;
		add(lossesField, gbcLossesFieldRO);
		lossesField.setColumns(10);
		
		JButton backButton = new JButton("Back");
		GridBagConstraints gbcBackButton = new GridBagConstraints();
		gbcBackButton.gridx = 1;
		gbcBackButton.gridy = 9;
		backButton.addActionListener(new BackToSearchButtonListener());
		add(backButton, gbcBackButton);

	}
}

class BackToSearchButtonListener implements ActionListener
{
	@Override
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
