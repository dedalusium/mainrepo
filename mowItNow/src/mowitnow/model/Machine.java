package mowitnow.model;

import javax.swing.event.EventListenerList;

import mowitnow.instruction.InstructionSet;
import mowitnow.view.ConsoleView;

import org.apache.log4j.Logger;

public abstract class Machine {
	private String name;
	private Direction dir;
	private int x;
	private int y;
	private int xMax;
	private int yMax;
	private final Logger logger;
	private InstructionSet instructions;
	private EventListenerList modelListeners = new EventListenerList();

	public Machine(InstructionSet is, String name, int xMax, int yMax) {
		super();
		this.instructions = is;
		this.dir = is.getInitDir();
		this.x = is.getInitX();
		this.y = is.getInitY();
		this.xMax = xMax;
		this.yMax = yMax;
		this.name = name;
		this.logger = Logger.getLogger(Machine.class);
	}

	/**
	 * Fait avancer la tondeuse d'une case dans la direction courante TODO:
	 * ajouter des TU pour chaque cas
	 * 
	 * @param gridSizeX
	 * @param gridSizeY
	 * @return
	 */
	private boolean move() {
		// on ne fait pas de modulo et on passe a l'instruction suivante si on
		// depasse les dimensions
		int nextX = x + dir.getDx();
		int nextY = y + dir.getDy();
		if (nextX <= xMax && nextX >= 0 && nextY >= 0 && nextY <= yMax) {
			logger.debug("Machine " + name + " goes to " + dir.name()
					+ " from (" + x + "," + y + ") to (" + nextX + "," + nextY
					+ ")");
			x = nextX;
			y = nextY;
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
			// plan d'instructions
			if ('A' == c) {
				this.move();
			} else if ('G' == c) {
				this.turnLeft();
			} else if ('D' == c) {
				this.turnRigth();
			}
		}
		// on signale aux listener la fin des instructions
		this.update();

	}

	public void addModelListener(ModelListener m) {
		this.modelListeners.add(ModelListener.class, m);
	}

	public void removeModelListener(ModelListener m) {
		this.modelListeners.remove(ModelListener.class, m);
	}

	public void update() {
		ModelListener[] listenerList = (ModelListener[]) modelListeners
				.getListeners(ModelListener.class);
		for (ModelListener listener : listenerList) {
			listener.modelChanged(new ModelChangedEvent(this));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void draw(ConsoleView c) {
		String position = this.name + ": " + "I am in (" + this.x + ","
				+ this.y + ")";
		c.display(position);
	}
}
