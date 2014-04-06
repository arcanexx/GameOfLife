package GameOfLife;

public class GameOfLife {
	protected static GameOfLifeInit GOLinit;
	protected static GameOfLifeGrid gameOfLifeGrid;
	protected static GameOfLifeWindow GameOfLifeFrame;
	
	public static void main(String[] args) throws GameOfLifeException {

		GOLinit = new GameOfLifeInit(args);  //Input helper and validator
	    gameOfLifeGrid = new GameOfLifeGrid(); //Make the grid, set the rules
		GameOfLifeFrame = new GameOfLifeWindow(gameOfLifeGrid); // Create a window
		GameOfLifeFrame.setVisible(true); // Display it
	    run();
	}
	
	protected synchronized static void run() {
		    while (true) {
		      try {
		        Thread.sleep(4000);
		        gameOfLifeGrid.next();
		        GameOfLifeFrame.repaint();
		       // showGenerations();
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		  }
}
