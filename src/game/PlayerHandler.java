package game;

import java.util.ArrayList;

public class PlayerHandler {
	
	public static ArrayList<Player> playerlist= new ArrayList<Player>();
	
	
	public static void addPlayer(Player p)
	{
		playerlist.add(p);
	}
	
	public static Player containsPlayer(String str)
	{
		for (Player player : playerlist) {
			if(player.name.equals(str))
				return player;
		}
		
		return null;
		
	}

}
