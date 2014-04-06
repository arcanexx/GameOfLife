package GameOfLifeTest;

import static org.junit.Assert.*;

import org.junit.Test;

import GameOfLife.GameOfLifeCell;
import GameOfLife.GameOfLifeException;

public class cellTest {

	@Test
	public void testGameOfLifeCellConstructor() throws GameOfLifeException {
		GameOfLifeCell cell = new GameOfLifeCell((short)0, (short)0, false);
		assertEquals(false, cell.isAlive());
		assertEquals(0, cell.column);
		assertEquals(0, cell.row);
		assertEquals(false, cell.isAlive());
	}

	@Test public void testGameOfLifeCellConstructorIllegalValues() throws GameOfLifeException {
	    try {
	      new GameOfLifeCell((short)-1,(short)0,false);
	      fail("Exception was expected for null input");
	    } catch (IllegalArgumentException e) {          
	    }
	}
	
	@Test
	public void testIsAlive() throws GameOfLifeException {
		GameOfLifeCell cell = new GameOfLifeCell((short)0, (short)0, false);
		cell.setAlive(true);
		assertEquals(true, cell.isAlive());
	}

	@Test
	public void testSetAlive() throws GameOfLifeException {
		GameOfLifeCell cell = new GameOfLifeCell((short)0, (short)0, false);
		cell.setAlive(true);
		assertEquals(true, cell.isAlive());
	}

	@Test
	public void testToString() throws GameOfLifeException {
		GameOfLifeCell cell = new GameOfLifeCell((short)10, (short)5, true);
		assertEquals("Cell at (10, 5) with 0 neighbors", cell.toString());
	}

}
