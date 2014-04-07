package GameOfLifeTest;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;
import GameOfLife.gameOfLifeInit;

public class initTest {
	final String[] s = {"0", "0", "1", "0", "1", "1","0", "1", "1"};
	final String[] emptyWorld = {};
	final Dimension d = new Dimension(3,3);
	final boolean[][] cellMap = {{false, false, false}, {false, true, true}, {true, true, true}};
	
	@Test
	public void testGameOfLifeInit() throws Exception {
		assertNotNull(new gameOfLifeInit(s));
	}
	
	@Test
	public void testGameOfLifeInitSmallWorld() throws Exception {
	    try {
		      new gameOfLifeInit(emptyWorld);;
		      fail("Exception was expected for null input");
		    } catch (Exception e) {          
		    }
	}

	@Test
	public void testGetDimension() throws Exception {
		new gameOfLifeInit(s);
		assertEquals(d,gameOfLifeInit.getDimension());
	}

	@Test
	public void testGetCells() throws Exception {
		new gameOfLifeInit(s);
		assertArrayEquals(cellMap,gameOfLifeInit.getCells());
	}
	
}
