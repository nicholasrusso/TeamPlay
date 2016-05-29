package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * Class that encapsulates Label and JPassword Field in a flow layout.
 * */
public class EditorPasswordField extends JPanel
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