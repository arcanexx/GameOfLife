package GameOfLife;

public class GameOfLifeCell {
	public final short column;
	public final short row;
	private boolean alive;
	public byte neighbors;

	public GameOfLifeCell(short i, short j, boolean alive) throws GameOfLifeException {
		
		 if (i < 0 || j< 0 ) {
			 throw new IllegalArgumentException("Column or Row cannot be negative");
			 }
		 
		this.alive = alive;
		this.column = (short) i;
		this.row = (short) j;
		this.neighbors = 0;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean a) {
		alive = a;
	}
	
	public String toString() {
		return "Cell at (" + column + ", " + row + ") with " + neighbors
				+ " neighbor" + (neighbors == 1 ? "" : "s");
	}
}
