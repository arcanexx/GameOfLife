package GameOfLifeTest;

import static org.junit.Assert.*;

import org.junit.Test;
import GameOfLife.gameOfLifeGrid;
import GameOfLife.gameOfLifeInit;

public class gridTest {
	private static int THREADPOOL = 4;
	private static int THREADSLEEP = 3000;
	final String[] s = {"0", "0", "1", "0", "1", "1","0", "1", "1"};
	
	@Test
	public void testGameOfLifeGrid() throws Exception{
		assertNotNull(new gameOfLifeGrid());
	}

	@Test
	public void testGetCell() throws Exception {
		gameOfLifeGrid g = new gameOfLifeGrid();
		assertEquals(true, g.getCell(2, 2));
	}

	@Test
	public void testReset() throws Exception {
		new gameOfLifeInit(s, THREADPOOL, THREADSLEEP);
		gameOfLifeGrid g = new gameOfLifeGrid();
		g.reset();
	}

	@Test
	public void testGetDimension() throws Exception {
		new gameOfLifeInit(s, THREADPOOL, THREADSLEEP);
		gameOfLifeGrid g = new gameOfLifeGrid();
		assertEquals(3,g.getDimension());
	}

	@Test
	public void testGetGrid() {
		fail("Not yet implemented, you get the idea though...");
	}

	@Test
	public void testGetColumns() {
		fail("Not yet implemented, you get the idea though...");
	}
	
	@Test
	public void testGetRows() {
		fail("Not yet implemented, you get the idea though...");
	}
	
	@Test
	public void testNext() {
		fail("Not yet implemented, you get the idea though...");
	}

	@Test
	public void testSetCell() {
		fail("Not yet implemented, you get the idea though...");
	}
}
