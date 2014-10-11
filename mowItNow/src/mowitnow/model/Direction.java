package mowitnow.model;

/**
 * Modification de la classe issue du post stack exchange
 * http://codereview.stackexchange.com/questions/42817/direction-enum-class
 * 
 * Represente les directions via une enum construite a l'aide d'ordinaux permet
 * de calculer les changements de directions
 */
public enum Direction {

	// use magic numbers to set the ordinal (used for rotation),
	// and the dx and dy of each direction.
	NORTH(0, 0, 1), EAST(1, 1, 0), SOUTH(2, 0, -1), WEST(3, -1, 0);

	private final int r90index, r180index, r270index;
	private final int dx, dy;

	private Direction(int ordinal, int dx, int dy) {
		// from the ordinal, dx, and dy, we can calculate all the other
		// constants.
		this.dx = dx;
		this.dy = dy;
		this.r90index = (ordinal + 1) % 4;
		this.r180index = (ordinal + 2) % 4;
		this.r270index = (ordinal + 3) % 4;
	}

	// Rotate 90 degrees clockwise
	public Direction rotate90() {
		return values()[r90index];
	}

	// Rotate 180 degrees
	public Direction rotate180() {
		return values()[r180index];
	}

	// Rotate 270 degrees clockwise (90 counterclockwise)
	public Direction rotate270() {
		return values()[r270index];
	}

	/**
	 * @return the dx
	 */
	public int getDx() {
		return dx;
	}

	/**
	 * @return the dy
	 */
	public int getDy() {
		return dy;
	}
}