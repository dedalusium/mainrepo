package mowitnow.model;

import java.util.List;

public class Grid {
	private List<Machine> machines;
	private int gridSizeX;
	private int gridSizeY;

	public Grid(int maxX, int maxY) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the machines
	 */
	public List<Machine> getMachines() {
		return machines;
	}

	/**
	 * @param machines
	 *            the machines to set
	 */
	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	/**
	 * @return the gridSizeY
	 */
	public int getGridSizeY() {
		return gridSizeY;
	}

	/**
	 * @return the gridSizeX
	 */
	public int getGridSizeX() {
		return gridSizeX;
	}

}
