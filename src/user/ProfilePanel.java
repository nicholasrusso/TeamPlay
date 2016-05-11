package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public ProfilePanel(User user)
    {
        userToEdit = user;
        setLayout(new GridLayout(8,1));
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

        finish.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you wish to edit your profile?",
                                "Confirm Edit Profile", JOptionPane.YES_NO_OPTION);
                        if (ans == JOptionPane.YES_OPTION)
                        {
                            userToEdit.setFirstName(firstName.getTextInput());
                            userToEdit.setLastName(lastName.getTextInput());
                            userToEdit.setUsername(userName.getTextInput());
                            userToEdit.setEmail(email.getTextInput());

                            if (userToEdit.isValidated())
                            {
                                setVisible(false);
                            }
                        }

                    }
                }
        );

        this.add(finish);
        this.add(cancel);
    }

    private void initTextFields()
    {
        firstName = new EditorTextField("First Name", "Charlie");
        lastName = new EditorTextField("Last Name", "Gels");
        userName = new EditorTextField("User Name", "CGULS");
        email = new EditorTextField("E-Mail", "cvgels3@gmail.com");

        this.add(firstName);
        this.add(lastName);
        this.add(userName);
        this.add(email);

        pass = new EditorPasswordField("Password");
        confirm = new EditorPasswordField("Confirm Password");

        this.add(pass);
        this.add(confirm);
    }
/* %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
    /**
     * Private class that serves to encapsulate a JLabel and Text Field.
     * */
    private class EditorTextField extends JPanel
    {
        JLabel label;
        JTextField input;
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
}