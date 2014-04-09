package GameOfLifeTest;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;
import GameOfLife.gameOfLifeInit;

public class initTest {
	final String[] s = {"0", "0", "1", "0", "1", "1","0", "1", "1"};
	final String[] emptyWorld = {};
	private static int THREADPOOL = 4;
	private static int THREADSLEEP = 3000;
	final Dimension d = new Dimension(3,3);
	final boolean[][] cellMap = {{false, false, false}, {false, true, true}, {true, true, true}};
	
	@Test
	public void testGameOfLifeInit() throws Exception {
		assertNotNull(new gameOfLifeInit(s, THREADPOOL, THREADSLEEP));
	}
	
	@Test
	public void testGameOfLifeInitSmallWorld() throws Exception {
	    try {
		      new gameOfLifeInit(emptyWorld, THREADPOOL, THREADSLEEP);;
		      fail("Exception was expected for null input");
		    } catch (Exception e) {          
		    }
	}

	@Test
	public void testGetDimension() throws Exception {
		new gameOfLifeInit(s, THREADPOOL, THREADSLEEP);
		assertEquals(d,gameOfLifeInit.getDimension());
	}

	@Test
	public void testGetCells() throws Exception {
		new gameOfLifeInit(s, THREADPOOL, THREADSLEEP);
		assertArrayEquals(cellMap,gameOfLifeInit.getCells());
	}
	
	@Test
	public void testGetTheads() throws Exception {
		new gameOfLifeInit(s, THREADPOOL, THREADSLEEP);
		assertEquals(4,gameOfLifeInit.getThreadPool());
	}
	
	@Test
	public void testGetTheadSleep() throws Exception {
		new gameOfLifeInit(s, THREADPOOL, THREADSLEEP);
		assertEquals(3000,gameOfLifeInit.getThreadSleep());
	}
}
