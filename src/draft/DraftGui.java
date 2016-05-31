package draft;

import java.util.*;

import javax.swing.*;

import soccerplayer.SoccerPlayer;
import tournament.Tournament;
import user.User;
import view.MainMenuView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

public class DraftGui implements Observer
{
    private static JPanel frame;
    private JTextField txtTimeRemaining;
    private JTextField txtPlayerSelection;
    private JTextField txtCurrentTeam;
    private JTextField txtTeamStatistics;
    private JTextField timerTxt;
    private JTextField player1Name;
    private JTextField player2Name;
    private JTextField player3Name;
    private JTextArea forward;
    private JTextArea mids;
    private JTextArea defs;
    private JTextArea keeps;
    private JButton quitDraftButton;
    private JButton startDraftButton;
    private JButton btnPlayer1;
    private JButton btnPlayer2;
    private JButton btnPlayer3;
    private JButton saveButton;
    private SoccerPlayer[] players;
    private JTextArea txtrTeamName;
    private JTextArea txtrNumberOfPlayers;
    private JTextArea txtrFormation;
    private JTextArea userNameTA;
    private JTextArea userNameInfoTA;
    private JTextArea numOfPlayers;
    private JTextArea teamNameTA;
    private JPanel playerSelectionPanel;
    private JPanel timerPanel;
    private JPanel currentUserTeamPanel;
    private JPanel teamStatsPanel;
    private JComboBox<String> formationComboBox;
    private static final String FONT = "Lucida Grande";  
    private DraftModel model;
    private JTextField txtForwards;
    private JTextField txtMidfielders;
    private JTextField txtDefenders;
    private JTextField txtGoalkeepers;
    private JTextArea textArea2;
    private JTextArea textArea;
    

