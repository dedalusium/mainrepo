package mowitnow.instruction;

import mowitnow.model.Direction;

public class InstructionSet {
	private String moves;
	private int initX;
	private int initY;
	private Direction initDir;

	/**
	 * @return the moves
	 */
	public String getMoves() {
		return moves;
	}

	/**
	 * @param moves
	 *            the moves to set
	 */
	public void setMoves(String moves) {
		this.moves = moves;
	}

	/**
	 * @return the initX
	 */
	public int getInitX() {
		return initX;
	}

	/**
	 * @param initX
	 *            the initX to set
	 */
	public void setInitX(int initX) {
		this.initX = initX;
	}

	/**
	 * @return the initY
	 */
	public int getInitY() {
		return initY;
	}

	/**
	 * @param initY
	 *            the initY to set
	 */
	public void setInitY(int initY) {
		this.initY = initY;
	}

	/**
	 * @return the initDir
	 */
	public Direction getInitDir() {
		return initDir;
	}

	/**
	 * @param initDir
	 *            the initDir to set
	 */
	public void setInitDir(Direction initDir) {
		this.initDir = initDir;
	}

	/**
	 * @param initDir
	 *            the initDir to set
	 */
	public void setInitDir(char initDir) {
		if ('N' == initDir) {
			this.initDir = Direction.NORTH;
		} else if ('S' == initDir) {
			this.initDir = Direction.SOUTH;
		} else if ('E' == initDir) {
			this.initDir = Direction.EAST;
		} else if ('W' == initDir) {
			this.initDir = Direction.WEST;
		}

	}
}
