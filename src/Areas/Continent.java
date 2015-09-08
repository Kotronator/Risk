package Areas;

import java.awt.Color;
import java.util.ArrayList;

public class Continent {
	String name;
	public Color areaColor,lineColor;
	int bonus;
	public ArrayList<Territory> territories;
	
	Continent(String name)
	{
		territories= new ArrayList<Territory>();
		this.name=name;
	}
	
	public void addTerritory(Territory t)
	{
		territories.add(t);
	}

}
