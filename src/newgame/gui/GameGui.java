package newgame.gui;

import java.awt.Color;
import java.util.Arrays;

import asciiPanel.AsciiPanel;
import newgame.game.Drawable;
import newgame.game.Game;
import newgame.gui.components.Component;

public class GameGui implements Drawable {
	private GuiWindow inventoryWindow;
	private GuiWindow viewsWindow;

	public GameGui(Color borderColour, Color titleColour, int width, int height) {
		inventoryWindow = new GuiWindow(Arrays.asList(new Component("Test", 2, 2)), "Inventory", borderColour, titleColour, 0, 5, Game.WIDTH / 5, Game.HEIGHT - 6);
		viewsWindow = new GuiWindow(Arrays.asList(new Component("Test", 2, 1)), "Views", borderColour, titleColour, 0, 0, Game.WIDTH / 5, 4);
	}

	@Override
	public void draw(AsciiPanel term) {
		viewsWindow.draw(term);
		inventoryWindow.draw(term);
	}
}
