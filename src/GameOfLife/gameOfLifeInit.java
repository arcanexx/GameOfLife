package GameOfLife;

import java.awt.Dimension;
import java.lang.Math;

public class gameOfLifeInit {
	private static int size;
	private static boolean[][] initShape;
	private final int MINSIZE = 4;
	
	public gameOfLifeInit(String[] Inputarray) throws Exception {
		if ( null == Inputarray || Inputarray.length < MINSIZE ){
			throw new Exception(
					"Sad, small world.  Don't you want a larger game of life?  Exiting");
		}

		double root =  Math.sqrt(Inputarray.length);
		if (root != Math.floor(root)) {
			// a square will have an integer root
			throw new Exception(
					"Bad Input.  Not a square board.  Exiting");
		}
		// we're safe to cast since we verified a whole number root
		size = (int) Math.sqrt(Inputarray.length);
		initShape = new boolean[size][size];

		for (int x = 0; x <size; x++) {
			for (int y = 0; y < size; y++) {
			initShape[y][x] = (Inputarray[(x*size)+y].equals("1")) ? true: false;
			}
		}
	}

	public static Dimension getDimension() {
		return new Dimension(size, size);
	}

	public static boolean[][] getCells() {
		return initShape;
	}
}
