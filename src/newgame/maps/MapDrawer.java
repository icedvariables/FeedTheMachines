package newgame.maps;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class MapDrawer {
	private GameMap map;

	private int scrollX = 0;
	private int scrollY = 0;

	public MapDrawer(GameMap map) {
		this.map = map;
	}

	public void drawTiles(AsciiPanel term) {
		for(int x = 0; x < map.getWidth(); x++) {
			for(int y = 0; y < map.getHeight(); y++) {
				Tile tile = map.getTileAt(x, y);

				if(tile != null)
					term.write(tile.getGlyph(), mapToScreenX(x), mapToScreenY(y), tile.getColour());
			}
		}
	}


	public void drawCables(AsciiPanel term) {
		for(int x = 0; x < map.getWidth(); x++) {
			for(int y = 0; y < map.getHeight(); y++) {
				drawCable(term, x, y);
			}
		}
	}

	public void scroll(int x, int y) {
		scrollX += x;
		scrollY += y;
	}

	public int mapToScreenX(int x) {
		return x + scrollX;
	}

	public int mapToScreenY(int y) {
		return y + scrollY;
	}

	private void drawCable(AsciiPanel term, int x, int y) {
		Cable cable = map.getCableAt(x, y);

		if(cable != null) {
			// Only cables of the same colour category can connect to each other.
			ColourCategory cableColourCat = cable.getColourCategory();

			// Check if there are any cables of the same colour category adjacent to this cable.
			Cable cableAbove = map.getCableAt(x, y - 1);
			boolean isCableAbove = (cableAbove != null) && (cableColourCat == cableAbove.getColourCategory());
			Cable cableRight = map.getCableAt(x + 1, y);
			boolean isCableRight = (cableRight != null) && (cableColourCat == cableRight.getColourCategory());
			Cable cableBelow = map.getCableAt(x, y + 1);
			boolean isCableBelow = (cableBelow != null) && (cableColourCat == cableBelow.getColourCategory());
			Cable cableLeft = map.getCableAt(x - 1, y);
			boolean isCableLeft = (cableLeft != null) && (cableColourCat == cableLeft.getColourCategory());

			// Fetch the appropriate glyph depending on what other cables surround this cable.
			char glyph = Cable.glyphs[isCableAbove ? 1 : 0][isCableRight ? 1 : 0][isCableBelow ? 1 : 0][isCableLeft ? 1 : 0];

			term.write(glyph, mapToScreenX(x), mapToScreenY(y), cableColourCat.getColour());
		} else {
			// Default to a grey cable with no connections if there is no actual cable present.
			term.write(Cable.glyphs[0][0][0][0], mapToScreenX(x), mapToScreenY(y), Color.GRAY);
		}
	}
}
