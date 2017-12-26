package newgame.states;

import java.awt.Color;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import newgame.game.Game;
import newgame.gui.GameGui;
import newgame.maps.GameMap;
import newgame.maps.MapDrawer;

public class GameState implements State {
	public static final Color BORDER_COLOUR = Color.GREEN;
	public static final Color TITLE_COLOUR = Color.WHITE;
	private GameMap map;
	private MapDrawer mapDrawer;
	private GameGui gui;

	public GameState() {
		map = new GameMap(30, 30);
		mapDrawer = new MapDrawer(map);
		gui = new GameGui(Color.BLUE, Color.WHITE, Game.WIDTH, Game.HEIGHT);
	}

	@Override
	public void update() {
		gui.update();
	}

	@Override
	public void draw(AsciiPanel term) {
		mapDrawer.drawCables(term);
		gui.draw(term);
	}

	@Override
	public void respondToKeyPress(KeyEvent key) {
		System.out.println(key.getKeyChar());
		mapDrawer.scroll(1, 0);
	}

	@Override
	public void respondToMouseClick(int clickX, int clickY) {
		System.out.println("Click: " + clickX + ", " + clickY);
	}

	@Override
	public void respondToMouseMove(int mouseX, int mouseY) {
		System.out.println("Move: " + mouseX + ", " + mouseY);
	}
}
