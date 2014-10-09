package mowitnow.model;

import org.apache.log4j.Logger;

public abstract class Machine {
	private Direction dir;
	private int x;
	private int y;
	private final Logger logger;

	public Machine(Direction dir, int x, int y) {
		super();
		this.dir = dir;
		this.x = x;
		this.y = y;
		this.logger = Logger.getLogger(Machine.class);
	}

	public void move(final int gridSizeX, final int gridSizeY) {

		x = (x + dir.getDx()) % gridSizeX;
		y = (y + dir.getDy()) % gridSizeY;
		
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

}
