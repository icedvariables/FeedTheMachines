package newgame.gui;

import java.awt.Color;
import java.util.List;

import asciiPanel.AsciiPanel;
import newgame.game.Drawable;
import newgame.game.Updatable;
import newgame.gui.components.Component;

public class GuiWindow implements Drawable, Updatable {
	private final char HORIZONTAL_CHAR = (char) 196;
	private final char VERTICAL_CHAR = (char) 179;
	private final char TOPLEFT_CHAR = (char) 218;
	private final char TOPRIGHT_CHAR = (char) 191;
	private final char BOTTOMLEFT_CHAR = (char) 192;
	private final char BOTTOMRIGHT_CHAR = (char) 217;

	private List<Component> components;
	private String title;
	private Color borderColour;
	private Color titleColour;
	private int x, y;
	private int width, height;

	public GuiWindow(List<Component> components, String title, Color borderColour, Color titleColour, int x, int y, int width, int height) {
		this.components = components;
		this.title = title;
		this.borderColour = borderColour;
		this.titleColour = titleColour;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(AsciiPanel term) {
		// Top line:
		term.write(TOPLEFT_CHAR, x, y, borderColour);
		term.write(TOPRIGHT_CHAR, x + width, y, borderColour);
		for(int across = 1; across < width; across++) {
			term.write(HORIZONTAL_CHAR, x + across, y, borderColour);
		}

		// Lines on each side:
		for(int row = 1; row < height; row++) {
			term.write(VERTICAL_CHAR, x, y + row, borderColour);
			term.write(VERTICAL_CHAR, x + width, y + row, borderColour);
		}

		// Bottom line:
		term.write(BOTTOMLEFT_CHAR, x, y + height, borderColour);
		term.write(BOTTOMRIGHT_CHAR, x + width, y + height, borderColour);
		for(int across = 1; across < width; across++) {
			term.write(HORIZONTAL_CHAR, x + across, y + height, borderColour);
		}

		// Remove the centre area:
		term.clear(' ', x + 1, y + 1, width - 1, height - 1);

		// Draw components:
		for(Component component : components) {
			component.drawWithinGui(term, x, y);
		}

		// Draw title:
		term.write(title, x + 2, y, titleColour);
	}

	@Override
	public void update() {
	}
}
