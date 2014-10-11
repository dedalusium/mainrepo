/**
 * 
 */
package mowitnow.test;

import java.io.IOException;
import java.util.List;

import mowitnow.instruction.InstructionBuilder;
import mowitnow.instruction.InstructionSet;
import mowitnow.model.Direction;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nordwin
 *
 */
public class InstructionBuilderTest {

	private String path = "input/test1Mower.txt";

	/**
	 * Test method for
	 * {@link mowitnow.instruction.InstructionBuilder#load(java.lang.String)}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testLoad() throws IOException {
		List<InstructionSet> l = InstructionBuilder.load(path);
		Assert.assertTrue(l.size() == 1);
		Assert.assertTrue(l.get(0).getInitDir() == Direction.NORTH);
		Assert.assertTrue(l.get(0).getInitX() == 1);
		Assert.assertTrue(l.get(0).getInitY() == 2);
	}

	/**
	 * Test method for
	 * {@link mowitnow.instruction.InstructionBuilder#getGridSize(java.lang.String)}
	 * .
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testGetGridSize() throws IOException {
		int[] size = InstructionBuilder.getGridSize(path);
		Assert.assertTrue(size.length == 2);
		Assert.assertTrue(size[0] == 5);
		Assert.assertTrue(size[1] == 5);
	}

}
