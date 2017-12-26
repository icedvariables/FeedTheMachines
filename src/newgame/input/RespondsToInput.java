package newgame.input;

import java.awt.event.KeyEvent;

public interface RespondsToInput {
	public void respondToKeyPress(KeyEvent key);
	public void respondToMouseClick(int clickX, int clickY);
	public void respondToMouseMove(int mouseX, int mouseY);
}
