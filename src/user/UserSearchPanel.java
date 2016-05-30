package user;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

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
		GridBagConstraints gbcLblUsername = new GridBagConstraints();
		gbcLblUsername.anchor = GridBagConstraints.EAST;
		gbcLblUsername.gridwidth = 3;
		gbcLblUsername.insets = new Insets(0, 0, 5, 5);
		gbcLblUsername.gridx = 1;
		gbcLblUsername.gridy = 1;
		add(lblUsername, gbcLblUsername);
		
		usernameTextField = new JTextField();
		GridBagConstraints gbcUsernameTextField = new GridBagConstraints();
		gbcUsernameTextField.gridwidth = 6;
		gbcUsernameTextField.insets = new Insets(0, 0, 5, 5);
		gbcUsernameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUsernameTextField.gridx = 4;
		gbcUsernameTextField.gridy = 1;
		add(usernameTextField, gbcUsernameTextField);
		usernameTextField.setColumns(10);
		
		final JList<String> resultList = new JList<>();
		GridBagConstraints gbcResultList = new GridBagConstraints();
		gbcResultList.gridheight = 6;
		gbcResultList.gridwidth = 9;
		gbcResultList.insets = new Insets(0, 0, 5, 5);
		gbcResultList.fill = GridBagConstraints.BOTH;
		gbcResultList.gridx = 4;
		gbcResultList.gridy = 2;
		add(resultList, gbcResultList);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(element -> {
				UserSearch uSearch = new UserSearch(usernameTextField.getText());
				ArrayList<User> users = (ArrayList<User>) uSearch.getUsers();
				
				DefaultListModel<String> resultModel = new DefaultListModel<>();
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
		btnViewUser.addActionListener(new ViewUserButtonListener());
		
		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 7;
		gbc_btnBack.gridy = 8;
		add(btnBack, gbc_btnBack);
		
		btnBack.addActionListener(new BackToMainMenuListener());
		

		GridBagConstraints gbc_btnViewUser = new GridBagConstraints();
		gbc_btnViewUser.insets = new Insets(0, 0, 0, 5);
		gbc_btnViewUser.gridx = 10;
		gbc_btnViewUser.gridy = 8;
		add(btnViewUser, gbc_btnViewUser);

	}
	
	class ViewUserButtonListener implements ActionListener
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
	
	class BackToMainMenuListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			Component component = (Component) e.getSource();
        	JFrame frame = (JFrame) SwingUtilities.getRoot(component);
        	            
        	frame.getContentPane().removeAll();
        	//TODO provide correct user reference
        	frame.getContentPane().add(new MainMenuView(null));
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
		}
    }
	

}
