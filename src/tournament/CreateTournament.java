package tournament;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CreateTournament {
   public String tournamentName;
   //public ArrayList<SoccerPlayer> playerPool;
   public int numberUsers = 2;

   //private ArrayList<ProfessionalTeam> allTeams;
   public JPanel tournamentPanel;

   /*
   public Tournament returnTournament() {
      Tournament t = new Tournament(tournamentName, numberUsers, playerPool);
      return t;
   }
   */

   public JPanel createTournamentMenu() {
      // Upload All Teams w/ Rosters (currently from CSV)
      //UploadTeamsByCSV ut = new UploadTeamsByCSV();
      //allTeams = ut.upload();

      /* For testing only
      // Initialize Frame
      JFrame frame = new JFrame();
      frame.setTitle("TeamPlay");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800,600);
      frame.setResizable(true);
      Dimension dim = new Dimension(360,40);
      frame.setVisible(true);
      */

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
                  System.out.println("Selected " + teamName);
                  // Add all players on that team to pool
                  // (pool is ArrayList<SoccerPlayer> playerPool)
               }
               else {
                  System.out.println("Deselected " + teamName);
                  // Remove all players from that team to pool
                  // (pool is ArrayList<SoccerPlayer> playerPool)
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

      /* For testing only
      // Add stuff to frame
      frame.add(tournamentPanel);
      frame.setVisible(true);
      frame.getContentPane().add(tournamentPanel);
      */

      return tournamentPanel;
   }

   /* For testing only
   public static void main(String[] args) {
     try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
     | UnsupportedLookAndFeelException e1) {
         e1.printStackTrace();
     }
     CreateTournament ct = new CreateTournament();
     ct.createTournamentMenu();
      System.out.println("tournamentName: " + ct.tournamentName);
      System.out.println("numberUsers: " + ct.numberUsers);
   }
   */
}
