package GameOfLife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameOfLifeWindow extends JFrame implements ComponentListener {
	private static final long serialVersionUID = 1L;
	private Image offScreenImageDrawed;
	private Graphics offScreenGraphicsDrawed;
	private int cellSize;
	private GameOfLifeGrid cellGrid;
	private int xOffset = 8;
	private int yOffset = 30;

	public GameOfLifeWindow(GameOfLifeGrid gameOfLifeGrid) {
		setTitle("Game of Life Demo");
		setSize(500, 550);
		setBackground(new Color(0x999999));
		setLocationRelativeTo(null);
		this.cellGrid = gameOfLifeGrid;
		this.cellSize = getSize().width / GameOfLifeInit.getDimension().width - 3; // to accomodate for border
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentListener(this);
	}

	public void componentResized(ComponentEvent e) {
		this.cellSize = getSize().width / GameOfLifeInit.getDimension().width- 3;
		this.repaint();
	}

	public void paint(Graphics g) {

		Dimension dim = cellGrid.getDimension();
		Dimension d = getSize();
		offScreenImageDrawed = createImage(d.width, d.height);
		offScreenGraphicsDrawed = offScreenImageDrawed.getGraphics();
		offScreenGraphicsDrawed.setColor(getBackground());
		offScreenGraphicsDrawed.fillRect(0, 0, d.width, d.height);
		offScreenGraphicsDrawed.setColor(Color.gray);
		offScreenGraphicsDrawed.fillRect(0, 0, cellSize * dim.width - 1, cellSize * dim.height - 1);
		offScreenGraphicsDrawed.setColor(getBackground());
		for (int x = 1; x < dim.width; x++) {
			offScreenGraphicsDrawed.drawLine(x * cellSize - 1, 0, x * cellSize - 1, cellSize * dim.height - 1);
		}
		for (int y = 1; y < dim.height; y++) {
			offScreenGraphicsDrawed.drawLine(0, y * cellSize - 1, cellSize * dim.width - 1, y * cellSize - 1);
		}
		g.drawImage(offScreenImageDrawed, xOffset, yOffset, null);
		
		// draw populated cells
		g.setColor(Color.yellow);
		for (int x = 0; x < cellGrid.getDimension().height; x++) {
			for (int y = 0; y < cellGrid.getDimension().width; y++) {
				if (cellGrid.getCell(x, y))
					g.fillRect(xOffset + x * cellSize, yOffset + y * cellSize, cellSize - 1, cellSize - 1);
			}
		}
	}

	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}
}
