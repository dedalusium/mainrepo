/**
 * 
 */
package mowitnow.test;

import mowitnow.controller.GridController;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author nhoff
 *
 */
public class GridControllerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		GridController controller = new GridController();
		String path = "input/test.txt";
		controller.buildGridContext(path);
	}
}
