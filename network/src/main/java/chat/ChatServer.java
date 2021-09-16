package chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import echo.EchoServerReceiveThread;

//메인스레드
public class ChatServer {
	private static final int PORT = 6000;
	
	  public static void main(String[] args) {
	      
	      ServerSocket serverSocket = null;
	      
	      try {
	         serverSocket = new ServerSocket();
	         
	         serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
	         log("starts... [port:" + PORT + "]");
	         
	         while(true) {
	            Socket socket = serverSocket.accept();
	            new EchoServerReceiveThread(socket).start();
	         }
	         
	               } catch(IOException e) {
	         log("error: " + e);
	      } finally {
	         try {
	            if(serverSocket != null && serverSocket.isClosed() == false) {
	               serverSocket.close();
	            }
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	   }
	
	public static void log(String log) {
		System.out.println("[Chat Server]" + log);
	}
}
