package communication;

import debug.Debug;
import game.Player;
import game.PlayerHandler;
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
                                    Player p =new Player(username,playerID,PlayerHandler.availableColors[playerColorID]);
                                    Client.player=p;
                                    Client.playerHandler.addPlayer(p);
                                    answer=dis.readUTF();
                                    while(!answer.equals("END_OLD_PLAYERS"))
                                    {
                                        debug.Debug.println("hello");
                                        String playerName=answer;
                                        playerID = dis.readInt();
                                        playerColorID = dis.readInt();
                                        debug.Debug.println("hello4");
                                        Client.playerHandler.addPlayer(new Player(playerName,playerID,PlayerHandler.availableColors[playerColorID]));
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
                        Player p =new Player(playerName,playerID,PlayerHandler.availableColors[playerColorID]);
                        Client.playerHandler.addPlayer(p);
                        if(LobbyWindow.enabled)
                            LobbyWindow.loadPlayersNames();
                    }
                    
                }
                
                
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
           
	}

}
