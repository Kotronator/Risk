package communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable {

	//private static int idCounter=0;
	static Socket socket;
	private static DataInputStream dis;
	private static DataOutputStream dos;
	
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
					return 1;
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
		//DataOutputStream dos= new DataOutputStream(outstream);
//		try {
//			//dos.writeChars("hi server from client");
//			//dos.writeUTF("hello to server from client"+idCounter++);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
