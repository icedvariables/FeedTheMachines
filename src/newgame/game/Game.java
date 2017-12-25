package newgame.game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import asciiPanel.AsciiPanel;
import newgame.states.GameState;
import newgame.states.State;

public class Game  extends JFrame implements KeyListener, MouseListener {
	public static final int WIDTH = 132;
	public static final int HEIGHT = 43;

	private AsciiPanel terminal;
	private State currentState;

	public Game() {
		super();
		terminal = new AsciiPanel(WIDTH, HEIGHT);
		terminal.setDefaultForegroundColor(Color.WHITE);
		add(terminal);
		pack();

		addKeyListener(this);
		addMouseListener(this);

		currentState = new GameState();

		repaint();
	}

	@Override
	public void repaint() {
		// Clears the terminal window, allows the current state to draw and then repaints.

		terminal.clear();
		currentState.display(terminal);
		super.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Allows the current state to respond to input and (if required) return a new state to become the current state.
		currentState = currentState.respondToInput(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		Game app = new Game();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
