package tournament;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import soccerPlayer.*;
import teams.*;

public class CreateTournament {
   private String tournamentName;
   private ArrayList<SoccerPlayer> playerPool;
   private int numberUsers = 2;
   private JPanel tournamentPanel;

   public Tournament returnTournament() {
      return new Tournament(tournamentName, numberUsers, playerPool);
   }

   public JPanel createTournamentMenu() {
      // Upload All Teams w/ Rosters (currently from CSV)
      UploadTeamsByCSV ut = new UploadTeamsByCSV();
      final ArrayList<ProfessionalTeam> allTeams = ut.upload();

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
                  for (int i = 0; i < allTeams.size(); i++) {
                	  if (allTeams.get(i).getName().equals(teamName)) {
                		  ProfessionalTeam pt = allTeams.get(i);
                		  for (int j = 0; j < pt.getSize(); i++) {
                			  playerPool.add(pt.listOfPlayers.get(j));
                		  }
                	  }
                  }
               }
               else {
                  //System.out.println("Deselected " + teamName);
                  // Remove all players from deselected team
            	   for (int i = 0; i < playerPool.size(); i++) {
            		   if (playerPool.get(i).getTeam().equals(teamName)) {
            			   playerPool.remove(i);
            		   }
            	   }
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

      JTextField tournamentNameField = new JTextField();
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
         }
      }

      // Add Submit Button
      JButton submitButton = new JButton("Submit");
      submitButton.addActionListener(new submitButtonListener());
      submitButton.setBounds(100, 450, 200, 20);
      tournamentPanel.add(submitButton);

      return tournamentPanel;
   }

}
