package mowitnow;

import mowitnow.controller.GridController;
import mowitnow.view.ConsoleView;

public class Main {

	public static void main(String[] args) {
		GridController controller = new GridController(args[0]);
		ConsoleView view = new ConsoleView(controller);
		controller.buildGridContext();
		controller.addListener(view);
		controller.start();

	}

}
