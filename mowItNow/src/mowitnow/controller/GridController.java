package mowitnow.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import mowitnow.model.Grid;
import mowitnow.model.InstructionBuilder;
import mowitnow.model.InstructionSet;
import mowitnow.model.Machine;
import mowitnow.model.Mower;

/**
 * On prévoit une architecture MVC en prévision d'une supervision
 * 
 * @author Nordwin
 *
 */
public class GridController {
	private Grid grid;
	private Logger logger;

	public GridController() {
		this.logger = Logger.getLogger(GridController.class);
	}

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
				Mower mower = new Mower(is, String.valueOf(list.indexOf(is)+1),
						grid.getGridSizeX(), grid.getGridSizeY());
				grid.getMachines().add(mower);
			}

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	public void start() {
		for (Machine m : this.grid.getMachines()) {
			m.executeInstructions();
		}
	}

	public void buildAndStart(String path) {
		this.buildGridContext(path);
		this.start();
	}

}
