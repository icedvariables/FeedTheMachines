package newgame.states;

import asciiPanel.AsciiPanel;
import newgame.input.RespondsToInput;

public interface State extends RespondsToInput {
	public void update();							// Called repeatedly in main loop.
	public void display(AsciiPanel term);			// Display to the terminal window.
}
