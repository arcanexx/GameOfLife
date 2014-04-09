package GameOfLife;

import java.util.concurrent.Callable;

public class gameOfLifeCellWorkItem implements Callable<gameOfLifeCell> {
	private gameOfLifeGrid currentGrid;
	private int cellX;
	private int cellY;
	private gameOfLifeCell cell;

	public gameOfLifeCellWorkItem(gameOfLifeGrid g, int x, int y) throws Exception {
		currentGrid = g;
		cellX = x;
		cellY = y;
		cell = new gameOfLifeCell(cellX, cellY, g.getCell(cellX, cellY));
	}

	public gameOfLifeCell call() throws Exception {
		cell.setAlive(calculateCell());
		//great for debugging
		//System.out.println(cell.toString() + " is now set " + cell.isAlive());
		return cell;
	}

	private Boolean calculateCell() {
		checkNeighbor();
		return followRules();
	}

	private void checkNeighbor() {
		checkSide(cell, -1, -1);
		checkSide(cell, -1, 0);
		checkSide(cell, -1, 1);
		checkSide(cell, 0, -1);
		checkSide(cell, 0, 1);
		checkSide(cell, 1, -1);
		checkSide(cell, 1, 0);
		checkSide(cell, 1, 1);
	}

	private void checkSide(gameOfLifeCell c, int x, int y) {
		try {
			if (cell.getColumn() + x < 0 || cell.getColumn() + x >= currentGrid.getColumns())
				return;
			if (cell.getRow() + y < 0 || cell.getRow() + y >= currentGrid.getRows())
				return;
			if (currentGrid.getCell(cell.getColumn() + x, cell.getRow() + y)) {
				cell.incrementNeighbor();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Addressed out of bounds array value: "
					+ cell.getRow() + " " + cell.getColumn());
		}
	}

	private boolean followRules() {
		boolean alive = cell.isAlive();
		int neighbors = cell.getNeighbor();
		// break out rules for simplicity
		// rule 4
		if (!alive && (neighbors == 3)) {
			return true;
		}
		// rule 3
		else if (alive && (neighbors > 3)) {
			return false;
		}
		// rule 1
		else if (alive && (neighbors < 2)) {
			return false;
		}
		// rule 2
		else
			return alive;
	}

}
