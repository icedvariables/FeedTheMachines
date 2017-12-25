package newgame.gui.components;

import asciiPanel.AsciiPanel;

public class Component {
	private String text;
	private int x, y; // Position inside a gui window (does not include borders).

	public Component(String text, int x, int y) {
		this.text = text;
		this.x = x;
		this.y = y;
	}

	// Draw the component at its x and y within its parent guiWindow.
	public void drawWithinGui(AsciiPanel term, int guiX, int guiY) {
		term.write(text, x + guiX, y + guiY);
	}
}
