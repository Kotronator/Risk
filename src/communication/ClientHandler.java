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
				if(PlayerHandler.containsPlayer(str)==null)
                                {
                                    PlayerHandler.addPlayer(new Player(str));
					outstream.writeUTF("OK");
                                }
				else
					outstream.writeUTF("EXISTS");
				outstream.flush();
				Debug.println("message");
				Debug.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
