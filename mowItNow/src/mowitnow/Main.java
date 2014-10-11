package mowitnow;

import java.io.IOException;

import mowitnow.controller.GridController;
import mowitnow.view.ConsoleView;

import org.apache.log4j.Logger;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		if (args.length > 0 && !args[0].isEmpty()) {
			GridController controller;
			try {
				controller = new GridController(args[0]);
				ConsoleView view = new ConsoleView(controller);
				controller.buildGridContext();
				controller.addListener(view);
				controller.start();
			} catch (IOException e) {
				logger.error(e.getMessage());
				logger.debug(e.getStackTrace());
			}
		} else {
			String message = "Veuillez renseigner le fichier d'instruction en argument";
			System.out.println(message);
			logger.error(message);
		}
	}

}
