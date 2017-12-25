package newgame.entities;

import java.awt.Color;

public class Entity {
	// Can exist atop of tiles.
	// Can be moved.

	private int x, y;
	private char glyph;
	private Color colour;

	public Entity(int x, int y, char glyph, Color colour) {
		this.x = x;
		this.y = y;
		this.glyph = glyph;
		this.colour = colour;
	}
}
