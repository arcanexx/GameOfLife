package GameOfLife;

import java.awt.Dimension;

public class GameOfLifeGrid {
	private int Rows;
	private int Columns;
	private int generations;
	boolean[][] nextState;
	private GameOfLifeCell[][] grid;

	public GameOfLifeGrid() throws GameOfLifeException {
		reset();
	}

	public boolean getCell(int column, int row) {
		return grid[column][row].isAlive();
	}

	public void reset() throws GameOfLifeException {
		this.Columns = GameOfLifeInit.getDimension().width;
		this.Rows = GameOfLifeInit.getDimension().height;
		boolean[][] initState = GameOfLifeInit.getCells();
		grid = new GameOfLifeCell[Columns][Rows];
		for (short x = 0; x < Columns; x++) {
			for (short y = 0; y < Rows; y++) {
			    grid[x][y] = new GameOfLifeCell(x, y, initState[x][y]);
			}
		}
	}

	public Dimension getDimension() {
		return new Dimension(Columns, Rows);
	}

	public synchronized void next() {
		generations++;
		for (GameOfLifeCell c[] : grid) {
			for (GameOfLifeCell y : c) {
				checkNeighbor(y);
			}
		}
		for (GameOfLifeCell c[] : grid) {
			for (GameOfLifeCell y : c) {
				reproduction(y);
			}
		}
	}

	public void checkNeighbor(GameOfLifeCell c) {
			grid[c.row][c.column].neighbors = 0;		
			checkSide(c,-1,-1);
			checkSide(c,-1,0);
			checkSide(c,-1,1);
			checkSide(c,0,-1);
			checkSide(c,0,1);
			checkSide(c,1,-1);
			checkSide(c,1,0);
			checkSide(c,1,1);
	}
	
	public void checkSide(GameOfLifeCell c, int x, int y) {
		try {
			if (grid[c.row + x][c.column + y].isAlive()){
				grid[c.row][c.column].neighbors++;}
		} catch (ArrayIndexOutOfBoundsException e) {
			// ignore
		}
	}
	
	public synchronized void reproduction(GameOfLifeCell c) {

		if (c.isAlive() == false && c.neighbors == 3)
			c.setAlive(true);
		if (c.neighbors != 3 && c.neighbors != 2)
			c.setAlive(false);
	}

	int getGeneration() {
		return generations;
	}
}
