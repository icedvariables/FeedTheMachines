package newgame.maps;

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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
