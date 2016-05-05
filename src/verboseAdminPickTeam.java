import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.*;

public class adminPickTeam {
   private JFrame frame;
   private JPanel menuPanel, menuButtonPanel, profilePanel, settingsPanel, createTournamentPanel, tournamentPanel, rulesPanel;
   private JButton rulesButton, tournamentButton, createTournamentButton, editProfileButton, settingsButton, backButton; 

   void pickTeamMenu() {
      // Frame
      frame = new JFrame();
      frame.setTitle("TeamPlay");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800,600);
      //frame.setResizable(false);
      frame.setResizable(true);
      Dimension dim = new Dimension(360,40);
      frame.setVisible(true);

      // JCheckBoxes

      String[] teamNames = {"Arsenal", "Atletico Madrid", "Bayern Munich", 
         "Chelsea", "FC Barcelona", "Leicester City", "Liverpool", 
         "Manchester City", "Manchester United", "PSG", "Real Madrid", "Roma"};
      JCheckBox[] teamBoxes = new JCheckBox[teamNames.length];

      for (int i = 0; i < teamBoxes.length; i++) {
         teamBoxes[i] = new JCheckBox(teamNames[i]);
      }

      // Arsenal = 0
      // Atletico = 1
      // Bayern = 2
      // Chelsea = 3
      // FC Barcelona = 4
      // Leicester = 5
      // Liverpool = 6
      // Man City = 7
      // Man U = 8
      // PSG = 9
      // Real Madrid = 10
      // Roma = 11

      for (int i = 0; i < teamBoxes.length; i++) {
         final String teamName = teamNames[i];
         teamBoxes[i].addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
               if (e.getStateChange() == ItemEvent.SELECTED) {
                  System.out.println("Selected " + teamName);
               }
               else {
                  System.out.println("Deselected " + teamName);
               }
            }
         });
      }

      /*
      // Arsenal
      JCheckBox afc = new JCheckBox("Arsenal");
      afc.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               System.out.println("Selected Arsenal");
            }
            else {
               System.out.println("Deselected Arsenal");
            }
         }
      });
      
      // Atletico Madrid
      JCheckBox am = new JCheckBox("Atletico Madrid");
      am.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               System.out.println("Selected Atletico Madrid");
            }
            else {
               System.out.println("Deselected Atletico Madrid");
            }
         }
      });
      */

      // Panel
      JPanel teamsPanel = new JPanel();
      teamsPanel.setLayout(null);
      frame.getContentPane().add(teamsPanel);
      teamsPanel.setPreferredSize(new Dimension(400, 300));
      //teamsPanel.add(afc);
      //afc.setBounds(20, 20, 200, 20);
      //teamsPanel.add(am);
      //am.setBounds(20, 40, 200, 20);
      for (int i = 0; i < teamBoxes.length; i++) {
         teamBoxes[i].setBounds(20, 20 * i, 200, 20);
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
        new adminPickTeam().pickTeamMenu();
    }
}
