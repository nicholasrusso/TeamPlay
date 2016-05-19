package user;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import user.UserSearch;
import java.util.ArrayList;
import user.User;
import java.awt.Font;

public class UserSearchPanel extends JPanel {
	private JTextField usernameTextField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public UserSearchPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridwidth = 3;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 1;
		add(lblUsername, gbc_lblUsername);
		
		usernameTextField = new JTextField();
		GridBagConstraints gbc_usernameTextField = new GridBagConstraints();
		gbc_usernameTextField.gridwidth = 6;
		gbc_usernameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameTextField.gridx = 4;
		gbc_usernameTextField.gridy = 1;
		add(usernameTextField, gbc_usernameTextField);
		usernameTextField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSearch uSearch = new UserSearch(usernameTextField.getText());
				ArrayList<User> u = uSearch.getUsers();
				if (u.size() > 0) {
					System.out.println(u.size() + " users found.");
					for (User user : u) {
						System.out.println(user.getUsername());
					}
				} else {
					System.out.println("No users found.");
				}
				
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.anchor = GridBagConstraints.WEST;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 10;
		gbc_btnSearch.gridy = 1;
		add(btnSearch, gbc_btnSearch);
		
		JLabel lblSearchResults = new JLabel("Search Results:");
		lblSearchResults.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblSearchResults = new GridBagConstraints();
		gbc_lblSearchResults.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSearchResults.gridwidth = 3;
		gbc_lblSearchResults.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchResults.gridx = 1;
		gbc_lblSearchResults.gridy = 2;
		add(lblSearchResults, gbc_lblSearchResults);
		
		JButton btnViewUser = new JButton("View User");
		btnViewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 7;
		gbc_table.gridheight = 6;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 4;
		gbc_table.gridy = 2;
		add(table, gbc_table);
		
		JLabel labelInfoOutput = new JLabel("");
		labelInfoOutput.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		labelInfoOutput.setForeground(new Color(0, 0, 128));
		GridBagConstraints gbc_labelInfoOutput = new GridBagConstraints();
		gbc_labelInfoOutput.anchor = GridBagConstraints.WEST;
		gbc_labelInfoOutput.gridwidth = 5;
		gbc_labelInfoOutput.insets = new Insets(0, 0, 0, 5);
		gbc_labelInfoOutput.gridx = 4;
		gbc_labelInfoOutput.gridy = 8;
		add(labelInfoOutput, gbc_labelInfoOutput);
		GridBagConstraints gbc_btnViewUser = new GridBagConstraints();
		gbc_btnViewUser.insets = new Insets(0, 0, 0, 5);
		gbc_btnViewUser.gridx = 10;
		gbc_btnViewUser.gridy = 8;
		add(btnViewUser, gbc_btnViewUser);

	}

}
