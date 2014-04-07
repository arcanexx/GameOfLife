package GameOfLife;

public class gameOfLifeCell {
	public final int column;
	public final int row;
	private boolean alive;
	public int liveNeighbors;

	public gameOfLifeCell(int x, int y, boolean alive) throws Exception {
		
		 if (x < 0 || y< 0 ) {
			 throw new IllegalArgumentException("Column or Row cannot be negative");
			 }
		 
		this.alive = alive;
		this.column = x;
		this.row = y;
		this.liveNeighbors = 0;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean a) {
		alive = a;
	}
	
	public String toString() {
		return "Cell at (" + column + ", " + row + ") with " + liveNeighbors
				+ " neighbor" + (liveNeighbors == 1 ? "" : "s");
	}
}
