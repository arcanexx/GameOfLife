package GameOfLife;

public class gameOfLife {
	private static int THREADPOOL = 4;
	private static int THREADSLEEP = 1000;
	private static gameOfLifeGrid gameOfLifeGrid;
	private static gameOfLifeWindow GameOfLifeFrame;
	//expecting command line input of space separated 1s and 0s
	//Attempts to handle badly formated input or fail gracefully
	public static void main(String[] args) throws Exception {
		new gameOfLifeInit(args,THREADPOOL,THREADSLEEP);  //helper to take input, validate, and set initial state
	    gameOfLifeGrid = new gameOfLifeGrid(); //Make the grid, set the rules
		GameOfLifeFrame = new gameOfLifeWindow(gameOfLifeGrid); // Create a window
	    run();
	}
	
	protected static void run() throws Exception {
		    while (true) {
		      try {
		        gameOfLifeGrid.next();
		        GameOfLifeFrame.repaint();
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		  }
}
