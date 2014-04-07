package GameOfLife;

import java.awt.Dimension;

public class gameOfLifeGrid {
	private int Rows;
	private int Columns;
	private int generations;
	boolean[][] nextState;
	private gameOfLifeCell[][] grid;

	public gameOfLifeGrid() throws Exception {
		reset();
	}

	public boolean getCell(int column, int row) {
		return grid[column][row].isAlive();
	}

	public void reset() throws Exception {
		this.Columns = gameOfLifeInit.getDimension().width;
		this.Rows = gameOfLifeInit.getDimension().height;
		boolean[][] initState = gameOfLifeInit.getCells();
		grid = new gameOfLifeCell[Columns][Rows];
		for (int x = 0; x < Columns; x++) {
			for (int y = 0; y < Rows; y++) {
			    grid[x][y] = new gameOfLifeCell(x, y, initState[x][y]);
			}
		}
	}

	public Dimension getDimension() {
		return new Dimension(Columns, Rows);
	}

	public synchronized void next() {
		for (gameOfLifeCell c[] : grid) {
			for (gameOfLifeCell y : c) {
				checkNeighbor(y);
			}
		}
		for (gameOfLifeCell c[] : grid) {
			for (gameOfLifeCell y : c) {
				reproduction(y);
			}
		}
	}

	public void checkNeighbor(gameOfLifeCell c) {
			grid[c.row][c.column].liveNeighbors = 0;		
			checkSide(c,-1,-1);
			checkSide(c,-1,0);
			checkSide(c,-1,1);
			checkSide(c,0,-1);
			checkSide(c,0,1);
			checkSide(c,1,-1);
			checkSide(c,1,0);
			checkSide(c,1,1);
	}
	
	private void checkSide(gameOfLifeCell c, int x, int y) {
		try {
			if (c.row + x < 0 || c.row + x >= Rows)
				return;
			if (c.column + y < 0 || c.column + y >= Columns)
				return;
			if (grid[c.row + x][c.column + y].isAlive()){
				grid[c.row][c.column].liveNeighbors++;}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Addressed out of bounds array value");
		}
	}
	
	public synchronized void reproduction(gameOfLifeCell c) {

		// rule 4
		if (c.isAlive() == false && c.liveNeighbors == 3)
			c.setAlive(true);
		// rule 1 AND rule 2 AND rule 3
		if (c.liveNeighbors != 3 && c.liveNeighbors != 2)
			c.setAlive(false);
	}

	int getGeneration() {
		return generations;
	}
}
