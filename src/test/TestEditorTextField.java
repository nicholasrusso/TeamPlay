package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import view.EditorTextField;

/**
 * Test Type: Unit Test
 * Author: Charlie Gels
 */
public class TestEditorTextField {
	
	@Test
    public void testGetTextInput() throws Exception
    {
		String txt = "Input";
		EditorTextField test = new EditorTextField("Label", txt);
		
        assertTrue(txt.equals(test.getTextInput()));
    }
	
	@Test
    public void testGetLabelText() throws Exception
    {
		String txt = "Label";
		EditorTextField test = new EditorTextField(txt, "Input");
		
        assertTrue(txt.equals(test.getLabelText()));
    }

}

