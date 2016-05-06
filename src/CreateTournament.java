import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.*;

public class CreateTournament {
   public String tournamentName;
   public ArrayList<SoccerPlayer>() playerPool;
   public int numberUsers;

   private ArrayList<ProfessionalTeam> allTeams;
   private JFrame frame;
   private JPanel teamsPanel;

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
      UploadTeamsByCSV ut = new UploadTeamsByCSV();
      allTeams = ut.upload();

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
               }
               else {
                  System.out.println("Deselected " + teamName);
                  // Remove all players from that team to pool
               }
            }
         });
      }

      // Create Tournament Panel
      teamsPanel = new JPanel();
      teamsPanel.setLayout(null);
      frame.getContentPane().add(teamsPanel);
      teamsPanel.setPreferredSize(new Dimension(400, 300));

      // Add Top Label to Panel
      JLabel selectTeams = new JLabel("Select Teams: ");
      selectTeams.setBounds(100, 20, 300, 40);
      teamsPanel.add(selectTeams);

      // Add Checkboxes to Panel
      for (int i = 0; i < teamBoxes.length; i++) {
         teamBoxes[i].setBounds(100, 50 + 20 * i, 200, 20);
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
     new CreateTournament().createTournamentMenu();
   }
}
