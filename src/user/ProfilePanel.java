package user;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import view.MainMenuView;

public class ProfilePanel extends JPanel
{
    // give access to all users in game
    // private ProfileManager pm;
    // User being edited in this panel
    private User userToEdit;

    private JButton finish;
    private JButton cancel;
    private EditorTextField firstName;
    private EditorTextField lastName;
    private EditorTextField userName;
    private EditorTextField email;
    private EditorPasswordField pass;
    private EditorPasswordField confirm;
    private JLabel passMatch;

    public ProfilePanel(User user)
    {
        userToEdit = user;
        setLayout(new GridLayout(9,1));
        initEditButtons();
        setPreferredSize(new Dimension(640, 480));
        setVisible(true);

    }

    private void initEditButtons()
    {
        initTextFields();
        finish = new JButton("Finish");
        finish.addActionListener(null);
        finish.setVisible(true);
        cancel = new JButton("Cancel");
        cancel.addActionListener(null);
        cancel.setVisible(true);

        finish.addActionListener(new updateAndBackToMainMenuListener());
        cancel.addActionListener(new cancelAndBackToMainMenuListener());

        this.add(finish);
        this.add(cancel);
    }

    private void initTextFields()
    {	
        firstName = new EditorTextField("First Name", userToEdit.getFirstName());
        lastName = new EditorTextField("Last Name", userToEdit.getLastName());
        userName = new EditorTextField("User Name", userToEdit.getUsername());
        userName.setEditable(false);
        email = new EditorTextField("E-Mail", userToEdit.getEmail().toString());

        this.add(firstName);
        this.add(lastName);
        this.add(userName);
        this.add(email);

        pass = new EditorPasswordField("Password");
        confirm = new EditorPasswordField("Confirm Password");
        
        passMatch = new JLabel("");
        passMatch.setHorizontalAlignment(JLabel.CENTER);
        passMatch.setForeground(Color.RED);

        this.add(pass);
        this.add(confirm);
        //label for password mismatches
        this.add(passMatch);
        passMatch.setVisible(true);
    }
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%Private Classes%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
    /**
     * Private class that serves to encapsulate a JLabel and Text Field.
     * */
    private class EditorTextField extends JPanel
    {
        JLabel label;
        JTextField input;
        //editable by default -- want to set to false for the username because its DB primary key
        boolean editable = true;
        
        /**
         * Creates a small panel with a Label and TextField for changing user profile information. 
         * TextField is editable by default, this can be changed via setEditable(bool)
         * */
        public EditorTextField(String labelText, String inputText)
        {
            label = new JLabel(labelText);
            input = new JTextField(inputText);
            setLayout(new FlowLayout());
            Dimension dim = new Dimension(200, 55);
            label.setMinimumSize(dim);
            label.setPreferredSize(dim);
            label.setMaximumSize(dim);
            dim = new Dimension(300, 55);
            input.setMinimumSize(dim);
            input.setPreferredSize(dim);
            input.setMaximumSize(dim);
            add(label);
            add(input);
            setVisible(true);
        }

        /**
         * Accessor for getting text in JTextField for validation by User class.
         * */
        public String getTextInput()
        {
            return input.getText();
        }
        
        
        /**
         * Mutator to change the TextFields state of editability. 
         * */
        public void setEditable(boolean canEdit) {
        	editable = canEdit;
        	input.setEditable(editable);
        }
    }

    /**
     * Private class that encapsulates Label and JPassword Field in a flow layout.
     * */
    private class EditorPasswordField extends JPanel
    {
        JLabel label;
        JPasswordField input;
        public EditorPasswordField(String labelText)
        {
            label = new JLabel(labelText);
            input = new JPasswordField();
            setLayout(new FlowLayout());
            Dimension dim = new Dimension(200, 55);
            label.setMinimumSize(dim);
            label.setPreferredSize(dim);
            label.setMaximumSize(dim);
            dim = new Dimension(300, 55);
            input.setMinimumSize(dim);
            input.setPreferredSize(dim);
            input.setMaximumSize(dim);
            add(label);
            add(input);
            setVisible(true);
        }

        /**
         * Accessor for getting text in JTextField for validation by User class.
         * */
        public String getPasswordInput()
        {
            return String.valueOf(input.getPassword());
        }
    }
    
    class updateAndBackToMainMenuListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        	String pw = pass.getPasswordInput();
        	if (pw.equals(confirm.getPasswordInput()))
        	{
	            int ans = JOptionPane.showConfirmDialog(null, "Are you sure you wish to edit your profile?",
	                    "Confirm Edit Profile", JOptionPane.YES_NO_OPTION);
	            if (ans == JOptionPane.YES_OPTION)
	            {   	
	                userToEdit.setFirstName(firstName.getTextInput());
	                userToEdit.setLastName(lastName.getTextInput());
	                userToEdit.setEmail(email.getTextInput());
	                userToEdit.setPasswordHashFromPassword(pw);
	                
	                //proceed with update as long as updates are valid. 
	                if (userToEdit.isValidated())
	                {
	                    userToEdit.update();  
	                }
	                //TODO get invalid field.... and return to editor
	                
                    //take to back Main menu
        			Component component = (Component) e.getSource();
                	JFrame frame = (JFrame) SwingUtilities.getRoot(component);        
                	frame.getContentPane().removeAll();
                	//TODO provide correct user reference
                	frame.getContentPane().add(new MainMenuView(userToEdit));
                    frame.getContentPane().revalidate();
                    frame.getContentPane().repaint();
	            }
        	}
            else {
            	passMatch.setText("Password and Confirm Password text fields do not match!");
            }
        }
    }
    
    class cancelAndBackToMainMenuListener implements ActionListener
    {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		Component component = (Component) e.getSource();
    		JFrame frame = (JFrame) SwingUtilities.getRoot(component);        
    		frame.getContentPane().removeAll();
    		//TODO provide correct user reference
    		frame.getContentPane().add(new MainMenuView(userToEdit));
    		frame.getContentPane().revalidate();
    		frame.getContentPane().repaint();    		
    	}	
    }
}