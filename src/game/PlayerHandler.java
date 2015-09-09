package game;

import graphics.PlayerColor;
import java.awt.Color;
import java.util.ArrayList;

public class PlayerHandler {
	
	public static ArrayList<Player> playerlist= new ArrayList<Player>();
        public static ArrayList<PlayerColor> playerColorlist= new ArrayList<PlayerColor>();
	public static PlayerColor[] availableColors ={new PlayerColor(1,Color.BLUE,null)
                ,new PlayerColor(2,Color.RED,null),new PlayerColor(3,Color.GREEN,null)};
	
	public synchronized static void  addNewPlayer(Player p)
	{
            synchronized(playerlist){
		playerlist.add(p);
                p.setId(playerlist.size()-1);
                for (int i = 0; i < availableColors.length; i++) {
                    PlayerColor availableColor = availableColors[i];
                    if(availableColor.getPlayerID()==-1)
                    {
                        availableColor.setPlayerID(p.getId());
                        p.setColor(availableColor);
                    }
                    
                }
	
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
