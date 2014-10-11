package mowitnow.model;

import mowitnow.instruction.InstructionSet;

/**
 * Model class for mower
 * 
 * @author nhoff
 *
 */
public class Mower extends Machine {

	public Mower(InstructionSet is, String name, int xMax, int yMax) {
		super(is, name, xMax, yMax);
	}

	public Mower() {
		super();
	}

	@Override
	public void executeInstructions() {
		super.executeInstructions();
	}

}
