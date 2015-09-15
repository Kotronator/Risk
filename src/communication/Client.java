package communication;

import debug.Debug;
import game.Player;
import game.PlayerHandler;
import graphics.PlayerColor;
import graphics.lobby.LobbyWindow;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {

	//private static int idCounter=0;
	static Socket socket;
        public static PlayerHandler playerHandler= new PlayerHandler();
	private static DataInputStream dis;
	private static DataOutputStream dos;
        public static int id;
        public static Player player;
	
	public Client()
	{
		
	}
	
	static public int connect(String address, int port,String username) 
	{
			try {
				socket = new Socket(address, port);
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF("ADDP "+username);
				dos.flush();
				String answer =dis.readUTF();
				if(answer.startsWith("OK"))
                                {
                                    int playerID = Client.id = dis.readInt();
                                    int playerColorID = dis.readInt();
                                    Player p =new Player(username,playerID,Client.playerHandler.availableColors[playerColorID]);
                                    Client.player=p;
                                    Client.playerHandler.addPlayer(p);
                                    answer=dis.readUTF();
                                    while(!answer.equals("END_OLD_PLAYERS"))
                                    {
                                        //debug.Debug.println("hello");
                                        String playerName=answer;
                                        playerID = dis.readInt();
                                        playerColorID = dis.readInt();
                                        //debug.Debug.println("hello4");
                                        Client.playerHandler.addPlayer(new Player(playerName,playerID,Client.playerHandler.availableColors[playerColorID]));
                                        answer=dis.readUTF();
                                    }
                                    
                                    return 1;
                                }
				else if(answer.startsWith("EXISTS"))
					return 0;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
			return -1;
			
	}
	
	public void run() 
	{
            String str;
            try {
               
                while((str= dis.readUTF())!=null)
                {
                    if(str.startsWith("ADD_PLAYER"))
                    {
                        String playerName=dis.readUTF();
                        int playerID = dis.readInt();
                        int playerColorID = dis.readInt();
                        Player p =new Player(playerName,playerID,Client.playerHandler.availableColors[playerColorID]);
                        Client.playerHandler.addPlayer(p);
                        if(LobbyWindow.enabled)
                            //LobbyWindow.loadPlayer(p);
                            LobbyWindow.loadPlayersNames();
                    }
                    else if(str.startsWith("MAKE_COLOR_AVAILABLE"))
                    {
                        int playerID = dis.readInt();
                        int newColorID = dis.readInt();
                        int oldColorID = dis.readInt();
                        //Client.playerHandler.availableColors[oldColorID].setPlayerID(-1);
                        debug.Debug.println("klhsh setColor apo Client me mhnima make c av");
                        Client.playerHandler.getPlayerWithID(playerID).setColor(Client.playerHandler.availableColors[newColorID]);
                         debug.Debug.println("allaksa xroma ston paikth kai twra ananewnw");
                        LobbyWindow.loadPlayersNames();
                       
                    }
                    
                }
                
                
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
           
	}
        
        public static void informAboutPlayerColorChange(PlayerColor color)
        {
            try {
                dos.writeUTF("INFORM_ABOUT_PL_COL_CHA");
                dos.writeInt(Client.player.getId());
                dos.writeInt(color.getColorID());
                dos.writeInt(Client.player.getColor().getColorID());
                debug.Debug.println("perimenw 1");
                //String ans = dis.readUTF();
//                debug.Debug.println(ans);
//                if(ans.equals("OK"))
//                {
//                    Client.player.setColor(color);
//                }
                //debug.Debug.println("perimenw 2");
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

}
