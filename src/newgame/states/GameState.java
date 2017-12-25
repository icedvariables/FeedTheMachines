package newgame.states;

import java.awt.Color;
import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import newgame.game.Game;
import newgame.gui.GameGui;
import newgame.maps.GameMap;

public class GameState implements State {
	public static final Color BORDER_COLOUR = Color.GREEN;
	public static final Color TITLE_COLOUR = Color.WHITE;
	private GameMap map;
	private GameGui gui;

	public GameState() {
		map = new GameMap(30, 30);
		gui = new GameGui(Color.BLUE, Color.WHITE, Game.WIDTH, Game.HEIGHT);
	}

	@Override
	public void update() {
	}

	@Override
	public void display(AsciiPanel term) {
		map.drawCable(term);
		gui.draw(term);
	}

	@Override
	public State respondToInput(KeyEvent key) {
		System.out.println(key.getKeyChar());
		return this;
	}
}
