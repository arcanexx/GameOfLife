package GameOfLifeTest;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;



import GameOfLife.GameOfLifeException;
import GameOfLife.GameOfLifeInit;

public class initTest {
	final String[] s = {"0", "0", "1", "0", "1", "1","0", "1", "1"};
	final Dimension d = new Dimension(3,3);
	final boolean[][] cellMap = {{false, false, true}, {false, true, true}, {false, true, true}};
	@Test
	public void testGameOfLifeInit() throws GameOfLifeException {
		assertNotNull(new GameOfLifeInit(s) != null);
	}

	@Test
	public void testGetDimension() throws GameOfLifeException {
		new GameOfLifeInit(s);
		assertEquals(d,GameOfLifeInit.getDimension());
	}

	@Test
	public void testGetCells() throws GameOfLifeException {
		new GameOfLifeInit(s);
		assertArrayEquals(cellMap,GameOfLifeInit.getCells());
	}

}
