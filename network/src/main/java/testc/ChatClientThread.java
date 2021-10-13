package testc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatClientThread extends Thread{
	private Socket socket;
	private BufferedReader reader;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		/*reader 를 통해 읽은 통해 데이터 콘솔에 출력하기(message 처리)*/
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			while(true) {
				System.out.println("<<" + reader.readLine());
			
			}
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	

	
}
