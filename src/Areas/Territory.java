package Areas;

import java.awt.Polygon;

public class Territory {
	String name;
	Continent continent;
	public Polygon polygon;
	
	public Territory(Polygon polygon,String name) {
		this(name);
		this.polygon=polygon;
	}
	
	public Territory(String name) {
		this.name=name;
	}


}
