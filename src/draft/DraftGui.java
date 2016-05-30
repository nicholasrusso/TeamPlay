package draft;

import java.util.*;

import javax.swing.*;

import soccerplayer.SoccerPlayer;
import tournament.Tournament;

import java.awt.Color;
import java.awt.Font;

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
    private JTextArea currentUserTeamTable;
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
    private JTextArea txtrFormationGrap;
    private JTextArea teamNameTA;
    private JPanel playerSelectionPanel;
    private JPanel timerPanel;
    private JPanel currentUserTeamPanel;
    private JPanel teamStatsPanel;
    private JComboBox<String> formationComboBox;
    private static final String FONT = "Lucida Grande";  
    private DraftModel model;
    

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
        playerSelectionPanel.setBounds(6, 74, 364, 180);
        frame.add(playerSelectionPanel);
        playerSelectionPanel.setLayout(null);
        
        
        btnPlayer1 = new JButton("");
        btnPlayer2 = new JButton("");
        btnPlayer3 = new JButton("");
        
        
        btnPlayer1.addActionListener(element -> model.nextUser(0));
        btnPlayer1.setBounds(6, 69, 117, 29);
        playerSelectionPanel.add(btnPlayer1);
        
        btnPlayer2.addActionListener(element -> model.nextUser(1));
        btnPlayer2.setBounds(122, 69, 117, 29);
        playerSelectionPanel.add(btnPlayer2);
        
        btnPlayer3.addActionListener(element -> model.nextUser(2));
        btnPlayer3.setBounds(241, 69, 117, 29);
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
        player2Name.setBounds(122, 29, 117, 29);
        playerSelectionPanel.add(player2Name);
        
        player3Name = new JTextField();
        player3Name.setText("");
        player3Name.setHorizontalAlignment(SwingConstants.CENTER);
        player3Name.setColumns(10);
        player3Name.setBounds(241, 29, 117, 29);
        playerSelectionPanel.add(player3Name);
        player1Name.setEditable(false);
        player2Name.setEditable(false);
        player3Name.setEditable(false);
        
        userNameInfoTA = new JTextArea();
        userNameInfoTA.setBounds(151, 6, 164, 32);
        userNameInfoTA.setFont(new Font(FONT, Font.PLAIN, 24));
        frame.add(userNameInfoTA);
        userNameInfoTA.setEditable(false);
        userNameInfoTA.setBackground(Color.WHITE);
        userNameInfoTA.setText("Current User:");
        
        timerPanel = new JPanel();
        timerPanel.setBounds(382, 74, 364, 180);
        frame.add(timerPanel);
        timerPanel.setLayout(null);
        
        timerTxt = new JTextField();
        timerTxt.setEditable(false);
        timerTxt.setFont(new Font(FONT, Font.BOLD, 35));
        timerTxt.setText("STARTING DRAFT!");
        timerTxt.setHorizontalAlignment(SwingConstants.CENTER);
        timerTxt.setColumns(10);
        timerTxt.setBounds(35, 6, 275, 168);
        timerPanel.add(timerTxt);
        
        txtTimeRemaining = new JTextField();
        txtTimeRemaining.setBounds(382, 50, 364, 26);
        txtTimeRemaining.setEditable(false);
        txtTimeRemaining.setHorizontalAlignment(SwingConstants.CENTER);
        txtTimeRemaining.setText("Time Remaining");
        frame.add(txtTimeRemaining);
        txtTimeRemaining.setColumns(10);
        
        txtPlayerSelection = new JTextField();
        txtPlayerSelection.setBounds(6, 49, 364, 26);
        txtPlayerSelection.setEditable(false);
        frame.add(txtPlayerSelection);
        txtPlayerSelection.setText("Player Selection");
        txtPlayerSelection.setHorizontalAlignment(SwingConstants.CENTER);
        txtPlayerSelection.setColumns(10);
        
        currentUserTeamPanel = new JPanel();
        currentUserTeamPanel.setBounds(6, 345, 364, 169);
        frame.add(currentUserTeamPanel);
        currentUserTeamPanel.setLayout(null);
        
        currentUserTeamTable = new JTextArea();
        currentUserTeamTable.setBounds(6, 6, 352, 154);
        currentUserTeamPanel.add(currentUserTeamTable);
        
        txtCurrentTeam = new JTextField();
        txtCurrentTeam.setBounds(6, 319, 364, 26);
        txtCurrentTeam.setEditable(false);
        txtCurrentTeam.setText("Current Team");
        txtCurrentTeam.setHorizontalAlignment(SwingConstants.CENTER);
        txtCurrentTeam.setColumns(10);
        frame.add(txtCurrentTeam);
        
        teamStatsPanel = new JPanel();
        teamStatsPanel.setBounds(382, 286, 364, 228);
        frame.add(teamStatsPanel);
        teamStatsPanel.setLayout(null);
        
        txtrTeamName = new JTextArea();
        txtrTeamName.setEditable(false);
        txtrTeamName.setFont(new Font(FONT, Font.PLAIN, 16));
        txtrTeamName.setText("Team Name:");
        txtrTeamName.setBounds(6, 6, 102, 27);
        teamStatsPanel.add(txtrTeamName);
        
        txtrNumberOfPlayers = new JTextArea();
        txtrNumberOfPlayers.setEditable(false);
        txtrNumberOfPlayers.setText("# of Players:");
        txtrNumberOfPlayers.setFont(new Font(FONT, Font.PLAIN, 16));
        txtrNumberOfPlayers.setBounds(202, 182, 102, 27);
        teamStatsPanel.add(txtrNumberOfPlayers);
        
        txtrFormation = new JTextArea();
        txtrFormation.setEditable(false);
        txtrFormation.setText("Formation:");
        txtrFormation.setFont(new Font(FONT, Font.PLAIN, 16));
        txtrFormation.setBounds(6, 182, 95, 27);
        teamStatsPanel.add(txtrFormation);
        
        formationComboBox = new JComboBox<>();
        formationComboBox.setBounds(101, 181, 102, 27);
        teamStatsPanel.add(formationComboBox);
        formationComboBox.addItem("4-3-3");
        formationComboBox.addItem("4-5-1");
        formationComboBox.addItem("4-4-2");
        
        numOfPlayers = new JTextArea();
        numOfPlayers.setEditable(false);
        numOfPlayers.setBounds(320, 240, 38, 27);
        teamStatsPanel.add(numOfPlayers);
        
        txtrFormationGrap = new JTextArea();
        txtrFormationGrap.setEditable(false);
        txtrFormationGrap.setText("Formation Graph");
        txtrFormationGrap.setBounds(6, 38, 352, 132);
        teamStatsPanel.add(txtrFormationGrap);
        
        teamNameTA = new JTextArea();
        teamNameTA.setText("Team Name:");
        teamNameTA.setFont(new Font(FONT, Font.PLAIN, 16));
        teamNameTA.setBounds(120, 6, 238, 27);
        teamStatsPanel.add(teamNameTA);
        
        txtTeamStatistics = new JTextField();
        txtTeamStatistics.setBounds(382, 258, 364, 26);
        txtTeamStatistics.setEditable(false);
        txtTeamStatistics.setText("Team Information");
        txtTeamStatistics.setHorizontalAlignment(SwingConstants.CENTER);
        txtTeamStatistics.setColumns(10);
        frame.add(txtTeamStatistics);
        
        quitDraftButton = new JButton("Quit Draft");
        quitDraftButton.setBounds(6, 529, 364, 49);
        quitDraftButton.setFont(new Font(FONT, Font.PLAIN, 34));
        frame.add(quitDraftButton);
        
        saveButton = new JButton("Save");
        saveButton.setBounds(382, 526, 366, 54);
        saveButton.addActionListener(element -> {
                model.setTeamName(teamNameTA.getText());
                model.setTeamFormation(formationComboBox.getSelectedItem().toString());
            });
        saveButton.setForeground(Color.BLACK);
        saveButton.setFont(new Font(FONT, Font.PLAIN, 34));
        saveButton.setBackground(Color.RED);
        saveButton.setEnabled(false);
        
        
        startDraftButton = new JButton("Start");
        startDraftButton.setBounds(6, 266, 366, 54);
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
        frame.setSize(800, 600);
        frame.setVisible(true);
        
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
        currentUserTeamTable.setText(model.getTeamToString());
    }
    
    public JPanel getPanel()
    {
    	return frame;
    }
}
