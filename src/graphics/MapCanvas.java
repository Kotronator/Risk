package graphics;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Areas.Continent;
import Areas.MapController;
import Areas.Territory;

public class MapCanvas extends Canvas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5214636220140070352L;
	public static double zoomFactor=1.5;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (Continent continent : MapController.continents) {
			
			for (Territory territory : continent.territories) {
				Graphics2D g2d= (Graphics2D) g;
				g.setColor(continent.areaColor);
				g.fillPolygon(territory.polygon);
				g2d.setColor(continent.lineColor);
				g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
				g2d.drawPolygon(territory.polygon);
				//g.fillPolygon(territory.polygon);
			}
			
		}
		
	}

}
