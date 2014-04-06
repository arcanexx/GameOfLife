package GameOfLife;

import java.awt.Dimension;
import java.lang.Math;

public class GameOfLifeInit {
	private static int size;
	private static boolean[][] initShape;

	public GameOfLifeInit(String[] Inputarray) throws GameOfLifeException {
		if (Math.sqrt(Inputarray.length) != Math.floor(Math
				.sqrt(Inputarray.length))) {
			// a square will have an integer root
			throw new GameOfLifeException(
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
