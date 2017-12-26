package newgame.input;

import java.awt.event.KeyEvent;

import newgame.states.State;

public interface RespondsToInput {
	public State respondToKeyPress(KeyEvent key);
	public State respondToMouseClick(int clickX, int clickY);
	public State respondToMouseMove(int mouseX, int mouseY);
}
