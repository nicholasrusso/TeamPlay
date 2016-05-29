package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Private class that serves to encapsulate a JLabel and Text Field.
 * */
public class EditorTextField extends JPanel
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
    
    /**
     * Accessor for getting label text in JTextField for validation by User class.
     * */
    public String getLabelText()
    {
        return label.getText();
    }
}

