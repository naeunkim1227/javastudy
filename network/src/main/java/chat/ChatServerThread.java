package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.omg.CORBA.Request;

import chat.ChatServer;
import echo.EchoServer;

public class ChatServerThread extends Thread{
	
	private String nickname;
	private Socket socket;
	private List<Writer> listWriters;
	PrintWriter printWriter = null;

	public ChatServerThread(Socket socket, List<Writer> listWriters ) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		
		InetSocketAddress inetremoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetremoteSocketAddress.getAddress().getHostAddress();
		int remoteHostport = inetremoteSocketAddress.getPort();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostport + "]");
		
		
		try {
			
			//2. 스트림 얻기
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
			
			//3. 요청처리
			while(true) {
				String request = reader.readLine();
				
				if(request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(writer);
					//log("클라이언트로 부터 연결 끊김");
					break;
				}
				
				String[] tokens = request.split(":");
				
				if("join".equals(tokens[0])) {
					dojoin(tokens[1], writer);
				}else if("message".equals(tokens[0])){
					domessage(tokens[1]);
				}else if("quit".equals(tokens[0])) {
					//doQuit();
					doQuit(writer);
				}else {
					ChatServer.log("error: 알 수 없는 요청" + tokens[0] + ")");
				}
					
					
			}
			
			
			
		}catch (UnsupportedEncodingException e) {
			ChatServer.log("error" + e); 
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (socket != null && socket.isClosed() == false) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	private void log(String log) {
		System.out.println(log);
		
	}
	
	
	private void dojoin(String nickName, Writer writer) {
		this.nickname = nickName;
		
		String data = nickName + "님이 참여하였습니다.";
		
		broadcast(data);
		
		addWriter(writer);
		System.out.println(writer + "님이 참여했습니다.");
		printWriter.flush();
	}
		
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}
	
	private void broadcast(String data) {
		synchronized (listWriters) {
			
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
			
		}
	}
	
	private void domessage(String message) {
		//잘 구현해보기
		broadcast(this.nickname + ":" + message);
		
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname+ "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		//잘 구현해보기
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
		
		
	}
	
	
}
