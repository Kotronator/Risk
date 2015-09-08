package Areas;

import graphics.MapCanvas;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import game.FileLoader;

public class MapController {
	
	public static ArrayList<Continent> continents;
	//ArrayList<ArrayList<Territory>> territories;
	int availableMaps;
	File mapsFile;
	File[] mapsFileList;
	Map map;
	ArrayList<String> modNames;
	
	
	public MapController()
	{
		continents = new ArrayList<Continent>();
		modNames = new ArrayList<String>();
		
		//File f = new File(FileLoader.loadFile("Mods.md"));
		Scanner scanner;
//		try {
			scanner = new Scanner(FileLoader.loadFile("Mods.md"));
			while(scanner.hasNextLine())
			{
				modNames.add(scanner.nextLine());
			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			scanner.close();
		
	}
	
	public boolean setMap(int index)
	{
		//
		String modName = modNames.get(index);
		//File modFolder =new File(modName);
//		File mapFile =new File(FileLoader.loadFile(modName+"/"+modName+".map"));
		System.out.println(modName);
		Scanner continentScanner;
		Continent continent;
		Territory territory;
//		try {
			continentScanner = new Scanner(FileLoader.loadFile(modName+"/"+modName+".map"));
			Scanner territoryScannernew = null;
			while(continentScanner.hasNextLine())
			{
				
				String continentName =continentScanner.nextLine();
				System.out.println(continentName);
				continent = new Continent(continentName);
				continents.add(continent);
				//File continentFolder =new File(modName+"/"+continentName);
//				File continentInfoFile =new File(FileLoader.loadFile(modName+"/"+continentName+"/"+continentName+".co"));
				territoryScannernew  = new Scanner(FileLoader.loadFile(modName+"/"+continentName+"/"+continentName+".co"));
				int[] areaColor= new int[3];
				int lineColor[]= new int[3];
				for (int i = 0; i < lineColor.length; i++) {
					areaColor[i]= (territoryScannernew.nextInt());
					System.out.println(areaColor[i]);
				}
				
				for (int i = 0; i < 3; i++) {
					lineColor[i]=(territoryScannernew.nextInt());
					System.out.println(lineColor[i]);
				}
				
				continent.areaColor= new Color(areaColor[0],areaColor[1],areaColor[2]);
				continent.lineColor= new Color(lineColor[0],lineColor[1],lineColor[2]);
				
				continent.bonus=territoryScannernew.nextInt();
				
				territoryScannernew.nextLine();
				while(territoryScannernew.hasNextLine())
				{
					String territoryName =territoryScannernew.nextLine();
//					File territoryAreaFile =new File(FileLoader.loadFile(modName+"/"+continentName+"/"+territoryName+".ar"));
					
					System.out.println(territoryName);
					
					Scanner territoryAreaScanner = new Scanner(FileLoader.loadFile(modName+"/"+continentName+"/"+territoryName+".ar"));
					while(territoryAreaScanner.hasNextInt())
					{
						ArrayList<Point> points = new ArrayList<Point>();
						while(territoryAreaScanner.hasNextInt()){
						  points.add(new Point(territoryAreaScanner.nextInt(), territoryAreaScanner.nextInt()));
						}
						
						
						int[] x = new int[points.size()];
						int[] y = new int[points.size()];
						for (int j = 0; j < points.size(); j++) {
							x[j]=(int)(points.get(j).x*MapCanvas.zoomFactor);
							y[j]=(int)(points.get(j).y*MapCanvas.zoomFactor);
						}
						territory= new Territory(new Polygon(x, y, points.size()-1),"a");
						continent.addTerritory(territory);
						//------------------
					}
					territoryAreaScanner.close();
					
					
					//System.out.println(territoryName);
					
				}
				
				
			}
			territoryScannernew.close();
			continentScanner.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		return false;
	}
	
	

}
