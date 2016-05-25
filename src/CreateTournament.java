//import src.tournament;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CreateTournament {
   public String tournamentName;
   //public ArrayList<SoccerPlayer> playerPool;
   public int numberUsers = 2;

   //private ArrayList<ProfessionalTeam> allTeams;
   private JFrame frame;
   private JPanel teamsPanel;

   /*
   public Tournament returnTournament() {
      Tournament t = new Tournament(tournamentName, numberUsers, playerPool);
      return t;
   }
   */

   void createTournamentMenu() {
      // Initialize Frame
      frame = new JFrame();
      frame.setTitle("TeamPlay");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800,600);
      frame.setResizable(true);
      Dimension dim = new Dimension(360,40);
      frame.setVisible(true);

      // Upload All Teams w/ Rosters (currently from CSV)
      //UploadTeamsByCSV ut = new UploadTeamsByCSV();
      //allTeams = ut.upload();

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
      teamsPanel = new JPanel();
      teamsPanel.setLayout(null);
      frame.getContentPane().add(teamsPanel);
      teamsPanel.setPreferredSize(new Dimension(400, 300));

      // Add Tournament Name via JTextField
      JLabel tournamentNameLabel = new JLabel("Tournament Name: ");
      tournamentNameLabel.setBounds(100, 20, 300, 40);
      teamsPanel.add(tournamentNameLabel);

      JTextField tournamentNameField = new JTextField();
      tournamentNameField.setBounds(100, 50, 300, 40);
      teamsPanel.add(tournamentNameField);
      tournamentName = tournamentNameField.getText();

      // Add Max # Users via JSlider
      JLabel maxUsersLabel = new JLabel("Maximum number of players: ");
      maxUsersLabel.setBounds( 100, 80, 300, 40);
      teamsPanel.add(maxUsersLabel);

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
      teamsPanel.add(maxNumUsers);

      // Add Team Selection via JCheckBoxes
      JLabel selectTeamsLabel = new JLabel("Select Teams: ");
      selectTeamsLabel.setBounds(100, 150, 300, 40);
      teamsPanel.add(selectTeamsLabel);
      for (int i = 0; i < teamBoxes.length; i++) {
         teamBoxes[i].setBounds(100, 180 + 20 * i, 200, 20);
         teamsPanel.add(teamBoxes[i]);
      }

      frame.add(teamsPanel);
      frame.setVisible(true);
   }

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
}
