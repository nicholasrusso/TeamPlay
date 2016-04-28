
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.gui2.dialogs.*;
import com.googlecode.lanterna.gui2.*;

import java.util.regex.Pattern;
import java.io.IOException;


/**
 * Creates a TerminalScreen and a TextGraphics from it and writes a reg screen
 * @author Michael Haskell
 *
 */
public class DrawRectangle {

	public static void main(String[] args) throws IOException {
		Terminal terminal = new DefaultTerminalFactory().createTerminal();
		Screen screen = new TerminalScreen(terminal);

		TextGraphics tGraphics = screen.newTextGraphics();
		screen.startScreen();
    final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);

    try {
      final BasicWindow window = new BasicWindow("User Registration");
			Panel mainPanel = new Panel();
			screen.clear();

      /*
			String regText = "User Registration";
			tGraphics.putString(10, 3, regText);
			tGraphics.drawRectangle(
				new TerminalPosition(2,2), new TerminalSize(32,3), '*');
			screen.refresh(); 
      */
        mainPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

        mainPanel.addComponent(new TextBox(new TerminalSize(30, 1), "").withBorder(Borders.singleLine("Username:")));
        mainPanel.addComponent(new TextBox(new TerminalSize(30, 1), "").withBorder(Borders.singleLine("First Name:")));
        mainPanel.addComponent(new TextBox(new TerminalSize(30, 1), "").withBorder(Borders.singleLine("Last Name:")));
        mainPanel.addComponent(new TextBox(new TerminalSize(30, 1), "").withBorder(Borders.singleLine("Email")));
        TextBox passwordField = new TextBox(new TerminalSize(30, 1), "");
        passwordField.withBorder(Borders.singleLine("Password"));
        passwordField.setMask('*');
        mainPanel.addComponent(passwordField);

        //mainPanel.addComponent(new TextBox(new TerminalSize(30, 1), "").setMask('*').withBorder(Borders.singleLine("Password")));

				mainPanel.addComponent(new EmptySpace(TerminalSize.ONE));
				mainPanel.addComponent(new Button("Exit", new Runnable() {
						@Override
						public void run() {
								window.close();
						}
				}));

			window.setComponent(mainPanel);
			textGUI.addWindowAndWait(window);

    } finally {
      screen.stopScreen();
    }

	}

}
