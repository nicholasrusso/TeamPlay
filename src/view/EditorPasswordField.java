package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * Class that encapsulates Label and JPassword Field in a flow layout.
 * */
public class EditorPasswordField extends EditorField
{

    public EditorPasswordField(String labelText)
    {
        super(labelText, new JPasswordField());
    }

    /**
     * Accessor for getting text in JPasswordField for validation by User class.
     * */
    @Override
    public String getTextInput()
    {
        return String.valueOf( ((JPasswordField) input).getPassword());
    }
   
}