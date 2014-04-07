package GameOfLife;

public class gameOfLife {
	private final static int threadSleep = 3000;
	protected static gameOfLifeInit GOLinit;
	protected static gameOfLifeGrid gameOfLifeGrid;
	protected static gameOfLifeWindow GameOfLifeFrame;
	//expecting command line input of space separated 1s and 0s
	//Attempts to handle badly formated input or fail gracefully
	public static void main(String[] args) throws Exception {

		GOLinit = new gameOfLifeInit(args);  //Input helper and validator 
	    gameOfLifeGrid = new gameOfLifeGrid(); //Make the grid, set the rules
		GameOfLifeFrame = new gameOfLifeWindow(gameOfLifeGrid); // Create a window
		GameOfLifeFrame.setVisible(true); // Display it
	    run();
	}
	
	protected synchronized static void run() {
		    while (true) {
		      try {
		        Thread.sleep(threadSleep);
		        gameOfLifeGrid.next();
		        GameOfLifeFrame.repaint();
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		  }
}
