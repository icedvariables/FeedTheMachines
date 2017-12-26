package newgame.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import asciiPanel.AsciiPanel;
import newgame.game.Drawable;
import newgame.game.Game;
import newgame.game.Updatable;
import newgame.gui.components.Component;

public class GameGui implements Drawable, Updatable {
	private GuiWindow inventoryWindow;
	private GuiWindow viewWindow;
	private GuiWindow inspectWindow;

	public GameGui(Color borderColour, Color titleColour, int width, int height) {
		inventoryWindow = new GuiWindow(new ArrayList<Component>(), "Inventory", borderColour, Color.RED, 0, 5, Game.WIDTH / 5, Game.HEIGHT - 6);
		viewWindow = new GuiWindow(Arrays.asList(new Component("Standard", 2, 1), new Component("Cables", 2, 2)), "View", borderColour, titleColour, 0, 0, Game.WIDTH / 5, 4);
		inspectWindow = new GuiWindow(new ArrayList<Component>(), "Inspect", borderColour, titleColour, Game.WIDTH - (Game.WIDTH / 5) - 1, 0, Game.WIDTH / 5, Game.HEIGHT / 2);
	}

	@Override
	public void draw(AsciiPanel term) {
		viewWindow.draw(term);
		inventoryWindow.draw(term);
		inspectWindow.draw(term);
	}

	@Override
	public void update() {
		inventoryWindow.update();
		viewWindow.update();
		inspectWindow.update();
	}
}
