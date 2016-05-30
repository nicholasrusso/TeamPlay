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
		GridBagConstraints gbc_userNameField = new GridBagConstraints();
		gbc_userNameField.insets = new Insets(0, 0, 5, 0);
		gbc_userNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNameField.gridx = 1;
		gbc_userNameField.gridy = 2;
		add(usernameField, gbc_userNameField);
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
		GridBagConstraints gbc_firstName = new GridBagConstraints();
		gbc_firstName.insets = new Insets(0, 0, 5, 0);
		gbc_firstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstName.gridx = 1;
		gbc_firstName.gridy = 3;
		add(firstNameField, gbc_firstName);
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
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 0);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 5;
		add(emailField, gbc_emailField);
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
		GridBagConstraints gbc_teamsField = new GridBagConstraints();
		gbc_teamsField.insets = new Insets(0, 0, 5, 0);
		gbc_teamsField.fill = GridBagConstraints.HORIZONTAL;
		gbc_teamsField.gridx = 1;
		gbc_teamsField.gridy = 6;
		add(teamsField, gbc_teamsField);
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
		GridBagConstraints gbc_winsField = new GridBagConstraints();
		gbc_winsField.insets = new Insets(0, 0, 5, 0);
		gbc_winsField.fill = GridBagConstraints.HORIZONTAL;
		gbc_winsField.gridx = 1;
		gbc_winsField.gridy = 7;
		add(winsField, gbc_winsField);
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
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 9;
		backButton.addActionListener(new backToSearchButtonListener());
		add(backButton, gbc_backButton);

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
