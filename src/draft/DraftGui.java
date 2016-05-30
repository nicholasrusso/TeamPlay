package draft;

import java.util.*;
import java.util.Timer;

import javax.swing.*;

import soccerPlayer.Defender;
import soccerPlayer.Forward;
import soccerPlayer.Midfielder;
import soccerPlayer.SoccerPlayer;
import teams.Team;
import tournament.Tournament;
import user.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DraftGui implements Observer
{
    private static JFrame frame;
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
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        model.addObserver(this);
        
        
        userNameTA = new JTextArea();
        userNameTA.setFont(new Font(FONT, Font.PLAIN, 24));
        userNameTA.setWrapStyleWord(true);
        userNameTA.setEditable(false);
        userNameTA.setLineWrap(true);
        userNameTA.setBounds(440, 6, 265, 32);
        frame.getContentPane().add(userNameTA);
        
        playerSelectionPanel = new JPanel();
        playerSelectionPanel.setBounds(31, 87, 364, 244);
        frame.getContentPane().add(playerSelectionPanel);
        playerSelectionPanel.setLayout(null);
        
        
        btnPlayer1 = new JButton("");
        btnPlayer2 = new JButton("");
        btnPlayer3 = new JButton("");
        
        
        btnPlayer1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                model.nextUser(0);
                
            }
        });
        btnPlayer1.setBounds(6, 209, 117, 29);
        playerSelectionPanel.add(btnPlayer1);
        
        btnPlayer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.nextUser(1);
            }
        });
        btnPlayer2.setBounds(122, 209, 117, 29);
        playerSelectionPanel.add(btnPlayer2);
        
        btnPlayer3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
  
                model.nextUser(2);
                
            }
        });
        btnPlayer3.setBounds(241, 209, 117, 29);
        playerSelectionPanel.add(btnPlayer3);
        
 
        
        player1Name = new JTextField();
        player1Name.setText("");
        player1Name.setHorizontalAlignment(SwingConstants.CENTER);
        player1Name.setColumns(10);
        player1Name.setBounds(6, 28, 117, 29);
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
        userNameInfoTA.setFont(new Font(FONT, Font.PLAIN, 24));
        userNameInfoTA.setBounds(264, 6, 164, 32);
        frame.getContentPane().add(userNameInfoTA);
        userNameInfoTA.setEditable(false);
        userNameInfoTA.setBackground(Color.WHITE);
        userNameInfoTA.setText("Current User:");
        
        timerPanel = new JPanel();
        timerPanel.setBounds(440, 87, 364, 244);
        frame.getContentPane().add(timerPanel);
        timerPanel.setLayout(null);
        
        timerTxt = new JTextField();
        timerTxt.setEditable(false);
        timerTxt.setFont(new Font(FONT, Font.BOLD, 35));
        timerTxt.setText("STARTING DRAFT!");
        timerTxt.setHorizontalAlignment(SwingConstants.CENTER);
        timerTxt.setColumns(10);
        timerTxt.setBounds(6, 6, 352, 228);
        timerPanel.add(timerTxt);
        
        txtTimeRemaining = new JTextField();
        txtTimeRemaining.setEditable(false);
        txtTimeRemaining.setHorizontalAlignment(SwingConstants.CENTER);
        txtTimeRemaining.setText("Time Remaining");
        txtTimeRemaining.setBounds(440, 58, 364, 26);
        frame.getContentPane().add(txtTimeRemaining);
        txtTimeRemaining.setColumns(10);
        
        txtPlayerSelection = new JTextField();
        txtPlayerSelection.setEditable(false);
        txtPlayerSelection.setBounds(31, 58, 364, 26);
        frame.getContentPane().add(txtPlayerSelection);
        txtPlayerSelection.setText("Player Selection");
        txtPlayerSelection.setHorizontalAlignment(SwingConstants.CENTER);
        txtPlayerSelection.setColumns(10);
        
        currentUserTeamPanel = new JPanel();
        currentUserTeamPanel.setBounds(31, 419, 364, 226);
        frame.getContentPane().add(currentUserTeamPanel);
        currentUserTeamPanel.setLayout(null);
        
        currentUserTeamTable = new JTextArea();
        currentUserTeamTable.setBounds(6, 6, 352, 214);
        currentUserTeamPanel.add(currentUserTeamTable);
        
        txtCurrentTeam = new JTextField();
        txtCurrentTeam.setEditable(false);
        txtCurrentTeam.setText("Current Team");
        txtCurrentTeam.setHorizontalAlignment(SwingConstants.CENTER);
        txtCurrentTeam.setColumns(10);
        txtCurrentTeam.setBounds(31, 390, 364, 26);
        frame.getContentPane().add(txtCurrentTeam);
        
        teamStatsPanel = new JPanel();
        teamStatsPanel.setBounds(440, 372, 364, 273);
        frame.getContentPane().add(teamStatsPanel);
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
        txtrNumberOfPlayers.setBounds(206, 240, 102, 27);
        teamStatsPanel.add(txtrNumberOfPlayers);
        
        txtrFormation = new JTextArea();
        txtrFormation.setEditable(false);
        txtrFormation.setText("Formation:");
        txtrFormation.setFont(new Font(FONT, Font.PLAIN, 16));
        txtrFormation.setBounds(6, 240, 95, 27);
        teamStatsPanel.add(txtrFormation);
        
        formationComboBox = new JComboBox<String>();
        formationComboBox.setBounds(102, 239, 102, 27);
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
        txtrFormationGrap.setBounds(6, 38, 352, 193);
        teamStatsPanel.add(txtrFormationGrap);
        
        teamNameTA = new JTextArea();
        teamNameTA.setText("Team Name:");
        teamNameTA.setFont(new Font(FONT, Font.PLAIN, 16));
        teamNameTA.setBounds(120, 6, 238, 27);
        teamStatsPanel.add(teamNameTA);
        
        txtTeamStatistics = new JTextField();
        txtTeamStatistics.setEditable(false);
        txtTeamStatistics.setText("Team Information");
        txtTeamStatistics.setHorizontalAlignment(SwingConstants.CENTER);
        txtTeamStatistics.setColumns(10);
        txtTeamStatistics.setBounds(440, 343, 364, 26);
        frame.getContentPane().add(txtTeamStatistics);
        
        quitDraftButton = new JButton("Quit Draft");
        quitDraftButton.setFont(new Font(FONT, Font.PLAIN, 34));
        quitDraftButton.setBounds(31, 657, 364, 49);
        frame.getContentPane().add(quitDraftButton);
        
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setTeamName(teamNameTA.getText());
                model.setTeamFormation(formationComboBox.getSelectedItem().toString());
            }
        });
        saveButton.setForeground(Color.BLACK);
        saveButton.setFont(new Font(FONT, Font.PLAIN, 34));
        saveButton.setBackground(Color.RED);
        saveButton.setBounds(438, 657, 366, 54);
        saveButton.setEnabled(false);
        
        
        startDraftButton = new JButton("Start");
        startDraftButton.setForeground(Color.BLACK);
        startDraftButton.setBackground(Color.RED);
        startDraftButton.setFont(new Font(FONT, Font.PLAIN, 34));
        startDraftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                    
                    //start timer
                    model.startTimer();
                }
                
            }
        });
        startDraftButton.setBounds(31, 333, 366, 54);
        frame.getContentPane().add(startDraftButton);
        
        
        frame.getContentPane().add(saveButton);
        frame.setSize(890, 769);
        frame.setVisible(true);
        
        System.out.println("asdfasdfasdfasdf");
    }
    
    public void init()
    {
        JPanel panel = new JPanel();
    }

    public static void main(String[] args) 
    {
//        TimerFrame timerFrame = new TimerFrame();
//        timerFrame.frame.setVisible(true);
//        timerFrame.frame.setSize(400,100);
        ArrayList<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
        players.add(new Forward("Messi", "Barcelona"));
        players.add(new Forward("Saurez", "Barcelona"));
        players.add(new Forward("Neymar", "Barcelona"));
        players.add(new Midfielder("Xavi", "Barcelona"));
        players.add(new Midfielder("Iniesta", "Barcelona"));
        players.add(new Midfielder("Rakitic", "Barcelona"));
        players.add(new Midfielder("Busquets", "Barcelona"));
        players.add(new Defender("Pique", "Barcelona"));
        players.add(new Defender("Mascherano", "Barcelona"));
        players.add(new Defender("Dani Alves", "Barcelona"));
        players.add(new Defender("Jordi Alba", "Barcelona"));
        User user1 = new User();
        user1.setFirstName("Nick");
        user1.setLastName("Russo");
        user1.setUsername("nrusso");
        User user2 = new User();
        user2.setFirstName("rick");
        user2.setLastName("nusso");
        user2.setUsername("russo");
        User user3 = new User();
        user3.setFirstName("asdf");
        user3.setLastName("asdf");
        user3.setUsername("fdas");
        Tournament tournament = new Tournament("Test Tournament", 10, players);
        tournament.addUser(user1);
        tournament.addUser(user2);
        tournament.addUser(user3);
        DraftGui gui = new DraftGui(tournament);
        
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
}
