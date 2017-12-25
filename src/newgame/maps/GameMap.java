package newgame.maps;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class GameMap {
	private int width, height;
	private Tile[][] tiles;
	private Cable[][] cables;

	public GameMap(int width, int height) {
		tiles = new Tile[width][height];
		cables = new Cable[width][height];
		this.width = width;
		this.height = height;

		Cable c = new Cable(10, ColourCategory.RED);
		cables[10][10] = c;
		cables[10][11] = c;
		cables[11][11] = c;
		cables[11][10] = c;
		cables[12][10] = c;
		cables[12][11] = c;
	}

	public Tile getTileAt(int x, int y) {
		return tiles[x][y];
	}

	public Cable getCableAt(int x, int y) {
		return cables[x][y];
	}

	public void drawTiles(AsciiPanel term) {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Tile tile = getTileAt(x, y);

				if(tile != null)
					term.write(tile.getGlyph(), x, y, tile.getColour());
			}
		}
	}

	public void drawCable(AsciiPanel term) {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Cable cable = getCableAt(x, y);

				if(cable != null) {
					// Only cables of the same colour category can connect to each other.
					ColourCategory cableColourCat = cable.getColourCategory();

					// Check if there are any cables of the same colour category adjacent to this cable.
					Cable cableAbove = getCableAt(x, y - 1);
					boolean isCableAbove = (cableAbove != null) && (cableColourCat == cableAbove.getColourCategory());
					Cable cableRight = getCableAt(x + 1, y);
					boolean isCableRight = (cableRight != null) && (cableColourCat == cableRight.getColourCategory());
					Cable cableBelow = getCableAt(x, y + 1);
					boolean isCableBelow = (cableBelow != null) && (cableColourCat == cableBelow.getColourCategory());
					Cable cableLeft = getCableAt(x - 1, y);
					boolean isCableLeft = (cableLeft != null) && (cableColourCat == cableLeft.getColourCategory());

					// Fetch the appropriate glyph depending on what other cables surround this cable.
					char glyph = Cable.glyphs[isCableAbove ? 1 : 0][isCableRight ? 1 : 0][isCableBelow ? 1 : 0][isCableLeft ? 1 : 0];

					term.write(glyph, x, y, cableColourCat.getColour());
				} else {
					// Default to a grey cable with no connections if there is no actual cable present.
					term.write(Cable.glyphs[0][0][0][0], x, y, Color.GRAY);
				}
			}
		}
	}
}
