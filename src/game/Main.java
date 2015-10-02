package game;

import Areas.MapController;
import graphics.LogInWindow;

public class Main {

	static Player myPlayer;
	
	public static void main(String[] args) {
		
		MapController mc = new MapController();
                mc.setMap("Classic");
                new LogInWindow();
		//mc.wait();
		//mc.setMap(0);
		//new MainWindow();

	}

}
