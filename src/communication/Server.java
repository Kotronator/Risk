package communication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import debug.Debug;

public class Server implements Runnable {
	
	public static ServerSocket socket;
	static ClientHandler ch;
	ArrayList<Socket> sockets;
	
	public Server()
	{
		sockets = new ArrayList<Socket>();
		ch = new ClientHandler();
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
				Thread t = new Thread(cl);
				t.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
