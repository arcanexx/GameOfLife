package GameOfLifeTest;

import static org.junit.Assert.*;

import org.junit.Test;

import GameOfLife.gameOfLifeGrid;
import GameOfLife.gameOfLifeInit;
import GameOfLife.gameOfLifeWorkParallelizer;

public class workParallelizerTest {
	final String[] s = { "0", "0", "1", "0", "1", "1", "0", "1", "1" };

	@Test
	public void workParallelizerConstructorTest() throws Exception {
		new gameOfLifeInit(s, 4, 3000);
		gameOfLifeGrid g = new gameOfLifeGrid();
		assertNotNull(new gameOfLifeWorkParallelizer(g, 1));
	}

	@Test
	public void workParallelizerInvalidTheadPoolTest() throws Exception {
		gameOfLifeGrid g = new gameOfLifeGrid();
		try {
			new gameOfLifeWorkParallelizer(g, 0);
			fail("Exception was expected for null input");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testThreadPerformance() {
		fail("Not yet implemented, Here's where it could be fun to unit test performance...");
	}
}
