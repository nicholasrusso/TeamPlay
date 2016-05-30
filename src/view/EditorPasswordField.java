package view;

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