package newgame.maps;

import java.awt.Color;

public class Tile {
	// Background glyphs that cannot be moved or interacted with that much.
	// Make up the lowest layer of a map.
	// Entities can exist atop tiles.

	private char glyph;
	private Color colour;

	public Tile(char glyph, Color colour) {
		this.glyph = glyph;
		this.colour = colour;
	}

	public char getGlyph() {
		return glyph;
	}
	public Color getColour() {
		return colour;
	}
}
