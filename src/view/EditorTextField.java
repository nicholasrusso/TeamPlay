package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Private class that serves to encapsulate a JLabel and Text Field.
 * */
public class EditorTextField extends EditorField
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
    	super(labelText, new JTextField(inputText));
    }
    
    /**
     * Mutator to change the TextFields state of editability. 
     * */
    public void setEditable(boolean canEdit) {
    	editable = canEdit;
    	input.setEditable(editable);
    }
}

