package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = ChatServer.PORT;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		PrintWriter writer = null;
		BufferedReader reader = null;

		try {
			scanner = new Scanner(System.in);

			// 2.socket 생성
			socket = new Socket();

			// 3.연결
			socket.connect(new InetSocketAddress(SERVER_IP,PORT));

			// 4.reader/writer 생성
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			//5.join 프로토콜 생성
			String nickname = "";

			while (true) {
				System.out.print(">> 닉네임을 입력하세요");
				nickname = scanner.nextLine();
				if ("".equals(nickname) == false) {
					break;
				}
			}

			writer.println("join:" + nickname);
			
			
			// 6.chatClientReceiveThread 시작
			new ChatClientThread(socket).start();

			// 7. 키보드 입력 처리
			while (true) {
				
				System.out.println(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					writer.println("quit:" + input);
					break;
				} else {
					// 9. 메세지처리
					writer.println("message:" + input);
				}
			}

		} catch (ConnectException ex) {
			ChatServer.log("error:" + ex);
		} catch (IOException ex) {
			ChatServer.log("error:" + ex);
		} finally {
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				ChatServer.log("error:" + e);
			}
		}

	}

	
	/*
	public static String join() {

			// 1.키보드 연결
			
			//String nickName = scanner.nextLine();
			
			while(true) {
			System.out.println("닉네임을 입력해주세요.");
			System.out.print("닉네임>>");
			//nickName = scanner.nextLine();

			if (!"".equals(nickName)) {
				System.out.println("공백은 불가능합니다.");
				break;
			}
			
			}
			
			//System.out.println(nickName + "으로 설정합니다.");

			return nickName;
	}
	
	*/
}
