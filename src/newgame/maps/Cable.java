package newgame.maps;

public class Cable {
	public static char[][][][] glyphs;
	static {
		glyphs = new char[2][2][2][2];

		//       UP   RIGHT   DOWN   LEFT
		glyphs[  1  ][  0  ][  1  ][  0  ] = (char) 179;		// Vertical connection.
		glyphs[  1  ][  0  ][  1  ][  1  ] = (char) 180;
		glyphs[  0  ][  0  ][  1  ][  1  ] = (char) 191;
		glyphs[  1  ][  1  ][  0  ][  0  ] = (char) 192;
		glyphs[  1  ][  1  ][  0  ][  1  ] = (char) 193;
		glyphs[  0  ][  1  ][  1  ][  1  ] = (char) 194;
		glyphs[  1  ][  1  ][  1  ][  0  ] = (char) 195;
		glyphs[  1  ][  0  ][  1  ][  0  ] = (char) 196;		// Horizontal connection.
		glyphs[  1  ][  1  ][  1  ][  1  ] = (char) 197;		// Connections in all directions.
		glyphs[  1  ][  0  ][  0  ][  1  ] = (char) 217;
		glyphs[  0  ][  1  ][  1  ][  0  ] = (char) 218;
		glyphs[  0  ][  0  ][  0  ][  0  ] = (char) 249;		// No connections.
	}

	private int transferRate;

	private ColourCategory colourCategory;

	public Cable(int transferRate, ColourCategory colourCategory) {
		this.transferRate = transferRate;
		this.colourCategory = colourCategory;
	}

	public int getTransferRate() {
		return transferRate;
	}

	public ColourCategory getColourCategory() {
		return colourCategory;
	}
}
