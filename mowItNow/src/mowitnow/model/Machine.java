package mowitnow.model;

import org.apache.log4j.Logger;

public abstract class Machine {
	private Direction dir;
	private int x;
	private int y;
	private final Logger logger;
	private InstructionSet instructions;

	public Machine(InstructionSet is) {
		super();
		this.instructions = is;
		this.dir = is.getInitDir();
		this.x = is.getInitX();
		this.y = is.getInitY();
		this.logger = Logger.getLogger(Machine.class);
	}

	/**
	 * Fait avancer la tondeuse d'une case dans la direction courante
	 * 
	 * @param gridSizeX
	 * @param gridSizeY
	 * @return
	 */
	private boolean move(final int gridSizeX, final int gridSizeY) {
		// on ne fait pas de modulo et on passe a l'instruction suivante si on
		// depasse les dimensions
		int nextX = x + dir.getDx();
		int nextY = y + dir.getDy();
		if (nextX < gridSizeX && nextX > 0 && nextY > 0 && nextY < gridSizeY) {
			x = nextX;
			y = nextY;
			logger.debug("Mower goes to " + dir.name());
			return true;
		} else {
			logger.debug("Mower stay in the same square.");
			return false;
		}
	}

	/**
	 * turn machine's direction on the left
	 */
	public void turnLeft() {
		dir = dir.rotate270();
	}

	/**
	 * turn machine's direction on the right
	 */
	public void turnRigth() {
		dir = dir.rotate90();
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the dir
	 */
	public Direction getDir() {
		return dir;
	}

	/**
	 * @param dir
	 *            the dir to set
	 */
	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public void executeInstructions() {
		// lecture des instructions
		for (char c : instructions.getMoves().toCharArray()) {
			// move turn etc.
		}
	}

}
