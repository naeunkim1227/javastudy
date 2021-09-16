package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 6000;
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		
		try 
		{
			//클라이언트 소켓, 스케너 생성
			scanner = new Scanner(System.in);
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP,PORT));
			
			log("connected");
			
			//reader, writer 생성
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
			
			while(true) {
				System.out.println(">");
				String line = scanner.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				writer.println(line);
				
				String data = reader.readLine();
				
				if(data == null) {
					log("closed by server");
					break;
				}
				
				System.out.println("<" + data);
			}
			
			
		} catch (SocketException e) {
			log("suddenly closed by server" + e);
		}catch (IOException e) {
			log("error:" + e);
		}finally {
			try {
				if(scanner != null) {scanner.close();}
				if(socket != null && socket.isClosed() == false) {
				socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void log(String log) {
		System.out.println("[Client]" + log);
		
	}
	
}	
