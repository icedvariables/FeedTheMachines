package newgame.game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import asciiPanel.AsciiPanel;
import newgame.states.GameState;
import newgame.states.StateManager;

public class Game  extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
	public static final int WIDTH = 132;
	public static final int HEIGHT = 43;

	public static final int FPS = 20;
	public static final float TIME_BETWEEN_FRAMES = 1_000_000_000 / FPS;

	private AsciiPanel terminal;

	private boolean running = true;

	private double lastTime = System.nanoTime();

	public Game() {
		super();
		terminal = new AsciiPanel(WIDTH, HEIGHT);
		terminal.setDefaultForegroundColor(Color.WHITE);
		getContentPane().add(terminal);
		pack();

		addKeyListener(this);
		getContentPane().addMouseListener(this);		// Adding to the content pane instead of the JFrame ensures the mouse coords do not include the title bar of the window.
		getContentPane().addMouseMotionListener(this);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		StateManager.runState(new GameState());

		loop();
	}

	public void loop() {
		while(running) {
			double currentTime = System.nanoTime();

			//System.out.println("Current: " + currentTime + " Last: " + lastTime);

			if((currentTime - lastTime) >= TIME_BETWEEN_FRAMES) {
				System.out.println((currentTime - lastTime));
				update();
				repaint();
				lastTime = System.nanoTime();
			}
		}
	}

	public void update() {
		StateManager.getCurrentState().update();
	}

	@Override
	public void repaint() {
		// Clears the terminal window, allows the current state to draw and then repaints.

		terminal.clear();
		StateManager.getCurrentState().draw(terminal);
		super.repaint();
	}

	private int[] getMouseCharPos(int mouseX, int mouseY) {
		// This takes the mouse's position in pixels and find its position in terms of characters in the terminal.

		int width = terminal.getCharWidth();
		int height = terminal.getCharHeight();

		int charX = (int) Math.floor(mouseX / width);
		int charY = (int) Math.floor(mouseY / height);

		return new int[] {charX, charY};
	}

	// INPUT LISTENERS

	@Override
	public void mouseClicked(MouseEvent e) {
		// When the mouse is clicked, the current state is given the coordinates of the click in characters (not pixels).

		// TODO: Potentially add a Coordinate class instead of integer arrays?
		int[] charPos = getMouseCharPos(e.getX(), e.getY());
		int charX = charPos[0];
		int charY = charPos[1];

		StateManager.getCurrentState().respondToMouseClick(charX, charY);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Allows the current state to respond to input and (if required) return a new state to become the current state.
		StateManager.getCurrentState().respondToKeyPress(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int[] charPos = getMouseCharPos(e.getX(), e.getY());
		int charX = charPos[0];
		int charY = charPos[1];

		StateManager.getCurrentState().respondToMouseMove(charX,  charY);
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
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	public static void main(String[] args) {
		Game app = new Game();
	}
}
