/**
 * 
 */
package mowitnow.view;

import mowitnow.controller.GridController;
import mowitnow.model.Machine;
import mowitnow.model.ModelChangedEvent;
import mowitnow.model.ModelListener;

/**
 * @author Nordwin
 *
 */
public class ConsoleView implements ModelListener {

	public GridController controller;

	public ConsoleView(GridController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void modelChanged(ModelChangedEvent e) {
		Machine m = (Machine) e.getSource();
		m.draw(this);
	}

	public void display(String s) {
		System.out.println(s);
	}

}
