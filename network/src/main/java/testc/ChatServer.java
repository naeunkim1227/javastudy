package testc;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	static final int PORT = 9999;
	List<Writer> listwriters = new ArrayList<Writer>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listwriters = null;
		
		try {
			serverSocket = new ServerSocket();
			
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress,PORT));
			log("연결 기다림" + hostAddress + ":" + PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listwriters).start();
				//new ChatServerThread(socket).start();
			}
			
		} catch (IOException e) {
			log("error "+ e);
		}finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				log("error:" + ex);
			}
			
		}
		
	}

	public static void log(String log) {
		System.out.println(log);
	}

}