    /**
     * @wbp.parser.entryPoint
     */
    public DraftGui(Tournament tournament)
    {
        model = new DraftModel(tournament);
        frame = new JPanel();
        
        model.addObserver(this);
        frame.setLayout(null);
        
        
        userNameTA = new JTextArea();
        userNameTA.setBounds(327, 6, 265, 32);
        userNameTA.setFont(new Font(FONT, Font.PLAIN, 24));
        userNameTA.setWrapStyleWord(true);
        userNameTA.setEditable(false);
        userNameTA.setLineWrap(true);
        frame.add(userNameTA);
        
        playerSelectionPanel = new JPanel();
        playerSelectionPanel.setBounds(6, 74, 461, 180);
        frame.add(playerSelectionPanel);
        playerSelectionPanel.setLayout(null);
        
        
        btnPlayer1 = new JButton("");
        btnPlayer2 = new JButton("");
        btnPlayer3 = new JButton("");
        
        
        btnPlayer1.addActionListener(element -> model.nextUser(0));
        btnPlayer1.setBounds(6, 145, 117, 29);
        playerSelectionPanel.add(btnPlayer1);
        
        btnPlayer2.addActionListener(element -> model.nextUser(1));
        btnPlayer2.setBounds(180, 145, 117, 29);
        playerSelectionPanel.add(btnPlayer2);
        
        btnPlayer3.addActionListener(element -> model.nextUser(2));
        btnPlayer3.setBounds(338, 145, 117, 29);
        playerSelectionPanel.add(btnPlayer3);
        
 
        
        player1Name = new JTextField();
        player1Name.setText("");
        player1Name.setHorizontalAlignment(SwingConstants.CENTER);
        player1Name.setColumns(10);
        player1Name.setBounds(6, 29, 117, 29);
        playerSelectionPanel.add(player1Name);
        
        player2Name = new JTextField();
        player2Name.setText("");
        player2Name.setHorizontalAlignment(SwingConstants.CENTER);
        player2Name.setColumns(10);
        player2Name.setBounds(180, 29, 117, 29);
        playerSelectionPanel.add(player2Name);
        
        player3Name = new JTextField();
        player3Name.setText("");
        player3Name.setHorizontalAlignment(SwingConstants.CENTER);
        player3Name.setColumns(10);
        player3Name.setBounds(338, 29, 117, 29);
        playerSelectionPanel.add(player3Name);
        player1Name.setEditable(false);
        player2Name.setEditable(false);
        player3Name.setEditable(false);
        
        userNameInfoTA = new JTextArea();
        userNameInfoTA.setBounds(151, 6, 164, 32);
        userNameInfoTA.setFont(new Font(FONT, Font.PLAIN, 24));
        frame.add(userNameInfoTA);
        userNameInfoTA.setEditable(false);
        userNameInfoTA.setBackground(SystemColor.window);
        userNameInfoTA.setText("Current User:");
        
        timerPanel = new JPanel();
        timerPanel.setBounds(479, 74, 315, 180);
        frame.add(timerPanel);
        timerPanel.setLayout(null);
        
        timerTxt = new JTextField();
        timerTxt.setEditable(false);
        timerTxt.setFont(new Font(FONT, Font.BOLD, 35));
        timerTxt.setText("Press Start");
        timerTxt.setHorizontalAlignment(SwingConstants.CENTER);
        timerTxt.setColumns(10);
        timerTxt.setBounds(6, 6, 303, 168);
        timerPanel.add(timerTxt);
        
        txtTimeRemaining = new JTextField();
        txtTimeRemaining.setBackground(SystemColor.window);
        txtTimeRemaining.setBounds(479, 50, 317, 26);
        txtTimeRemaining.setEditable(false);
        txtTimeRemaining.setHorizontalAlignment(SwingConstants.CENTER);
        txtTimeRemaining.setText("Time Remaining");
        frame.add(txtTimeRemaining);
        txtTimeRemaining.setColumns(10);
        
        txtPlayerSelection = new JTextField();
        txtPlayerSelection.setBackground(SystemColor.window);
        txtPlayerSelection.setBounds(6, 49, 461, 26);
        txtPlayerSelection.setEditable(false);
        frame.add(txtPlayerSelection);
        txtPlayerSelection.setText("Player Selection");
        txtPlayerSelection.setHorizontalAlignment(SwingConstants.CENTER);
        txtPlayerSelection.setColumns(10);
        
        currentUserTeamPanel = new JPanel();
        currentUserTeamPanel.setBounds(6, 345, 461, 162);
        frame.add(currentUserTeamPanel);
        currentUserTeamPanel.setLayout(null);
        
        forward = new JTextArea();
        forward.setEditable(false);
        forward.setWrapStyleWord(true);
        forward.setFont(new Font(FONT, Font.PLAIN, 10));
        forward.setBounds(5, 22, 112, 134);
        currentUserTeamPanel.add(forward);
        
        mids = new JTextArea();
        mids.setEditable(false);
        mids.setWrapStyleWord(true);
        mids.setFont(new Font(FONT, Font.PLAIN, 10));
        mids.setBounds(119, 22, 110, 134);
        currentUserTeamPanel.add(mids);
        
        defs = new JTextArea();
        defs.setEditable(false);
        defs.setWrapStyleWord(true);
        defs.setFont(new Font(FONT, Font.PLAIN, 10));
        defs.setBounds(231, 22, 112, 134);
        currentUserTeamPanel.add(defs);
        
        keeps = new JTextArea();
        keeps.setEditable(false);
        keeps.setWrapStyleWord(true);
        keeps.setFont(new Font(FONT, Font.PLAIN, 10));
        keeps.setBounds(345, 22, 110, 134);
        currentUserTeamPanel.add(keeps);
        
        txtForwards = new JTextField();
        txtForwards.setHorizontalAlignment(SwingConstants.CENTER);
        txtForwards.setText("Forwards");
        txtForwards.setBounds(5, 3, 112, 16);
        currentUserTeamPanel.add(txtForwards);
        txtForwards.setColumns(10);
        
        txtMidfielders = new JTextField();
        txtMidfielders.setText("Midfielders");
        txtMidfielders.setHorizontalAlignment(SwingConstants.CENTER);
        txtMidfielders.setColumns(10);
        txtMidfielders.setBounds(119, 3, 112, 16);
        currentUserTeamPanel.add(txtMidfielders);
        
        txtDefenders = new JTextField();
        txtDefenders.setText("Defenders");
        txtDefenders.setHorizontalAlignment(SwingConstants.CENTER);
        txtDefenders.setColumns(10);
        txtDefenders.setBounds(231, 3, 112, 16);
        currentUserTeamPanel.add(txtDefenders);
        
        txtGoalkeepers = new JTextField();
        txtGoalkeepers.setText("Goalkeepers");
        txtGoalkeepers.setHorizontalAlignment(SwingConstants.CENTER);
        txtGoalkeepers.setColumns(10);
        txtGoalkeepers.setBounds(345, 3, 112, 16);
        currentUserTeamPanel.add(txtGoalkeepers);
        
        txtCurrentTeam = new JTextField();
        txtCurrentTeam.setBackground(SystemColor.window);
        txtCurrentTeam.setBounds(6, 319, 461, 26);
        txtCurrentTeam.setEditable(false);
        txtCurrentTeam.setText("Current Team");
        txtCurrentTeam.setHorizontalAlignment(SwingConstants.CENTER);
        txtCurrentTeam.setColumns(10);
        frame.add(txtCurrentTeam);
        
        teamStatsPanel = new JPanel();
        teamStatsPanel.setBounds(479, 292, 309, 215);
        frame.add(teamStatsPanel);
        teamStatsPanel.setLayout(null);
        
        txtrTeamName = new JTextArea();
        txtrTeamName.setBackground(SystemColor.window);
        txtrTeamName.setEditable(false);
        txtrTeamName.setFont(new Font(FONT, Font.PLAIN, 16));
        txtrTeamName.setText("Team Name:");
        txtrTeamName.setBounds(6, 6, 102, 20);
        teamStatsPanel.add(txtrTeamName);
        
        txtrNumberOfPlayers = new JTextArea();
        txtrNumberOfPlayers.setBackground(SystemColor.window);
        txtrNumberOfPlayers.setEditable(false);
        txtrNumberOfPlayers.setText("Players:");
        txtrNumberOfPlayers.setFont(new Font(FONT, Font.PLAIN, 16));
        txtrNumberOfPlayers.setBounds(189, 182, 60, 27);
        teamStatsPanel.add(txtrNumberOfPlayers);
        
        txtrFormation = new JTextArea();
        txtrFormation.setBackground(SystemColor.window);
        txtrFormation.setEditable(false);
        txtrFormation.setText("Formation:");
        txtrFormation.setFont(new Font(FONT, Font.PLAIN, 16));
        txtrFormation.setBounds(6, 182, 86, 27);
        teamStatsPanel.add(txtrFormation);
        
        formationComboBox = new JComboBox<>();
        formationComboBox.setBounds(88, 181, 102, 27);
        teamStatsPanel.add(formationComboBox);
        formationComboBox.addItem("4-3-3");
        formationComboBox.addItem("4-5-1");
        formationComboBox.addItem("4-4-2");
        
        numOfPlayers = new JTextArea();
        numOfPlayers.setEditable(false);
        numOfPlayers.setBounds(261, 182, 38, 27);
        teamStatsPanel.add(numOfPlayers);
        
        teamNameTA = new JTextArea();
        teamNameTA.setBackground(SystemColor.window);
        teamNameTA.setText("Team");
        teamNameTA.setFont(new Font(FONT, Font.PLAIN, 16));
        teamNameTA.setBounds(120, 6, 184, 20);
        teamStatsPanel.add(teamNameTA);
        
        textArea2 = new JTextArea();
        textArea2.setWrapStyleWord(true);
        textArea2.setText((String) null);
        textArea2.setFont(new Font(FONT, Font.PLAIN, 10));
        textArea2.setEditable(false);
        textArea2.setBounds(16, 29, 138, 151);
        teamStatsPanel.add(textArea2);
        
        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setText((String) null);
        textArea.setFont(new Font(FONT, Font.PLAIN, 10));
        textArea.setEditable(false);
        textArea.setBounds(161, 29, 138, 151);
        teamStatsPanel.add(textArea);
        
        txtTeamStatistics = new JTextField();
        txtTeamStatistics.setBackground(SystemColor.window);
        txtTeamStatistics.setBounds(479, 266, 315, 26);
        txtTeamStatistics.setEditable(false);
        txtTeamStatistics.setText("Team Information");
        txtTeamStatistics.setHorizontalAlignment(SwingConstants.CENTER);
        txtTeamStatistics.setColumns(10);
        frame.add(txtTeamStatistics);
        
        quitDraftButton = new JButton("Quit Draft");
        quitDraftButton.setBounds(6, 519, 461, 52);
        quitDraftButton.setFont(new Font(FONT, Font.PLAIN, 34));
        quitDraftButton.addActionListener((ActionEvent ae) -> {
  			Component component = (Component) ae.getSource();
        	JFrame newFrame = (JFrame) SwingUtilities.getRoot(component);
        	            
        	newFrame.getContentPane().removeAll();
        	newFrame.getContentPane().add(new MainMenuView(null));
        	newFrame.getContentPane().revalidate();
        	newFrame.getContentPane().repaint();
        });
        frame.add(quitDraftButton);
        
        
        saveButton = new JButton("Save");
        saveButton.setBounds(477, 519, 317, 54);
        saveButton.addActionListener(element -> {
                model.setTeamName(teamNameTA.getText());
                model.setTeamFormation(formationComboBox.getSelectedItem().toString());
                for (User user : tournament.getUsers())
                {
                	user.getEmail().sendEmailTo(user.getEmail(), "Hello From TeamPlay!"
                			+ "\nYou've Joined: " + tournament.getName() +
                    		"\nThis s Your Selected Team: " + model.getTeamToString("forws") +
                    		model.getTeamToString("mids") + model.getTeamToString("defs") +
                    		model.getTeamToString("keeps") + "\n Good Luck This Week!\nThe TeamPlay Devs");
                }
                
            });
        saveButton.setForeground(Color.BLACK);
        saveButton.setFont(new Font(FONT, Font.PLAIN, 34));
        saveButton.setBackground(Color.RED);
        saveButton.setEnabled(false);
        
        
        startDraftButton = new JButton("Start");
        startDraftButton.setBounds(6, 266, 461, 54);
        startDraftButton.setForeground(Color.BLACK);
        startDraftButton.setBackground(Color.RED);
        startDraftButton.setFont(new Font(FONT, Font.PLAIN, 34));
        startDraftButton.addActionListener(element -> {
                if (!model.isOver())
                {
	            	model.startDraft();
	                if (!model.hasTeam())
	                {
	                    String name = JOptionPane.showInputDialog(frame,
	                            "What is your team name?",  JOptionPane.OK_CANCEL_OPTION); 
	                    model.addNewTeam(name);       
	                }
	                DraftGui.this.update(model, null);

	                model.startTimer();
                }
        });
        frame.add(startDraftButton);
        
        
        frame.add(saveButton);
        frame.setSize(800, 591);
        frame.setVisible(true);
        update(null, null);
        
    }

   

