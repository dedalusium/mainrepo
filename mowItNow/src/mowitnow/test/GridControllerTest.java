/**
 * 
 */
package mowitnow.test;

import mowitnow.controller.GridController;
import mowitnow.model.Direction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author nhoff
 *
 */
public class GridControllerTest {

	private static GridController controller;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		controller = new GridController("input/test.txt");
	}

	@Test
	public void buildGridContexttest() {
		controller.buildGridContext();
		Assert.assertTrue(controller.getGrid().getMachines().size() == 2);
	}

	@Test
	public void buildAndStartTest() {
		controller.buildAndStart();
		Assert.assertTrue(controller.getGrid().getMachines().get(0).getX() == 1);
		Assert.assertTrue(controller.getGrid().getMachines().get(0).getY() == 3);
		Assert.assertTrue(controller.getGrid().getMachines().get(0).getDir() == Direction.NORTH);
	}
}
