package GameOfLifeTest;

import static org.junit.Assert.*;

import org.junit.Test;

import GameOfLife.GameOfLifeCell;
import GameOfLife.GameOfLifeException;
import GameOfLife.GameOfLifeGrid;
import GameOfLife.GameOfLifeInit;

public class gridTest {

	final String[] s = {"0", "0", "1", "0", "1", "1","0", "1", "1"};
	@Test
	public void testGameOfLifeGrid() throws GameOfLifeException{
		assertNotNull(new GameOfLifeGrid());
	}

	@Test
	public void testGetCell() throws GameOfLifeException {
		GameOfLifeGrid g = new GameOfLifeGrid();
		assertEquals(true, g.getCell(2, 2));
	}

	@Test
	public void testReset() throws GameOfLifeException {
		GameOfLifeGrid g = new GameOfLifeGrid();
		 g.reset();
		 GameOfLifeCell c = new GameOfLifeCell((short)0, (short)0, false);
		g.checkNeighbor(c);
		g.checkSide(c, 0, 1);
		//assertEquals();
	}

	@Test
	public void testGetDimension() {
		fail("Not yet implemented");
	}

	@Test
	public void testNext() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckNeighbor() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckSide() {
		fail("Not yet implemented");
	}

	@Test
	public void testReproduction() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGeneration() {
		fail("Not yet implemented");
	}

}
