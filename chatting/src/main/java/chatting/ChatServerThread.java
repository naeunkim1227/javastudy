package chatting;

import java.net.Socket;

public class ChatServerThread extends Thread{
	private String nickname;
	private Socket socket;
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

	
	
	}

	

}
