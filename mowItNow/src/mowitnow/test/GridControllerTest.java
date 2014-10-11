/**
 * 
 */
package mowitnow.test;

import mowitnow.controller.GridController;
import mowitnow.model.Direction;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author nhoff
 *
 */
public class GridControllerTest {

	private static String path;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		path = "input/test1Mower.txt";
		path = "input/test.txt";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void buildGridContexttest() {
		GridController controller = new GridController();
		controller.buildGridContext(path);
		Assert.assertTrue(controller.getGrid().getMachines().size() == 2);
	}

	@Test
	public void buildAndStartTest() {
		GridController controller = new GridController();
		controller.buildAndStart(path);
		Assert.assertTrue(controller.getGrid().getMachines().get(0).getX() == 1);
		Assert.assertTrue(controller.getGrid().getMachines().get(0).getY() == 3);
		Assert.assertTrue(controller.getGrid().getMachines().get(0).getDir() == Direction.NORTH);
	}
}
