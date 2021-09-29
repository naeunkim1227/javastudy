package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;


public class ChatServerThread extends Thread{
	private String nickname;
	private Socket socket;
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		//1. Remote Host Information
		InetSocketAddress remoteAddr = (InetSocketAddress) socket.getRemoteSocketAddress();
		ChatServer.log("[server] connected by client[" + remoteAddr.getAddress().getHostAddress() + ":" + remoteAddr.getPort());
		
		try {
			//2. 스트림 얻기
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		    PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream() ,"utf-8"),true);
		    
		    while(true) {
		    	String request = reader.readLine();
		    	System.out.println(request);
		    	if(request == null) {
		    		ChatServer.log("클라이언트로 부터 연결 끊김");
		    		break;
		    	}
		    	String[] tokens = request.split(":");
		    	// Join:둘리 일때 -    0은 Join 1은 둘리
		    	if("join".equals(tokens[0])) {
		    		nickname = tokens[1]; 
		    		doJoin(nickname + "님이 입장하였습니다.", writer);
		    	}else if("message".equals(tokens[0])) {
		    		
		    		doMessage(nickname + ":" + tokens[1] );
		    	}else if("quit".equals(tokens[0])) {
		    		doQuit(nickname + "님이 퇴장하였습니다.", writer);
		    	}else {
		    		ChatServer.log("에러: 알수 없는 요청(" + tokens[0] + ")");
		    	}
		    }
		
		} catch (SocketException e) {
			ChatServer.log(nickname);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doJoin(String msg, PrintWriter writer) {
		for(PrintWriter pw : ChatServer.writerList) {  //wirterlist라는 리스트 방에 pw(둘리)를 넣어준다.
			pw.println(msg);
		} //"둘리"님이 입장하였습니다.
		ChatServer.writerList.add(writer);  //list에 추가되었다.
	} 
	
	private void doMessage(String msg) {
		System.out.println(ChatServer.writerList);
		for(PrintWriter pw : ChatServer.writerList) {
			pw.println(msg);
		}
	}
	
	private void doQuit(String msg, PrintWriter writer) {
		
		ChatServer.writerList.remove(writer);
		System.out.println("----------------------------------");
		System.out.println(ChatServer.writerList);
		for(PrintWriter pw : ChatServer.writerList) {
			pw.println(msg);
		}
	}

}