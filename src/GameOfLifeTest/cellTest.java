package GameOfLifeTest;

import static org.junit.Assert.*;
import org.junit.Test;
import GameOfLife.gameOfLifeCell;

public class cellTest {

	@Test
	public void testIsAlive() throws Exception {
		gameOfLifeCell cell = new gameOfLifeCell(0, 0, false);
		cell.setAlive(true);
		assertEquals(true, cell.isAlive());
	}

	@Test
	public void testSetAlive() throws Exception {
		gameOfLifeCell cell = new gameOfLifeCell(0, 0, false);
		cell.setAlive(true);
		assertEquals(true, cell.isAlive());
	}

	@Test
	public void testToString() throws Exception {
		gameOfLifeCell cell = new gameOfLifeCell(10, 5, true);
		assertEquals("Cell alive at (10, 5) with 0 neighbors", cell.toString());
	}

}
