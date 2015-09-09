package game;

import java.awt.Color;
import java.util.ArrayList;

public class PlayerHandler {
	
	public static ArrayList<Player> playerlist= new ArrayList<Player>();
        public static ArrayList<Color> playerColorlist= new ArrayList<Color>();
	
	
	public synchronized static void  addPlayer(Player p)
	{
            synchronized(playerlist){
		playerlist.add(p);
                p.setId(playerlist.size()-1);
	
            }
        }
	public synchronized static Player containsPlayer(String str)
	{
            synchronized(playerlist){
		for (Player player : playerlist) {
			if(player.getName().equals(str))
				return player;
		}
            }
		return null;
		
	}
        
        
        public synchronized static void printPlayers()
        {
            synchronized(playerlist){
            System.out.println("#printing players#");
            for (Player player : playerlist) {
                System.out.println(player.getName());
            }
            System.out.println("#end printing players#");
            }
        }
}
