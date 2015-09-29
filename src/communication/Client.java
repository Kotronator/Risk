package communication;

import debug.Debug;
import game.Player;
import game.PlayerHandler;
import graphics.LogInWindow;
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
	
	public void connect(String address, int port,String username) 
	{
			try {
                                
				socket = new Socket(address, port);
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
                                Thread t = new Thread(this);
                                t.start();
                                StringBuilder myMessage;
                                String message= MessageConstractor.createNewMessage(MessageConstractor.ADD_NEW_PLAYER);
                                message=MessageConstractor.messageAddToken(message, username);
//                                debug.Debug.println(username);
//                                debug.Debug.println(message);
				//dos.writeUTF("ADDP "+username);
                                dos.writeUTF(message);
				dos.flush();
                                
//                              t.start();
//				String answer =dis.readUTF();
//				if(answer.startsWith("OK"))
//                                {
//                                    int playerID = Client.id = dis.readInt();
//                                    int playerColorID = dis.readInt();
//                                    Player p =new Player(username,playerID,Client.playerHandler.availableColors[playerColorID]);
//                                    Client.player=p;
//                                    Client.playerHandler.addPlayer(p);
//                                    answer=dis.readUTF();
//                                    while(!answer.equals("END_OLD_PLAYERS"))
//                                    {
//                                        //debug.Debug.println("hello");
//                                        String playerName=answer;
//                                        playerID = dis.readInt();
//                                        playerColorID = dis.readInt();
//                                        //debug.Debug.println("hello4");
//                                        Client.playerHandler.addPlayer(new Player(playerName,playerID,Client.playerHandler.availableColors[playerColorID]));
//                                        answer=dis.readUTF();
//                                    }
//                                    
//                                    return 1;
//                                }
//				else if(answer.startsWith("EXISTS"))
//					return 0;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//return -1;
			}
			//return -1;
			
	}
	
	public void run() 
	{
            
            
            
            String str;
            try {
               
                while((str= dis.readUTF())!=null)
                {
                    String firstToken = str.split(" ")[0];
                    if(firstToken.equals(MessageConstractor.OK_FOR_NEW_PLAYER))
                    {
                        String[] tokens=str.split(" ");
                        int tokensNum = tokens.length;
                        this.id=Integer.parseInt(tokens[2]);
                        for (int i = 1; i < tokensNum; i+=3)
                        {
                            
                            String username =tokens[i];
                            int playerID =Integer.parseInt(tokens[i+1]);
                            int playerColorID =Integer.parseInt(tokens[i+2]);
                            Player p =new Player(username,playerID,Client.playerHandler.availableColors[playerColorID]);
                            if( this.id==playerID)
                            {
                                Client.player=p;
                            }
                            
                            Client.playerHandler.addPlayer(p);
                        }
                       
                       
                        
                        //Client.player=p;
                       
                        LogInWindow.setConected(1);
                    }
                    else if(firstToken.equals(MessageConstractor.NEW_PLAYER_EXISTS))
                    {
                        LogInWindow.setConected(0);
                    }
                    else if(firstToken.equals("ADD_PLAYER"))
                    {
                        String[] tokens=str.split(" ");
                        String playerName=tokens[1];
                        int playerID = Integer.parseInt(tokens[2]);
                        int playerColorID = Integer.parseInt(tokens[3]);
                        Player p =new Player(playerName,playerID,Client.playerHandler.availableColors[playerColorID]);
                        Client.playerHandler.addPlayer(p);
                        if(LobbyWindow.enabled)
                            //LobbyWindow.loadPlayer(p);
                            LobbyWindow.loadPlayersNames();
                    }
                    else if(firstToken.equals("MAKE_COLOR_AVAILABLE"))
                    {
//                        int playerID = dis.readInt();
//                        int newColorID = dis.readInt();
//                        int oldColorID = dis.readInt();
                        String[] tokens=str.split(" ");
                        int playerID = Integer.parseInt(tokens[1]);
                        int newColorID = Integer.parseInt(tokens[2]);
                        int oldColorID = Integer.parseInt(tokens[3]);
                        //Client.playerHandler.availableColors[oldColorID].setPlayerID(-1);
                        debug.Debug.println("klhsh setColor apo Client me mhnima make c av");
                        Client.playerHandler.getPlayerWithID(playerID).setColor(Client.playerHandler.availableColors[newColorID]);
                         debug.Debug.println("allaksa xroma ston paikth kai twra ananewnw");
                        LobbyWindow.loadPlayersNames();
                       
                    }
                    else if(firstToken.equals(MessageConstractor.GET_MESSAGE))
                    {
                        String[] tokens=str.split(" ");
                        //String msg = dis.readUTF();
                        if(LobbyWindow.enabled)
                        LobbyWindow.displayMessage(str.substring(MessageConstractor.GET_MESSAGE.length()));
                    }
                    
                }
                
            }    
            catch (java.net.SocketException e)
                {
                    //Server.informAboutDisconection(this);
                   // debug.Debug.println(e.getMessage());
                }   
                
                
             catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
           
	}
        
        public static void informAboutPlayerColorChange(PlayerColor color)
        {
            try {
                String message=MessageConstractor.createNewMessage(MessageConstractor.INFORM_ABOUT_PL_COL_CHA);
                //dos.writeUTF("INFORM_ABOUT_PL_COL_CHA");
                message=MessageConstractor.messageAddToken(message, Client.player.getId());
                message=MessageConstractor.messageAddToken(message, color.getColorID());
                message=MessageConstractor.messageAddToken(message, Client.player.getColor().getColorID());
//                dos.writeInt(Client.player.getId());
//                dos.writeInt(color.getColorID());
//                dos.writeInt(Client.player.getColor().getColorID());
//                debug.Debug.println("perimenw 1");
                //String ans = dis.readUTF();
//                debug.Debug.println(ans);
//                if(ans.equals("OK"))
//                {
//                    Client.player.setColor(color);
//                }
                //debug.Debug.println("perimenw 2");
                dos.writeUTF(message);
                dos.flush();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public static void sendMessage(String msg)
        {
            try {
                String message=MessageConstractor.createNewMessage(MessageConstractor.SEND_MESSAGE);
                message = MessageConstractor.messageAddToken(message, msg);
                dos.writeUTF(message);
                dos.flush();
//                dos.writeUTF("MESSAGE_RECIEVE");
//                dos.writeUTF(message);
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    public static void sendMessageExpMe(String msg) {
        try {
               String message=MessageConstractor.createNewMessage(MessageConstractor.SEND_MESSAGE_OTHERS);
                message = MessageConstractor.messageAddToken(message, msg);
                dos.writeUTF(message);
                dos.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
