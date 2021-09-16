package chatstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		
		try {
		//1.키보드 연결
		Scanner scanner = new Scanner(System.in);
		PrintWriter printWriter = null;
		
		//5.join 프로토콜
		System.out.println("닉네임>>");
		String nickName = scanner.nextLine();
		printWriter.println("join :" + nickName);
		printWriter.flush();
		
		//2.socket 생성
		Socket socket = new Socket();
		
		//3.연결
		
		//4.reader/writer 생성
		BufferedReader reader =  new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(null))
		//6.chatClientReceiveThread 시작
		
		//ChatClientThread.start();

		//7. 키보드 입력 처리
		while(true) {
			System.out.println(">>");
			String input = scanner.nextLine();
			
			if("quit".equals(input) == true) {
				//8. quit 프로토콜 처리
				break;
			}else {
				//9. 메세지처리
			}
		}
		
	}catch (IOException ex) {
		ChatServer.log("error:" + ex);
	}finally {
		
	}

}
}
