package newgame.maps;

import java.awt.Color;

public enum ColourCategory {
	RED	(Color.RED),
	GREEN (Color.GREEN),
	BLUE (Color.BLUE);

	private Color colour;

	ColourCategory(Color colour) {
		this.colour = colour;
	}

	public Color getColour() {
		return colour;
	}
}
