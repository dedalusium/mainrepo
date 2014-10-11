/**
 * 
 */
package mowitnow.view;

import mowitnow.controller.GridController;
import mowitnow.model.Machine;
import mowitnow.model.MachineChangedEvent;
import mowitnow.model.MachineListener;

/**
 * @author Nordwin
 *
 */
public class ConsoleView implements MachineListener {

	public GridController controller;

	public ConsoleView(GridController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void modelChanged(MachineChangedEvent e) {
		Machine m = (Machine) e.getSource();
		m.draw(this);
	}

	public void display(String s) {
		System.out.println(s);
	}

}
