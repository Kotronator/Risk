package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1454966611986481108L;
	
	JPanel mapPanel;
	MapCanvas canvas;
	
	public MainWindow()
	{
		mapPanel= new JPanel();
		canvas = new MapCanvas(800,600);
		//canvas.setSize(800,600);
		
		mapPanel.add(canvas);
		add(mapPanel);
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
