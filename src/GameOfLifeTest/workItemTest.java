package GameOfLifeTest;

import static org.junit.Assert.*;

import org.junit.Test;

import GameOfLife.gameOfLifeCell;
import GameOfLife.gameOfLifeCellWorkItem;
import GameOfLife.gameOfLifeGrid;
import GameOfLife.gameOfLifeInit;

public class workItemTest {
	final String[] s = { "0", "0", "1", "0", "1", "1", "0", "1", "1" };

	@Test
	public void testGameOfLifeCellConstructor() throws Exception {
		new gameOfLifeInit(s, 4, 3000);
		assertNotNull(new gameOfLifeCellWorkItem(new gameOfLifeGrid(), 0, 0));
	}

	@Test
	public void testCall() throws Exception {
		new gameOfLifeInit(s, 4, 3000);
		gameOfLifeCellWorkItem cellWorkItem = new gameOfLifeCellWorkItem(
				new gameOfLifeGrid(), 0, 0);
		gameOfLifeCell cell = cellWorkItem.call();
		assertFalse(cell.isAlive());
		assertEquals(0, cell.getColumn());
		assertEquals(0, cell.getRow());
		assertEquals(1, cell.getNeighbor());
	}

}
