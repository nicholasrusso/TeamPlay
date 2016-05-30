package tournament;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBFactory;
import draft.DraftGui;

import javax.swing.event.ChangeEvent;

import soccerplayer.*;
import teams.*;
import user.User;
import user.UserSearch;
import view.MainMenuView;

public class CreateTournament {
   private String tournamentName = "";
   private ArrayList<SoccerPlayer> playerPool = new ArrayList<SoccerPlayer>();
   private int numberUsers = 2;
   private JPanel tournamentPanel;

   public Tournament returnTournament() {
      return new Tournament(tournamentName, numberUsers, playerPool);
   }

   public JPanel createTournamentMenu() {
      // JCheckBoxes (one for each team that has a teamName)
      String[] teamNames = {"Arsenal", "Atletico Madrid", "Bayern Munich", 
         "Chelsea", "FC Barcelona", "Leicester City", "Liverpool", 
         "Manchester City", "Manchester United", "PSG", "Real Madrid", "Roma"};
      JCheckBox[] teamBoxes = new JCheckBox[teamNames.length];

      for (int i = 0; i < teamBoxes.length; i++) {
         teamBoxes[i] = new JCheckBox(teamNames[i]);
      }

      // When boxes are checked or unchecked
      for (int i = 0; i < teamBoxes.length; i++) {
         final String teamName = teamNames[i];
         teamBoxes[i].addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
               if (e.getStateChange() == ItemEvent.SELECTED) {
                  //System.out.println("Selected " + teamName);
                  // Add all players from selected team
            	   String retrievePlayers = "select * from main.ProPlayer where team = ?";

            	   Connection db = DBFactory.getDBConnection();
            	   
            	   try {
            		   PreparedStatement pstmt = db.prepareStatement(retrievePlayers);
            		   pstmt.setString(1, teamName);
            		   ResultSet rs = pstmt.executeQuery(); 
            		   while (rs.next()) {
            			   if (rs.getString("position").equals("G")) {
            				   playerPool.add(new GoalKeeper(rs.getString("name"), rs.getString("team")));
            			   }
            			   else if (rs.getString("position").equals("D")) {
            				   playerPool.add(new Defender(rs.getString("name"), rs.getString("team")));
            			   }
            			   else if (rs.getString("position").equals("M")) {
            				   playerPool.add(new Midfielder(rs.getString("name"), rs.getString("team")));
            			   }
            			   else if (rs.getString("position").equals("F")) {
            				   playerPool.add(new Forward(rs.getString("name"), rs.getString("team")));
            			   }
            			   else {
            				   System.out.println("Incorrect database entry");
            			   }
            		   }
                     pstmt.close();
                     db.close();
            	   }
            	   catch (SQLException se) {
            		   // This will need to be turned into a logger later
            		   System.out.println("Unable to retrieve players from team " + teamName);
            	   }
               }
               else {
                  // Remove all players from deselected team
               }
            }
         });
      }

      // Create Tournament Panel
      tournamentPanel = new JPanel();
      tournamentPanel.setLayout(null);
      tournamentPanel.setPreferredSize(new Dimension(400, 300));

      // Add Tournament Name via JTextField
      JLabel tournamentNameLabel = new JLabel("Tournament Name: ");
      tournamentNameLabel.setBounds(100, 20, 300, 40);
      tournamentPanel.add(tournamentNameLabel);

      final JTextField tournamentNameField = new JTextField();
      tournamentNameField.setBounds(100, 50, 300, 40);
      tournamentPanel.add(tournamentNameField);
      tournamentName = tournamentNameField.getText();

      // Add Max # Users via JSlider
      JLabel maxUsersLabel = new JLabel("Maximum number of players: ");
      maxUsersLabel.setBounds( 100, 80, 300, 40);
      tournamentPanel.add(maxUsersLabel);

      JSlider maxNumUsers = new JSlider(0, 20, 2);
      maxNumUsers.setMajorTickSpacing(5);
      maxNumUsers.setMinorTickSpacing(1);
      maxNumUsers.setPaintTicks(true);
      maxNumUsers.setPaintLabels(true);
      maxNumUsers.setBounds(100, 110, 300, 40);
      maxNumUsers.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            numberUsers = ((JSlider)e.getSource()).getValue();
            System.out.println("numberUsers: " + numberUsers);
         }
      });
      tournamentPanel.add(maxNumUsers);

      // Add Team Selection via JCheckBoxes
      JLabel selectTeamsLabel = new JLabel("Select Teams For Player Pool: ");
      selectTeamsLabel.setBounds(100, 150, 300, 40);
      tournamentPanel.add(selectTeamsLabel);
      for (int i = 0; i < teamBoxes.length; i++) {
         teamBoxes[i].setBounds(100, 180 + 20 * i, 200, 20);
         tournamentPanel.add(teamBoxes[i]);
      }

      // Submit Button Listener
      class submitButtonListener implements ActionListener {
         public void actionPerformed(ActionEvent ae) {
        	 tournamentName = tournamentNameField.getText();
        	 System.out.println("Submitted");
        	 System.out.println("name: " + tournamentName);
        	 System.out.println("numberUsers: " + numberUsers);
        	 //System.out.println("playerPool: " + playerPool);
        	 
        	 
        	 Tournament tournament = new Tournament(tournamentName, numberUsers, playerPool);
        	 UserSearch search = new UserSearch("");
        	 ArrayList<User> list = (ArrayList<User>) search.getUsers();
        	 for (User user : list)
        	 {
        		 tournament.addUser(user);
        	 }
        	 DraftGui gui = new DraftGui(tournament);
        	 Component component = (Component) ae.getSource();
         	 JFrame frame = (JFrame) SwingUtilities.getRoot(component);
        	 frame.getContentPane().removeAll();
             frame.getContentPane().add(gui.getPanel());
             frame.getContentPane().revalidate();
             frame.getContentPane().repaint();
         }
      }

      // Add Submit Button
      JButton submitButton = new JButton("Submit");
      submitButton.addActionListener(new submitButtonListener());
      submitButton.setBounds(100, 450, 150, 20);
      tournamentPanel.add(submitButton);
      
      // Back Button Listener
      class backButtonListener implements ActionListener {
          public void actionPerformed(ActionEvent ae) {
  			Component component = (Component) ae.getSource();
        	JFrame frame = (JFrame) SwingUtilities.getRoot(component);
        	            
        	frame.getContentPane().removeAll();
        	//TODO provide correct user reference
        	frame.getContentPane().add(new MainMenuView(null));
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
          }
       }
      
      // Add Back Button
      JButton backButton = new JButton("Back");
      backButton.addActionListener(new backButtonListener());
      backButton.setBounds(500, 450, 150, 20);
      tournamentPanel.add(backButton);

      return tournamentPanel;
   }

}
