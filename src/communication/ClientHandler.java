package communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import debug.Debug;
import game.Player;
import game.PlayerHandler;

public class ClientHandler implements Runnable {

	//ServerSocket socket;
	
	//ArrayList<Socket> sockets;
	Socket socket;
	DataInputStream instream;
	DataOutputStream outstream;
	
	public ClientHandler(Socket socket) {
		this.socket=socket;
		try {
			instream = new DataInputStream(socket.getInputStream());
			outstream = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//sockets= new ArrayList<Socket>();
	}

	public ClientHandler() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	@Override
	public void run() {
		DataInputStream br = new DataInputStream(instream);
		String str;
		try {
			Debug.println("waiting to read");
			//int i =br.readInt();
			while((str= br.readUTF())!=null)
			{
                            String firstToken = str.split(" ")[0];
//				if(PlayerHandler.containsPlayer(str)==null)
//                                {
//                                    PlayerHandler.addPlayer(new Player(str));
//					outstream.writeUTF("OK");
//                                }
//				else
//					outstream.writeUTF("EXISTS");
//				outstream.flush();
//				Debug.println("message");
//				Debug.println(str);
                                //if(str.startsWith("ADDP"))
                                if(firstToken.equals(MessageConstractor.ADD_NEW_PLAYER))
                                {
                                    //Debug.println("Server recived:"+str);
                                    String[] tokens=str.split(" ");
                                    String playerName =tokens[1];
                                    //Debug.println("Server recived:ADDP "+playerName);
                                    if(Server.playerHandler.containsPlayer(playerName)==null)
                                    {
                                        Player player =new Player(playerName);
                                        int numofPlayersBefore =Server.playerHandler.playerlist.size();
                                        Server.playerHandler.addNewPlayer(player);
                                        //Server.playerHandler.printPlayers();
                                        int PlayerId=player.getId();
                                        int PlayerColorId=player.getColor().getColorID();
                                        String message = MessageConstractor.createNewMessage(MessageConstractor.OK_FOR_NEW_PLAYER);
//                                        outstream.writeUTF("OK ");
//                                        outstream.writeInt(PlayerId);
//                                        outstream.writeInt(PlayerColorId);
                                        message = MessageConstractor.messageAddToken(message, playerName);
                                        message = MessageConstractor.messageAddToken(message, PlayerId);
                                        message = MessageConstractor.messageAddToken(message, PlayerColorId);
                                        
                                        Debug.println(message);
                                        //Debug.println("Server sends:OK "+PlayerId+" "+PlayerColorId+" For Player:"+playerName);
                                        if(numofPlayersBefore!=0){
//                                            //outstream.writeUTF("OLD_PLAYERS");
//                                            for (Player p : Server.playerHandler.playerlist) {
//                                                debug.Debug.println("hello2");
//                                                if(p.getId()!=PlayerId){
//                                                    debug.Debug.println("hello3");
//                                                    outstream.writeUTF(p.getName());
//                                                    outstream.writeInt(p.getId());
//                                                    outstream.writeInt(p.getColor().getColorID());
//                                                }
//                                            }
                                            for (Player p : Server.playerHandler.playerlist) 
                                            {
                                                if(p.getId()!=PlayerId)
                                                {
                                                    message = MessageConstractor.messageAddToken(message, p.getName());
                                                    message = MessageConstractor.messageAddToken(message, p.getId());
                                                    message = MessageConstractor.messageAddToken(message, p.getColor().getColorID());
                                                }
                                                
                                            }
//                                            
                                        }
                                        outstream.writeUTF(message);
                                        outstream.flush();
//                                        outstream.writeUTF("END_OLD_PLAYERS");
                                        Server.informOtherPlayersForNewPlayer(player, this);
                                        //TODO inform players for new player
                                    }else
                                    {
                                         outstream.writeUTF(MessageConstractor.NEW_PLAYER_EXISTS);
                                         outstream.flush();
                                         Debug.println("Server sends:EXISTS"+" For Player:"+playerName);
                                    }
                                    
                                }
                               
                                else if(firstToken.equals( MessageConstractor.INFORM_ABOUT_PL_COL_CHA))
                                {
                                    //String message = MessageConstractor.createNewMessage(MessageConstractor.OK_FOR_NEW_PLAYER);
                                    String[] tokens=str.split(" ");
                                    int playerID =Integer.parseInt(tokens[1]);
                                    int newColorID =Integer.parseInt(tokens[2]);
                                    int oldColorID =Integer.parseInt(tokens[3]);
                                    
//                                    int newColorID = br.readInt();
//                                    int oldColorID = br.readInt();
                                    //debug.Debug.println("klhsh setColor apo ClientHandler me mhnima inform ab PL_COL_CHA");
                                    Server.playerHandler.playerlist.get(playerID).setColor(Server.playerHandler.availableColors[newColorID]);
                                    Server.informClientsAboutAvailableColor(playerID,newColorID,oldColorID ,this);
                                    //outstream.writeUTF("OK");
                                    //outstream.flush();
                                }
                                else if(firstToken.equals(MessageConstractor.SEND_MESSAGE))
                                {   
                                    //debug.Debug.println("edw ==++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    
                                    
                                    Server.sendMessageToClients(str.substring(MessageConstractor.SEND_MESSAGE.length()));
                                }
                                else if(firstToken.equals(MessageConstractor.SEND_MESSAGE_OTHERS))
                                {   
                                    //debug.Debug.println("edw ==++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    //String msg =br.readUTF();
                                    Server.sendMessageToClientsButNotThis(str.substring(MessageConstractor.SEND_MESSAGE.length()),this);
                                }
                                
                            
			}
		} 
                catch (java.net.SocketException e)
                {
                    Server.informAboutDisconection(this);
                    debug.Debug.println(e.getMessage());
                }
                catch (IOException e) {
			// TODO Auto-generated catch block
                        //remove player
                  
			e.printStackTrace();
		}
                
		
		
		
	}

}
