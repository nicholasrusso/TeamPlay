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
		GridBagConstraints gbcFirstName = new GridBagConstraints();
		gbcFirstName.insets = new Insets(0, 0, 5, 0);
		gbcFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbcFirstName.gridx = 1;
		gbcFirstName.gridy = 3;
		add(firstNameField, gbcFirstName);
		firstNameField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbcLblLastName = new GridBagConstraints();
		gbcLblLastName.anchor = GridBagConstraints.EAST;
		gbcLblLastName.insets = new Insets(0, 0, 5, 5);
		gbcLblLastName.gridx = 0;
		gbcLblLastName.gridy = 4;
		add(lblLastName, gbcLblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setBackground(windowColor);
		lastNameField.setEditable(false);
		GridBagConstraints gbcLastNameField = new GridBagConstraints();
		gbcLastNameField.insets = new Insets(0, 0, 5, 0);
		gbcLastNameField.fill = GridBagConstraints.HORIZONTAL;
		gbcLastNameField.gridx = 1;
		gbcLastNameField.gridy = 4;
		add(lastNameField, gbcLastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		GridBagConstraints gbcLblEmailAddress = new GridBagConstraints();
		gbcLblEmailAddress.anchor = GridBagConstraints.EAST;
		gbcLblEmailAddress.insets = new Insets(0, 0, 5, 5);
		gbcLblEmailAddress.gridx = 0;
		gbcLblEmailAddress.gridy = 5;
		add(lblEmailAddress, gbcLblEmailAddress);
		
		emailField = new JTextField();
		emailField.setBackground(windowColor);
		emailField.setEditable(false);
		GridBagConstraints gbcEmailField = new GridBagConstraints();
		gbcEmailField.insets = new Insets(0, 0, 5, 0);
		gbcEmailField.fill = GridBagConstraints.HORIZONTAL;
		gbcEmailField.gridx = 1;
		gbcEmailField.gridy = 5;
		add(emailField, gbcEmailField);
		emailField.setColumns(10);
		
		JLabel lblTeams = new JLabel("Teams");
		GridBagConstraints gbcLblTeams = new GridBagConstraints();
		gbcLblTeams.anchor = GridBagConstraints.EAST;
		gbcLblTeams.insets = new Insets(0, 0, 5, 5);
		gbcLblTeams.gridx = 0;
		gbcLblTeams.gridy = 6;
		add(lblTeams, gbcLblTeams);
		
		teamsField = new JTextField();
		teamsField.setBackground(windowColor);
		teamsField.setEditable(false);
		GridBagConstraints gbcTeamsField = new GridBagConstraints();
		gbcTeamsField.insets = new Insets(0, 0, 5, 0);
		gbcTeamsField.fill = GridBagConstraints.HORIZONTAL;
		gbcTeamsField.gridx = 1;
		gbcTeamsField.gridy = 6;
		add(teamsField, gbcTeamsField);
		teamsField.setColumns(10);
		
		JLabel lblWins = new JLabel("Wins");
		GridBagConstraints gbcLblWins = new GridBagConstraints();
		gbcLblWins.anchor = GridBagConstraints.EAST;
		gbcLblWins.insets = new Insets(0, 0, 5, 5);
		gbcLblWins.gridx = 0;
		gbcLblWins.gridy = 7;
		add(lblWins, gbcLblWins);
		
		winsField = new JTextField();
		winsField.setBackground(windowColor);
		winsField.setEditable(false);
		GridBagConstraints gbcWinsField = new GridBagConstraints();
		gbcWinsField.insets = new Insets(0, 0, 5, 0);
		gbcWinsField.fill = GridBagConstraints.HORIZONTAL;
		gbcWinsField.gridx = 1;
		gbcWinsField.gridy = 7;
		add(winsField, gbcWinsField);
		winsField.setColumns(10);
		
		JLabel lblLosses = new JLabel("Losses");
		GridBagConstraints gbcLblLosses = new GridBagConstraints();
		gbcLblLosses.anchor = GridBagConstraints.EAST;
		gbcLblLosses.insets = new Insets(0, 0, 5, 5);
		gbcLblLosses.gridx = 0;
		gbcLblLosses.gridy = 8;
		add(lblLosses, gbcLblLosses);
		
		lossesField = new JTextField();
		lossesField.setBackground(windowColor);
		lossesField.setEditable(false);
		GridBagConstraints gbcLossesField = new GridBagConstraints();
		gbcLossesField.insets = new Insets(0, 0, 5, 0);
		gbcLossesField.fill = GridBagConstraints.HORIZONTAL;
		gbcLossesField.gridx = 1;
		gbcLossesField.gridy = 8;
		add(lossesField, gbcLossesField);
		lossesField.setColumns(10);
		
		JButton backButton = new JButton("Back");
		GridBagConstraints gbcBackButton = new GridBagConstraints();
		gbcBackButton.gridx = 1;
		gbcBackButton.gridy = 9;
		backButton.addActionListener(new backToSearchButtonListener());
		add(backButton, gbcBackButton);

	}
}

class backToSearchButtonListener implements ActionListener
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