    @Override
    public void update(Observable o, Object arg) {
    	btnPlayer1.setEnabled(model.getSelection());
        btnPlayer2.setEnabled(model.getSelection());
        btnPlayer3.setEnabled(model.getSelection());
        if (model.getSelection())
        {
	        players = model.getCurrentPlayerSelection();
	        btnPlayer1.setText(players[0].getName());
	        btnPlayer2.setText(players[1].getName());
	        btnPlayer3.setText(players[2].getName());
	        player1Name.setText(players[0].getName());
	        player2Name.setText(players[1].getName());
	        player3Name.setText(players[2].getName());
        }
        else
        {
        	btnPlayer1.setText("");
	        btnPlayer2.setText("");
	        btnPlayer3.setText("");
	        player1Name.setText("");
	        player2Name.setText("");
	        player3Name.setText("");
        }
        
        numOfPlayers.setText(model.getCurrentUserTeamSize());
        saveButton.setEnabled(true);
        teamNameTA.setText(model.getCurrentUserTeamName());
        formationComboBox.setSelectedItem(model.getCurrentUserTeamFormation());   
        if (!model.isOver())
        	timerTxt.setText(model.getTime());
        else
        	timerTxt.setText("DraftOver");
        userNameTA.setText(model.getCurrentUserName());
        startDraftButton.setEnabled(!model.getSelection());
        forward.setText(model.getTeamToString("forws"));
        mids.setText(model.getTeamToString("mids"));
        defs.setText(model.getTeamToString("defs"));
        keeps.setText(model.getTeamToString("keeps"));
        if (model.hasTeam() && model.getTeamStats().indexOf("\n\n") != -1) 
        {
	        textArea.setText(model.getTeamStats().substring(model.getTeamStats().indexOf("\n\n")).trim());
	        textArea2.setText(model.getTeamStats().substring(0, model.getTeamStats().indexOf("\n\n")).trim());
    	}
    }
    
    public JPanel getPanel()
    {
    	return frame;
    }
}
