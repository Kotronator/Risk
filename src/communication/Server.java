package communication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import debug.Debug;
import game.Player;
import game.PlayerHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {
	
	public static ServerSocket socket;
	//static ClientHandler ch;
        public static PlayerHandler playerHandler= new PlayerHandler();
	static ArrayList<Socket> sockets;
        static ArrayList<ClientHandler> clientHaldlers;
	
	public Server()
	{
		sockets = new ArrayList<Socket>();
		clientHaldlers = new ArrayList<ClientHandler>();
	}
	
	static public boolean connect(int port)
	{
		try 
		{
			socket = new ServerSocket(port);
			//Debug.println(InetAddress.getLocalHost().getHostAddress());
			//InetSocketAddress ad =new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), port);
			//socket = new ServerSocket();//port, 10, InetAddress.getByName("25.148.35.134"));
			//socket.bind(ad);
			return true;
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void run() {
		while(true)
		{
			try {
				Debug.println("loop");
				Socket clientSocket =socket.accept();
				sockets.add(clientSocket);
				ClientHandler cl =new ClientHandler(clientSocket);
                                clientHaldlers.add(cl);
				Thread t = new Thread(cl);
				t.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
        
        public static void informOtherPlayersForNewPlayer(Player p, ClientHandler cl)
        {
            try {
                for (ClientHandler clhnd :clientHaldlers) {
                    //if(clhnd!=cl)
                    {
                        clhnd.outstream.writeUTF("ADD_PLAYER");
                        clhnd.outstream.writeUTF(p.getName());
                        clhnd.outstream.writeInt(p.getId());
                        clhnd.outstream.writeInt(p.getColor().getColorID());
                        clhnd.outstream.flush();
                    }


                }
             } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }

}
