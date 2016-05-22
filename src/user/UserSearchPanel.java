package user;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.border.BevelBorder;
import user.UserSearch;
import java.util.ArrayList;
import user.User;
import javax.swing.JList;
import view.GUI;
import view.MainMenuView;


public class UserSearchPanel extends JPanel {
	private JTextField usernameTextField;

	/**
	 * Create the panel.
	 */
	public UserSearchPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		JList resultList = new JList();
		GridBagConstraints gbc_resultList = new GridBagConstraints();
		gbc_resultList.gridheight = 6;
		gbc_resultList.gridwidth = 9;
		gbc_resultList.insets = new Insets(0, 0, 5, 5);
		gbc_resultList.fill = GridBagConstraints.BOTH;
		gbc_resultList.gridx = 4;
		gbc_resultList.gridy = 2;
		add(resultList, gbc_resultList);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSearch uSearch = new UserSearch(usernameTextField.getText());
				ArrayList<User> users = uSearch.getUsers();
				ArrayList<String> resultsData = new ArrayList<String>();
				
				DefaultListModel resultModel = new DefaultListModel();

				if (users.size() > 0) {
					System.out.println(users.size() + " users found.");
					for (User user : users) {
						System.out.println(user.getUsername());
						resultModel.addElement(user.getUsername());
					}
				} else {
					System.out.println("No users found.");
				}
				resultList.setModel(resultModel);
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
		btnViewUser.addActionListener(new viewUserButtonListener());
		
		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 7;
		gbc_btnBack.gridy = 8;
		add(btnBack, gbc_btnBack);
		
		btnBack.addActionListener(new backToMainMenuListener());
		

		GridBagConstraints gbc_btnViewUser = new GridBagConstraints();
		gbc_btnViewUser.insets = new Insets(0, 0, 0, 5);
		gbc_btnViewUser.gridx = 10;
		gbc_btnViewUser.gridy = 8;
		add(btnViewUser, gbc_btnViewUser);

	}
	
	class viewUserButtonListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			Component component = (Component) e.getSource();
        	JFrame frame = (JFrame) SwingUtilities.getRoot(component);
        	
        	JButton backButton = new JButton("Back");
            backButton.addActionListener(new backToSearchButtonListener());
            
        	frame.getContentPane().removeAll();
        	frame.getContentPane().add(new UserInfoPanel());
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
		}
    }
	
	class backToMainMenuListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			Component component = (Component) e.getSource();
        	JFrame frame = (JFrame) SwingUtilities.getRoot(component);
        	            
        	frame.getContentPane().removeAll();
        	frame.getContentPane().add(new MainMenuView());
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
		}
    }

}
