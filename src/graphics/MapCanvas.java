package graphics;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Areas.Continent;
import Areas.MapController;
import Areas.Territory;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.util.Iterator;

public class MapCanvas extends Canvas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5214636220140070352L;
	public  double zoomFactor=1;
	
        public MapCanvas(int width, int height)
        {
            this.setSize(width, height);
            zoomFactor=height/400.0;
        }
        
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (Continent continent : MapController.continents) {
			
			for (Territory territory : continent.territories) {
                                Polygon pol = territory.polygon;
                                int size =pol.npoints;
                                int[] xpoints,ypoints;
                                xpoints = new int [size];
                                ypoints = new int [size];
                                PathIterator pathIt= pol.getPathIterator( new AffineTransform(zoomFactor, 0, 0, zoomFactor, 0, 0));
                                //int i=0;
                                //for (PathIterator iterator = pathIt; pathIt.isDone(); iterator.next()) 
                                for (int i = 0; i < size; i++)
                                {
                                    float[] coords = new float[2];
                                    pathIt.currentSegment(coords);
                                    xpoints[i]=(int)coords[0];
                                    ypoints[i]=(int)coords[1];
                                    //debug.Debug.println(xpoints[i]+" "+ypoints[i]);
                                    pathIt.next();
                                }
                                Polygon transformedPol = new Polygon(xpoints, ypoints, size);
                                
				Graphics2D g2d= (Graphics2D) g;
				g.setColor(continent.areaColor);
                                g.fillPolygon(transformedPol);
				//g.fillPolygon(territory.polygon);
				g2d.setColor(continent.lineColor);
				g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
				//g2d.drawPolygon(territory.polygon);
                                g2d.drawPolygon(transformedPol);
				//g.fillPolygon(territory.polygon);
			}
			
		}
		
	}

}
