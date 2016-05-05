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
      frame.setResizable(false);
      Dimension dim = new Dimension(360,40);
      frame.setVisible(true);

      // JCheckBoxes
      JCheckBox arsenal = new JCheckBox("Arsenal");
      arsenal.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             System.out.println(e.getID() == ActionEvent.ACTION_PERFORMED
                 ? "ACTION_PERFORMED" : e.getID());
         }
      });
      arsenal.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
             System.out.println(e.getStateChange() == ItemEvent.SELECTED
                 ? "SELECTED" : "DESELECTED");
         }
      });

      // Panel
      JPanel teamsPanel = new JPanel(new BorderLayout());
      frame.getContentPane().add(teamsPanel);
      teamsPanel.setPreferredSize(new Dimension(400, 300));
      frame.add(teamsPanel);
      frame.add(arsenal);
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
