package GameOfLife;

import java.awt.Dimension;

public class gameOfLifeGrid {
	private int Rows;
	private int Columns;
	private gameOfLifeCell[][] grid;

	public gameOfLifeGrid() throws Exception {
		reset();
	}

	public boolean getCell(int column, int row) {
		return grid[column][row].isAlive();
	}
	
	public void setCell(int column, int row, boolean isAlive) {
		grid[column][row].setAlive(isAlive);
	}

	public int getRows() {
		return Rows;
	}
	
	public int getColumns() {
		return Columns;
	}
	
	public gameOfLifeCell[][] getCellGrid() {
		return grid;
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

	public void next() throws Exception {
		Thread.sleep(gameOfLifeInit.getThreadSleep());
		gameOfLifeWorkParallelizer p = new gameOfLifeWorkParallelizer(this, gameOfLifeInit.getThreadPool());
		grid = p.next();
		printCells();
		
	}

	private void printCells() {
		for (int x = 0; x < Columns; x++) {
			for (int y = 0; y < Columns; y++) {
				System.out.print(grid[y][x].isAlive() == true ? "1 " : "0 ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
