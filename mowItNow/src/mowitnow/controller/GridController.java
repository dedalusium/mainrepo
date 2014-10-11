package mowitnow.controller;

import java.io.IOException;
import java.util.List;

import mowitnow.instruction.InstructionBuilder;
import mowitnow.instruction.InstructionSet;
import mowitnow.model.Grid;
import mowitnow.model.Machine;
import mowitnow.model.Mower;
import mowitnow.view.ConsoleView;

import org.apache.log4j.Logger;

/**
 * On prévoit une architecture MVC en prévision d'une supervision
 * 
 * @author Nordwin
 *
 */
public class GridController {
	private Grid grid;
	private String path;
	private Logger logger;

	public GridController(String path) {
		this.logger = Logger.getLogger(GridController.class);
		this.setPath(path);
		try {
			int[] size = InstructionBuilder.getGridSize(path);
			this.grid = new Grid(size[0], size[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void buildGridContext() {
		try {
			List<InstructionSet> list = InstructionBuilder.load(path);
			for (InstructionSet is : list) {
				Mower mower = new Mower(is,
						String.valueOf(list.indexOf(is) + 1),
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

	public void buildAndStart() {
		this.buildGridContext();
		this.start();
	}

	/**
	 * Ajoute un listner a toutes les machines
	 * 
	 * @param consoleView
	 */
	public void addListener(ConsoleView consoleView) {
		for (Machine m : grid.getMachines()) {
			m.addModelListener(consoleView);
		}
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
}
