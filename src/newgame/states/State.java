package newgame.states;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public interface State {
	public void update();							// Called repeatedly in main loop.
	public void display(AsciiPanel term);			// Display to the terminal window.
	public State respondToKeyPress(KeyEvent key);	// Allow the state to respond to a key press. Should return the next state to be displayed.
	public State respondToMouseClick(int clickX, int clickY);
	public State respondToMouseMove(int mouseX, int mouseY);
}
