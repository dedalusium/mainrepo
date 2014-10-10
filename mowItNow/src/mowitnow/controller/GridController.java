package mowitnow.controller;

import java.io.IOException;
import java.util.List;

import mowitnow.model.Grid;
import mowitnow.model.InstructionBuilder;
import mowitnow.model.InstructionSet;
import mowitnow.model.Machine;
import mowitnow.model.Mower;

public class GridController {
	private Grid grid;

	/**
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * @param grid
	 *            the grid to set
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public void buildGridContext(String path) {
		try {
			int[] size = InstructionBuilder.getGridSize(path);
			this.grid = new Grid(size[0], size[1]);
			List<InstructionSet> list = InstructionBuilder.load(path);
			for (InstructionSet is : list) {
				Mower mower = new Mower(is);
				grid.getMachines().add(mower);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Start() {
		for (Machine m : this.grid.getMachines()) {
			m.executeInstructions();
		}
	}

}
