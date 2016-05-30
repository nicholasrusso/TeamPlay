package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import view.EditorPasswordField;

/**
 * Test Type: Unit Test
 * Author: Charlie Gels
 */
public class TestEditorPasswordField {
    
    @Test
    public void testGetPasswordInput() throws Exception
    {
        EditorPasswordField test = new EditorPasswordField("Test");
        String txt = "password";
        test.setInputText(txt);
        
        assertTrue(txt.equals(test.getTextInput()));
    }

    @Test
    public void testGetLabelText()
    {
        String txt = "Test";
        EditorPasswordField test = new EditorPasswordField(txt);
        
        assertTrue(txt.equals(test.getLabelText()));
    }
}
