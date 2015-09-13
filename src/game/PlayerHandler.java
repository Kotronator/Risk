package game;

import graphics.PlayerColor;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PlayerHandler {
	
       
    static Icon blueIcon = new ImageIcon(PlayerHandler.class.getResource("/resources/icons/blue.gif"));
    static Icon redIcon = new ImageIcon(PlayerHandler.class.getResource("/resources/icons/red.gif"));
    static Icon greenIcon = new ImageIcon(PlayerHandler.class.getResource("/resources/icons/green.gif"));
    static Icon yellowIcon = new ImageIcon(PlayerHandler.class.getResource("/resources/icons/yellow.gif"));
    
	public  ArrayList<Player> playerlist= new ArrayList<Player>();
        public static ArrayList<PlayerColor> playerColorlist= new ArrayList<PlayerColor>();
            public static PlayerColor[] availableColors =
            {
                new PlayerColor(0,Color.BLUE,blueIcon), new PlayerColor(1,Color.RED,redIcon),
                new PlayerColor(2,Color.GREEN,greenIcon), new PlayerColor(3, Color.YELLOW, yellowIcon)
            };
	
	public synchronized  void  addNewPlayer(Player p)
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
                        break;
                    }
                    
                }
	
            }
        }
        
        public  void addPlayer(Player player)
        {
            //playerlist.set(i, player)
//            for(int i=0; i<player.getId(); i++)
//            {
//                playerlist.add(null);
//            }
            
            playerlist.add(/*player.getId(),*/ player);
        }
	public synchronized  Player containsPlayer(String str)
	{
            synchronized(playerlist){
		for (Player player : playerlist) {
			if(player.getName().equals(str))
				return player;
		}
            }
		return null;
		
	}
        
        
//        public synchronized static void printPlayers()
//        {
//            synchronized(playerlist){
//            System.out.println("#printing players#");
//            for (Player player : playerlist) {
//                System.out.println(player.getName());
//            }
//            System.out.println("#end printing players#");
//            }
//        }
}
