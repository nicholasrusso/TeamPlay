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

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Savepoint;
import java.awt.event.ActionEvent;

public class DraftGui implements Observer
{
    public static JFrame frame;
    private JTextField txtTimeRemaining;
    private JTextField txtPlayerSelection;
    private JTextField txtCurrentTeam;
    private JTextField txtTeamStatistics;
    private JTextField txtTimeRemaining_1;
    private JTextField player1Name;
    private JTextField player2Name;
    private JTextField player3Name;
    private JTable currentUserTeamTable;
    private JButton quitDraftButton;
    private JButton startDraftButton;
    private Tournament tournament;
    private SoccerPlayer selectedPlayer;
    private SoccerPlayer[] players;
    private JTextArea txtrTeamName;
    private JTextArea txtrNumberOfPlayers;
    private JTextArea txtrFormation;
    private Timer clock;
    private User currentUser;

    /**
     * @wbp.parser.entryPoint
     */
    public DraftGui(Tournament tournament)
    {
        DraftModel model = new DraftModel(tournament);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        currentUser = model.getCurrentUser();
        
        
        JTextArea userNameTA = new JTextArea();
        userNameTA.setText(currentUser.getFirstName() + " " + currentUser.getLastName());
        userNameTA.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
        userNameTA.setWrapStyleWord(true);
        userNameTA.setEditable(false);
        userNameTA.setLineWrap(true);
        userNameTA.setBounds(440, 6, 265, 32);
        frame.getContentPane().add(userNameTA);
        
        JPanel playerSelectionPanel = new JPanel();
        playerSelectionPanel.setBounds(31, 87, 364, 244);
        frame.getContentPane().add(playerSelectionPanel);
        playerSelectionPanel.setLayout(null);
        
        //players = model.getThreeRandomSoccerPlayers();
        
        JButton btnPlayer1 = new JButton("");
        JButton btnPlayer2 = new JButton("");
        JButton btnPlayer3 = new JButton("");
        
        
        btnPlayer1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnPlayer1.setEnabled(false);
                btnPlayer2.setEnabled(false);
                btnPlayer3.setEnabled(false);
                Team currentUserTeam = currentUser.getTeam(tournament.getName());
                currentUserTeam.addPlayer(players[0]);
                currentUser.setTeam(tournament.getName(), currentUserTeam);
                //todo pop up
                model.nextUser();
                currentUser = model.getCurrentUser();
                User cur = model.getCurrentUser();
                userNameTA.setText(cur.getFirstName() + " " + cur.getLastName());
                txtTimeRemaining_1.setText("STARTING DRAFT");
                btnPlayer1.setText("");
                btnPlayer2.setText("");
                btnPlayer3.setText("");
                player1Name.setText("");
                player2Name.setText("");
                player3Name.setText("");
                clock.cancel();
                
            }
        });
        btnPlayer1.setBounds(6, 209, 117, 29);
        playerSelectionPanel.add(btnPlayer1);
        
        btnPlayer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnPlayer1.setEnabled(false);
                btnPlayer2.setEnabled(false);
                btnPlayer3.setEnabled(false);
                Team currentUserTeam = currentUser.getTeam(tournament.getName());
                currentUserTeam.addPlayer(players[1]);
                currentUser.setTeam(tournament.getName(), currentUserTeam);
                //txtTimeRemaining_1.setText("You selected: " + players[2].getName());
                model.nextUser();
                currentUser = model.getCurrentUser();
                User cur = model.getCurrentUser();
                userNameTA.setText(cur.getFirstName() + " " + cur.getLastName());
                txtTimeRemaining_1.setText("STARTING DRAFT");
                btnPlayer1.setText("");
                btnPlayer2.setText("");
                btnPlayer3.setText("");
                player1Name.setText("");
                player2Name.setText("");
                player3Name.setText("");
                clock.cancel();
            }
        });
        btnPlayer2.setBounds(122, 209, 117, 29);
        playerSelectionPanel.add(btnPlayer2);
        
        btnPlayer3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnPlayer1.setEnabled(false);
                btnPlayer2.setEnabled(false);
                btnPlayer3.setEnabled(false);
                Team currentUserTeam = currentUser.getTeam(tournament.getName());
                
                System.out.println("Length: " + players.length);
                System.out.println("Length: " + players[2].getName());
                System.out.println("Is null" + players[2]);
                System.out.println("Is null" + (players[2] == null));
                System.out.println("Team Is null" + (currentUserTeam == null));
                
                currentUserTeam.addPlayer(players[2]);
                currentUser.setTeam(tournament.getName(), currentUserTeam);
                //txtTimeRemaining_1.setText("You selected: " + players[2].getName());
                
                model.nextUser();
                currentUser = model.getCurrentUser();
                User cur = model.getCurrentUser();
                userNameTA.setText(cur.getFirstName() + " " + cur.getLastName());
                txtTimeRemaining_1.setText("STARTING DRAFT");
                btnPlayer1.setText("");
                btnPlayer2.setText("");
                btnPlayer3.setText("");
                player1Name.setText("");
                player2Name.setText("");
                player3Name.setText("");
                clock.cancel();
                
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
        
        JTextArea userNameInfoTA = new JTextArea();
        userNameInfoTA.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
        userNameInfoTA.setBounds(264, 6, 164, 32);
        frame.getContentPane().add(userNameInfoTA);
        userNameInfoTA.setEditable(false);
        userNameInfoTA.setBackground(Color.WHITE);
        userNameInfoTA.setText("Current User:");
        
        JPanel timerPanel = new JPanel();
        timerPanel.setBounds(440, 87, 364, 244);
        frame.getContentPane().add(timerPanel);
        timerPanel.setLayout(null);
        
        txtTimeRemaining_1 = new JTextField();
        txtTimeRemaining_1.setEditable(false);
        txtTimeRemaining_1.setFont(new Font("Lucida Grande", Font.BOLD, 35));
        txtTimeRemaining_1.setText("STARTING DRAFT!");
        txtTimeRemaining_1.setHorizontalAlignment(SwingConstants.CENTER);
        txtTimeRemaining_1.setColumns(10);
        txtTimeRemaining_1.setBounds(6, 6, 352, 228);
        timerPanel.add(txtTimeRemaining_1);
        
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
        
        JPanel currentUserTeamPanel = new JPanel();
        currentUserTeamPanel.setBounds(31, 419, 364, 226);
        frame.getContentPane().add(currentUserTeamPanel);
        currentUserTeamPanel.setLayout(null);
        
        currentUserTeamTable = new JTable();
        currentUserTeamTable.setBounds(6, 6, 352, 214);
        currentUserTeamPanel.add(currentUserTeamTable);
        
        txtCurrentTeam = new JTextField();
        txtCurrentTeam.setEditable(false);
        txtCurrentTeam.setText("Current Team");
        txtCurrentTeam.setHorizontalAlignment(SwingConstants.CENTER);
        txtCurrentTeam.setColumns(10);
        txtCurrentTeam.setBounds(31, 390, 364, 26);
        frame.getContentPane().add(txtCurrentTeam);
        
        JPanel teamStatsPanel = new JPanel();
        teamStatsPanel.setBounds(440, 372, 364, 273);
        frame.getContentPane().add(teamStatsPanel);
        teamStatsPanel.setLayout(null);
        
        txtrTeamName = new JTextArea();
        txtrTeamName.setEditable(false);
        txtrTeamName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        txtrTeamName.setText("Team Name:");
        txtrTeamName.setBounds(6, 6, 102, 27);
        teamStatsPanel.add(txtrTeamName);
        
        txtrNumberOfPlayers = new JTextArea();
        txtrNumberOfPlayers.setEditable(false);
        txtrNumberOfPlayers.setText("# of Players:");
        txtrNumberOfPlayers.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        txtrNumberOfPlayers.setBounds(206, 240, 102, 27);
        teamStatsPanel.add(txtrNumberOfPlayers);
        
        txtrFormation = new JTextArea();
        txtrFormation.setEditable(false);
        txtrFormation.setText("Formation:");
        txtrFormation.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        txtrFormation.setBounds(6, 240, 95, 27);
        teamStatsPanel.add(txtrFormation);
        
        JComboBox formationComboBox = new JComboBox();
        formationComboBox.setBounds(102, 239, 102, 27);
        teamStatsPanel.add(formationComboBox);
        formationComboBox.addItem("4-3-3");
        formationComboBox.addItem("4-5-1");
        formationComboBox.addItem("4-4-2");
        
        JTextArea numOfPlayers = new JTextArea();
        numOfPlayers.setEditable(false);
        numOfPlayers.setBounds(320, 240, 38, 27);
        teamStatsPanel.add(numOfPlayers);
        
        JTextArea txtrFormationGrap = new JTextArea();
        txtrFormationGrap.setEditable(false);
        txtrFormationGrap.setText("Formation Graph");
        txtrFormationGrap.setBounds(6, 38, 352, 193);
        teamStatsPanel.add(txtrFormationGrap);
        
        JTextArea teamNameTA = new JTextArea();
        teamNameTA.setText("Team Name:");
        teamNameTA.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
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
        quitDraftButton.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
        quitDraftButton.setBounds(31, 657, 364, 49);
        frame.getContentPane().add(quitDraftButton);
        
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Team team = currentUser.getTeam(tournament.getName());
                team.setName(teamNameTA.getText());
                team.setFormation(formationComboBox.getSelectedItem().toString());
            }
        });
        saveButton.setForeground(Color.BLACK);
        saveButton.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
        saveButton.setBackground(Color.RED);
        saveButton.setBounds(438, 657, 366, 54);
        saveButton.setEnabled(false);
        
        
        startDraftButton = new JButton("Start");
        startDraftButton.setForeground(Color.BLACK);
        startDraftButton.setBackground(Color.RED);
        startDraftButton.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
        startDraftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                btnPlayer1.setEnabled(true);
                btnPlayer2.setEnabled(true);
                btnPlayer3.setEnabled(true);
                players = model.getThreeRandomSoccerPlayers();
                btnPlayer1.setText(players[0].getName());
                btnPlayer2.setText(players[1].getName());
                btnPlayer3.setText(players[2].getName());
                player1Name.setText(players[0].getName());
                player2Name.setText(players[1].getName());
                player3Name.setText(players[2].getName());
                if (currentUser.getTeam(tournament.getName()) == null)
                {
                    String name = JOptionPane.showInputDialog(frame,
                            "What is your team name?",  JOptionPane.OK_CANCEL_OPTION);
                    Team team = new Team(name);
                currentUser.setTeam(tournament.getName(), team);
                numOfPlayers.setText(team.getSize() + "");
                formationComboBox.setSelectedItem(team.getFormation());
                saveButton.setEnabled(true);
                teamNameTA.setText(name);
                formationComboBox.setSelectedItem(team.getFormation());
                numOfPlayers.setText("0");
                    
                }
                else
                {
                    teamNameTA.setText(currentUser.getTeam(tournament.getName()).getName());
                formationComboBox.setSelectedItem(currentUser.getTeam(tournament.getName()).getFormation());
                numOfPlayers.setText(currentUser.getTeam(tournament.getName()).getSize() + "");
                }
                
                clock = new Timer();
                clock.schedule(new TimerTask(){

                    int second = 60;
                    @Override
                    public void run() {
                        txtTimeRemaining_1.setText(second-- + " seconds.");
                    }   
                },0, 1000);
                
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
        // TODO Auto-generated method stub
        
    }
}
