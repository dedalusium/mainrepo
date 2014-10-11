package mowitnow.model;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private List<Machine> machines;
	private int gridSizeX;
	private int gridSizeY;
	
	public Grid(int maxX, int maxY) {
		this.gridSizeX = maxX;
		this.gridSizeY = maxY;
	}

	/**
	 * @return the machines
	 */
	public List<Machine> getMachines() {
		if (machines == null) {
			// avoid NPE
			machines = new ArrayList<Machine>();
		}
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
