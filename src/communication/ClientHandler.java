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
                                if(str.startsWith(MessageConstractor.ADD_PLAYER))
                                {
                                    Debug.println("Server recived:"+str);
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
                                        outstream.writeUTF("OK ");
                                        outstream.writeInt(PlayerId);
                                        outstream.writeInt(PlayerColorId);
                                        Debug.println("Server sends:OK "+PlayerId+" "+PlayerColorId+" For Player:"+playerName);
                                        if(numofPlayersBefore!=0){
                                            //outstream.writeUTF("OLD_PLAYERS");
                                            for (Player p : Server.playerHandler.playerlist) {
                                                debug.Debug.println("hello2");
                                                if(p.getId()!=PlayerId){
                                                    debug.Debug.println("hello3");
                                                    outstream.writeUTF(p.getName());
                                                    outstream.writeInt(p.getId());
                                                    outstream.writeInt(p.getColor().getColorID());
                                                }
                                            }
                                            
                                        }
                                        outstream.writeUTF("END_OLD_PLAYERS");
                                        Server.informOtherPlayersForNewPlayer(player, this);
                                        //TODO inform players for new player
                                    }else
                                    {
                                         outstream.writeUTF("EXISTS");
                                         Debug.println("Server sends:EXISTS"+" For Player:"+playerName);
                                    }
                                    outstream.flush();
                                }
                                else if(str.equals("INFORM_ABOUT_PL_COL_CHA"))
                                {
                                    int playerID = br.readInt();
                                    int newColorID = br.readInt();
                                    int oldColorID = br.readInt();
                                    debug.Debug.println("klhsh setColor apo ClientHandler me mhnima inform ab PL_COL_CHA");
                                    Server.playerHandler.playerlist.get(playerID).setColor(Server.playerHandler.availableColors[newColorID]);
                                    Server.informClientsAboutAvailableColor(playerID,newColorID,oldColorID ,this);
                                    //outstream.writeUTF("OK");
                                    //outstream.flush();
                                }
                                else if(str.equals("MESSAGE_RECIEVE"))
                                {   
                                    String msg =br.readUTF();
                                    Server.sendMessageToClients(msg);
                                }
                                else if(str.startsWith("MESSAGE_RECIEVE_SENT_OTHERS"))
                                {   
                                    String msg =br.readUTF();
                                    Server.sendMessageToClientsButNotThis(msg,this);
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
