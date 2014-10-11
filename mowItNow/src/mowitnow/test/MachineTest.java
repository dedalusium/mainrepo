package mowitnow.test;

import mowitnow.model.Direction;
import mowitnow.model.Machine;
import mowitnow.model.Mower;

import org.junit.Assert;
import org.junit.Test;

public class MachineTest {

	@Test
	public final void moveForwardTest() {
		Machine m = new Mower();
		m.setDir(Direction.NORTH);
		m.setName("test machine");
		m.setX(0);
		m.setY(0);
		m.setxMax(10);
		m.setyMax(10);
		m.move(2);
		Assert.assertTrue(m.getY() == 2);
		Assert.assertTrue(m.getX() == 0);
		Assert.assertTrue(m.getDir() == Direction.NORTH);
	}

	@Test
	public final void trunRightTest() {
		Machine m = new Mower();
		m.setDir(Direction.NORTH);
		m.setName("test machine");
		m.turnRigth();
		Assert.assertTrue(m.getDir() == Direction.EAST);
	}

	@Test
	public final void turnLeftTest() {
		Machine m = new Mower();
		m.setDir(Direction.NORTH);
		m.setName("test machine");
		m.turnLeft();
		Assert.assertTrue(m.getDir() == Direction.WEST);
	}

	public final void stayTest() {
		Machine m = new Mower();
		m.setDir(Direction.NORTH);
		m.setName("test machine");
		m.setX(0);
		m.setY(0);
		m.setxMax(0);
		m.setyMax(0);
		m.move(2);
		Assert.assertTrue(m.getY() == 0);
		Assert.assertTrue(m.getX() == 0);
		Assert.assertTrue(m.getDir() == Direction.NORTH);
	}

}
