package GameOfLife;

public class gameOfLifeCell {
	private final int column;
	private final int row;
	private boolean alive;
	private int liveNeighbors;

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
	
	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	public int getNeighbor(){
		return liveNeighbors;
	}
	
	public void incrementNeighbor(){
		liveNeighbors++;
	}
	
	public String toString() {
		return "Cell " + (alive == true ? "alive" : "dead") + " at (" + column + ", " + row + ") with " + liveNeighbors
				+ " neighbor" + (liveNeighbors == 1 ? "" : "s" );
	}
}
