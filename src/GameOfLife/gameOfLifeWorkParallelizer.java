package GameOfLife;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class gameOfLifeWorkParallelizer {
    private static gameOfLifeGrid nextGrid;
    private static gameOfLifeGrid grid;
    
	public  gameOfLifeWorkParallelizer(gameOfLifeGrid g, int threadpool) throws Exception{
		grid = g;
        ExecutorService executorService = Executors.newFixedThreadPool(threadpool);
        CompletionService<gameOfLifeCell> taskCompletionService = new ExecutorCompletionService<gameOfLifeCell>(
                executorService);
        
        try {
        	nextGrid = new gameOfLifeGrid();
            List<Callable<gameOfLifeCell>> callables = createCallableList();
            for (Callable<gameOfLifeCell> callable : callables) {
                taskCompletionService.submit(callable);
            }
            for (int i = 0; i < callables.size(); i++) {
                Future<gameOfLifeCell> result = taskCompletionService.take();
                nextGrid.setCell(result.get().getColumn(), result.get().getRow(),result. get().isAlive());
            }
        } catch (InterruptedException e) {
            // no real error handling. Don't do this in production!
            e.printStackTrace();
        } catch (ExecutionException e) {
            // no real error handling. Don't do this in production!
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static List<Callable<gameOfLifeCell>> createCallableList() throws Exception {
        List<Callable<gameOfLifeCell>> callables = new ArrayList<Callable<gameOfLifeCell>>();
        for (int x = 0; x < grid.getColumns(); x++) {
        	for (int y = 0; y < grid.getRows(); y++) {
			callables.add(new gameOfLifeCellWorkItem(grid,x,y));
        	}
        }
        return callables;
    }
	
public gameOfLifeCell[][] next() {
	return nextGrid.getCellGrid();
}

}
