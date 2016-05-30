package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class EditorField extends JPanel
{
	protected JLabel label = null;
	protected JTextField input = null;
	
	public EditorField(String text, JTextField inputField)
	{
		label = new JLabel(text);
		this.input = inputField;
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
     * Accessor for getting text in JPasswordField for validation by User class.
     * */
    public String getLabelText()
    {
        return label.getText();
    }
    
    /**
     * Mutator for setting text in JPasswordField for validation by User class. - Testing only
     * */
    public void setInputText(String pw)
    {
    	input.setText(pw);
    }
    
    /**
     * Accessor for getting text in JTextField for validation by User class.
     * */
    public String getTextInput()
    {
        return input.getText();
    }
	
}
